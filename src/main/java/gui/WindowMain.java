package gui;

import javax.swing.*;

public class WindowMain {
    private JPanel mainPanel;
    private JPanel content;
    private JPanel stopwatch;
    private JPanel teacher;
    private JPanel fire;
    private JPanel animation;
    private LeftPanel leftPanel1;

    public void iniciar() {
        JFrame frame = new JFrame("Hilosu Test");
        frame.setContentPane(new WindowMain().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new WindowMain()::iniciar);
    }
}
