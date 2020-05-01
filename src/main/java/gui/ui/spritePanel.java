package gui.ui;

import core.animation.Animation;
import core.animation.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class spritePanel extends JPanel {
    private Graphics2D g2;
    public spritePanel() {
        animation.start();
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

    private final BufferedImage[] walkingLeft = Sprite.getRow(1,6); // Gets the upper left images of my sprite sheet
    private final BufferedImage[] walkingRight = {Sprite.getSprite(0, 1), Sprite.getSprite(2, 1)};
    private final BufferedImage[] standing = Sprite.getRow(0,6);
    // These are animation states

    private final Animation walkLeft = new Animation(walkingLeft, 299999);
    private final Animation walkRight = new Animation(walkingRight, 10);
    private final Animation stand = new Animation(standing, 299999);
    // This is the actual animation

    private Animation animation = stand;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//            animation.update();
            g.drawImage(animation.getSprite(), getWidth()/2-Sprite.getTileWidth()/2, getHeight()/2-Sprite.getTileHeight()/2, null);
//            repaint();
//        System.out.println(Thread.currentThread().toString());
//            revalidate();
    }
}
