public class MediumSquareBullet extends GameObject {

    int vx;
    int vy;

    public MediumSquareBullet() {
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");

    }

    @Override
    public void run() {
        super.run();
        this.x += vx;
        this.y += vy;
    }
}
