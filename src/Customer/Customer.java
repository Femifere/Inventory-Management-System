package Customer;

import java.io.Serializable;
public class Customer implements Serializable{
    private int customerId;
    private String name;
    private String email;
    private String phone;

    // Constructor
    public Customer(int customerId, String name, String email, String phone){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // GETTER and SETTER Methods

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Method to convert object to array
    public Object[] toArray() {
        return new Object[]{customerId, name, email, phone};
    }

    // Static method to create Customer object from array
    public static Customer fromArray(Object[] array) {
        int customerId = (int) array[0];
        String name = (String) array[1];
        String email = (String) array[2];
        String phone = (String) array[3];
        return new Customer(customerId, name, email, phone);
    }
}
