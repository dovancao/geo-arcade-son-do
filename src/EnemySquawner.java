import java.util.Random;

public class EnemySquawner extends GameObject {

    private int count = 0;
    private Random random;

    public EnemySquawner() {
        this.random = new Random();
    }

    @Override
    public void run() {
        if (this.count > 200) {
            int c = random.nextInt(400);
            MediumSquare mediumSquare = new MediumSquare();
            mediumSquare.x = this.random.nextInt(400);
            mediumSquare.vy = this.random.nextInt(3);
            GameObject.add(mediumSquare);
            this.count = 0;

        } else {
            this.count += 1;
        }
    }


}
