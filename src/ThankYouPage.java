import javax.swing.*;
import java.awt.*;

public class ThankYouPage extends JFrame {
    private double totalPrice;

    public ThankYouPage(JFrame parent, double totalPrice) {
        this.totalPrice = totalPrice; // Store the total price
        setTitle("Thank You");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Thank You message
        JLabel thankYouLabel = new JLabel("Thank You for Your Purchase!", SwingConstants.CENTER);
        add(thankYouLabel);

        // Total Amount Label
        JLabel totalAmountLabel = new JLabel("Total Amount: $" + String.format("%.2f", totalPrice), SwingConstants.CENTER);
        add(totalAmountLabel);

        // Back to Shopping Cart Button
        JButton backButton = new JButton("Back to Shopping Cart");
        backButton.addActionListener(e -> {
            parent.setVisible(true); // Show the shopping cart again
            dispose(); // Close the thank you page
        });
        add(backButton);
    }
}
