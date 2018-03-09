public class EnemyShoot {
    private int count = 0;

    public void run(MediumSquare mediumSquare) {
        if (this.count >= 10) {
            MediumSquareBullet mediumSquareBullet = new MediumSquareBullet();
            mediumSquareBullet.x = mediumSquare.x;
            mediumSquareBullet.y = mediumSquare.y;
            mediumSquareBullet.vy = 7;
            GameObject.add(mediumSquareBullet);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
