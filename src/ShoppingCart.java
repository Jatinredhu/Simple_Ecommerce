import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ShoppingCart extends JFrame {
    class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " ($" + price + ")";
        }
    }

    private DefaultListModel<Product> productListModel;
    private DefaultListModel<Product> cartListModel;
    private JLabel totalLabel;
    private double totalPrice = 0;
    private Connection connection;

    public ShoppingCart() {
        // Set Nimbus Look and Feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Online Shopping Cart");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize database connection
        initDatabaseConnection();

        // Product List
        productListModel = new DefaultListModel<>();
        loadProducts();

        JList<Product> productList = new JList<>(productListModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane productScrollPane = new JScrollPane(productList);
        productScrollPane.setBorder(BorderFactory.createTitledBorder("Products"));

        // Cart List
        cartListModel = new DefaultListModel<>();
        JList<Product> cartList = new JList<>(cartListModel);
        cartList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        cartScrollPane.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));

        // Total Price Label
        totalLabel = new JLabel("Total: $0.00");

        // Add to Cart Button
        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(e -> addToCart(productList));

        // Remove from Cart Button
        JButton removeButton = new JButton("Remove from Cart");
        removeButton.addActionListener(e -> removeFromCart(cartList));

        // Checkout Button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> checkout());

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        // Panels for layout management
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(exitButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(totalLabel, BorderLayout.WEST);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        // Add components to the frame
        add(productScrollPane, BorderLayout.WEST);
        add(cartScrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initDatabaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcartdb_new", "root", "1520");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void loadProducts() {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, price FROM products")) {
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                productListModel.addElement(new Product(name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateTotal() {
        totalLabel.setText("Total: $" + String.format("%.2f", totalPrice));
    }

    private void addToCart(JList<Product> productList) {
        Product selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            cartListModel.addElement(selectedProduct);
            totalPrice += selectedProduct.price;
            updateTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to add.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void removeFromCart(JList<Product> cartList) {
        Product selectedProduct = cartList.getSelectedValue();
        if (selectedProduct != null) {
            cartListModel.removeElement(selectedProduct);
            totalPrice -= selectedProduct.price;
            updateTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to remove.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void checkout() {
        if (cartListModel.getSize() == 0) {
            JOptionPane.showMessageDialog(this, "Your cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CheckoutPage checkoutPage = new CheckoutPage(this, totalPrice);
        checkoutPage.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingCart frame = new ShoppingCart();
            frame.setVisible(true);
        });
    }
}
