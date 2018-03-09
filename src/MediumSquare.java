public class MediumSquare extends GameObject {

    public int vx;
    public int vy;

    private EnemyShoot enemyShoot;

    private int countBullet;


    public MediumSquare() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.enemyShoot = new EnemyShoot();
    }


    @Override
    public void run() {
        super.run();
        this.x += vx;
        this.y += vy;
        this.enemyShoot.run(this);
    }

}