package game.project.smlc.metier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Smlc on 10/05/2016.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private BallThread ballThread;
    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);
        ballThread = new BallThread(getHolder(), this);

        //focus for handle event
        setFocusable(true);
    }


    @Override
    public void draw(Canvas pCanvas) {
        super.draw(pCanvas);
        
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        ballThread.setRunning(true);
        ballThread.run();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {


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
