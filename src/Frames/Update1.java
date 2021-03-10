package Frames;

import Database.EmployeeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update1 extends JFrame implements ActionListener {
    JLabel name_label,emailid_label,id_label,phone_label,salary_label,age_label,image_view,email_not_exist;
    JTextField Name,EmailId,Phone,Salary,Age,ID;
    JButton Update,Previous;
    String res ;
    boolean flag = true;
    Update1(String em){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        new SetAttributes().set(this);
        setTitle("Update Page");
        name_label = new JLabel("Name:");
        name_label.setBounds(20,20,70,20);
        Name = new JTextField();
        Name.setBounds(70,20,200,20);

        emailid_label = new JLabel("Email Id:");
        emailid_label.setBounds(20, 60,80,20);
        EmailId = new JTextField();
        EmailId.setBounds(70,60,200,20);

        id_label = new JLabel("ID:");
        id_label.setBounds(20,100,80,20);
        ID = new JTextField();
        ID.setBounds(70,100,200,20);

        phone_label = new JLabel("Phone:");
        phone_label.setBounds(20,140,80,20);
        Phone = new JTextField();
        Phone.setBounds(70,140,200,20);

        salary_label = new JLabel("Salary:");
        salary_label.setBounds(20,180,80,20);
        Salary = new JTextField();
        Salary.setBounds(70,180,200,20);

        age_label = new JLabel("Age:");
        age_label.setBounds(20,220,80,20);
        Age = new JTextField();
        Age.setBounds(70,220,200,20);

        add(name_label);
        add(Name);

        add(emailid_label);
        add(EmailId);

        add(ID);
        add(Phone);

        add(id_label);
        add(phone_label);

        add(salary_label);
        add(Salary);

        add(age_label);
        add(Age);

        Update = new JButton("Update");
        Update.setBounds(300,400,100,20);
        Update.addActionListener(this);

        add(Update);
        res = em;
        email_not_exist = new JLabel("Email not existed");
        add(email_not_exist);
        Update.setBackground(Color.white); // To change background of button
        Update.setForeground(Color.black); // To change text color on button
        Update.setOpaque(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Update){
            EmployeeData.init();
            flag = EmployeeData.update_record(res,Integer.parseInt(ID.getText()),Name.getText(),EmailId.getText(),Phone.getText(),Integer.parseInt(Age.getText()),Long.parseLong(Salary.getText()));
            if(flag){
                new Facility("Updated Successfully");

            }
            else{
                email_not_exist.setBounds(200,400,100,20);
                repaint();
            }
        }
    }
}
