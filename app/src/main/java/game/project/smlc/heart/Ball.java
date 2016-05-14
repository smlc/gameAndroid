package game.project.smlc.heart;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by Smlc on 10/05/2016.
 */
public class Ball {

    private int x,y;
    private int height, width;
    private int xSpeed, ySpeed;
    private int direction;
    private int currentFrame;
    private Bitmap ballImage;

    public Ball(Bitmap ball){

        ballImage = ball;
        this.xSpeed = 5;
        this.ySpeed = 5;
        direction = 2;
        this.x = 15;
        this.y = 15;

        //2 rows in sprite sheet
        height = ball.getHeight() / 4;
        width = ball.getWidth() / 4;
    }

    public void draw(Canvas canvas) {

        update();
        int srcX = currentFrame * width;
        int srcY = direction * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);
        canvas.drawBitmap(ballImage, src, dst, null);

    }

    public void update() {
        currentFrame = ++currentFrame % 4;
        x += xSpeed;
        y += ySpeed;
    }

    public void checkCollisions(Canvas canvas) {
        // 1 = right up      2 = right down
        // 0 = left up       3 = left down

        if(x - xSpeed < 0) {
            Log.d("Test", "x - xSpeed " +x);
            xSpeed = Math.abs(xSpeed);
            if(direction == 3){
                direction = 2;
            }else {
                direction = 1;
            }


        } else if(x + xSpeed > canvas.getWidth() - width) {
            Log.d("Test", "x + xSpeed " +x);
            xSpeed = -Math.abs(xSpeed);
            if(direction == 1){
                direction = 0;
            }else {
                direction = 3;
            }
        }

        if(y - ySpeed < 0) {
            Log.d("Test", "y - ySpeed " +y + " direction :" + direction);
            ySpeed = Math.abs(ySpeed);
            if(direction == 0){
                direction = 3;
            }else {
                direction = 2;
            }

        } else if(y + ySpeed > canvas.getHeight() - height) {
            Log.d("Test", "y + ySpeed " +y);
            ySpeed = -Math.abs(ySpeed);
            if(direction == 3){
                direction = 0;
            }else {
                direction = 1;
            }
        }
    }
    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }
}
