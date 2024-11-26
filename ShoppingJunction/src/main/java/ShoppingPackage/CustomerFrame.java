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
public class CustomerFrame extends JFrame {
    private ProductCatalog productCatalog;
    private ShoppingCart shoppingCart;
    private JTextArea productCatalogArea;
    private JTextArea cartArea;

    public CustomerFrame(ProductCatalog productCatalog, ShoppingCart shoppingCart) {
        this.productCatalog = productCatalog;
        this.shoppingCart = shoppingCart;

        // Frame setup
        setTitle("Customer Shopping");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        // Header label
        JLabel headerLabel = new JLabel("Customer Shopping", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headerLabel, BorderLayout.NORTH);

        // Catalog area
        productCatalogArea = new JTextArea();
        productCatalogArea.setEditable(false);
        productCatalogArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane catalogScrollPane = new JScrollPane(productCatalogArea);
        catalogScrollPane.setBorder(BorderFactory.createTitledBorder("Product Catalog"));
        add(catalogScrollPane, BorderLayout.WEST);

        // Cart area
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane cartScrollPane = new JScrollPane(cartArea);
        cartScrollPane.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        add(cartScrollPane, BorderLayout.EAST);

        // Buttons and input area
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Shopping Options"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel addLabel = new JLabel("Product ID to Add:");
        JTextField addField = new JTextField(15);
        JButton addButton = new JButton("Add to Cart");

        JLabel removeLabel = new JLabel("Product ID to Remove:");
        JTextField removeField = new JTextField(15);
        JButton removeButton = new JButton("Remove from Cart");

        JButton viewCartButton = new JButton("View Cart");

        // Adding components to inputPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(addLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(addField, gbc);

        gbc.gridx = 2;
        inputPanel.add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(removeLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(removeField, gbc);

        gbc.gridx = 2;
        inputPanel.add(removeButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.CENTER;
        inputPanel.add(viewCartButton, gbc);

        add(inputPanel, BorderLayout.SOUTH);

        // Update catalog display
        updateProductCatalogDisplay();

        // Add button listener
        addButton.addActionListener(e -> {
            try {
                int productId = Integer.parseInt(addField.getText().trim());
                Product product = productCatalog.findProductById(productId);

                if (product != null && product.getProductQuantity() > 0) {
                    shoppingCart.addProduct(product, 1);
                    productCatalog.updateProductAvailability(productId, product.getProductQuantity() - 1);
                    updateProductCatalogDisplay();
                    updateCartDisplay();
                    JOptionPane.showMessageDialog(this, "Product added to cart.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Product not available.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                addField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid product ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Remove button listener
        removeButton.addActionListener(e -> {
            try {
                int productId = Integer.parseInt(removeField.getText().trim());
                Product product = shoppingCart.findProductById(productId);

                if (product != null) {
                    shoppingCart.removeProduct(product);
                    productCatalog.updateProductAvailability(productId, product.getProductQuantity() + 1);
                    updateProductCatalogDisplay();
                    updateCartDisplay();
                    JOptionPane.showMessageDialog(this, "Product removed from cart.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Product not in cart.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                removeField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid product ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // View Cart button listener
        viewCartButton.addActionListener(e -> new ViewCartFrame(shoppingCart));

        setVisible(true);
    }

    private void updateProductCatalogDisplay() {
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
        productCatalogArea.setText(display.toString());
    }

    private void updateCartDisplay() {
        StringBuilder display = new StringBuilder();
        display.append(String.format("%-5s %-20s %-10s %-10s\n", "ID", "Name", "Price ($)", "Quantity"));
        display.append("-------------------------------------------------\n");
        for (Product product : shoppingCart.getCartItems().keySet()) {
            int quantity = shoppingCart.getCartItems().get(product);
            display.append(String.format("%-5d %-20s %-10.2f %-10d\n",
                    product.getProductId(),
                    product.getProductName(),
                    product.getProductPrice(),
                    quantity));
        }
        cartArea.setText(display.toString());
    }
}
