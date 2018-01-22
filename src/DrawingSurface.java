import processing.core.PApplet;

public class DrawingSurface extends PApplet
{

    private Board board;
    private int time;
    private boolean gameOver;

    public DrawingSurface()
    {

        time = millis() / 1000;
        board = new Board(500, 500, 20, 20);
        System.out.print(board);
    }

    public void setup()
    {
        Tile.setup(this);
        Bomb.setup(this);

        Tile[][] tiles = board.getTiles();

        for (int x = 0; x < board.getNumRows(); x++)
        {
            for (int y = 0; y < board.getNumCols(); y++)
            {

                if (tiles[x][y] instanceof Empty)
                {

                    ((Empty) tiles[x][y]).setup(this, board.numNeighbouringBombs(x, y));

                }

            }
        }

    }

    // Random flood fill
    public void openNeighbors(Tile tile)
    {

        if (!tile.isVisble())
        {
            tile.setIsVisble(true);

            Tile[] neighbors = board.neighbouringBombs(tile.getxPos(), tile.getyPos());
            Empty element = (Empty) tile;

            if (element.getNeighbouringBombs() > 0)
            {

                return;
            }
            else
            {
                int rand = 0;

                while (rand < neighbors.length / 3)
                {
                    openNeighbors(neighbors[(int) (Math.random() * neighbors.length)]);
                    rand++;
                }
            }

        }

    }

    public void draw()
    {

        if (!gameOver)
        {
            background(255);

            board.draw(this);

            if (mousePressed)
                check();

            fill(0);
            textSize(20);
            text(time, 280, 20);
            
            if (millis() - time >= 1000)
            {
                if (time >= 60)
                    gameOver = true;                    
                else
                    time = millis() / 1000;
            }
                
            

        }
        else
        {

            delay(2500);
            fill(0);
            rect(0, 0, 600, 600);
            fill(255);
            textSize(60);
            text("GAME OVER", 125, 275);

        }
    }

    private void showAll()
    {
        for (int i = 0; i < board.getNumRows(); i++)
        {
            for (int j = 0; j < board.getNumCols(); j++)
            {
                Tile element = board.getTiles()[i][j];

                if (element instanceof Bomb)
                {
                    element.setIsVisble(true);
                }

            }
        }

        board.draw(this);

    }

    public void check()
    {
        for (int i = 0; i < board.getNumRows(); i++)
        {
            for (int j = 0; j < board.getNumCols(); j++)
            {
                Tile element = board.getTiles()[i][j];

                if (element.isPointInside(mouseX, mouseY) && mouseButton == LEFT)
                {
                    // element.setIsVisble(true);

                    if (element instanceof Bomb)
                    {
                        gameOver = true;
                        showAll();
                    }
                    else
                        openNeighbors(element);
                }

            }
        }
    }

    public Board getBoard()
    {
        return board;
    }

    public void setBoard(Board board)
    {
        this.board = board;
    }

    public boolean isGameOver()
    {
        return gameOver;
    }

    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }

}
