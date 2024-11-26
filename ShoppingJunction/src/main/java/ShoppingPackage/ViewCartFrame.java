/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * 
 * @author shivan
 */
public class ViewCartFrame extends JFrame {
    private ShoppingCart shoppingCart;
    private JTextArea cartDetailsTextArea;

    public ViewCartFrame(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;

        // Frame setup
        setTitle("Shopping Cart");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // TextArea to display cart details
        cartDetailsTextArea = new JTextArea();
        cartDetailsTextArea.setEditable(false);
        add(new JScrollPane(cartDetailsTextArea), BorderLayout.CENTER);

        // Panel for action buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton removeProductButton = new JButton("Remove Product");
        JButton checkoutButton = new JButton("Checkout");

        buttonPanel.add(removeProductButton);
        buttonPanel.add(checkoutButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action listeners for buttons
        removeProductButton.addActionListener(e -> removeProduct());
        checkoutButton.addActionListener(e -> checkout());

        updateCartDisplay();

        setVisible(true);
    }

    private void updateCartDisplay() {
        StringBuilder details = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : shoppingCart.getCartItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            details.append("ID: ").append(product.getProductId())
                   .append(", Name: ").append(product.getProductName())
                   .append(", Quantity: ").append(quantity)
                   .append(", Price: $").append(product.getProductPrice())
                   .append("\n");
        }
        cartDetailsTextArea.setText(details.toString());
    }

    private void removeProduct() {
        String productIdStr = JOptionPane.showInputDialog(this, "Enter Product ID to remove:");
        try {
            int productId = Integer.parseInt(productIdStr);
            Product productToRemove = shoppingCart.findProductById(productId);
            if (productToRemove != null) {
                shoppingCart.removeProduct(productToRemove);
                updateCartDisplay();
                JOptionPane.showMessageDialog(this, "Product removed from cart.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Product not found in cart.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Product ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkout() {
        if (shoppingCart.getCartItems().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is empty.", "Checkout Error", JOptionPane.ERROR_MESSAGE);
        } else {
            double total = shoppingCart.calculateTotalPrice();
            JOptionPane.showMessageDialog(this, "Checkout successful! Total: $" + total, "Success", JOptionPane.INFORMATION_MESSAGE);
            shoppingCart.clearCart();
            updateCartDisplay();
        }
    }
}
