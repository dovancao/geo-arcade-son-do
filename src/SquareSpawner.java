import java.util.Random;

public class SquareSpawner extends GameObject {
    private int count = 0;
    private Random random = new Random();

    public SquareSpawner() {
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 30) {
            Square square = new Square();
            square.x = 1;
            square.vy = 1;
            GameObject.add(square);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }


}
