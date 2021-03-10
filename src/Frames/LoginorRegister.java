package Frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginorRegister extends JFrame implements ActionListener {
    JButton login,register;
    JLabel regster_status,login_status;

    LoginorRegister(String command){
        login = new JButton();
        setTitle("Employee Records");
        login = new JButton("Login");
        login.setBounds(210,210,100,20);
        register = new JButton("Register");
        register.setBounds(210,250,100,20);

        login.addActionListener(this);
        register.addActionListener(this);



        getContentPane().setBackground(Color.lightGray); // To change background of JFrame


        login.setBackground(Color.white); // To change background of button
        login.setForeground(Color.black); // To change text color on button
        login.setOpaque(true);

        register.setBackground(Color.white); // To change background of button
        register.setForeground(Color.black); // To change text color on button
        register.setOpaque(true);
        regster_status = new JLabel();
        login_status= new JLabel();

        if(command.equals("Registration Successful!")){
            regster_status.setText("Registration Successful!");
            regster_status.setBounds(20,20,200,30);
            repaint();


        }
        if(command.equals("Login Unsucessful")){
            login_status.setText("Login Unsucessful");
            login_status.setBounds(20,20,200,30);
            repaint();


        }
        add(register);
        add(login);
        add(login_status);
        add(regster_status);
        new SetAttributes().set(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            new LoginForm();
        }
        else{
            new RegistrationForm();
        }
        setVisible(false);
    }
}

