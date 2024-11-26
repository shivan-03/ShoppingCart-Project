/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shivan
 */
public class ProductCatalog {
    private Map<Product, Integer> products;
    private List<ProductCatalogObserver> observers;
    
    public ProductCatalog(){
        products = new HashMap<>();
        observers = new ArrayList<>();
    }
/**
 * 
 * @return the products available for products
 */    
    public Map<Product, Integer> getProducts(){
        return products;
    }
/**
 * 
 * @param productId the id integer of the product available
 * @return the product 
 */    
    public Product findProductById(int productId){
        for (Product product : products.keySet()){
            if (product.getProductId() == productId){
                return product;
            }
        }
        return null;
    }
    public void addProduct(int productId, String productName, int productQuantity, double productPrice) {
    Product product = new Product(productId, productName, productQuantity, productPrice);
    products.put(product, productQuantity);
    notifyObservers();
}

/**
 * Updates the quantity of a product in the catalog.
 * 
 * @param productId    the ID of the product to update
 * @param newQuantity  the new quantity of the product
 * @return true if the product is found and updated, false otherwise
 */
public boolean updateProductAvailability(int productId, int newQuantity) {
    Product product = findProductById(productId);
    if (product != null) {
        product.setProductQuantity(newQuantity); // Update the quantity directly in the Product object
        notifyObservers(); // Notify observers about the change
        return true;
    } else {
        System.out.println("Product not found.");
        return false;
    }
}
/**
 * 
 * @param observer this will be used to update the product catalog 
 */
    public void addObserver(ProductCatalogObserver observer){
        observers.add(observer);
    }
    public void removeObserver(ProductCatalogObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for (ProductCatalogObserver observer : observers){
            observer.update(products);
        }
    }

   public boolean removeProductById(int productId) {
        Product productToRemove = null; 
        for (Product product : products.keySet()) { 
            if (product.getProductId() == productId) { 
                productToRemove = product; 
                break; 
            } 
        } 
        if (productToRemove != null) { 
            products.remove(productToRemove); 
            return true; 
        } 
        return false; 
   }
}

