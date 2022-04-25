package Invoice;

import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class InvoiceItemController {
    //Item total price calculation
    public static double itemTotalPriceCalculation(double unitPrice,double discountPerUnit,int itemQuantity)throws ClassNotFoundException,SQLException{

        double totalItem=0;

       totalItem=(unitPrice-discountPerUnit)*itemQuantity;

        return totalItem;
    }

    //add Invoice one particular item
    public static int addItemToInvoice(Invoice invoice)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="INSERT INTO invoice_item VALUES('"+invoice.getInvoiceNo()+"','"+invoice.getProductID()+"',"+invoice.getUnitPerPrice()+","+invoice.getItemQuantity()+","+invoice.getPerItemDiscount()+","+invoice.getPerItemTotal()+")";
        int i = statement.executeUpdate(sql);

        return i;
    }

}


