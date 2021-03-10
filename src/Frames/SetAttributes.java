package Frames;

import javax.swing.*;

public class SetAttributes extends JFrame {
    public void set(JFrame frame){
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setLocation(500,250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
