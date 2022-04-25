package Product;

import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductController {

    //add product

    public static int addProduct(Product product)throws ClassNotFoundException,SQLException{

        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        String sql = "Insert into product values('"+product.getProductID()+"','"+product.getProductName()+"','"+product.getProductDescription()+"','"+product.getPurchasePrice()+"','"+product.getSellingPrice()+"','"+product.getQuantity()+"')";
        int i = statement.executeUpdate(sql);
        return i;
    }


    //delete product
    public static int deleteProduct(Product product)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="delete from product where product_id='"+product.getProductID()+"'";
        int i = statement.executeUpdate(sql);
        return i;
    }


    //update product
    public static int updateProduct(Product product)throws ClassNotFoundException,SQLException{

        Connection connection = DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="update product set product_name='"+product.getProductName()+"',product_description='"+product.getProductDescription()+"',"
                + "purchase_price="+product.getPurchasePrice()+",selling_price="+product.getSellingPrice()+",quantity="+product.getQuantity()+" where product_id='"+product.getProductID()+"'";
        int i=statement.executeUpdate(sql);
        return i;
    }


    //display or retrieve one product details
    public static void getProduct(Product product)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from product where product_id='"+product.getProductID()+"'";
        ResultSet resultSet =statement.executeQuery(sql);

        while(resultSet.next()){

            String productID=resultSet.getString("product_id");
            String productName=resultSet.getString("product_name");
            String productDescription=resultSet.getString("product_description");
            String productPurchasePrice=resultSet.getString("purchase_price");
            String productSellingPrice=resultSet.getString("selling_price");
            String productQuantity=resultSet.getString("quantity");

            System.out.println("Product ID="+productID+"    Product Name="+productName+"    Description="+productDescription+"  "
                    + " Purchase Price="+productPurchasePrice+"     Selling Price="+productSellingPrice+"   Quantity="+productQuantity);
        }

    }

    public static void getProducts()throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from product";
        ResultSet resultSet=statement.executeQuery(sql);

        while(resultSet.next()){

            String productID=resultSet.getString("product_id");
            String productName=resultSet.getString("product_name");
            String productDescription=resultSet.getString("product_description");
            String productPurchasePrice=resultSet.getString("purchase_price");
            String productSellingPrice=resultSet.getString("selling_price");
            String productQuantity=resultSet.getString("quantity");

            System.out.println("Product ID="+productID+"    Product Name="+productName+"    Description="+productDescription+""
                    + " Purchase Price= Rs."+productPurchasePrice+"     Selling Price= Rs."+productSellingPrice+"   Quantity="+productQuantity);
        }

    }


    //checking product quantity available or not
    public static boolean checkProductQuantityAvailability(Product product)throws ClassNotFoundException,SQLException{

        boolean available;
        String userEnterQuantity="0";


        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="SELECT QUANTITY FROM product WHERE product_id='"+product.getProductID()+"'";
        ResultSet resultSet=statement.executeQuery(sql);

        while(resultSet.next()){
            userEnterQuantity=resultSet.getString("quantity");
        }

        int x=Integer.parseInt(userEnterQuantity);
        if(product.getQuantity()<=x){
            available=true;
        }else{
            available=false;
        }

        return available;
    }


    //check customer exists
    public static boolean checkProductExists(Product product)throws ClassNotFoundException,SQLException{

        Connection connection=DBConnector.getConnection();
        Statement stmt=connection.createStatement();
        String sql="select product_id from product where product_id='"+product.getProductID()+"'";
        ResultSet resultSet=stmt.executeQuery(sql);
        boolean i=false;
        while(resultSet.next()){

            String productID=resultSet.getString("product_id");


            if(productID.equals(product.getProductID())){
                i=true;
            }else{ i=false;}
        }

        return i;
    }

    //take product unit price according to product id
    public static double getProductUnitPrice(Product product)throws ClassNotFoundException,SQLException{

        double unitPrice=0.0;

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="SELECT selling_price FROM product WHERE product_id='"+product.getProductID()+"'";
        ResultSet resultSet=statement.executeQuery(sql);

        while(resultSet.next()){
            String productPrice=resultSet.getString("selling_price");
            unitPrice=Double.parseDouble(productPrice);
        }

        return unitPrice;
    }

    //update product stock
    public static int updateProductStock(Product product)throws ClassNotFoundException,SQLException{

        int updateRecord;

        Connection connection=DBConnector.getConnection();
        Statement statement=connection.createStatement();
        String sql="UPDATE product set quantity=quantity-"+product.getQuantity()+" WHERE product_id='"+product.getProductID()+"'";
        updateRecord=statement.executeUpdate(sql);
        return updateRecord;
    }
}


