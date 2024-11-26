/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;
import java.util.Map;
/**
 *
 * @author shivan
 */
public interface InventoryObserver {
    void update(Map<Integer, Product> products);
}
