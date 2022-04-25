package AdminTask;

import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminTAskController {
    //add task
    public static int addTask(Admin admin)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time=dateTimeFormatter.format(now);
        String sql="insert into admin_task(task_date,task_information) values('"+time+"','"+admin.getTaskInformation()+"')";
        int i=statement.executeUpdate(sql);
        return i;
    }

    //display all task that have done earlier
    public static void getTasks()throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from admin_task";
        ResultSet resultSet=statement.executeQuery(sql);

        while(resultSet.next()){

            String taskID=resultSet.getString("task_id");
            String taskDate=resultSet.getString("task_date");
            String taskInfo=resultSet.getString("task_information");

            System.out.println("Task ID="+taskID+"--------->Date and Time="+taskDate+"--------->"+taskInfo);

        }
    }
}


