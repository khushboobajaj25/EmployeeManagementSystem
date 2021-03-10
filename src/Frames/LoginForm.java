package Frames;

import Database.Admin;
import Database.EmployeeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    JLabel email,password,duplicate_email;
    JTextField Email;
    JButton Previous,Login;
    JCheckBox ShowPassword;
    JPasswordField Password;
    LoginForm() {
        new SetAttributes().set(this);
        setTitle("Login Page");

         email = new JLabel("Email:");
         password = new JLabel("Password:");

        email.setBounds(20, 20, 60, 20);
        password.setBounds(20, 60, 60, 20);

         Email = new JTextField();
         Password = new JPasswordField();

        Email.setBounds(80, 20, 200, 20);
        Password.setBounds(80, 60, 200, 20);

        ShowPassword = new JCheckBox("Show Password");
        ShowPassword.setBounds(80, 100, 160, 20);


        Previous = new JButton("Previous");
        Previous.setBounds(20, 400, 100, 60);

        Previous.addActionListener(this);

        Login = new JButton("Login");
        Login.setBounds(300, 400, 100, 60);
        Login.addActionListener(this);

        getContentPane().setBackground(Color.LIGHT_GRAY); // To change background of JFrame


        Email.setBackground(Color.white); // To change background of button
        Email.setForeground(Color.black); // To change text color on button
        Email.setOpaque(true);

        Password.setBackground(Color.white); // To change background of button
        Password.setForeground(Color.black); // To change text color on button
        Password.setOpaque(true);


        Previous.setBackground(Color.white); // To change background of button
        Previous.setForeground(Color.black); // To change text color on button
        Previous.setOpaque(true);

        ShowPassword.addActionListener(e -> {
            JCheckBox c = (JCheckBox) e.getSource();
            Password.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        });
        Login.setBackground(Color.white); // To change background of button
        Login.setForeground(Color.black); // To change text color on button
        Login.setOpaque(true);

        Previous.setBackground(Color.white); // To change background of button
        Previous.setForeground(Color.black); // To change text color on button
        Previous.setOpaque(true);




        add(email);
        add(password);
        add(Email);
        add(Password);
        add(Previous);
        add(ShowPassword);
        add(Login);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


            if(e.getSource() == Login){
                    Admin.init();
                   boolean flag = Admin.CheckId(Email.getText(), new String(Password.getPassword()));
                   if(flag){
                       Admin.getAscii(Email.getText());
                       new Facility("");

                   }
                   else{

                       new LoginorRegister("Login Unsucessful");
                       setVisible(false);

                   }
                setVisible(false);
            }
            Admin.close();
            if(e.getSource()==Previous){
                new LoginorRegister("");
            }
    }
}
