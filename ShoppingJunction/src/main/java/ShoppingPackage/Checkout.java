/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author shivan
 */
public class Checkout {
    private List<Product> currentOrder;
    private List<CheckoutObserver> observers;

    public Checkout() {
        this.currentOrder = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // Method to get order details
    public List<Product> getOrderDetails() {
        return currentOrder;
    }

    // Method to add product to the order
    public void addProductToOrder(Product product) {
        currentOrder.add(product);
        notifyObservers();
    }

    // Method to process payment
    public void processPayment(String paymentType, double amount) {
        // Implementation for processing payment
        // Assuming paymentType and amount parameters
        System.out.println("Processing payment: " + paymentType + ", Amount: " + amount);
        finalizeOrder();
    }

    // Method to finalize the order
    public void finalizeOrder() {
        // Implementation to finalize the order
        System.out.println("Order finalized.");
        notifyObservers();
    }

    // Method to add an observer
    public void addObserver(CheckoutObserver observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(CheckoutObserver observer) {
        observers.remove(observer);
    }

    // Method to notify all observers
    private void notifyObservers() {
        for (CheckoutObserver observer : observers) {
            observer.update(currentOrder);
        }
    }
}

