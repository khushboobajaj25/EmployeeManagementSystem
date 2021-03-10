package Frames;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Facility  extends JFrame implements ActionListener {
    JButton EditProfile,Insert,Update,Delete,Search,Logout;
    JLabel messages;
    Facility(String message){
       new SetAttributes().set(this);
       setTitle("Activity Page");
       EditProfile = new JButton("Edit Profile");
       Insert = new JButton("Insert");
       Update = new JButton("Update");
       Delete = new JButton("Delete");
       Search = new JButton("Search");
       Logout = new JButton("Logout");

       EditProfile.setBounds(220,20,100,50);
       add(EditProfile);
       Insert.setBounds(220,80,100,50);
       add(Insert);
       Update.setBounds(220,140,100,50);
       add(Update);
       Delete.setBounds(220,200,100,50);
       add(Delete);
       Search.setBounds(220,260,100,50);
       add(Search);
       Logout.setBounds(220,320,100,50);
       add(Logout);
       Insert.addActionListener(this);
       Update.addActionListener(this);
       Delete.addActionListener(this);
       Search.addActionListener(this);
       Logout.addActionListener(this);

       messages = new JLabel(message);
       add(messages);
        Insert.setBackground(Color.white); // To change background of button
        Insert.setForeground(Color.black); // To change text color on button
        Insert.setOpaque(true);

        Delete.setBackground(Color.white); // To change background of button
        Delete.setForeground(Color.black); // To change text color on button
        Delete.setOpaque(true);

        Search.setBackground(Color.white); // To change background of button
        Search.setForeground(Color.black); // To change text color on button
        Search.setOpaque(true);

        Update.setBackground(Color.white); // To change background of button
        Update.setForeground(Color.black); // To change text color on button
        Update.setOpaque(true);

        Logout.setBackground(Color.white); // To change background of button
        Logout.setForeground(Color.black); // To change text color on button
        Logout.setOpaque(true);

        EditProfile.setBackground(Color.white); // To change background of button
        EditProfile.setForeground(Color.black); // To change text color on button
        EditProfile.setOpaque(true);



        if(message.equals("Inserted Sucessfully!!")){
            messages.setBounds(100,400,200,20);
            repaint();
        }
        if(message.equals("Deleted Successfully")){
            messages.setText(message);
            messages.setBounds(100,400,200,20);
            repaint();
        }
        if(message.equals("Updated Successfully")){
            messages.setText(message);
            messages.setBounds(100,400,200,20);
            repaint();
        }





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Insert){
            new Insert();
            setVisible(false);
        }
        if(e.getSource() == Delete){
            new Delete();
            setVisible(false);
        }
        if(e.getSource()== Update){
            new Update();
            setVisible(false);
        }
        if(e.getSource()==Logout){
            new LoginorRegister("");
        }
        if(e.getSource()==Search){
            new Search();
        }

    }
}
