package Staff;

import java.util.ArrayList;
import java.util.List;
import Customer.*;
import OrderManagement.*;
import Product.*;
import Inventory.*;

public class StaffServiceImpl implements StaffService {
    private List<Customer> customers;
    private List<Order> orders;
    private List<Product> products;

    public StaffServiceImpl() {
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    @Override
    public boolean login(String username, String password) {
        // Implement login logic here
        return true; // Placeholder, implement actual logic
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }

    @Override
    public void manageInventory(InventoryItem inventory) {
        // Implement inventory management logic here
    }

    @Override
    public void editProduct(int productId, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                products.set(i, updatedProduct);
                break;
            }
        }
    }

    @Override
    public void confirmOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                customers.set(i, updatedCustomer);
                break;
            }
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                customers.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
      

    @Override
    public void fulfillOrder(int orderId) {
        // Implement order fulfillment logic here
    }
    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        List<Product> searchResult = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResult.add(product);
            }
        }
        return searchResult;
    }
}

