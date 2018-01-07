import processing.core.PApplet;
import processing.core.PImage;

public class Bomb extends Tile
{
    public static PImage bombImg;

    public Bomb(float x, float y, float width, float height, int xPos, int yPos)
    {
        super(x, y, width, height, xPos, yPos);

    }

    public static void setup(PApplet drawer)
    {
        bombImg = drawer.loadImage("Images//bomb.png");
        
    }

    public void draw(PApplet drawer)
    {
        super.draw(drawer);

        if (super.isVisble())
        {
            drawer.imageMode(PApplet.CORNER);
            drawer.image(bombImg, (float) super.getX(), (float) super.getY(), (float) super.getWidth(),
                    (float) super.getHeight());
        }

    }

}
