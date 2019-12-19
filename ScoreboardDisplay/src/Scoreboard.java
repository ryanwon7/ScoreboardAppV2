import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JFrame implements Runnable {
    private Thread scoreboardThread;

    Canvas c;
    Graphics g;

    Image logoJBA, logoJesuwon;

    Scoreboard() {
        super("canvas");
        c = new Canvas() {
            public void paint() {
                g.setColor(Color.gray);
                g.drawLine(0, 100, 10, 200);
            }

            public void drawImage(Graphics g, Image img, int xpos, int ypos) {
                g.drawImage(img, xpos, ypos, null);
            }
        };
        c.setBackground(Color.white);

        add(c);
        setSize(1920, 1080);
        setVisible(true);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        logoJBA = toolkit.getImage("resources/JBA CALEB.png");
        logoJesuwon = toolkit.getImage("resources/jesuwon.png");
    }

    private void initialize() {
    }

    public synchronized void paintLogos() {
        Graphics g = c.getGraphics();
        g.setColor(Color.red);
        g.drawLine(0, 100, 10, 200);
        //g.drawImage(logoJesuwon,20, 30, this);
    }
    public void start() {
        if ((scoreboardThread == null) || (!scoreboardThread.isAlive())) {
            scoreboardThread = new Thread(this);
        }
        scoreboardThread.start();
    }

    public void run() {
        while (Thread.currentThread() == scoreboardThread) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        revalidate();
    }
}
