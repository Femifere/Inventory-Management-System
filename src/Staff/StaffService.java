package Staff;

import java.util.List;
import Customer.*;
import OrderManagement.*;
import Product.*;
import Inventory.*;
public interface StaffService {
    boolean login(String username, String password);
    void createProduct(Product product);
    void manageInventory(InventoryItem inventory);
    void editProduct(int productId, Product updatedProduct);
    void confirmOrder(Order order);
    void addCustomer(Customer customer);
    void updateCustomer(int customerId, Customer updatedCustomer);
    void deleteCustomer(int customerId);
    List<Customer> getAllCustomers();
    Customer getCustomerById(int customerId);
    List<Order> getAllOrders();
    void fulfillOrder(int orderId);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    List<Product> searchProducts(String keyword);
}

