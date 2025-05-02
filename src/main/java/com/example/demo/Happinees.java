package com.example.demo;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Happinees {
    private DefaultListModel<String> cartModel;
    private JList<String> cartList;

    public Happinees() {
        JFrame frame = new JFrame("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLayout(new BorderLayout());

        // Items available for purchase
        String[] items = {"Laptop - $1000", "Phone - $500", "Tablet - $400", "Headphones - $150", "Smartwatch - $250"};
        JComboBox<String> itemDropdown = new JComboBox<>(items);

        // Buttons
        JButton addButton = new JButton("Add to Cart");
        JButton removeButton = new JButton("Remove Item");
        JButton checkoutButton = new JButton("Checkout");

        cartModel = new DefaultListModel<>();
        cartList = new JList<>(cartModel);
        JScrollPane cartScrollPane = new JScrollPane(cartList);

        // Adding item to cart
        addButton.addActionListener(e -> {
            String selectedItem = (String) itemDropdown.getSelectedItem();
            if (selectedItem != null) {
                cartModel.addElement(selectedItem);
            }
        });

        // Removing item from cart
        removeButton.addActionListener(e -> {
            int selectedIndex = cartList.getSelectedIndex();
            if (selectedIndex != -1) {
                cartModel.remove(selectedIndex);
            }
        });

        // Checkout
        checkoutButton.addActionListener(e -> {
            if (cartModel.getSize() > 0) {
                JOptionPane.showMessageDialog(frame, "Purchase successful! Thank you for shopping.");
                cartModel.clear(); // Clear cart after checkout
            } else {
                JOptionPane.showMessageDialog(frame, "Your cart is empty. Please add items.");
            }
        });

        // Panel for item selection and add button
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select an item:"));
        topPanel.add(itemDropdown);
        topPanel.add(addButton);

        // Panel for remove and checkout buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(removeButton);
        bottomPanel.add(checkoutButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(cartScrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Happinees::new);
    }
}