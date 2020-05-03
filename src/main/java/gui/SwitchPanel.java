package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwitchPanel extends JPanel {
    public static Color BGCOLOR = Color.decode("#363636");
    public static Color COLORSEL = Color.decode("#707070");

    public SwitchPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public SwitchPanel(LayoutManager layout) {
        super(layout);
    }

    public SwitchPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public SwitchPanel() {
        setPreferredSize(new Dimension(315,40));
        setMaximumSize(new Dimension(325,40));
        setBackground(BGCOLOR);
        add(new label("Testo"));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Color.blue);
            }
        });
    }
    public SwitchPanel(String s) {
        setPreferredSize(new Dimension(315,40));
        setMaximumSize(new Dimension(325,40));
        setBackground(BGCOLOR);
        add(new label(s));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Color.blue);
            }
        });
    }
}
class label extends JLabel{
    public label(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public label(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public label(String text) {
        super(text);
        setHorizontalAlignment(SwingConstants.LEFT);
//        setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        setBackground(Color.black);
        setForeground(Color.white);
        setFont(new Font("Segoe UI",Font.PLAIN,18));
    }

    public label(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public label(Icon image) {
        super(image);
    }

    public label() {
    }
}
