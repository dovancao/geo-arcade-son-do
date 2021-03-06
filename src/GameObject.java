import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    BufferedImage image;
    public Vector2D position;

    private static Vector<GameObject> vector = new Vector<>();
    private static Vector<GameObject> temp = new Vector<>();

    public static void add(GameObject gameObject) {
        temp.add(gameObject);
    }

    public static void runAll() {
        vector.forEach(gameObject -> gameObject.run());
        vector.addAll(temp);
        temp.clear();
    }

    public static void renderAll(Graphics graphics) {
        vector.forEach(gameObject -> gameObject.render(graphics));
    }



    public GameObject() {
    }

    public void run() {
    }

    public void render(Graphics graphics) {
        if (this.image != null) {
            graphics.drawImage(this.image, (int) this.position.x - this.image.getWidth() / 2, (int) this.position.y - this.image.getHeight() / 2, null);
        }
    }
}
