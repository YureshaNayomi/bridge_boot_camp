package Customer;

import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CustomerController {
    //insert customer data
    public static int addCustomer(Customer customer) throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="update customer set customer_name='"+customer.getCustomerName()+"',email='"+customer.getEmail()+"',address='"+customer.getAddress()+"',contact_number="+customer.getContactNumber()+",date_of_birth='"+customer.getDateOfBirth()+"',gender='"+customer.getGender()+"' where customer_id='"+customer.getCustomerID()+"' ";
        int i=statement.executeUpdate(sql);
        return i;
    }


    //delete customer data
    public static int deleteCustomer(Customer customer)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="delete from customer where customer_id='"+customer.getCustomerID()+"'";
        int i=statement.executeUpdate(sql);
        return i;
    }


    //update customer data
    public static int updateCustomer(Customer customer)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="update customer set customer_name='"+customer.getCustomerName()+"',"
                + "email='"+customer.getEmail()+"',address='"+customer.getAddress()+"'"
                + "contact_number="+customer.getContactNumber()+",date_of_birth='"+customer.getDateOfBirth()+"'"
                + "gender='"+customer.getGender()+"' where customer_id='"+customer.getCustomerID()+"' ";
        int i = statement.executeUpdate(sql);
        return i;
    }


    //RETRIEVE ONE CUSTOMER RECORD FROM THE TABLE
    public static void getCustomer(Customer customer)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from customer where customer_id='"+customer.getCustomerID()+"'";
        ResultSet resultSet=statement.executeQuery(sql);

        while(resultSet.next()){

            String customerID=resultSet.getString("customer_id");
            String customerName=resultSet.getString("customer_name");
            String customerEmail=resultSet.getString("email");
            String customerAddress=resultSet.getString("address");
            String customerContactNo=resultSet.getString("contact_number");
            String customerDateOfBirth=resultSet.getString("date_of_birth");
            String customerGender=resultSet.getString("gender");

            System.out.println("Customer ID = "+customerID+" Customer Name = "+customerName+" Email = "+customerEmail+" Address = "
                    + ""+customerAddress+"  Contact Number = "+customerContactNo+"    Date of Birth = "+customerDateOfBirth+"  Gender = "+customerGender);
        }
    }

    //Retrieve all the customer data
    public static void getCustomers()throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from customer";
        ResultSet resultSet=statement.executeQuery(sql);

        while(resultSet.next()){

            String customerID=resultSet.getString("customer_id");
            String customerName=resultSet.getString("customer_name");
            String customerEmail=resultSet.getString("email");
            String customerAddress=resultSet.getString("address");
            String customerContactNo=resultSet.getString("contact_number");
            String customerDateOfBirth=resultSet.getString("date_of_birth");
            String customerGender=resultSet.getString("gender");

            System.out.println("Customer ID = "+customerID+" Customer Name = "+customerName+" Email = "+customerEmail+" Address = "
                    + ""+customerAddress+"  Contact Number = "+customerContactNo+"    Date of Birth = "+customerDateOfBirth+"  Gender = "+customerGender);
        }
    }


    //check customer exists
    public static boolean customerCheck(Customer customer)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from customer where customer_id='"+customer.getCustomerID()+"'";
        ResultSet resultSet=statement.executeQuery(sql);
        boolean i=false;
        while(resultSet.next()){

            String customerID=resultSet.getString("customer_id");


            if(customerID.equals(customer.getCustomerID())){
                i=true;
            }
        }

        return i;
    }

}



