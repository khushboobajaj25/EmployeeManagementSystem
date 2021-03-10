package Frames;
import Database.EmployeeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Search extends JFrame implements ActionListener {
    JTextField searchBar;
    JPanel datapanel;
    JButton back;
    ArrayList<JButton> resultEmployee;
    Search(){
        searchBar = new JTextField();
        searchBar.setBounds(20,20,400,20);
        datapanel = new JPanel();
        back = new JButton("Back");
        back.setBounds(320,320,100,20);
        resultEmployee = new ArrayList<>();
        datapanel.setBounds(20,40,400,270);
        searchBar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                        resultEmployee.clear();
                        datapanel.removeAll();
                        EmployeeData.searchAndSetData(resultEmployee,searchBar.getText());
                        displaySearchResult();
                        repaint();
            }

        });
        back.addActionListener(this);
        add(back);
        add(searchBar);
        add(datapanel);
        new SetAttributes().set(this);
        back.setBackground(Color.white); // To change background of button
        back.setForeground(Color.black); // To change text color on button
        back.setOpaque(true);
    }
    public void displaySearchResult(){
        int y=0;
        for(JButton label:resultEmployee){
            label.setBounds(20,y,300,20);
            datapanel.add(label);
            y+=20;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Facility("");
        }
    }
}
