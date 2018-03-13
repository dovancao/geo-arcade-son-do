import java.util.Random;

public class EnemySquawner extends GameObject {

    private int count = 0;
    private Random random;

    public EnemySquawner() {
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.count > 200) {
            MediumSquare mediumSquare = new MediumSquare();
            mediumSquare.position.set(random.nextInt(400), 0);
            mediumSquare.velocity.set(0, random.nextInt(3) + 1);
            GameObject.add(mediumSquare);
            this.count = 0;

        } else {
            this.count += 1;
        }
    }


}
