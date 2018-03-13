public class MediumSquare extends GameObject {

    private EnemyShoot enemyShoot;
    public Vector2D velocity;

    public MediumSquare() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.enemyShoot = new EnemyShoot();
        this.velocity = new Vector2D();
    }


    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
    }

}