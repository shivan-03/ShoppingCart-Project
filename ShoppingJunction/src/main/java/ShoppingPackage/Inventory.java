/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;
import java.util.HashMap; 
import java.util.Map; 
import java.util.ArrayList; 
import java.util.List;
/**
 *
 * @author shivan
 */
public class Inventory {
    private Map<Integer, Product> products;
    private List<InventoryObserver> observers;

    public Inventory(){
        products = new HashMap<>();
        observers = new ArrayList<>();
    }
/**
 * 
 * @param ProductId integer attached to a product set by seller
 * @return the productId of a product
 */    
    public Product getProductDetails(int ProductId){
        return products.get(ProductId);
    }
/**
 * 
 * @param productId required product id for a specific product
 * @param newQuantity input of a new integer to set the product's quantity 
 */
    public void updateProductQuantity(int productId, int newQuantity){
        Product product = products.get(productId);
        if (product != null){
            product.setProductQuantity(newQuantity);
            notifyObservers();
        } else {
            System.out.println("Product not found.");
        }
    }
/**
 * 
 * @param observer allows for updates on the inventory directly 
 */    
    public void addObserver(InventoryObserver observer){
        observers.add(observer);
    }
/**
 * 
 * @param observer allows for updates on the inventory
 */   
    public void removeObserver(InventoryObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (InventoryObserver observer : observers){
            observer.update(products);
        }
    }
/**
 * 
 * @param product the product the seller adds to inventory
 */   
    public void addProduct(Product product){
        products.put(product.getProductId(), product);
        notifyObservers();
    }
}
