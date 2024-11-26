/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppingjunction;
import ShoppingPackage.ProductCatalog;
import ShoppingPackage.SellerFrame;
/**
 *
 * @author shivan
 */
public class ShoppingJunction {
    public static void main(String[] args) {
        ProductCatalog productCatalog = new ProductCatalog();
        new SellerFrame(productCatalog);
    }
}

