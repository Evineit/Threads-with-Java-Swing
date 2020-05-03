package gui;

import javax.swing.*;

public class HilosuGUI {
    public static void main(String[] args) {
        try{
            SwingUtilities.invokeLater(new LoadingWindow()::iniciar);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
