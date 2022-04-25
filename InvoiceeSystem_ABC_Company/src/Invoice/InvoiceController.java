package Invoice;

import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InvoiceController {
    //add invoice
    public static int addInvoice(Invoice invoice)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //System.out.println(dtf.format(now));
        String time=dateTimeFormatter.format(now);
        invoice.setInvoiceCreateDate(time);
        String sql="INSERT INTO invoice VALUES('"+invoice.getInvoiceNo()+"','"+invoice.getCustomerID()+"','"+invoice.getInvoiceCreateDate()+"',"
                + ""+invoice.getInvoiceTotalAmount()+","+invoice.getInvoiceTotalDiscount()+")";
        int i=statement.executeUpdate(sql);
        return i;
    }



    //display all generated invoices
    public static void getInvoices()throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from invoice";
        ResultSet resultSet=statement.executeQuery(sql);

        while(resultSet.next()){

            String invoiceNo=resultSet.getString("invoice_no");
            String customerID=resultSet.getString("customer_id");
            String invoiceDate=resultSet.getString("invoice_date");
            String invoiceTotalPrice=resultSet.getString("total_price");
            String invoiceTotalDiscount=resultSet.getString("total_discount");

            System.out.println("Invoice No="+invoiceNo+"    Customer ID="+customerID+"   Invoice Issued Date="+invoiceDate+"   Total Amount= Rs."+invoiceTotalPrice+"   Total Discount= Rs."+invoiceTotalDiscount);
        }
    }

    //check invoice no not exists in the table
    public static boolean checkInvoiceNo(Invoice invoice)throws ClassNotFoundException,SQLException{

        boolean invoiceExists=true;

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="SELECT invoice_no FROM invoice WHERE invoice_no='"+invoice.getInvoiceNo()+"'";
        ResultSet resultSet=statement.executeQuery(sql);

        while(resultSet.next()){

            String invoiceID=resultSet.getString("invoice_no");

            if(invoiceID.equals(invoice.getInvoiceNo())){
                invoiceExists=false;
            }
        }

        return invoiceExists;
    }


    //auto generate invoice ID method
    public static String nextInvoiceID() throws ClassNotFoundException,SQLException{

        String nextInvoiceID="No Invoice No";

        Connection connection=DBConnector.getConnection();
        Statement statement =connection.createStatement();
        String sql="SELECT COUNT(invoice_no) FROM invoice";
        ResultSet resultSet=statement.executeQuery(sql);

        resultSet.next();
        int invoicesCount=resultSet.getInt(1)+1;

        nextInvoiceID="T-"+invoicesCount;

        return nextInvoiceID;
    }




}


