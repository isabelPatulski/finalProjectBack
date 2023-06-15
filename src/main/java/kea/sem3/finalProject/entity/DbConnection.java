package kea.sem3.finalProject.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Singleton class til at håndtere databaseConnection
public class DbConnection {
    public static String dbName = "finalProject";
    private static String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
    private static String user = "root";
    private static String password = "12345678";

    private static Connection connection;          //Statisk variabel til genbrug af connection databasen

    static void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //Initialisering af forbindelse til driver og database. Udføres når objekt oprettes
    static {
        if (connection == null) {
            createConnection();
        }
    }

    public static Connection connect() {
        if (connection == null) { //Hvis ikke der allerede er oprettet en forbindelse til JDBC-driver og database, så opret en forbindelse
            createConnection(); //Kalder statisk metode
        }
        return connection; //Retunere ny eller eksisterende connection
    }
}