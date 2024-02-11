package Inventory;

import java.util.ArrayList;
import java.util.List;
public interface InventoryService {
    void addStock(InventoryItem item, int quantity);
    void removeStock(InventoryItem item, int quantity);

    // Methods for checking stock levels
    int getStockLevel(InventoryItem item);
    boolean isItemInStock(InventoryItem item);

    // Method for checking if an item is available in a specific quantity
    boolean isItemAvailable(InventoryItem item, int quantity);

    // Method for replenishing stock
    void replenishStock(InventoryItem item, int quantity);

    // Method for adjusting stock levels (increase or decrease)
    void adjustStock(InventoryItem item, int quantity);

    // Method for retrieving all items in the inventory
    List<InventoryItem> getAllItems();

    // Method for retrieving items based on certain criteria (e.g., category, price range)
    List<InventoryItem> getItemsByCriteria(String criteria);

    // Method for updating item information (e.g., price, description)
    void updateItemInfo(InventoryItem item, String newInfo);

    // Method for removing an item from the inventory
    void removeItem(InventoryItem item);

    // Method for calculating the total value of the inventory
    double calculateInventoryValue();

    // Other methods for managing the inventory
}

