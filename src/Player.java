import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {
    //Image that represents the player's position on the board
    private BufferedImage image;
    //Current position of the player on the board grid
    private Point pos;
    //Keep track of the player's score
    private int score;

    public Player() {
        //Load the assets
        loadImage();

        //Initialize the state
        pos = new Point(0, 0);
        score = 0;
    }

    private void loadImage() {
        try {
            //You can use just the filename if the image file is in your project folder,
            //otherwise you need to provide the file path.
            image = ImageIO.read(new File("assests/player.png"));
        } catch (IOException exc) {
            System.out.println("Error loading image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        //With the Point class, note that pos.getX() returns a double,
        //but pox.x reliably returns an int. https://stackoverflow.com/a/30220114/4655368
        //this is also where we translate board grid position into a canvas pixel
        //position by multiplying by the tile size.
        g.drawImage(
                image,
                pos.x * Board.TITLE_SIZE,
                pos.y * Board.TITLE_SIZE,
                observer
        );

        public void keyPressed(KeyEvent e) {
            //Every keyboard get has a certain code. Get the value of that code from keyboard event
            //so that we can compare it to KeyEvent constants
            int key = e.getKeyCode();

            //Depending on which arrow key was pressed, we're going to move the player one whole tile for this input
            if (key == KeyEvent.VK_UP) {
                pos.translate(0, -1);
            }
            if (key == KeyEvent.VK_RIGHT) {
                pos.translate(1, 0);
            }
            if (key == KeyEvent.VK_DOWN) {
                pos.translate(0, 1);
            }
            if (key == KeyEvent.VK_LEFT) {
                pos.translate(-1, 0);
            }
        }

        public void tick() {
            //This gets called once every tick, before the repainting process happer so we can do anything needed in
            //here to update the state of the player

            //Prevent the player from moving off the edge of the board horizontally
            if (pos.x < 0) {
                pos.x = 0;
            } else if (pos.x >= Board.COLUMNS) {
                pos.x = Board.COLUNS - 1;
            }
            //Prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= Board.ROWS) {
            pos.y = Board.ROWS - 1;
        }
        }

        //region Score Section
//        public String getScore() {
//            return String.valueOf(score);
//        }
//
//        public void addScore(int amount) {
//            score += amount;
//        }
//
//        public Point getPos() {
//            return pos;
//        }
        //endregion
    }
}
