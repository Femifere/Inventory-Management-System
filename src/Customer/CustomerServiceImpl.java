package Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public Customer getCustomerById(int customerId) {
        // Implementation to retrieve customer by ID
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    @Override
    public List<Customer> getAllCustomers() {
        // Implementation to retrieve all customers
        return new ArrayList<>(customers);
        // Return a copy of the list to avoid exposing the internal list directly
    }

    @Override
    public void addCustomer(Customer customer) {
        // Implementation to add a new customer
        customers.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        // Implementation to update an existing customer
        int customerId = customer.getCustomerId();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                customers.set(i, customer); // Update the customer at index i with the new customer object
                return;
            }
        }
        // Customer not found, you may throw an exception or handle it based on your requirement
        throw new IllegalArgumentException("Customer with ID " + customerId + " not found");
    }

    @Override
    public void deleteCustomer(int customerId) {
        // Implementation to delete a customer
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
            customers.remove(index); // Remove the customer at the found index
        } else {
            // If the customer with the specified ID is not found, throw an exception or handle it accordingly
            throw new IllegalArgumentException("Customer with ID " + customerId + " not found");
        }
    }
}

