import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setup();
        this.setupCanvas();
        this.windowListener();
        ;
        this.listener();
    }

    private void listener() {
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.players.x = e.getX();
                gameCanvas.players.y = e.getY();
                if (e.getX() < 0) gameCanvas.players.x = 0;
                if (e.getY() < 0) gameCanvas.players.y = 0;
                if (e.getX() > 400) gameCanvas.players.x = 400;
                if (e.getY() > 600) gameCanvas.players.y = 600;
            }
        });
    }

    private void setup() {
        this.setSize(400, 600);
    }

    private void setupCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void windowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        this.setVisible(true); // set cho cua so hien thi
    }


    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                lastTime = currentTime;
            }
        }
    }


}
