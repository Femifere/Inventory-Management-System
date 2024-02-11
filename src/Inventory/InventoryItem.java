package Inventory;

public class InventoryItem {
    // Properties
    private String name;
    private double price;
    private int quantity;
    private String description;

    // Constructor
    public InventoryItem(String name, double price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    // Methods
    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to increase quantity
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    // Method to decrease quantity
    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }

    // Setter method for updating the description
    public void setDescription(String description) {
        this.description = description;
    }

    // Override toString() method to provide a meaningful string representation of the object
    @Override
    public String toString() {
        return "InventoryItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

