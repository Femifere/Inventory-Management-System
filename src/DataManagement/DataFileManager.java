package DataManagement;

import Customer.Customer;
import Product.*;
import OrderManagement.*;
import Staff.*;
import Inventory.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class DataFileManager implements Serializable {
    private static final String CUSTOMER_FILE = "Customer.dat";
    private static final String PRODUCT_FILE = "Product.dat";
    private static final String ORDER_FILE = "Order.dat";
    private static final String INVENTORY_FILE = "Inventory.dat";

    public static void saveCustomerData(List<Customer> data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(CUSTOMER_FILE))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Customer> loadCustomerData() {
        List<Customer> data = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(CUSTOMER_FILE))) {
            data = (List<Customer>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static void updateCustomerData(Customer newData) {
        List<Customer> existingData = loadCustomerData();
        existingData.add(newData);
        saveCustomerData(existingData);
    }

    public static void deleteCustomerData(Customer dataToDelete) {
        List<Customer> existingData = loadCustomerData();
        existingData.remove(dataToDelete);
        saveCustomerData(existingData);
    }
    public static void saveOrderData(List<Order> data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ORDER_FILE))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Order> loadOrderData() {
        List<Order> data = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ORDER_FILE))) {
            data = (List<Order>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static void updateOrderData(Order newData) {
        List<Order> existingData = loadOrderData();
        existingData.add(newData);
        saveOrderData(existingData);
    }

    public static void deleteOrderData(Order dataToDelete) {
        List<Order> existingData = loadOrderData();
        existingData.remove(dataToDelete);
        saveOrderData(existingData);
    }

    public static void saveProductData(List<Product> data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PRODUCT_FILE))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Product> loadProductData() {
        List<Product> data = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PRODUCT_FILE))) {
            data = (List<Product>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static void updateProductData(Product newData) {
        List<Product> existingData = loadProductData();
        existingData.add(newData);
        saveProductData(existingData);
    }

    public static void deleteProductData(Product dataToDelete) {
        List<Product> existingData = loadProductData();
        existingData.remove(dataToDelete);
        saveProductData(existingData);
    }
    public static void saveInventoryItemData(List<InventoryItem> data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(INVENTORY_FILE))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<InventoryItem> loadInventoryItemData() {
        List<InventoryItem> data = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(INVENTORY_FILE))) {
            data = (List<InventoryItem>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static void updateInventoryItemData(InventoryItem newData) {
        List<InventoryItem> existingData = loadInventoryItemData();
        existingData.add(newData);
        saveInventoryItemData(existingData);
    }

    public static void deleteInventoryItemData(InventoryItem dataToDelete) {
        List<InventoryItem> existingData = loadInventoryItemData();
        existingData.remove(dataToDelete);
        saveInventoryItemData(existingData);
    }

}

