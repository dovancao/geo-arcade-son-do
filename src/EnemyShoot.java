public class EnemyShoot {
    private int count = 0;
    private FrameCounter frameCounter = new FrameCounter(10);

    public void run(MediumSquare mediumSquare) {
        if (this.frameCounter.run()) {
            MediumSquareBullet mediumSquareBullet = new MediumSquareBullet();
            mediumSquareBullet.position.set(mediumSquare.position);
            mediumSquareBullet.velocity.set(0, 6);
            GameObject.add(mediumSquareBullet);
        }
    }
}
