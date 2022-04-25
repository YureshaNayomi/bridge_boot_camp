package Invoice;

public class Invoice {

    //member variables
    private String invoiceNo;
    private String customerID;
    private String invoiceCreateDate;
    private double invoiceTotalAmount;
    private double invoiceTotalDiscount;

    private String productID;
    private double unitPerPrice;
    private int itemQuantity;
    private double perItemDiscount;
    private double perItemTotal;

    //constructors
    public Invoice() {

        invoiceNo="I000";
        customerID="C000";
        invoiceCreateDate="";
        invoiceTotalAmount=0.0;
        invoiceTotalDiscount=0.0;

        productID="P000";
        unitPerPrice=0.0;
        itemQuantity=0;
        perItemDiscount=0.0;
        perItemTotal=0.0;
    }

    public Invoice(String invoiceNo, String customerID, String invoiceCreateDate, double invoiceTotalAmount, double invoiceTotalDiscount, String productID, double unitPerPrice, int itemQuantity, double perItemDiscount, double perItemTotal) {
        this.invoiceNo = invoiceNo;
        this.customerID = customerID;
        this.invoiceCreateDate = invoiceCreateDate;
        this.invoiceTotalAmount = invoiceTotalAmount;
        this.invoiceTotalDiscount = invoiceTotalDiscount;
        this.productID = productID;
        this.unitPerPrice = unitPerPrice;
        this.itemQuantity = itemQuantity;
        this.perItemDiscount = perItemDiscount;
        this.perItemTotal = perItemTotal;
    }

    //setters

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setInvoiceCreateDate(String invoiceCreateDate) {
        this.invoiceCreateDate = invoiceCreateDate;
    }

    public void setInvoiceTotalAmount(double invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
    }

    public void setInvoiceTotalDiscount(double invoiceTotalDiscount) {
        this.invoiceTotalDiscount = invoiceTotalDiscount;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setUnitPerPrice(double unitPerPrice) {
        this.unitPerPrice = unitPerPrice;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setPerItemDiscount(double perItemDiscount) {
        this.perItemDiscount = perItemDiscount;
    }

    public void setPerItemTotal(double perItemTotal) {
        this.perItemTotal = perItemTotal;
    }

    //getters

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getInvoiceCreateDate() {
        return invoiceCreateDate;
    }

    public double getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    public double getInvoiceTotalDiscount() {
        return invoiceTotalDiscount;
    }

    public String getProductID() {
        return productID;
    }

    public double getUnitPerPrice() {
        return unitPerPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getPerItemDiscount() {
        return perItemDiscount;
    }

    public double getPerItemTotal() {
        return perItemTotal;
    }
}
