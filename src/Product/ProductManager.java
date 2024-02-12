package Product;

import java.util.ArrayList;
import java.util.List;

import Customer.Customer;
import DataManagement.*;

public class ProductManager {
    private List<Product> products;

    private int orderId;
    public ProductManager(){
        this.products = new ArrayList<>();
    }
    public void addProducts(Product product){
        products.add(product);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        DataFileManager.saveProductData(productList);
    }
    public void updateProduct(Product product){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId() == product.getId()){
                products.set(i, product); //Update the product at index i
                DataFileManager.updateProductData(product);
                return;
            }
        }
        //If product with given ID is not found:
        throw new IllegalArgumentException("Product with ID " + product.getId() + " not found");
    }
    public void deleteProduct(Product product){
        products.remove(product);
        DataFileManager.deleteProductData(product);
    }
    public  Product getProductById(int id){
        List<Product> allProducts = new ArrayList<>();

        // Add existing Products
        allProducts.addAll(products);

        // Load data from FileManager and add it to the list
        List<Product> loadedProducts = (List<Product>) DataFileManager.loadProductData();
        if (loadedProducts != null) {
            allProducts.addAll(loadedProducts);
        }

        // Iterate through the combined list to find the Product by ID
        for (Product product : allProducts) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null; // Customer not found
    }
    // New method to retrieve all products
    public List<Product> getProducts() {
        List<Product> allProducts = new ArrayList<>(products); // Copy the existing list
        allProducts.addAll(DataFileManager.loadProductData()); // Add Products from file
        return allProducts;
    }

    public int getOrderId() {
        return this.orderId;
    }
}
