
public class Square extends GameObject {
    public int vx;
    public int vy;


    public Square(int vx, int vy, int x, int y) {
        this.vx = vx;
        this.vy = vy;
        this.x = x;
        this.y = y;
    }

    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
    }

    @Override
    public void run() {
        super.run();// gọi lại method của thằng cha, nếu không có super run() thì không gọi thằng cha , và không ghi đè
        this.x += this.vx;
        this.y += this.vy;
        movingSquareMatric();
    }

    private void movingSquareMatric() {
        if (this.y < 400) {
            this.vy = 1;
            this.vx = 1;
        }
        if (this.y > 400) {
            this.vy = 1;
            this.vx = -1;
        }
    }
    
}
