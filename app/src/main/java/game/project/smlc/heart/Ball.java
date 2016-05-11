package game.project.smlc.heart;

/**
 * Created by Smlc on 10/05/2016.
 */
public class Ball {

    private int x;
    private int y;
    private int directionX;
    private int directionY;

    public Ball(int x,int y){
        this.directionX = 1;
        this.directionY = 1;
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDirectionX() {
        return directionX;
    }

    public int getDirectionY() {
        return directionY;
    }
}
