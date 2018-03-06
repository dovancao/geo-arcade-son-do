import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage straight;
    Vector<Square> squareVector;
    BufferedImage backBuffer;


    Player players;
    MediumSquare mediumSquare = new MediumSquare();
    Vector<Bullet> vectorBullet;
    Vector<MediumSquare> vectorMediumSquares;
    Vector<MediumSquareBullet> vectorMediumSquareBullet;

    int countSquare = 0;
    int countBullet = 0;
    int countMediumSquare = 0;
    int countEnemyBullet = 0;


    Random random = new Random();

    Graphics graphics;


    public GameCanvas() {
        this.setUpGameCanvas();
        this.setUpBackBuffed();
        this.setUpBackGround();
        this.setUpPlayer();
        this.squareVector = new Vector<>();
        this.vectorBullet = new Vector<>();
        this.vectorMediumSquares = new Vector<>();
        this.vectorMediumSquareBullet = new Vector<>();

    }

    private void setUpGameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void setUpBackBuffed() {
        this.backBuffer = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffer.getGraphics();
    }

    private void setUpBackGround() {
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUpPlayer() {
        try {
            this.players = new Player(ImageIO.read(new File("resources/player/straight.png")), 0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override

    protected void paintComponent(Graphics g) {
        //Draw bach buffer - draw lop de co the xep chong len
        g.drawImage(this.backBuffer, 0, 0, null);
    }


    public void runAll() {
        this.runSquare();
        this.runBullet();
        this.runMediumSquare();
        this.runEnemyBullet();
    }


    private void runMediumSquare() {
        if (this.countMediumSquare > 200) {
            try {
                int c = random.nextInt(400);
                MediumSquare mediumSquare = new MediumSquare(ImageIO.read(new File("resources/square/enemy_square_medium.png")), c, 0, 0, 2);
                this.vectorMediumSquares.add(mediumSquare);
                this.countMediumSquare = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.countMediumSquare += 1;
        }
        this.vectorMediumSquares.forEach(mediumSquare -> mediumSquare.run());
    }

    private void runEnemyBullet() {
        for (MediumSquare mediumSquare : vectorMediumSquares) {
            if (this.countEnemyBullet > 200) {
                try {
                    MediumSquareBullet mediumSquareBullet = new MediumSquareBullet(ImageIO.read(new File("resources/square/enemy_square_bullet.png")), mediumSquare.getX(), 0, 0, 3);
                    this.vectorMediumSquareBullet.add(mediumSquareBullet);
                    this.countEnemyBullet = 0;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                this.countEnemyBullet += 1;
            }
            this.vectorMediumSquareBullet.forEach(mediumSquareBullet -> mediumSquareBullet.run());
        }
    }

    private void runSquare() {
        if (this.countSquare >= 600) {
            try {
                Square square = new Square(ImageIO.read(new File("resources/square/enemy_square_small.png")), 0, 0, 0, 1);
                this.squareVector.add(square);
                this.countSquare = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.countSquare += 1;
        }
        this.squareVector.forEach(square -> square.run());
    }

    private void runBullet() {
        if (this.countBullet >= 15) {
            try {
                Bullet bullet = new Bullet(ImageIO.read(new File("resources/player/player_bullet.png")), players.x, players.y, 0, 5);
                this.vectorBullet.add(bullet);
                this.countBullet = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.countBullet += 1;
        }
        this.vectorBullet.forEach(bullet -> bullet.run());
    }

    public void renderAll() {
        this.graphics.drawImage(this.background, 0, 0, null);
        this.players.render(graphics);
        this.vectorBullet.forEach(bullet -> bullet.render(graphics));
        this.squareVector.forEach(square -> square.render(graphics));
        this.vectorMediumSquares.forEach(mediumSquare -> mediumSquare.render(graphics));
        this.vectorMediumSquareBullet.forEach((mediumSquareBullet -> mediumSquareBullet.render(graphics)));
        this.repaint();
    }

}
