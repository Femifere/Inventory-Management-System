package Staff;

import java.util.ArrayList;
import java.util.List;
import Customer.*;
import OrderManagement.*;
import DataManagement.*;
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
        // Assuming you have some way to retrieve stored credentials
        // For simplicity, let's assume you have hardcoded values here

        // Replace these hardcoded values with actual retrieval logic
        String storedUsername = "admin";
        String storedPassword = "12345";

        // Check if the provided username and password match the stored credentials
        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            return true; // Login successful
        } else {
            return false; // Login failed
        }
    }


    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        DataFileManager.saveCustomerData(customerList);
    }


    @Override
    public void updateCustomer(int customerId, Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                customers.set(i, updatedCustomer);
                DataFileManager.saveCustomerData(customers);
                break;
            }
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                Customer customerToDelete = customers.remove(i);
                DataFileManager.deleteCustomerData(customerToDelete); // Modify this line
                break;
            }
        }
    }


    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>(customers); // Copy the existing list
        allCustomers.addAll(DataFileManager.loadCustomerData()); // Add customers from file
        return allCustomers;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        List<Customer> allCustomers = new ArrayList<>();

        // Add existing customers
        allCustomers.addAll(customers);

        // Load data from FileManager and add it to the list
        List<Customer> loadedCustomers = (List<Customer>) DataFileManager.loadCustomerData();
        if (loadedCustomers != null) {
            allCustomers.addAll(loadedCustomers);
        }

        // Iterate through the combined list to find the customer by ID
        for (Customer customer : allCustomers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }

        return null; // Customer not found
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>(orders); // Copy the existing list
        allOrders.addAll(DataFileManager.loadOrderData()); // Add orders from file
        return allOrders;
    }
}

