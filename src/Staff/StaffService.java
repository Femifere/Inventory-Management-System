package Staff;

import java.util.List;
import Customer.*;
import OrderManagement.*;
import Product.*;
import Inventory.*;
public interface StaffService {
    boolean login(String username, String password);
    void addCustomer(Customer customer);
    void updateCustomer(int customerId, Customer updatedCustomer);
    void deleteCustomer(int customerId);
    List<Customer> getAllCustomers();
    Customer getCustomerById(int customerId);
    List<Order> getAllOrders();
}

