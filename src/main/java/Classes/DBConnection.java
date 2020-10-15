package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class can be used to initialize the database connection 
public class DBConnection {
    public static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
        // Database name to access
        String dbUsername = "root";
        String dbPassword = "qw79@dsg";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL,
                dbUsername,
                dbPassword);
        return con;
    }
} 