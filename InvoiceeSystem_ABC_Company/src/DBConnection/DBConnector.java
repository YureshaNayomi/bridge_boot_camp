package DBConnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnector {

    public static Connection getConnection()throws ClassNotFoundException,SQLException{
        Connection connection;
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Published the driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/slasscom","root","kaveen");
        return connection;
    }

}
