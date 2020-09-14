package Java3.Lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigMySqlDb {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection to chat DB succesfull!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }


    }

    public static Connection getConnection() {
        try {
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?serverTimezone=Europe/Moscow", "root", "3861568evaY");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Driver Registration Error");
        }
    }
}
