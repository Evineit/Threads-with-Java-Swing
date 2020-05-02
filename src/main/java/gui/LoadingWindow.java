package gui;

import javax.swing.*;

public class LoadingWindow {
    JFrame frame;
    JPanel panel;
    JLabel label;
    public LoadingWindow() {
        panel = new JPanel();
        label= new JLabel("Loading...");
        panel.add(label);
    }

    public void iniciar(){
        frame = new JFrame("Loading... ");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                label.setText(j +"%");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            label.setText("Carga Completa");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(new WindowMain()::iniciar);
            frame.dispose();
        }).start();
    }
}

