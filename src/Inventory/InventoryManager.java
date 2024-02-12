package Inventory;

import DataManagement.DataFileManager;
import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager implements InventoryService {

    // List to store inventory items
    private List<InventoryItem> inventoryItems;

    // Constructor to initialize the inventoryItems list
    public InventoryManager() {
        this.inventoryItems = new ArrayList<>();
    }

    // Method to add stock of a specific item to the inventory
    @Override
    public void addStock(InventoryItem item, int quantity) {
        // Check if the item is already present in the inventory
        for (InventoryItem inventoryItem : inventoryItems) {
            if (inventoryItem.equals(item)) {
                // If yes, update the quantity
                inventoryItem.setQuantity(inventoryItem.getQuantity() + quantity);
                return;
            }
        }
        // If the item is not present, add it to the inventory
        item.setQuantity(quantity);
        inventoryItems.add(item);
        DataFileManager.saveInventoryItemData(inventoryItems);
    }

    // Method to remove stock of a specific item from the inventory
    @Override
    public void removeStock(InventoryItem item, int quantity) {
        // Search for the item in the inventory
        for (InventoryItem inventoryItem : inventoryItems) {
            if (inventoryItem.equals(item)) {
                int currentQuantity = inventoryItem.getQuantity();
                // Check if there is sufficient stock to remove
                if (currentQuantity >= quantity) {
                    // If yes, update the quantity
                    inventoryItem.setQuantity(currentQuantity - quantity);
                } else {
                    // If not, print a message indicating insufficient stock
                    System.out.println("Insufficient stock available for " + item.getName());
                }
                return;
            }
        }
        // If the item is not found, print a message
        System.out.println("Item not found in inventory: " + item.getName());
        DataFileManager dataFileManager = new DataFileManager();
        dataFileManager.deleteInventoryItemData((InventoryItem) inventoryItems);
    }

    // Method to get the stock level of a specific item
    @Override
    public int getStockLevel(InventoryItem item) {
        // Search for the item in the inventory and return its quantity
        for (InventoryItem inventoryItem : inventoryItems) {
            if (inventoryItem.equals(item)) {
                return inventoryItem.getQuantity();
            }
        }
        // If the item is not found, return 0
        return 0;
    }

    // Method to check if a specific item is in stock
    @Override
    public boolean isItemInStock(InventoryItem item) {
        // Check if the stock level of the item is greater than 0
        return getStockLevel(item) > 0;
    }

    // Method to check if a specific quantity of an item is available in stock
    @Override
    public boolean isItemAvailable(InventoryItem item, int quantity) {
        // Check if the stock level of the item is greater than or equal to the requested quantity
        return getStockLevel(item) >= quantity;
    }

    // Method to replenish stock of a specific item in the inventory
    @Override
    public void replenishStock(InventoryItem item, int quantity) {
        // Delegate to addStock method
        addStock(item, quantity);
    }

    // Method to adjust the stock level of a specific item in the inventory
    @Override
    public void adjustStock(InventoryItem item, int quantity) {
        // Search for the item in the inventory and update its quantity
        for (InventoryItem inventoryItem : inventoryItems) {
            if (inventoryItem.equals(item)) {
                inventoryItem.setQuantity(quantity);
                return;
            }
        }
        // If the item is not found, print a message
        System.out.println("Item not found in inventory: " + item.getName());
    }

    // Method to retrieve all items in the inventory
    @Override
    public List<InventoryItem> getAllItems() {
        // Return a copy of the inventoryItems list
        return new ArrayList<>(inventoryItems);
    }

    // Method to retrieve items based on certain criteria
    @Override
    public List<InventoryItem> getItemsByCriteria(String criteria) {
        List<InventoryItem> filteredItems = new ArrayList<>();
        for (InventoryItem item : inventoryItems) {
            // Check if the item's name contains the provided criteria
            if (item.getName().toLowerCase().contains(criteria.toLowerCase())) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }


    // Method to update information of a specific item in the inventory
    @Override
    public void updateItemInfo(InventoryItem item, String newDescription) {
        for (InventoryItem inventoryItem : inventoryItems) {
            if (inventoryItem.equals(item)) {
                // Update the description of the item
                inventoryItem.setDescription(newDescription);
                return;
            }
        }
        // If the item is not found, print a message
        System.out.println("Item not found in inventory: " + item.getName());
    }


    // Method to remove a specific item from the inventory
    @Override
    public void removeItem(InventoryItem item) {
        // Remove the item from the inventoryItems list
        inventoryItems.removeIf(inventoryItem -> inventoryItem.equals(item));
    }

    // Method to calculate the total value of the inventory
    @Override
    public double calculateInventoryValue() {
        double totalValue = 0.0;
        // Iterate over all items in the inventory and calculate their total value
        for (InventoryItem item : inventoryItems) {
            totalValue += item.getPrice() * item.getQuantity();
        }
        return totalValue;
    }
}


