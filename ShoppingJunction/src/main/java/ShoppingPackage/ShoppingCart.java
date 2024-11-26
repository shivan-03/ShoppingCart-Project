/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;
import java.util.HashMap; 
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author shivan
 */
public class ShoppingCart {
    private Map<Product, Integer> cartItems;
    private double totalPrice;
    private List<ShoppingCartObserver> observers;
    
    public ShoppingCart(){
        this.cartItems = new HashMap<>();
        totalPrice = 0.0;
        observers = new ArrayList<>();
    }
/**
 * 
 * @param product product that will be added to the shopping cart
 * @param quantity the amount of the product added to the cart
 */
    public void addProduct(Product product, int quantity){
        if (cartItems.containsKey(product)){
            cartItems.put(product, cartItems.get(product) + quantity);
        } else {
            cartItems.put(product, quantity);
        }
   }
    
/**
 * 
 * @param product product that will be removed from shopping cart
 */
    public void removeProduct(Product product){
        cartItems.remove(product);
    }
/**
 * 
 * @param product product in cart 
 * @param quantity the amount of product that will be added to the cart
 */
    public void updateProductQuantity(Product product, int quantity){
        if (cartItems.containsKey(product)){
            cartItems.put(product, quantity);
        }
    }
    public double calculateTotalPrice(){
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()){
            total += entry.getKey().getProductPrice() * entry.getValue();
        }
        return total;   
    }

/**
 * @param productId the ID of the product to find.
 * @return the Product if found, or null if not found.
 */
public Product findProductById(int productId) {
    for (Product product : cartItems.keySet()) {
        if (product.getProductId() == productId) {
            return product;
        }
    }
    return null;
}
    public void clearCart(){
        cartItems.clear();
        totalPrice = 0.0; 
        notifyObservers();
    }
    public Map<Product, Integer> getCartItems(){
        return cartItems;
    }

    public double getTotalPrice() { 
        return totalPrice; 
    }
    
    
    public void addObserver(ShoppingCartObserver observer) { 
        observers.add(observer); 
    }
    public void removeObserver(ShoppingCartObserver observer) {
            observers.remove(observer); 
    }
    private void notifyObservers() { 
        for (ShoppingCartObserver observer : observers) { 
            observer.update(cartItems, totalPrice); 
        } 
    }
}
