package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/myDB";

    private DatabaseConnection() {
    }

    public static Connection getConnection()
            throws SQLException {

        String username = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        return DriverManager.getConnection(
                URL,
                username,
                password
        );
    }

}




