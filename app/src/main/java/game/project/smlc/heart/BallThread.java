package game.project.smlc.heart;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by Smlc on 10/05/2016.
 */
public class BallThread extends Thread {

    private int FPS = 60;
    private GamePanel gamePanel;
    private SurfaceHolder surfaceHolder;
    private boolean running;
    private Canvas canvas;

    public BallThread(SurfaceHolder surfaceHolder,GamePanel gamePanel){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;

    }

    public void setRunning(boolean run){
        running = run;
    }

    @Override
    public void run() {

        while (running){
            canvas = null;

            try{
                //get canvas for draw by surface holder and lock it
                if(!surfaceHolder.getSurface().isValid()){
                    Log.d("Message debug", "Non valide" );
                    continue;
                }
                canvas = surfaceHolder.lockCanvas();

                synchronized (surfaceHolder){

                    gamePanel.draw(canvas);
                   // gamePanel.checkCollisions(canvas,ball);


                }
            }catch (Exception e) {
            }finally {
                // draw ended, released canvas
                if (canvas != null)
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e){e.printStackTrace();}
            }

            // draw at 50 FPS
            try {
                this.sleep(FPS);
            } catch (InterruptedException e) {}
        }
    }
}
