public class Bullet extends GameObject {
    int vx;
    int vy;

    public Bullet() {
        this.image = Utils.loadImage("resources/player/player_bullet.png");
    }

    @Override
    public void run() {
        super.run();
        this.x += vx;
        this.y += vy;
    }

}
