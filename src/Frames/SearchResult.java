package Frames;

import Database.EmployeeData;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class SearchResult extends JFrame implements ActionListener {

    JLabel name_label,emailid_label,id_label,phone_label,salary_label,age_label,image_view,email_existed;
    JTextField Name,EmailId,Phone,Salary,Age,ID;
    JButton selectImage,Cancel;
    JPanel image_panel;
    public SearchResult(String resultEmail){
        String[] data;
        data = EmployeeData.searchByEmail(resultEmail);
        new SetAttributes().set(this);
        setTitle("Insert Page");
        name_label = new JLabel("Name:");
        name_label.setBounds(20,20,70,20);
        Name = new JTextField(data[2]);
        Name.setBounds(70,20,200,20);

        emailid_label = new JLabel("Email Id:");
        emailid_label.setBounds(20, 60,80,20);
        EmailId = new JTextField(data[1]);
        EmailId.setBounds(70,60,200,20);

        id_label = new JLabel("ID:");
        id_label.setBounds(20,100,80,20);
        ID = new JTextField(data[0]);
        ID.setBounds(70,100,200,20);

        phone_label = new JLabel("Phone:");
        phone_label.setBounds(20,140,80,20);
        Phone = new JTextField(data[3]);
        Phone.setBounds(70,140,200,20);

        salary_label = new JLabel("Salary:");
        salary_label.setBounds(20,180,80,20);
        Salary = new JTextField(data[4]);
        Salary.setBounds(70,180,200,20);

        age_label = new JLabel("Age:");
        age_label.setBounds(20,220,80,20);
        Age = new JTextField(data[5]);
        Age.setBounds(70,220,200,20);

        selectImage = new JButton("Select");
        selectImage.setBounds(100,260,100,20);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        image_panel = new JPanel();
        image_panel.setBounds(20,300,100,100);
        image_view = new JLabel();



        selectImage.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new ImageFilters());
            fileChooser.setAcceptAllFileFilterUsed(false);

            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                // imageView=new JLabel(new ImageIcon(file.getPath()));
                image_view.setIcon(new ImageIcon(file.getPath()));
                repaint();
            }
        });
        image_panel.add(image_view);

        email_existed = new JLabel("Email already existed");
        Cancel = new JButton("Cancel");
        Cancel.setBounds(300,400,100,20);
        Cancel.setBackground(Color.white); // To change background of button
        Cancel.setForeground(Color.black); // To change text color on button
        Cancel.setOpaque(true);
        Cancel.addActionListener(this);

        add(selectImage);
        add(image_panel);


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


        add(selectImage);
        add(image_panel);
        add(Cancel);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Cancel){
            setVisible(false);
            new Search();
        }
    }
}
class ImageFilters extends FileFilter {
    public final static String JPEG = "jpeg";
    public final static String JPG = "jpg";
    public final static String GIF = "gif";
    public final static String TIFF = "tiff";
    public final static String TIF = "tif";
    public final static String PNG = "png";

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = getExtension(f);
        if (extension != null) {
            if(extension.equals(TIFF) ||
                    extension.equals(TIF) ||
                    extension.equals(GIF) ||
                    extension.equals(JPEG) ||
                    extension.equals(JPG) ||
                    extension.equals(PNG)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    @Override
    public String getDescription() {
        return "Image Only";
    }

    String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}

