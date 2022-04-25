package Main;
import AdminTask.Admin;
import AdminTask.AdminTAskController;
import Customer.Customer;
import Customer.CustomerController;
import Invoice.Invoice;
import Invoice.InvoiceController;
import Invoice.InvoiceItemController;
import Product.Product;
import Product.ProductController;
import User.User;
import User.UserController;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Admin admin1=new Admin();

        User user=new User();
        String userID,pass;
        int mainMenuController,subMenuController;
        String mainExit="y";
        String subExit="y";
        try{



            System.out.println("$$$$---Welcome to The ABC Company Invoice System---$$$$");
            System.out.print("Please enter User Name: ");
            user.setUserID(scanner.next());
            System.out.print("Please enter Password: ");
            user.setUserPassword(scanner.next());


            //call login function
            boolean A =UserController.loginUser(user);

            if(A==false){
                System.out.println("access denied!..Username or Password Incorrect...!!");

                admin1.setTaskInformation("Access Denied! Login Failed...!!");
                AdminTAskController.addTask(admin1);
            }else{
                admin1.setTaskInformation("Access Granted | Successfully Log Into The System.....!!!");
                AdminTAskController.addTask(admin1);

                do{
                    System.out.println("*****---Invoice generate System Main Menu---*****");
                    //main menu
                    System.out.println("1.. Manage Products");
                    System.out.println("2.. Manage Customers");
                    System.out.println("3.. Invoice Generation");
                    System.out.println("4.. Display All Invoices");
                    System.out.println("5.. Admin Tasks");
                    System.out.println("6.. Exit from the System");

                    System.out.print("Please enter the Number to Select a Menu Item : ");
                    //getting user input to select main menu item
                    mainMenuController=scanner.nextInt();

                    //end of main menu

                    if(mainMenuController==1){

                        System.out.println("*****---You selected Manage Products from the Main Menu---*****");
                        Product product=new Product();

                        do{
                            System.out.println("These are the Products Managements");
                            //products menu
                            System.out.println("1.. Add New Product");
                            System.out.println("2.. Delete A Product");
                            System.out.println("3.. Update A Product");
                            System.out.println("4.. Display A product Details");
                            System.out.println("5.. Display All the Products details");
                            System.out.println("6.. Back to Main menu");

                            System.out.print("Enter the number of the Selected Function : ");
                            //getting user selection to products
                            subMenuController=scanner.nextInt();

                            switch(subMenuController){

                                //add product
                                case 1:
                                    System.out.println("@**- You Selected Add A New Product Function -**@");

                                    System.out.print("Enter Product ID: ");
                                    product.setProductID(scanner.next());

                                    System.out.print("Enter Product Name: ");
                                    product.setProductName(scanner.next());

                                    System.out.print("Enter Product Description: ");
                                    product.setProductDescription(scanner.next());

                                    System.out.print("Enter Product Purchase Price: ");
                                    product.setPurchasePrice(scanner.nextDouble());

                                    System.out.print("Enter Product Selling Price: ");
                                    product.setSellingPrice(scanner.nextDouble());

                                    System.out.print("Enter Product Quantity: ");
                                    product.setQuantity(scanner.nextInt());

                                    int g=ProductController.addProduct(product);

                                    if(g!=0){
                                        System.out.println("Product Added");
                                        admin1.setTaskInformation("A New Product Added | "+product.getProductID()+" - "+product.getProductName());
                                        AdminTAskController.addTask(admin1);
                                    }
                                    break;
                                //delete product
                                case 2:
                                    System.out.println("@**- You Selected Delete A Product Function -**@");

                                    System.out.print("Enter Product ID: ");
                                    product.setProductID(scanner.next());

                                    int h=ProductController.deleteProduct(product);

                                    if(h!=0){
                                        System.out.println("Product Deleted");
                                        admin1.setTaskInformation("A Product Deleted | "+product.getProductID());
                                        AdminTAskController.addTask(admin1);
                                    }
                                    break;
                                //update product
                                case 3:
                                    System.out.println("@**- You Selected Update A Product Function -**@");

                                    System.out.print("Enter product ID that you want to update: ");
                                    product.setProductID(scanner.next());

                                    System.out.print("Enter New Product Name: ");
                                    product.setProductName(scanner.next());

                                    System.out.print("Enter New Product Description: ");
                                    product.setProductDescription(scanner.next());

                                    System.out.print("Enter New Product Purchase Price: ");
                                    product.setPurchasePrice(scanner.nextDouble());

                                    System.out.print("Enter New Product Selling Price: ");
                                    product.setSellingPrice(scanner.nextDouble());

                                    System.out.print("Enter New Product Quantity: ");
                                    product.setQuantity(scanner.nextInt());

                                    int i=ProductController.updateProduct(product);

                                    if(i!=0){
                                        System.out.println("Product Updated");
                                        admin1.setTaskInformation("A Product Updated | "+product.getProductID());
                                        AdminTAskController.addTask(admin1);
                                    }
                                    break;
                                //get one product details
                                case 4:
                                    System.out.println("@**- You Selected Display A Product Function -**@");

                                    System.out.print("Enter product ID that you want to get Details: ");
                                    product.setProductID(scanner.next());

                                    ProductController.getProduct(product);
                                    admin1.setTaskInformation("A Product Displayed | "+product.getProductID());
                                    AdminTAskController.addTask(admin1);

                                    break;
                                //get all the product details
                                case 5:
                                    System.out.println("@**- You Selected Display All Products Function -**@");

                                    ProductController.getProducts();
                                    admin1.setTaskInformation("All Products Displayed");
                                    AdminTAskController.addTask(admin1);

                                    break;

                                case 6:
                                    break;

                                default:
                                    System.out.println("Invalid Input!");
                            }

                            if(subMenuController==6){
                                break;
                            }
                            System.out.println("Do you want to go back to Product Management Menu?(press y/n)");
                            subExit=scanner.next();

                        }while(subExit.equals("y"));

                    }
                    else if(mainMenuController==2){

                        System.out.println("@@@--- You selected Manage Customers from the Main Menu ---@@@");
                        Customer customer=new Customer();

                        do{
                            System.out.println("These are the Customers Managements");
                            //customers menu
                            System.out.println("1.. Add New Customer");
                            System.out.println("2.. Delete A Customer");
                            System.out.println("3.. Update A Customer");
                            System.out.println("4.. Display A Customer Details");
                            System.out.println("5.. Display All the Customers details");
                            System.out.println("6.. Back to Main menu");

                            System.out.print("Enter the number of the Selected Function : ");
                            //getting user selection to products
                            subMenuController=scanner.nextInt();

                            switch(subMenuController){

                                //add customer
                                case 1:
                                    System.out.println("@@@**- You Selected Add A New Customer Function -**@@@");

                                    System.out.print("Enter Customer ID: ");
                                    customer.setCustomerID(scanner.next());

                                    System.out.print("Enter Customer Name: ");
                                    customer.setCustomerName(scanner.next());

                                    System.out.print("Enter Customer Email: ");
                                    customer.setEmail(scanner.next());

                                    System.out.print("Enter Customer Address:");
                                    customer.setAddress(scanner.next());

                                    System.out.print("Enter Customer Contact Number: ");
                                    customer.setContactNumber(scanner.nextInt());

                                    System.out.println("Enter Customer Date of Birth(YYYY-MM-DD): ");
                                    customer.setDateOfBirth(scanner.next());

                                    System.out.println("Enter Customer Gender: ");
                                    customer.setGender(scanner.next());

                                    int i=CustomerController.addCustomer(customer);

                                    if(i!=0){
                                        System.out.println("Customer Added");
                                        admin1.setTaskInformation("A New Customer Added | "+customer.getCustomerID()+"-"+customer.getCustomerName());
                                        AdminTAskController.addTask(admin1);
                                    }
                                    break;
                                //delete customer
                                case 2:
                                    System.out.println("@**- You Selected Delete A Customer Function -**@");

                                    System.out.print("Enter Customer ID: ");
                                    customer.setCustomerID(scanner.next());

                                    int j=CustomerController.deleteCustomer(customer);

                                    if(j!=0){
                                        System.out.println("Customer Deleted");
                                        admin1.setTaskInformation("A Customer Deleted | "+customer.getCustomerID());
                                        AdminTAskController.addTask(admin1);
                                    }
                                    break;
                                //update Customer
                                case 3:
                                    System.out.println("@**- You Selected Update A Customer Function -**@");

                                    System.out.print("Enter Customer ID that you want to update: ");
                                    customer.setCustomerID(scanner.next());

                                    System.out.print("Enter New Customer Name: ");
                                    customer.setCustomerName(scanner.next());

                                    System.out.print("Enter New Customer Email: ");
                                    customer.setEmail(scanner.next());

                                    System.out.print("Enter New Customer Address:");
                                    customer.setAddress(scanner.next());

                                    System.out.print("Enter New Customer Contact Number: ");
                                    customer.setContactNumber(scanner.nextInt());

                                    System.out.print("Enter New Customer Date of Birth(YYYY-MM-DD): ");
                                    customer.setDateOfBirth(scanner.next());

                                    System.out.print("Enter New Customer Gender: ");
                                    customer.setGender(scanner.next());

                                    int k=CustomerController.updateCustomer(customer);

                                    if(k!=0){
                                        System.out.println("Customer Updated");
                                        admin1.setTaskInformation("A Customer updated | "+customer.getCustomerID());
                                        AdminTAskController.addTask(admin1);
                                    }
                                    break;
                                //get one customer details
                                case 4:
                                    System.out.println("@@**- You Selected Display A Customer Function -**@@");

                                    System.out.print("Enter Customer ID that you want to get Details: ");
                                    customer.setCustomerID(scanner.next());

                                    CustomerController.getCustomer(customer);
                                    admin1.setTaskInformation("A Customer details Displayed");
                                    AdminTAskController.addTask(admin1);
                                    break;

                                //get all customers details
                                case 5:
                                    System.out.println("@@**- You Selected Display All Customers Function -**@@");

                                    CustomerController.getCustomers();
                                    admin1.setTaskInformation("All Customers Displayed");
                                    AdminTAskController.addTask(admin1);

                                    break;

                                case 6:
                                    break;

                                default:
                                    System.out.println("Invalid Input!");
                            }
                            if(subMenuController==6){
                                break;
                            }

                            System.out.println("Do you want to go back to Product Management Menu?(press y/n)");
                            subExit=scanner.next();
                        }while(subExit.equals("y"));

                    }
                    else if(mainMenuController==3){
                        //invoice generate process
                        System.out.println("*****--- You selected Invoice Generation from the Main Menu ---*****");
                        Invoice invoice1 =new Invoice();

                        System.out.print("Enter Invoice ID Number: ");
                        invoice1.setInvoiceNo(scanner.next());


                        boolean invoiceApp=InvoiceController.checkInvoiceNo(invoice1);

                        if(invoiceApp==false){
                            System.out.println("Invalid Invoice ID or This ID Already Taken");
                        }else{
                            System.out.println("valid invoice ID");


                            System.out.print("Enter Customer ID: ");
                            //String cus=scan.next();
                            invoice1.setCustomerID(scanner.next());

                            Customer c2=new Customer();
                            c2.setCustomerID(invoice1.getCustomerID());

                            boolean customerApp=CustomerController.customerCheck(c2);

                            if(customerApp==false){
                                System.out.println("!!! Invalid Customer ID !!!");
                            }else{
                                CustomerController.getCustomer(c2);
                                String addItem="y";
                                Product product2=new Product();

                                double totalDiscountOfInvoice=0.0;
                                double totalAmountOfInvoice=0.0;

                                do{
                                    //adding Product to invoice

                                    //get product ID
                                    System.out.print("Enter product ID: ");
                                    product2.setProductID(scanner.next());

                                    //checking product availability
                                    boolean productExits=ProductController.checkProductExists(product2);
                                    if(productExits==false){
                                        System.out.println("Invalid Product ID!");
                                    }
                                    else{
                                        //if the product exists, now adding the product items to the Invoice
                                        ProductController.getProduct(product2);

                                        System.out.print("Enter Product Quantity: ");
                                        invoice1.setItemQuantity(scanner.nextInt());

                                        System.out.print("Enter Discount for per Product: ");
                                        invoice1.setPerItemDiscount(scanner.nextDouble());


                                        boolean availability=ProductController.checkProductQuantityAvailability(product2);

                                        if (availability==true){

                                            System.out.println("yes! we have stock available!!!!");

                                            //invoice id
                                            System.out.println("Invoice No = "+invoice1.getInvoiceNo());

                                            //product id setting to invoice
                                            invoice1.setProductID(product2.getProductID());
                                            System.out.println("product id is "+invoice1.getProductID());

                                            //quantity store into invoice
                                            //inv1.setItemQuantity(p2.getQuantity());
                                            System.out.println("product quantity for invoice "+invoice1.getItemQuantity());
                                            //update current available stock on product table
                                            product2.setProductID(invoice1.getProductID());
                                            product2.setQuantity(invoice1.getItemQuantity());
                                            int updatedStock=ProductController.updateProductStock(product2);
                                            if(updatedStock!=0){System.out.println("$$------product stock has been updated!----$$");}

                                            //get product selling price
                                            invoice1.setUnitPerPrice(ProductController.getProductUnitPrice(product2));
                                            System.out.println("invoice added unit price is "+invoice1.getUnitPerPrice());

                                            //get discount per product
                                            System.out.println("Discount per Item is = "+invoice1.getPerItemDiscount());
                                            //total product discount calculation
                                            totalDiscountOfInvoice+=(invoice1.getPerItemDiscount()*invoice1.getItemQuantity());

                                            //display item total price
                                            invoice1.setPerItemTotal(InvoiceItemController.itemTotalPriceCalculation(invoice1.getUnitPerPrice(),invoice1.getPerItemDiscount(),invoice1.getItemQuantity()));
                                            System.out.println("total item price= Rs."+invoice1.getPerItemTotal());
                                            //total product price calculation
                                            totalAmountOfInvoice+=invoice1.getPerItemTotal();

                                            //add one particular item record to invoice item table
                                            int addItemToInvoice=InvoiceItemController.addItemToInvoice(invoice1);
                                            if(addItemToInvoice!=0){
                                                System.out.println("***-- The Product added to the Invoice --***");
                                                admin1.setTaskInformation("A New Invoice Generated | "+invoice1.getInvoiceNo());
                                                AdminTAskController.addTask(admin1);
                                            }


                                        }else{
                                            System.out.println("Sorry there is no Stock   available!");
                                        }


                                    }

                                    System.out.print("Do you want Add another Product to Invoice(press y/n): ");
                                    addItem=scanner.next();
                                }while(addItem.equals("y"));

                                //add invoice
                                invoice1.setInvoiceTotalAmount(totalAmountOfInvoice);
                                invoice1.setInvoiceTotalDiscount(totalDiscountOfInvoice);
                                int addInvoice=InvoiceController.addInvoice(invoice1 );
                                if(addInvoice!=0){
                                    System.out.println("Invoice Created");
                                }

                            }


                        }


                    }
                    else if(mainMenuController==4){

                        InvoiceController.getInvoices();
                        admin1.setTaskInformation("All Invoices Displayed");
                        AdminTAskController.addTask(admin1);
                    }
                    else if(mainMenuController==5){
                        //admin task
                        System.out.println("@@****--- You selected Admin Task from the Main Menu ---*****@@");
                        AdminTAskController.getTasks();
                        admin1.setTaskInformation("All Admin Tasks Displayed");
                        AdminTAskController.addTask(admin1);



                    }
                    else if(mainMenuController==6){
                        break;
                    }
                    else{

                    }

                    System.out.println("Do you want to go back to Main menu?(press y/n)");
                    mainExit=scanner.next();

                }while(mainExit.equals("y"));

                System.out.println("Thank you.............!");
                admin1.setTaskInformation("LogOut From the System");
                AdminTAskController.addTask(admin1);

            }

        }
        catch(ClassNotFoundException ex){
            System.out.println("class not founded!");
        }catch(SQLException ex){
            System.out.println("SQL error!");
        }

    }

}



