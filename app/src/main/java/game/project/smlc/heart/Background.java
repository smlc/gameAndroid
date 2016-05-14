package game.project.smlc.heart;

import android.graphics.Bitmap;
import android.graphics.Canvas;


/**
 * Created by Smlc on 11/05/2016.
 */

public class Background {

    private Bitmap imageBleuSide;
    private int x, y;

    public Background(Bitmap imageBleuSide){

        this.imageBleuSide = imageBleuSide;

    }

    public void update(){

    }

    public void draw(Canvas canvas){
     /*   Paint paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setStyle(Paint.Style.STROKE);*/

 //     canvas.drawColor(Color.BLACK, PorterDuff.Mode.CLEAR);
   //    canvas.drawARGB(255,150,150,10);

        canvas.drawBitmap(imageBleuSide, x, y,null);
    }
}
