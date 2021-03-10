package Frames;


import Database.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegistrationForm extends JFrame implements ActionListener {
    JLabel email,password,duplicate_email;
    JTextField Email;
    JButton Previous,Register;
    JCheckBox ShowPassword;
    JPasswordField Password;



    boolean flag =true;

    RegistrationForm(){
        new SetAttributes().set(this);
        setTitle("Registration Page");

         email = new JLabel("Email:");
         password = new JLabel("Password:");

        email.setBounds(20,20,60,20);
        password.setBounds(20,60,60,20);

         Email = new JTextField();
         Password = new JPasswordField();

        Email.setBounds(80,20,200,20);
        Password.setBounds(80,60,200,20);

        ShowPassword = new JCheckBox("Show Password");
        ShowPassword.setBounds(80,100,160,20);


        Previous = new JButton("Previous");
        Previous.setBounds(20,400,100,60);

        Previous.addActionListener(this);

        Register = new JButton("Register");
        Register.setBounds(300,400,100,60);
        Register.addActionListener(this);


        duplicate_email = new JLabel();


        getContentPane().setBackground(Color.LIGHT_GRAY); // To change background of JFrame


        Email.setBackground(Color.white); // To change background of button
        Email.setForeground(Color.black); // To change text color on button
        Email.setOpaque(true);

        Password.setBackground(Color.white); // To change background of button
        Password.setForeground(Color.black); // To change text color on button
        Password.setOpaque(true);

        Register.setBackground(Color.white); // To change background of button
        Register.setForeground(Color.black); // To change text color on button
        Register.setOpaque(true);

        Previous.setBackground(Color.white); // To change background of button
        Previous.setForeground(Color.black); // To change text color on button
        Previous.setOpaque(true);

        ShowPassword.addActionListener(e -> {
            JCheckBox c = (JCheckBox) e.getSource();
            Password.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        });


        add(email);
        add(password);
        add(Email);
        add(Password);
        add(Previous);
        add(ShowPassword);
        add(Register);

    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if(e.getSource() == Previous){
            setVisible(false);
            new LoginorRegister("");

        }
        if(e.getSource() == Register){
            Admin.init();
            String s =  new String(Password.getPassword());
            if(s.isBlank()){
                remove(duplicate_email);
                duplicate_email.setText("Enter vaild password");
                duplicate_email.setBounds(20,80,60,20);
                add(duplicate_email);
                repaint();
            }
            else{
                flag = Admin.add_admin(Email.getText(),new String(Password.getPassword()));
                if(!flag){
                    remove(duplicate_email);
                    duplicate_email.setText("Email id already registered");
                    duplicate_email.setBounds(100,100,100,20);
                    add(duplicate_email);
                    repaint();
                }
                else{

                    String table_name = Admin.getAscii(String.valueOf(Email.getText()));
                    Admin.create_table(table_name);
                    remove(duplicate_email);
                    new LoginorRegister("Registration Successful!");
                }

            }


        }
    }
}


