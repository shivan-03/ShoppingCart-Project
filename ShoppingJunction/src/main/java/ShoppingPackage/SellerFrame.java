/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShoppingPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author shivan
 */
public class SellerFrame extends JFrame {
    private ProductCatalog productCatalog;
    private JTextArea productDisplay;

    public SellerFrame(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;

        // Frame setup
        setTitle("Seller Inventory Management");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        // Header label
        JLabel headerLabel = new JLabel("Seller Inventory Management", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headerLabel, BorderLayout.NORTH);

        // Text area to display products
        productDisplay = new JTextArea();
        productDisplay.setEditable(false);
        productDisplay.setFont(new Font("Monospaced", Font.PLAIN, 14));
        productDisplay.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(productDisplay);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Product Catalog"));
        add(scrollPane, BorderLayout.CENTER);

        // Panel for adding products
        JPanel addPanel = new JPanel(new GridBagLayout());
        addPanel.setBorder(BorderFactory.createTitledBorder("Add / Update Product"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Product Name:");
        JTextField nameField = new JTextField(15);
        JLabel priceLabel = new JLabel("Product Price ($):");
        JTextField priceField = new JTextField(15);
        JLabel quantityLabel = new JLabel("Product Quantity:");
        JTextField quantityField = new JTextField(15);
        JButton addButton = new JButton("Add Product");

        gbc.gridx = 0;
        gbc.gridy = 0;
        addPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        addPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        addPanel.add(priceLabel, gbc);

        gbc.gridx = 1;
        addPanel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        addPanel.add(quantityLabel, gbc);

        gbc.gridx = 1;
        addPanel.add(quantityField, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        addPanel.add(addButton, gbc);

        // Panel for removing/updating products
        JPanel modifyPanel = new JPanel(new GridBagLayout());
        modifyPanel.setBorder(BorderFactory.createTitledBorder("Modify Product"));
        JLabel removeLabel = new JLabel("Product ID to Remove:");
        JTextField removeField = new JTextField(15);
        JButton removeButton = new JButton("Remove Product");

        JLabel updateIdLabel = new JLabel("Product ID to Update:");
        JTextField updateIdField = new JTextField(15);
        JLabel updateQtyLabel = new JLabel("New Quantity:");
        JTextField updateQtyField = new JTextField(15);
        JButton updateButton = new JButton("Update Quantity");

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        modifyPanel.add(removeLabel, gbc);

        gbc.gridx = 1;
        modifyPanel.add(removeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        modifyPanel.add(removeButton, gbc); // Moved button to a new row for spacing

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        modifyPanel.add(updateIdLabel, gbc);

        gbc.gridx = 1;
        modifyPanel.add(updateIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        modifyPanel.add(updateQtyLabel, gbc);

        gbc.gridx = 1;
        modifyPanel.add(updateQtyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        modifyPanel.add(updateButton, gbc);

        // Add panels to frame
        add(addPanel, BorderLayout.NORTH);
        add(modifyPanel, BorderLayout.SOUTH);

        // Add button action listener
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                double price = Double.parseDouble(priceField.getText().trim());
                int quantity = Integer.parseInt(quantityField.getText().trim());

                if (name.isEmpty() || price <= 0 || quantity <= 0) {
                    JOptionPane.showMessageDialog(this, "Please enter valid product details.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int productId = productCatalog.getProducts().size() + 1; // Generate unique ID
                productCatalog.addProduct(productId, name, quantity, price);

                updateProductDisplay();
                JOptionPane.showMessageDialog(this, "Product added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear input fields
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter numeric values for price and quantity.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Remove button action listener
        removeButton.addActionListener(e -> {
            try {
                int productId = Integer.parseInt(removeField.getText().trim());
                boolean removed = productCatalog.removeProductById(productId);

                if (removed) {
                    updateProductDisplay();
                    JOptionPane.showMessageDialog(this, "Product removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Product ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                removeField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid product ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Update button action listener
        updateButton.addActionListener(e -> {
            try {
                int productId = Integer.parseInt(updateIdField.getText().trim());
                int newQuantity = Integer.parseInt(updateQtyField.getText().trim());

                boolean updated = productCatalog.updateProductAvailability(productId, newQuantity);

                if (updated) {
                    updateProductDisplay();
                    JOptionPane.showMessageDialog(this, "Product quantity updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Product ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                updateIdField.setText("");
                updateQtyField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        updateProductDisplay();
        setVisible(true);
    }

    private void updateProductDisplay() {
        StringBuilder display = new StringBuilder();
        display.append(String.format("%-5s %-20s %-10s %-10s\n", "ID", "Name", "Price ($)", "Quantity"));
        display.append("-------------------------------------------------\n");
        for (Product product : productCatalog.getProducts().keySet()) {
            display.append(String.format("%-5d %-20s %-10.2f %-10d\n",
                product.getProductId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductQuantity()));
        }
        productDisplay.setText(display.toString());
    }
}

