package game.project.smlc.heart;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import game.project.smlc.gameapp.R;


/**
 * Created by Smlc on 10/05/2016.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private BallThread ballThread;
    private Background background;
    private Ball ball;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);
        ballThread = new BallThread(getHolder(), this);

        //focus for handle event
        setFocusable(true);
    }


    @Override
    public void draw(Canvas canvas) {
       super.draw(canvas);
        background.draw(canvas);
        ball.checkCollisions(canvas);
        ball.draw(canvas);

    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        background = new Background(BitmapFactory.decodeResource(
                getResources(), R.drawable.bleusidee));
        ball = new Ball(BitmapFactory.decodeResource(
                getResources(), R.drawable.sprite_sheet));
        ballThread.setRunning(true);
        ballThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        Log.d("Message debug", "Destroyed" );
        boolean joined = true;
        while (joined) {
            try {
                ballThread.join();
                ballThread.setRunning(false);
                joined = false;
            } catch (InterruptedException e) {}
        }

    }
}
