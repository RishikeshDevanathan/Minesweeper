import processing.core.PApplet;
import processing.core.PImage;

public class Empty extends Tile
{
    private PImage emptyImg;
    private int neighbouringBombs;

    public Empty(float x, float y, float width, float height, int xPos, int yPos)
    {
        super(x, y, width, height, xPos, yPos);
    }

    public void setup(PApplet drawer, int val)
    {
        emptyImg = drawer.loadImage("Images//" + val + ".png");
        neighbouringBombs = val;
    }

    public void draw(PApplet drawer)
    {
        super.draw(drawer);

        if (super.isVisble())
        {
            drawer.imageMode(PApplet.CORNER);
            drawer.image(emptyImg, (float) super.getX(), (float) super.getY(), (float) super.getWidth(),
                    (float) super.getHeight());
        }

    }

    public PImage getEmptyImg()
    {
        return emptyImg;
    }

    public void setEmptyImg(PImage emptyImg)
    {
        this.emptyImg = emptyImg;
    }

    public int getNeighbouringBombs()
    {
        return neighbouringBombs;
    }

    public void setNeighbouringBombs(int neighbouringBombs)
    {
        this.neighbouringBombs = neighbouringBombs;
    }

}
