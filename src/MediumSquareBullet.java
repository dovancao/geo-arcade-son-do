import java.awt.*;
import java.awt.image.BufferedImage;

public class MediumSquareBullet {
    BufferedImage image;
    int x;
    int y;
    int vx;
    int vy;

    public MediumSquareBullet(BufferedImage image, int x, int y, int vx, int vy) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public MediumSquareBullet() {
        this.image = image;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void run() {
        this.x += vx;
        this.y += vy;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, x, y, null);
    }
}
