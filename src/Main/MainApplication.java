package Main;

import Customer.Customer;
import Customer.CustomerService;
import Customer.CustomerServiceImpl;
import OrderManagement.Order;
import OrderManagement.OrderStatus;
import Product.Product;
import Product.ProductManager;
import Staff.StaffService;
import Staff.StaffServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainApplication {
    private static Scanner scanner2 = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Main Application!");

        // Display a hello message on load
        displayHelloMessage();

        // Prompt the user to choose whether they are a staff or a customer
        int userType = promptUserType();

        if (userType == 1) { // Customer
            handleCustomer();
        } else if (userType == 2) { // Staff
            handleStaff();
        } else {
            System.out.println("Invalid choice. Exiting...");
        }

        // Display goodbye message
        displayGoodbyeMessage();
    }

    private static void displayHelloMessage() {
        System.out.println("Hello! Welcome to our application.");
    }

    private static int promptUserType() {
        System.out.println("Are you a:");
        System.out.println("1. Customer");
        System.out.println("2. Staff");
        System.out.print("Enter your choice: ");
        return scanner2.nextInt();
    }

    private static void handleCustomer() {
        // Implement customer functionality
        // Provide options to order, create an account, etc.
        // Utilize methods from CustomerService, OrderManagement, etc.
        // Instantiate services
        CustomerService customerService = new CustomerServiceImpl();
        // Assuming Customer class exists and has a default constructor
        System.out.println("Welcome, Customer!");

        while (true) {
            System.out.println("\nCustomer Options:");
            System.out.println("1. Order");
            System.out.println("2. Create an account");
            System.out.println("3. View list of products");
            System.out.println("4. Check order status");
            System.out.println("5. Change login information");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner2.nextInt();
            scanner2.nextLine(); // Consume newline character

            // Define a variable to store the order created in case 1
            Order currentOrder = null;

            switch (choice) {
                case 1:
                    // Order functionality
                    // Prompt customer for their ID
                    System.out.println("Please provide your customer ID:");
                    int customerId = scanner2.nextInt();
                    scanner2.nextLine(); // Consume newline character

                    // Fetch customer object using the provided ID
                    Customer customer = customerService.getCustomerById(customerId);

                    if (customer == null) {
                        System.out.println("Customer not found. Please try again.");
                        break;
                    }

                    System.out.println("Order Products:");
                    // Implement logic to display available products
                    // Example:
                    ProductManager productManager = new ProductManager();
                    List<Product> availableProducts = productManager.getProducts();
                    for (Product product : availableProducts) {
                        System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
                    }

                    // Prompt user to select products and quantities
                    System.out.println("Enter product ID and quantity (e.g., '1 2' for product ID 1 and quantity 2):");
                    String input = scanner2.nextLine();
                    String[] parts = input.split(" ");

                    // Create order using the fetched customer object
                    Order order = new Order(1, customer); // Assuming orderId is available
                    for (int i = 0; i < parts.length; i += 2) {
                        int productId = Integer.parseInt(parts[i]);
                        int quantity = Integer.parseInt(parts[i + 1]);
                        productManager = new ProductManager();
                        Product product = productManager.getProductById(productId);

                        // Check if product exists and quantity is valid
                        if (product != null && quantity > 0) {
                            order.addProduct(product, quantity);
                        } else {
                            System.out.println("Invalid product ID or quantity: " + productId + " " + quantity);
                        }
                    }

                    // Add order
                    order.placeOrder();
                    System.out.println("Order placed successfully!");
                    break;
                case 2:
                    // Create account functionality
                    createAccount(scanner2, customerService);
                    break;
                case 3:
                    // View list of products functionality
                    viewProducts();
                    break;
                case 4:
                    // Check order status functionality
                    if (currentOrder != null) {
                        System.out.println("Order ID: " + currentOrder.getOrderId());
                        currentOrder.getOrderStatus();
                    } else {
                        System.out.println("No order available. Please place an order first.");
                    }
                    break;
                case 5:
                    // Change login information functionality
                    changeLoginInformation(customerService);
                    break;
                case 6:
                    System.out.println("Exiting Customer Mode...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleStaff() {
        // Implement staff functionality
        // Provide options to manage products, inventory, customers, etc.
        // Utilize methods from StaffService, ProductManager, InventoryManager, etc.
        StaffService staffService = new StaffServiceImpl(); // Instantiate StaffService
        ProductManager productManager = new ProductManager(); // Instantiate ProductManager
        CustomerService customerService = new CustomerServiceImpl(); // Instantiate CustomerService

        System.out.println("Welcome, Staff!");

        while (true) {
            System.out.println("\nStaff Options:");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Orders");
            System.out.println("3. Manage Customers");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner2.nextInt();
            scanner2.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    manageProducts(productManager);
                    break;
                case 2:
                    manageOrders();
                    break;
                case 3:
                    manageCustomers();
                    break;
                case 4:
                    System.out.println("Exiting Staff Mode...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createAccount(Scanner scanner, CustomerService customerService) {

        Customer customer = new Customer(1, "Fere", "freshg665@gmail.com", "09030634956");
        System.out.println("Enter customer ID:");
        customer.setCustomerId(scanner.nextInt());
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter name:");
        customer.setName(scanner.nextLine());

        System.out.println("Enter email:");
        customer.setEmail(scanner.nextLine());

        System.out.println("Enter phone:");
        customer.setPhone(scanner.nextLine());

        customerService.addCustomer(customer);

        System.out.println("Account created successfully!");
    }



    private static void displayGoodbyeMessage() {
        System.out.println("Thank you for using the Main Application. Goodbye!");
    }
    private static void changeLoginInformation(CustomerService customerService) {
        System.out.println("Enter your customer ID:");
        int customerId = scanner2.nextInt();
        scanner2.nextLine(); // Consume newline character

        // Fetch customer object using the provided ID
        Customer customer = customerService.getCustomerById(customerId);

        if (customer == null) {
            System.out.println("Customer not found. Please try again.");
            return;
        }

        System.out.println("Enter new name (leave blank to keep current):");
        String newName = scanner2.nextLine();
        if (!newName.isEmpty()) {
            customer.setName(newName);
        }

        System.out.println("Enter new email (leave blank to keep current):");
        String newEmail = scanner2.nextLine();
        if (!newEmail.isEmpty()) {
            customer.setEmail(newEmail);
        }

        System.out.println("Enter new phone (leave blank to keep current):");
        String newPhone = scanner2.nextLine();
        if (!newPhone.isEmpty()) {
            customer.setPhone(newPhone);
        }

        // Update the customer information
        customerService.updateCustomer(customer);

        System.out.println("Login information updated successfully!");
    }
    private static void manageProducts(ProductManager productManager) {
        while (true) {
            System.out.println("\nProduct Management Options:");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Back to Staff Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner2.nextInt();
            scanner2.nextLine(); // Consume newline character

            ProductManager productManager1 = new ProductManager();
            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int productId = scanner2.nextInt();
                    scanner2.nextLine(); // Consume newline left by nextInt()

                    System.out.print("Enter product name: ");
                    String productName = scanner2.nextLine();

                    System.out.print("Enter product price: ");
                    double productPrice = scanner2.nextDouble();

                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner2.nextInt();

                    // Creating the Product object
                    Product product = new Product(productId, productName, productPrice, productQuantity);

                    productManager1.addProducts(product);
                    break;
                case 2:
                    System.out.print("Enter product ID to edit: ");
                    int productId2 = scanner2.nextInt();
                    scanner2.nextLine(); // Consume newline left by nextInt()

                    // Check if the product exists
                    Product product2 = productManager1.getProductById(productId2);
                    if (product2 != null) {
                        System.out.println("Product found. Select attribute to edit:");
                        System.out.println("1. Product name");
                        System.out.println("2. Product price");
                        System.out.println("3. Product quantity");
                        System.out.print("Enter option: ");
                        int option = scanner2.nextInt();
                        scanner2.nextLine(); // Consume newline left by nextInt()

                        switch (option) {
                            case 1:
                                System.out.print("Enter new product name: ");
                                String newName = scanner2.nextLine();
                                product2.setName(newName);
                                break;
                            case 2:
                                System.out.print("Enter new product price: ");
                                double newPrice = scanner2.nextDouble();
                                product2.setPrice(newPrice);
                                break;
                            case 3:
                                System.out.print("Enter new product quantity: ");
                                int newQuantity = scanner2.nextInt();
                                product2.setQuantity(newQuantity);
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    } else {
                        System.out.println("Product not found");
                    }

                    break;
                case 3:
                    System.out.print("Enter product ID to delete: ");
                    int productIdToDelete = scanner2.nextInt();
                    scanner2.nextLine(); // Consume newline left by nextInt()

                    // Check if the product exists
                    Product productToDelete = productManager1.getProductById(productIdToDelete);
                    if (productToDelete != null) {
                        // Delete the product
                        productManager1.deleteProduct(productToDelete);
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }

                    break;
                case 4:
                    System.out.println("Returning to Staff Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageOrders() {
        while (true) {
            System.out.println("\nOrder Management Options:");
            System.out.println("1. Show All Orders");
            System.out.println("2. Change Order Status");
            System.out.println("3. Cancel Order");
            System.out.println("4. Back to Staff Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner2.nextInt();
            scanner2.nextLine(); // Consume newline character

            // Instantiate StaffService
            StaffService staff = new StaffServiceImpl();

            switch (choice) {
                case 1:
                    staff.getAllOrders();
                    break;
                case 2:
                    changeOrderStatus();
                    break;
                case 3:
                    System.out.println("Enter the order ID to delete it:");
                    int orderId = scanner2.nextInt();
                    scanner2.nextLine(); // Consume newline character
                    System.out.println("Enter the order ID to delete it:");
                    int customerId = scanner2.nextInt();
                    CustomerService customerService = new CustomerServiceImpl();
                    Customer customer = customerService.getCustomerById(customerId);
                    // Instantiate StaffService
                    Order order = new Order(orderId, customer);
                    OrderStatus newStatus = OrderStatus.CANCELLED;
                    order.setOrderStatus(String.valueOf(newStatus));
                    System.out.println("Order Cancelled Successfully...");
                    break;
                case 4:
                    System.out.println("Returning to Staff Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageCustomers() {
        while (true) {
            System.out.println("\nCustomer Management Options:");
            System.out.println("1. Add Customer");
            System.out.println("2. Edit Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Show All Customers");
            System.out.println("5. Back to Staff Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner2.nextInt();
            scanner2.nextLine(); // Consume newline character

            // Instantiate StaffService
            StaffService staff = new StaffServiceImpl();

            switch (choice) {
                case 1:
                    // Add Customer
                    Customer customerObject = new Customer(scanner2.nextInt(), scanner2.nextLine(), scanner2.nextLine(), scanner2.nextLine());

                    System.out.println("Adding Customer...");
                    staff.addCustomer(customerObject);
                    break;
                case 2:
                    // Edit Customer
                    System.out.println("Editing Customer...");
                    System.out.println("Enter customer ID:");
                    int customerId = scanner2.nextInt();

                    Customer existingCustomer = staff.getCustomerById(customerId);

                    if (existingCustomer != null) {
                        System.out.println("Customer found:");
                        System.out.println(existingCustomer);
                        System.out.println("Do you want to edit this customer? (yes/no)");
                        String response = scanner2.next();

                        if (response.equalsIgnoreCase("yes")) {
                            System.out.println("Enter new customer details:");
                            scanner2.nextLine(); // Consume the newline character
                            String name = scanner2.nextLine();
                            String address = scanner2.nextLine();
                            String phoneNumber = scanner2.nextLine();

                            Customer updatedCustomer = new Customer(customerId, name, address, phoneNumber);
                            staff.updateCustomer(customerId, updatedCustomer);
                            System.out.println("Customer updated:");
                            System.out.println(updatedCustomer);
                        } else {
                            System.out.println("Customer not edited.");
                        }
                    } else {
                        System.out.println("Customer with ID " + customerId + " not found.");
                    }
                    break;
                case 3:
                    // Delete Customer
                    System.out.println("Enter Customer ID to delete:");
                    int customerIdToDelete = scanner2.nextInt();

                    // Check if the customer exists
                    Customer customerToDelete = staff.getCustomerById(customerIdToDelete);
                    if (customerToDelete != null) {
                        System.out.println("Customer found: " + customerToDelete.getName());
                        System.out.println("Do you want to delete this customer? (yes/no)");
                        String confirmDelete = scanner2.next();

                        if (confirmDelete.equalsIgnoreCase("yes")) {
                            // Delete the customer
                            staff.deleteCustomer(customerIdToDelete);
                            System.out.println("Customer deleted successfully.");
                        } else {
                            System.out.println("Deletion canceled.");
                        }
                    } else {
                        System.out.println("Customer with ID " + customerIdToDelete + " not found.");
                    }

                    // Print out all customers
                    System.out.println("All customers:");
                    staff.getAllCustomers();
                    break;

                case 4:
                    System.out.println("Showing All Customers...");
                    staff.getAllCustomers();
                    return;
                case 5:
                    System.out.println("Returning to Staff Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void changeOrderStatus() {
        System.out.println("Enter the order ID to change its status:");
        int orderId = scanner2.nextInt();
        scanner2.nextLine(); // Consume newline character
        System.out.println("Enter the order ID to change its status:");
        int customerId = scanner2.nextInt();

        // Here you would fetch the order object using the provided orderId
        // You can assume getOrderById() method exists in your OrderManagement system
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.getCustomerById(customerId);
        // Instantiate StaffService
        Order order = new Order(orderId, customer);

        if (order == null) {
            System.out.println("Order not found. Please try again.");
            return;
        }

        System.out.println("Current order status: " + order.getOrderStatus());
        System.out.println("Select new order status:");
        System.out.println("1. PENDING");
        System.out.println("2. CONFIRMED");
        System.out.println("3. FULFILLED");
        System.out.println("4. CANCELED");
        System.out.print("Enter your choice: ");
        int choice = scanner2.nextInt();
        scanner2.nextLine(); // Consume newline character

        OrderStatus newStatus = null;
        switch (choice) {
            case 1:
                newStatus = OrderStatus.PENDING;
                break;
            case 2:
                newStatus = OrderStatus.CONFIRMED;
                break;
            case 3:
                newStatus = OrderStatus.FULFILLED;
                break;
            case 4:
                newStatus = OrderStatus.CANCELLED;
                break;
            default:
                System.out.println("Invalid choice. Status remains unchanged.");
                return;
        }

        // Update the order status
        order.updateStatus(order.getOrderStatus());


        order.getOrderStatus();

        System.out.println("Order status updated successfully!");
    }
    private static void viewProducts() {
        // Update to load products from file using DataFileManager
        List<Object> productList = DataManagement.DataFileManager.loadData();
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("List of available products:");
            for (Object obj : productList) {
                if (obj instanceof Product) {
                    Product product = (Product) obj;
                    System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
                }
            }
        }
    }
}
