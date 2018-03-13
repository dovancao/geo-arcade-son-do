
public class Square extends GameObject {

    public Vector2D velocity;

    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
    }


    @Override
    public void run() {
        super.run();// gọi lại method của thằng cha, nếu không có super run() thì không gọi thằng cha , và không ghi đè
        this.position.addUp(this.velocity);
    }


}
