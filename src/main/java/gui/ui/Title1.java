package gui.ui;

import javax.swing.*;
import java.awt.*;

public class Title1 extends JLabel {
    public Title1(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public Title1(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public Title1(String text) {
        super(text);
        this.setFont(new Font("Segoe UI Semibold", Font.PLAIN,29));

    }

    public Title1(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public Title1(Icon image) {
        super(image);
    }

    public Title1() {
        this.setFont(new Font("Segoe UI Semibold", Font.PLAIN,29));
        setForeground(Color.white);
    }
}
