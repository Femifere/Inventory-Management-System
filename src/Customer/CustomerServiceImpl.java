package Customer;

import java.util.ArrayList;
import java.util.List;
import DataManagement.*;

public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers = new ArrayList<>();

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
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>(customers); // Copy the existing list
        allCustomers.addAll(DataFileManager.loadCustomerData()); // Add customers from file
        return allCustomers;
    }


    @Override
    public void addCustomer(Customer customer) {
        // Implementation to add a new customer
        customers.add(customer);
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer);
        DataFileManager.saveCustomerData(customerList);
    }

    @Override
    public void updateCustomer(Customer customer) {
        // Implementation to update an existing customer
        int customerId = customer.getCustomerId();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                customers.set(i, customer); // Update the customer at index i with the new customer object
                DataFileManager.updateCustomerData(customer);
                return;
            }
        }
        // Customer not found, you may throw an exception or handle it based on your requirement
        throw new IllegalArgumentException("Customer with ID " + customerId + " not found");
    }

    @Override
    public void deleteCustomer(int customerId) {
        // Load customer data
        List<Customer> customers = DataFileManager.loadCustomerData();

        // Find the index of the customer with the specified ID
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                index = i;
                break; // Exit the loop after finding the customer
            }
        }

        // Check if the customer was found
        if (index != -1) {
            // Remove the customer at the found index
            customers.remove(index);
            // Save the updated customer data
            DataFileManager.saveCustomerData(customers);
        } else {
            // If the customer with the specified ID is not found, throw an exception or handle it accordingly
            throw new IllegalArgumentException("Customer with ID " + customerId + " not found");
        }
    }

}

