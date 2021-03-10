package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update extends JFrame implements ActionListener {
    JLabel email_id_label;
    JTextField email_id;
    JButton Update;
    Update(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
       new SetAttributes().set(this);
       setTitle("Update Page");
       email_id_label = new JLabel("Email id:");
       email_id_label.setBounds(20,20,60,20);

       email_id = new JTextField();
       email_id.setBounds(80,20,200,20);

       Update = new JButton("Update");
       Update.setBounds(40,60,100,20);

       add(email_id_label);
       add(email_id);
       add(Update);
       Update.addActionListener(this);
        Update.setBackground(Color.white); // To change background of button
        Update.setForeground(Color.black); // To change text color on button
        Update.setOpaque(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Update){
            new Update1(email_id.getText());
            setVisible(false);

        }
    }
}
