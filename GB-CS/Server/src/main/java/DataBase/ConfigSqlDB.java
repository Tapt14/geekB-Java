package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigSqlDB {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found");
        }

    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:DataBase/GB_CS.db");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            throw new RuntimeException("Driver Registration Error");
        }
    }
}
