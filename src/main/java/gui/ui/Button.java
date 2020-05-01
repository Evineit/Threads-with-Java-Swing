package gui.ui;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private Graphics2D g2;
    Color color = Color.decode("#0088e4");
    public Button() {
        setBackground(color);
        setForeground(Color.black);
        setFont(new Font("Segoe UI", Font.BOLD,18));
//        setBorder(BorderFactory.);
//        setContentAreaFilled(false);


    }

    public Button(Icon icon) {
        super(icon);
    }

    public Button(String text) {
        super(text);
        setBackground(color);
        setForeground(Color.black);
        setFont(new Font("Segoe UI", Font.BOLD,18));


    }

    public Button(Action a) {
        super(a);
    }

    public Button(String text, Icon icon) {
        super(text, icon);
    }
        @Override
    protected void paintComponent(Graphics g) {
        setContentAreaFilled(false);
            if (ui != null) {
                Graphics scratchGraphics = (g == null) ? null : g.create();
                g2 = (Graphics2D) scratchGraphics;
//                g2.setPaint(Color.blue);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                if (isRolloverEnabled() && getModel().isRollover()){
                    g2.setPaint(color.brighter());
                }else {
                    g2.setPaint(color);
                }

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 6, 6);
//                g2.setPaint(color.);
//                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight(), 6, 6);
                try {
                    ui.update(g2, this);
                } finally {
                    scratchGraphics.dispose();
                    g2.dispose();
                }
            }
    }
}
