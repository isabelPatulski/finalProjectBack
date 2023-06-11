package kea.sem3.jwtdemo.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection instance;
    private static Connection con;

    static  {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzisalle", "root", "517598");
            }
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection connect()
    {
        return con;
    }

    public static DbConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbConnection();
        } else if (instance.connect().isClosed()) {
            instance = new DbConnection();
        }
        con = instance.connect();
        return instance;
    }
}