package Customer;

public class Customer {
    //member variable
    //member variables
    private String customerID;
    private String customerName;
    private String email;
    private String address;
    private int contactNumber;
    private String dateOfBirth;
    private String gender;

    //constructors
    public Customer(){

        customerID="C000";
        customerName="Unkown-Customer";
        email="Unkown-Email";
        address="Unkown-address";
        contactNumber=0;
        dateOfBirth="";
        gender="Unkown";
    }

    public Customer(String customerID, String customerName, String email, String address, int contactNumber, String dateOfBirth, String gender) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    //setters

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //getters

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }
}
