/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;
/**
 *
 * @author shivan
 */
public class Product {
    private int productId;
    private String productName;
    private int productQuantity;
    private double productPrice;
/**
 * 
 * @param productId the integer for the product to be recognized by 
 * @param productName name of the product
 * @param productQuantity number of product available
 * @param productPrice price of the product
 */   
    public Product(int productId, String productName, int productQuantity, double productPrice){
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }
/**
 * @return returns the productId
 */    
    public int getProductId(){
        return productId;
    }
/**
 * 
 * @param productId integer of a product 
 */    
    public void setProductId(int productId){
        this.productId = productId;
    }
/**
 * 
 * @return name of the product 
 */    
    public String getProductName(){
        return productName;
    }
/**
 * 
 * @param productName the name of the product for the name  
 */    
    public void setProductName(String productName){
        this.productName = productName;
    }
/**
 * 
 * @return the quantity of the product 
 */    
    public int getProductQuantity(){
        return productQuantity;
    }
 /**
  * 
  * @param productQuantity the quantity of product  
  */   
    public void setProductQuantity(int productQuantity){
        this.productQuantity = productQuantity;
    }
/**
 * 
 * @return price of the product 
 */    
    public double getProductPrice(){
        return productPrice;
    }
/**
 * 
 * @param productPrice the price of the product 
 */    
    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
/**
 * 
 * @param productId the integer id of a product
 * @param productName the name of the product
 * @param productQuantity the quantity of the product
 * @param productPrice the price of the product
 */    
    public void setProductDetails(int productId, String productName, int productQuantity, double productPrice){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }
}
