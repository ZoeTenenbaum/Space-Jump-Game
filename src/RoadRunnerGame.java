import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class GamePanel extends JPanel implements ActionListener, KeyListener {
    private BufferedImage characterImage;
    private BufferedImage flowerImage;
    private BufferedImage rockImage;
    private BufferedImage thornImage;
    private int characterY = 300;
    private int characterX = 100; // use for hitting obsacles
    private boolean isJumping = false;
    private Background background;
    private int shifter = 7000;
    private int endTime = 0;

    public GamePanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(600, 600));
        try {
            characterImage = ImageIO.read(new File("/Users/zoetenenbaum/bee.png"));
            flowerImage = ImageIO.read(new File("/Users/zoetenenbaum/flower.png"));
            rockImage = ImageIO.read(new File("/Users/zoetenenbaum/rock.png"));
            thornImage = ImageIO.read(new File("/Users/zoetenenbaum/thorn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        background = new Background();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.drawImage(characterImage, 100, characterY, 75, 75,null);
        for (Obstacle obstacle : background.getObstacles()) {
            g.drawImage(rockImage, obstacle.x1, obstacle.y1, obstacle.width/2, obstacle.height1/2,null);
            g.drawImage(thornImage, obstacle.x1, obstacle.y2, obstacle.width/2, obstacle.height2/2,null);
        }
        shifter -= 1.5;
        g.drawImage(flowerImage, shifter, 150, 300, 300, null);
        background.update();

        if (isJumping) {
            characterY -= 4;
        } else if (characterY < 550) {
            characterY += 2;
        } else if (characterY == 550) {
            characterY += 2;
            System.exit(0);
        }
        endTime += 1.5;
        if (endTime >= 3500) {
            System.exit(0);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !isJumping) {
            isJumping = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isJumping = false;
        }
    }
}