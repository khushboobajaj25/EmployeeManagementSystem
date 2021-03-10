package Frames;

import Database.EmployeeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame implements ActionListener {
    JLabel email_id_label,delete_label,message_label;
    JButton Delete,Previous,Delete_all_employees;
    JTextField Email_Id;
    boolean flag = true;
   Delete(){
       new SetAttributes().set(this);
       setTitle("Delete Page");

       email_id_label = new JLabel("Email id:");
       email_id_label.setBounds(20,20,60,20);

       Email_Id = new JTextField();
       Email_Id.setBounds(80,20,200,20);

       Delete = new JButton("Delete");
       Delete.setBounds(300,400,100,20);

       Previous = new JButton("Previous");
       Previous.setBounds(180,400,100,20);

       delete_label = new JLabel("User does not exist");

       Delete_all_employees = new JButton("Delete All Employees");
       Delete_all_employees.setBounds(80,60,200,20);

       message_label = new JLabel("Deleted Successfully");


       Delete.addActionListener(this);
       Previous.addActionListener(this);
       Delete_all_employees.addActionListener(this);


       add(email_id_label);
       add(Email_Id);
       add(Delete);
       add(Previous);
       add(delete_label);
       add(Delete_all_employees);
       add(message_label);
       getContentPane().setBackground(Color.LIGHT_GRAY);

       Delete.setBackground(Color.white); // To change background of button
       Delete.setForeground(Color.black); // To change text color on button
       Delete.setOpaque(true);

       Previous.setBackground(Color.white); // To change background of button
       Previous.setForeground(Color.black); // To change text color on button
       Previous.setOpaque(true);

       Delete_all_employees.setBackground(Color.white); // To change background of button
       Delete_all_employees.setForeground(Color.black); // To change text color on button
       Delete_all_employees.setOpaque(true);

   }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Delete){
            EmployeeData.init();
            flag = EmployeeData.delete(Email_Id.getText());
            if(!flag){
                delete_label .setBounds(80,60,300,20);
                repaint();
            }
            else{
                new Facility("Deleted Successfully");
                setVisible(false);
            }
        }
        if(e.getSource() == Previous){
            new Facility("");
            setVisible(false);
        }
        if(e.getSource()==Delete_all_employees){
            EmployeeData.init();
            EmployeeData.delete_all_employees();
            message_label.setBounds(20,100,200,20);
        }
    }
}
