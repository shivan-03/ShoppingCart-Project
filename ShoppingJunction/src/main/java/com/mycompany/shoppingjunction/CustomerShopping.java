/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingjunction;
import javax.swing.*;
import ShoppingPackage.ProductCatalog;
import ShoppingPackage.ShoppingCart;
import ShoppingPackage.CustomerFrame;

/**
 *
 * @author shivan
 */
public class CustomerShopping {
    public static void main(String[] args){
        // Create a ProductCatalog and populate it with some sample products
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.addProduct(1, "Laptop", 10, 999.99);
        productCatalog.addProduct(2, "Headphones", 15, 49.99);
        productCatalog.addProduct(3, "Smartphone", 20, 699.99);

        // Create a ShoppingCart instance
        ShoppingCart shoppingCart = new ShoppingCart();
        SwingUtilities.invokeLater(() -> {
            new CustomerFrame(productCatalog, shoppingCart);
        });
    }
}










