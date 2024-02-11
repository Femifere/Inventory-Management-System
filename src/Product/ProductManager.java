package Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager(){
        this.products = new ArrayList<>();
    }
    public void addProducts(Product product){
        products.add(product);
    }
    public void updateProduct(Product product){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId() == product.getId()){
                products.set(i, product); //Update the product at index i
                return;
            }
        }
        //If product with given ID is not found:
        throw new IllegalArgumentException("Product with ID " + product.getId() + " not found");
    }
    public void deleteProduct(Product product){
        products.remove(product);
    }
    public  Product getProductById(int id){
        for(Product product : products){
            if (product.getId() == id){
                return product; //Return the product if found
            }
        }
        //If product with given ID is not found:
        throw new IllegalArgumentException("Product with ID " + id + " not found");
    }
    // New method to retrieve all products
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
