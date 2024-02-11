package OrderManagement;

import Customer.Customer;
import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private List<Integer> quantities;
    private double totalAmount;
    private String orderStatus;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.totalAmount = 0.0; // Initialize total amount to zero
        this.orderStatus = "Pending"; // Default order status
    }

    // Getter and setter methods

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customer.getCustomerId();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        quantities.add(quantity);
        totalAmount += product.getPrice() * quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", products=" + products +
                ", quantities=" + quantities +
                ", totalAmount=" + totalAmount +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
    public void placeOrder() {
        if (products.isEmpty()) {
            System.out.println("Cannot place an empty order.");
            return;
        }

        System.out.println("Order placed successfully!");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Products ordered:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getName() + " - Quantity: " + quantities.get(i));
        }
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("Order Status: " + orderStatus);
    }

    public double calculateTotal() {
        // Calculate total amount
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void  updateStatus(String orderStatus) {
        // Update order status to one of the four options: "Pending", "Confirmed", "Fulfilled", "Cancelled"
        if (orderStatus.equalsIgnoreCase("Pending") || orderStatus.equalsIgnoreCase("Confirmed") || orderStatus.equalsIgnoreCase("Fulfilled") || orderStatus.equalsIgnoreCase("Cancelled")) {
            this.orderStatus = orderStatus;
        } else {
            System.out.println("Invalid status. Status must be one of: Pending, Confirmed, Delivered.");
        }
    }
    public boolean containsProduct(Product product) {
        // Check if the order contains a specific product
        return products.contains(product);
    }

    public void removeProduct(Product product, int quantity) {
        // Remove a specified quantity of a product from the order
        for (int i = 0; i < quantity; i++) {
            products.remove(product);
        }
    }

    public int getProductQuantity(Product product) {
        // Get the quantity of a specific product in the order
        int quantity = 0;
        for (Product p : products) {
            if (p.equals(product)) {
                quantity++;
            }
        }
        return quantity;
    }

    public int getOrderSize() {
        // Get the total number of products in the order
        return products.size();
    }

    public void displayOrderDetails() {
        // Display order details
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Products in the order:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println("Total Amount: $" + calculateTotal());
    }
}

