package Customer;

import java.io.Serializable;
import DataManagement.*;
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
    DataFileManager customerData = new DataFileManager();
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

}
