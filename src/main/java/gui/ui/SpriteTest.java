package gui.ui;

import javax.swing.*;

public class SpriteTest extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hilosu Test");
        frame.setContentPane(new spritePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}

