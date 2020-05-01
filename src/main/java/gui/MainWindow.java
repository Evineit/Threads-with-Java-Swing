package gui;

import javax.swing.*;

public class MainWindow {
    public void iniciar(){
        JFrame frame = new JFrame("Hilosu Testo");
        frame.setContentPane(new JPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
