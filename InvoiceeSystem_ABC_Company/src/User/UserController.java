package User;

import DBConnection.DBConnector;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class UserController {
    //login function
    public static boolean loginUser(User user)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from user where user_id='"+user.getUserID()+"' and password='"+user.getUserPassword()+"'";
        ResultSet resultSet=statement.executeQuery(sql);
        boolean i=false;
        while(resultSet.next()){

            String uID=resultSet.getString("user_id");
            String pass=resultSet.getString("password");

            if(uID.equals(user.getUserID()) & pass.equals(user.getUserPassword())){
                i=true;
            }
        }

        return i;
    }

}


