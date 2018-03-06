import java.awt.*;
import java.awt.image.BufferedImage;

public class Square {
    public BufferedImage images;
    public int x;
    public int y;
    public int vx;
    public int vy;

    public Square(BufferedImage images, int x, int y, int vx, int vy) {
        this.images = images;
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
        graphics.drawImage(this.images, x, y, null);
    }


}
