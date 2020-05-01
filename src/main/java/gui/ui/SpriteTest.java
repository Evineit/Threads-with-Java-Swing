package gui.ui;

import core.Animation;
import core.Sprite;
import gui.WindowMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class SpriteTest extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hilosu Test");
        frame.setContentPane(new nPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
class nPanel extends JPanel{
    private Graphics2D g2;
    public nPanel() {
        new Thread(() -> {
            while(true){
                animation.update();
                repaint();


            }
        }).start();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                    animation = walkLeft;
                    animation.start();
//                repaint();

                System.out.println("Pressed"+e.getPoint().toString());
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                    animation.stop();
                    animation.reset();
                    animation = stand;

            }
        });
    }
    // Images for each animation

    private final BufferedImage[] walkingLeft = {Sprite.getSprite(0, 1), Sprite.getSprite(2, 1)}; // Gets the upper left images of my sprite sheet
    private final BufferedImage[] walkingRight = {Sprite.getSprite(0, 2), Sprite.getSprite(2, 2)};
    private final BufferedImage[] standing = {Sprite.getSprite(1, 0)};
    // These are animation states

    private final Animation walkLeft = new Animation(walkingLeft, 10);
    private final Animation walkRight = new Animation(walkingRight, 10);
    private final Animation stand = new Animation(standing, 10);
    // This is the actual animation

    private Animation animation = stand;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//            animation.update();
            g.drawImage(animation.getSprite(), getWidth()/2, getHeight()/2, null);
//            repaint();
//        System.out.println(Thread.currentThread().toString());
//            revalidate();
    }
}
