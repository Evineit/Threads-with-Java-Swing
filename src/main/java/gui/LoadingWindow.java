package gui;

import javax.swing.*;
import java.awt.*;

public class LoadingWindow {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JProgressBar progressBar;
    public LoadingWindow() {
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setBackground(Color.white);
        progressBar = new JProgressBar(0,100);
        progressBar.setForeground(Color.decode("#0088e4"));
//        progressBar.getInsets().set(10,0,40,0);
//        progressBar.setPreferredSize(new Dimension(progressBar.getWidth(),progressBar.getHeight()+40));
        label= new JLabel("Loading...");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new BorderLayout());
        label.setFont(new Font("Segoe UI", Font.BOLD,20));
        panel.add(label,BorderLayout.CENTER);
        panel.add(progressBar,BorderLayout.SOUTH);
    }

    public void iniciar(){
        frame = new JFrame("Loading... ");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,130);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        new Thread(() -> {
            for (int j = 0; j <= 100; j++) {
                label.setText(j +"%");
                progressBar.setValue(j);
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

