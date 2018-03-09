import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage straight;
    BufferedImage backBuffer;

    Player players;
    Graphics graphics;

    int countSquare = 0;
    int countBullet = 0;

    Random random = new Random();

    public GameCanvas() {
        this.setUpGameCanvas();
        this.setUpBackBuffed();
        this.setUpBackGround();
        this.setUpPlayer();
        GameObject.add(new EnemySquawner());
        GameObject.add(new SquareSpawner());

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
        GameObject.add(new BackGround());
    }

    private void setUpPlayer() {
        this.players = new Player();
        this.players.x = 200;
        this.players.y = 300;
        GameObject.add(players);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //Draw bach buffer - draw lop de co the xep chong len
        g.drawImage(this.backBuffer, 0, 0, null);
    }


    public void runAll() {
        GameObject.runAll();
    }

    private void runSquares() {
        this.creatSquare();
    }

    private void creatSquare() {
        if (this.countSquare >= 30) {
            Square square = new Square();
            square.x = 20;
            square.vy = 3;
            this.countSquare = 0;
            GameObject.add(square);
        } else {
            this.countSquare += 1;
        }
    }

    private void creatBullet() {
        if (this.countBullet >= 15) {
            Bullet bullet = new Bullet();
            bullet.x = this.players.x;
            bullet.y = this.players.y;
            this.countBullet = 0;
            GameObject.add(bullet);
        } else {
            this.countBullet += 1;
        }
    }

    private void runBullets() {
        this.creatBullet();
    }

    public void renderAll() {
        this.graphics.drawImage(this.background, 0, 0, null);
        GameObject.renderAll(this.graphics);
        this.repaint();
    }

}
