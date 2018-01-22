import processing.core.PApplet;
import processing.core.PImage;
import shapes.*;

public class Tile extends Rectangle
{
    private boolean isVisble = false;
    private int xPos;
    private int yPos;

    public static PImage covered;
    public static PImage uncovered;

    public Tile(float x, float y, float width, float height, int xPos, int yPos)
    {
        super(x, y, width, height);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public static void setup(PApplet marker)
    {
        covered = marker.loadImage("Images//facingDown.png");
        uncovered = marker.loadImage("Images//0.png");

    }

    public void draw(PApplet marker)
    {

        this.setStrokeColor(0);

        if (!isVisble)
        {
            marker.imageMode(PApplet.CORNER);
            marker.image(covered, (float) super.getX(), (float) super.getY(), (float) super.getWidth(),
                    (float) super.getHeight());
        }
        else
        {
            marker.imageMode(PApplet.CORNER);
            marker.image(uncovered, (float) super.getX(), (float) super.getY(), (float) super.getWidth(),
                    (float) super.getHeight());
        }

    }

    public boolean isVisble()
    {
        return isVisble;
    }

    public void setIsVisble(boolean isVisble)
    {
        this.isVisble = isVisble;
    }

    public int getxPos()
    {
        return xPos;
    }

    public void setxPos(int xPos)
    {
        this.xPos = xPos;
    }

    public int getyPos()
    {
        return yPos;
    }

    public void setyPos(int yPos)
    {
        this.yPos = yPos;
    }

}