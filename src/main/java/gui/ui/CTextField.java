package gui.ui;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class CTextField extends JTextField {
    public CTextField() {
//        setColumns(1);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setMinimumSize(new Dimension(45,30));
        setPreferredSize(new Dimension(45,30));
    }

    public CTextField(String text) {
        super(text);
//        setColumns(1);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }

    public CTextField(int columns) {
        super(columns);
//        setColumns(1);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }

    public CTextField(String text, int columns) {
        super(text, columns);
        setColumns(1);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }

    public CTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
        setColumns(1);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }
}
