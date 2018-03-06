import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MediumSquare {
    public BufferedImage images;
    public int x;
    public int y;
    public int vx;
    public int vy;
    Random random = new Random();

    public MediumSquare(BufferedImage images, int x, int y, int vx, int vy) {
        this.images = images;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public MediumSquare() {
        this.images = images;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void run() {
        this.x += vx;
        this.y += vy;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.images, x, y, null);
    }


}