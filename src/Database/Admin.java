package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {
    private final static String TABLE_NAME = "admin_record";
    private final static String EMAIL_COLUMN = "admin_email";
    private final static String PASSWORD_COLUMN = "admin_password";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void init() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_record", "root", "Khushi1234@");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }








    public static void create_table(String table_name) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_record", "root", "Khushi1234@");
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + table_name + " (ID int PRIMARY KEY ,name varchar(50),email varchar(50),phoneno varchar(50),age int,salary long);");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean add_admin(String email, String password) {
        String Password = HashPassword.getSHA256(password);
        String query = "INSERT INTO " + TABLE_NAME + "  VALUES('" + email + "','" + Password + "');";

        try {
            resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + EMAIL_COLUMN + " = '" + email + "';");

            if (resultSet.next()) {
                // This condition is to check duplicate email in database
                return false;
            }
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static String getAscii (String email){
        char[] em;
        em = email.toCharArray();

        StringBuilder res = new StringBuilder();
        for (char c : em) {
            if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')) {
                char x;
                x = c;
                var y = (int) x;
                res.append(y);
            } else {
                res.append(c);
            }
        }
        return  EmployeeData.TABLE_NAME = String.valueOf(res);
    }
    public static boolean CheckId(String email, String password) {
        String Password = HashPassword.getSHA256(password);
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + EMAIL_COLUMN + " = '" + email + "';");
            if (resultSet.next()) {
                return resultSet.getString(PASSWORD_COLUMN).equals(Password);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
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




