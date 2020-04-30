package gui;

import javax.swing.*;

public class LoadingWindow {
    public void iniciar(){
        JFrame frame = new JFrame("Mathevnik Tools");
        frame.setContentPane(new JPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
