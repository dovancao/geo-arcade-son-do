import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    int x;
    int y;
    BufferedImage image;


    public Player(BufferedImage image, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, x, y, null);
    }
}
