
import java.util.Random;

import processing.core.PApplet;
import shapes.Rectangle;

public class DrawingSurface extends PApplet
{

    private Board board;

    private boolean gameOver;

    public DrawingSurface()
    {
        board = new Board(500, 500, 10, 10);

        System.out.print(board);
    }

//    public void setup()
//    {
//        // Tile.setup(this);
//        // Bomb.setup(this);
//
//        Tile[][] tiles = board.getTiles();
//
//        for (int x = 0; x < board.getNumRows(); x++)
//        {
//            for (int y = 0; y < board.getNumCols(); y++)
//            {
//
//                int xMin = x - 1;
//
//                int xMax = x + 1;
//                int yMin = y - 1;
//                int yMax = y + 1;
//
//                if (x == 0)
//                    xMin = 0;
//
//                if (y == 0)
//                    yMin = 0;
//
//                if (x == board.getNumRows() - 1)
//                    xMax = board.getNumRows() - 1;
//
//                if (y == board.getNumCols() - 1)
//                    yMax = board.getNumCols() - 1;
//
//                if (tiles[x][y] instanceof Empty)
//                {
//                    int count = 0;
//
//                    for (int i = xMin; i <= xMax; i++)
//                    {
//                        for (int j = yMin; j <= yMax; j++)
//                        {
//                            if (tiles[i][j] instanceof Bomb)
//                                count++;
//                        }
//                    }
//
//                    ((Empty) tiles[x][y]).setup(this, count);
//
//                }
//
//            }
//        }
//
//    }
//
//    public void openNeighbors(Tile tile)
//    {
//
//        if (!tile.isVisble())
//        {
//            tile.setIsVisble(true);
//
//            Tile[] neighbors = board.neighbouringBombs(tile.getxPos(), tile.getyPos());
//            Empty element = (Empty) tile;
//
//            if (element.getNeighbouringBombs() == board.getNumCols() / 5)
//            {
//
//                for (int i = 0; i < neighbors.length; i++)
//                {
//
//                    openNeighbors(neighbors[i]);
//
//                }
//            }
//
//        }
//
//    }
//
//    public void draw()
//    {
//
//        if (!gameOver)
//        {
//            background(255);
//
//            board.draw(this);
//
//            if (mousePressed)
//                check();
//
//        } else
//        {
//
//            delay(3000);
//
//            fill(0);
//            rect(0, 0, 600, 600);
//            fill(255);
//            textSize(60);
//            text("GAME OVER", 125, 275);
//            //
//            //
//            // Rectangle retry = new Rectangle(230, 350, 100, 50);
//            // retry.setFillColor(100);
//            // retry.draw(this);
//            //
//            // fill(255);
//            // textSize(30);
//            // text("Retry", 240, 375);
//            //
//            //
//            // if (mousePressed && retry.isPointInside(mouseX, mouseY))
//            // gameOver = false;
//            //
//            // if (!gameOver)
//            // {
//            //
//            //
//            //
//            // }
//
//        }
//    }
//
//    private void showAll()
//    {
//        for (int i = 0; i < board.getNumRows(); i++)
//        {
//            for (int j = 0; j < board.getNumCols(); j++)
//            {
//                Tile element = board.getTiles()[i][j];
//
//                if (element instanceof Bomb)
//                {
//                    element.setIsVisble(true);
//                }
//
//            }
//        }
//
//        board.draw(this);
//
//    }
//
//    public void check()
//    {
//        for (int i = 0; i < board.getNumRows(); i++)
//        {
//            for (int j = 0; j < board.getNumCols(); j++)
//            {
//                Tile element = board.getTiles()[i][j];
//
//                if (element.isPointInside(mouseX, mouseY) && mouseButton == LEFT)
//                {
//                    // element.setIsVisble(true);
//
//                    if (element instanceof Bomb)
//                    {
//                        gameOver = true;
//                        showAll();
//                    } else
//                        openNeighbors(element);
//                }
//
//            }
//        }
//    }
//
//    public Board getBoard()
//    {
//        return board;
//    }
//
//    public void setBoard(Board board)
//    {
//        this.board = board;
//    }
//
//    public boolean isGameOver()
//    {
//        return gameOver;
//    }
//
//    public void setGameOver(boolean gameOver)
//    {
//        this.gameOver = gameOver;
//    }

}
