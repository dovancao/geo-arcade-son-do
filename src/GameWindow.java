import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;
    public String name;

    public GameWindow() {
        this.setup();
        this.setupCanvas();
        this.listener();
        this.setVisible(true);
    }

    private void listener() {
        this.mouseMotionListener();
        this.windowListener();
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
    }

    private void mouseMotionListener() {
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (e.getX() > 0 && e.getY() < 400 - 40) {
                    gameCanvas.players.position.x = e.getX();
                } else if (e.getX() < 0) {
                    gameCanvas.players.position.x = 0;
                } else {
                    gameCanvas.players.position.x = 400 - 40;
                }
                if (e.getY() > 0 && e.getY() < 600 - 40) {
                    gameCanvas.players.position.y = e.getY();
                } else if (e.getY() < 0) {
                    gameCanvas.players.position.y = 0;
                } else {
                    gameCanvas.players.position.y = 600 - 40;
                }
            }
        });
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
