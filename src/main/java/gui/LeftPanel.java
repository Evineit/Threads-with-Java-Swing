package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeftPanel extends JPanel{
    ArrayList<JPanel> switches = new ArrayList<>();
    public LeftPanel() {
        setMinimumSize(new Dimension(315,600));
        setPreferredSize(new Dimension(315,600));
//        setMaximumSize(new Dimension(315,600));
        setBackground(Color.black);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
    void addSwitch(JPanel toAdd){
        removeAll();
        switches.add(toAdd);
        switches.forEach(x->add(x));
//        mainPanel.add(toAdd);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("idk");
        LeftPanel leftPanel = new LeftPanel();
        JPanel panel = leftPanel;
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        leftPanel.addSwitch(new SwitchPanel());
        leftPanel.addSwitch(new SwitchPanel());
        leftPanel.addSwitch(new SwitchPanel());
        leftPanel.addSwitch(new SwitchPanel());
        leftPanel.addSwitch(new SwitchPanel());
        frame.pack();
        frame.setVisible(true);


    }
}
