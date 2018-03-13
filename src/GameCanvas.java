import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameCanvas extends JPanel {

    Player players;
    BufferedImage backBuffer;
    Graphics graphics;

    public GameCanvas() {
        this.setUp();
        this.setUpBackBuffed();
        this.setUpBackGround();
        this.setUpPlayer();
        GameObject.add(new EnemySquawner());
        GameObject.add(new SquareSpawner());
        MatricSquare matricSquare = new MatricSquare();
        matricSquare.position.set(20, 20);
        matricSquare.velocity.set(3, 0);
        matricSquare.creat();
        GameObject.add(matricSquare);
    }

    private void setUp() {
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void setUpBackBuffed() {
        this.backBuffer = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffer.getGraphics();
    }

    private void setUpBackGround() {
        BackGround backGround = new BackGround();
        backGround.position.set(200, 300);
        GameObject.add(backGround);
    }

    private void setUpPlayer() {
        this.players = new Player();
        this.players.position.set(200, 300);
        GameObject.add(this.players);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //Draw bach buffer - draw lop de co the xep chong len
        g.drawImage(this.backBuffer, 0, 0, null);
    }


    public void runAll() {
        GameObject.runAll();
    }

//    private void runSquares() {
//        this.creatSquare();
//    }
//
//    private void creatSquare() {
//        if (this.countSquare >= 30) {
//            Square square = new Square();
//            square.x = 20;
//            square.vy = 3;
//            this.countSquare = 0;
//            GameObject.add(square);
//        } else {
//            this.countSquare += 1;
//        }
//    }
//
//    private void creatBullet() {
//        if (this.countBullet >= 15) {
//            Bullet bullet = new Bullet();
//            bullet.x = this.players.x;
//            bullet.y = this.players.y;
//            this.countBullet = 0;
//            GameObject.add(bullet);
//        } else {
//            this.countBullet += 1;
//        }
//    }
//
//    private void runBullets() {
//        this.creatBullet();
//    }

    public void renderAll() {
        GameObject.renderAll(this.graphics);
        this.repaint();
    }

}
