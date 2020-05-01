package gui.ui;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public Label(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public Label(String text) {
        super(text);
        setFont(new Font("Segoe UI", Font.PLAIN,16));
        setForeground(Color.white);
//        setBackground(C);


    }

    public Label(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public Label(Icon image) {
        super(image);
    }

    public Label() {
        setFont(new Font("Segoe UI", Font.BOLD,20));
        setForeground(Color.white);
    }
}
