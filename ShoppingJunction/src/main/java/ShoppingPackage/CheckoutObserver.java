/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;

import java.util.List;
/**
 * 
 * @author shivan
 */
public interface CheckoutObserver {
    void update(List<Product> productList);
}
