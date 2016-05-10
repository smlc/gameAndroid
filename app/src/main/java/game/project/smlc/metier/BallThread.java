package game.project.smlc.metier;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Smlc on 10/05/2016.
 */
public class BallThread extends Thread {

    private int FPS = 20;
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
                canvas = surfaceHolder.lockCanvas();

                synchronized (surfaceHolder){
                    gamePanel.draw(canvas);
                }
            } finally {
                // draw ended, released canvas
                if (canvas != null)
                    surfaceHolder.unlockCanvasAndPost(canvas);
            }

            // draw at 50 FPS
            try {
                Thread.sleep(FPS);
            } catch (InterruptedException e) {}
        }
    }
}
