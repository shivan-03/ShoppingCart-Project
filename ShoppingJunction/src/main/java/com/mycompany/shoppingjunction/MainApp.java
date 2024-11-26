/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingjunction;
import ShoppingPackage.ProductCatalog;
import ShoppingPackage.ShoppingCart;
import ShoppingPackage.SellerFrame;
import ShoppingPackage.CustomerFrame;

public class MainApp {
    public static void main(String[] args) {
        // Create a shared ProductCatalog instance
        ProductCatalog sharedProductCatalog = new ProductCatalog();
        
        // Create a ShoppingCart instance for the customer
        ShoppingCart customerShoppingCart = new ShoppingCart();

        // Initialize and display SellerFrame
        SellerFrame sellerFrame = new SellerFrame(sharedProductCatalog);

        // Initialize and display CustomerFrame
        CustomerFrame customerFrame = new CustomerFrame(sharedProductCatalog, customerShoppingCart);

        // Make frames visible
        sellerFrame.setVisible(true);
        customerFrame.setVisible(true);
    }
}

