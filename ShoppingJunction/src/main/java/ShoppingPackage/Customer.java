/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;

/**
 * 
 * @author shivan
 */
public class Customer {
    private String name;
    private String email;
    private ShoppingCart shoppingCart;
    private ProductCatalog productCatalog;

    public Customer(String name, String email, ProductCatalog productCatalog) {
        this.name = name;
        this.email = email;
        this.shoppingCart = new ShoppingCart();
        this.productCatalog = productCatalog;
    }

    // Getters and setters for customer details
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

    // Accessor for shopping cart
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    // Method to view the product catalog
    public void viewProductCatalog() {
        for (Product product : productCatalog.getProducts().keySet()) {
            System.out.println("Product ID: " + product.getProductId() + ", Name: " + product.getProductName() 
                               + ", Price: $" + product.getProductPrice() + ", Available Quantity: " + product.getProductQuantity());
        }
    }

    // Method to add a product to the shopping cart
    public void addToCart(Product product) {
        int quantity = 1; // Simplified, can be extended to ask for quantity
        shoppingCart.addProduct(product, quantity);
        System.out.println(product.getProductName() + " has been added to your cart.");
    }

    // Method to remove a product from the shopping cart
    public void removeFromCart(Product product) {
        shoppingCart.removeProduct(product);
        System.out.println(product.getProductName() + " has been removed from your cart.");
    }

}