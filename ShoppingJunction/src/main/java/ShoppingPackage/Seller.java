/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;

/**
 *
 * @author shivan
 */
public class Seller {
    private Inventory inventory;
    private String name;
    
    public Seller(Inventory inventory, String name){
        this.inventory = inventory;
        this.name = name;
    }
    public void manageInventory(){
        System.out.println("Managing inventory for " + name);
    }
    public void viewFinancialInfo(){
        System.out.println("Viewing financial info for " + name);
    }
    public Inventory getInventory(){
        return inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
}