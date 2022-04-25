package Product;

public class Product {

    private String productID;
    private String productName;
    private String productDescription;
    private double purchasePrice;
    private double sellingPrice;
    private int quantity;

    //constructors

    public Product(){
        productID="P000";
        productName="";
        productDescription="";
        purchasePrice=0.0;
        sellingPrice=0.0;
        quantity=0;
    }

    public Product(String productID, String productName, String productDescription, double purchasePrice, double sellingPrice, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    //setters

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //getters


    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
