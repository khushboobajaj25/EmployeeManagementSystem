package Database;

import Frames.SearchResult;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeData {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static String TABLE_NAME;


    public static void init() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_record", "root", "Khushi1234@");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean add_employee(int id, String name, String email, String phoneNumber, int age, long salary) {
        System.out.println(TABLE_NAME);
        try {
            String query = "INSERT INTO " + TABLE_NAME + " VALUES (" + id + " ,'" + name + "','" + email + "','" + phoneNumber + "'," + age + "," + salary + ");";
            resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID = " + id + ";");
            if (resultSet.next()) {
                return false;
            }
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean delete(String email_id) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE email  = '" + email_id + "';");
            if (resultSet.next()) {
                statement.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE email  = '" + resultSet.getString("email") + "';");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    public static boolean update_record(String em, int id, String name, String email, String phoneNumber, int age, long salary) {

        try {
            System.out.println(TABLE_NAME);
            resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME +" WHERE email  = '"+em+"';");
            if (resultSet.next()) {
                statement.executeUpdate("UPDATE " + TABLE_NAME + " SET ID = " + id + ", name =  '" + name + "' ,email = '" + email + "',phoneno = '" + phoneNumber + "',age = " + age + ",salary = " + salary + " WHERE ID = " + resultSet.getString("ID")+";");
                return true;
            }
            else{
                return false;
            }
            //statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static  void delete_all_employees(){
        try{
            statement.executeUpdate("DROP TABLE " + TABLE_NAME);
            Admin.create_table(TABLE_NAME);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public static void searchAndSetData(ArrayList<JButton> resultEmployee, String toSearch) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE "+"email"+" LIKE '" +toSearch+ "%'";
        init();
        try{
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                JButton button = new JButton(resultSet.getString("email"));
                button.addActionListener(e -> {
                    new SearchResult(button.getText());
                });

                resultEmployee.add(button);
            }
        } catch (Exception e){
            e.fillInStackTrace();
        } finally {
            close();
        }
    }







    public static String[] searchByEmail(String EMAIL){
        String query = "SELECT * FROM " + TABLE_NAME+ " WHERE "+"email"+" ='"+EMAIL+ "';";
        init();
        String res[] =new String[6];
        try{
            resultSet = statement.executeQuery(query);
            resultSet.next();
            res[0] = resultSet.getString("ID");
            res[1] = resultSet.getString("email");
            res[2] = resultSet.getString("name");
            res[3] = resultSet.getString("phoneno");
            res[4] = resultSet.getString("salary");
            res[5] = resultSet.getString("age");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            close();
        }
        return res;
    }

    public static void close () {
        try {
            connection.close();
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}








