import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class Board
{
    private Tile[][] tiles;
    private final float ORIGIN_X = 40;
    private final float ORIGIN_Y = 30;
    private float width;
    private float height;
    private int numRows;
    private int numCols;
    private int MAX_MINES;

    public Board(float width, float height, int numRows, int numCols)
    {
        this.setNumRows(numRows);
        this.setNumCols(numCols);
        this.width = width;
        this.height = height;
        float tileWidth = width / numCols;
        float tileHeight = height / numRows;
        tiles = new Tile[numRows][numCols];
        MAX_MINES = numRows;

        fillTilesArray(tileWidth, tileHeight, numRows, numCols);

    }

    private void fillTilesArray(float tileWidth, float tileHeight, int numRows, int numCols)
    {
        int minesPlaced = 0;
        Random random = new Random(); // this generates random numbers for us
        while (minesPlaced < MAX_MINES)
        {
            int x = random.nextInt((int) numCols); // a number between 0 and mWidth - 1
            int y = random.nextInt((int) numRows);
            // make sure we don't place a mine on top of another
            if (!(tiles[y][x] instanceof Bomb))
            {
                tiles[y][x] = new Bomb(ORIGIN_X + (y * tileWidth), ORIGIN_Y + (x * tileHeight), tileWidth,
                        tileHeight, y, x);
            }
        }
        
        for (int i = 0; i < numRows; i++)
        {
            
            for (int j = 0; j < numCols; j++)
            {
                
                    
                if (!(tiles[i][j] instanceof Bomb))
                {
                    tiles[i][j] = new Empty(ORIGIN_X + (i * tileWidth), ORIGIN_Y + (j * tileHeight), tileWidth,
                            tileHeight, i, j);
                }

            }
        }

    }

    public void draw(PApplet marker)
    {
        marker.pushStyle();

        for (int i = 0; i < tiles.length; i++)
        {
            for (int j = 0; j < tiles[i].length; j++)
            {
                Tile element = tiles[i][j];
                element.draw(marker);

            }
        }
        marker.popStyle();

    }

    public double getX()
    {
        return ORIGIN_X;
    }

    public double getY()
    {
        return ORIGIN_Y;
    }

    public int getNumRows()
    {
        return numRows;
    }

    public void setNumRows(int numRows)
    {
        this.numRows = numRows;
    }

    public int getNumCols()
    {
        return numCols;
    }

    public void setNumCols(int numCols)
    {
        this.numCols = numCols;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public Tile[][] getTiles()
    {
        return tiles;

    }

    public String toString()
    {
        String result = "";

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                if (tiles[j][i] instanceof Bomb)
                    result += "b ";
                else
                    result += "t ";
            }

            result += '\n';
        }

        return result;
    }

    public void showAll()
    {
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                Tile element = tiles[i][j];

                if (element instanceof Bomb)
                {
                    element.setIsVisble(true);

                }

            }
        }

    }

    public Tile[] neighbouringBombs(int x, int y)
    {
        ArrayList<Tile> result = new ArrayList<Tile>();
        int xMin = x - 1;
        int xMax = x + 1;
        int yMin = y - 1;
        int yMax = y + 1;

        if (x == 0)
            xMin = 0;

        if (y == 0)
            yMin = 0;

        if (x == numRows - 1)
            xMax = numRows - 1;

        if (y == numCols - 1)
            yMax = numCols - 1;

        if (tiles[x][y] instanceof Empty)
        {

            for (int i = xMin; i <= xMax; i++)
            {
                for (int j = yMin; j <= yMax; j++)
                {
                    if (tiles[i][j] instanceof Empty && tiles[i][j] != tiles[x][y])
                    {
                        result.add(tiles[i][j]);
                    }
                }
            }

        }
        return result.toArray(new Tile[result.size()]);
    }

}
