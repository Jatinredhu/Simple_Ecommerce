import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutPage extends JFrame {
    private double totalPrice;
    private JLabel totalLabel;
    private JTextField cardNumberField;
    private JTextField cvvField;
    private JTextField expDateField; // Format: MM/YY
    private JTextField cardHolderNameField;
    private JRadioButton creditCardButton;
    private JRadioButton debitCardButton;

    public CheckoutPage(JFrame parent, double totalPrice) {
        this.totalPrice = totalPrice;
        setTitle("Checkout");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        totalLabel = new JLabel("Total: $" + String.format("%.2f", totalPrice));
        add(totalLabel);

        // Card type selection
        add(new JLabel("Select Payment Method:"));

        creditCardButton = new JRadioButton("Credit Card");
        debitCardButton = new JRadioButton("Debit Card");

        // Group the radio buttons so only one can be selected at a time
        ButtonGroup cardTypeGroup = new ButtonGroup();
        cardTypeGroup.add(creditCardButton);
        cardTypeGroup.add(debitCardButton);

        // Add radio buttons to the frame
        add(creditCardButton);
        add(debitCardButton);

        // Card Number Input
        add(new JLabel("Card Number:"));
        cardNumberField = new JTextField();
        add(cardNumberField);

        // Expiration Date Input
        add(new JLabel("Expiry Date (MM/YY):"));
        expDateField = new JTextField();
        add(expDateField);

        // CVV Input
        add(new JLabel("CVV:"));
        cvvField = new JTextField();
        add(cvvField);

        // Cardholder Name Input
        add(new JLabel("Cardholder Name:"));
        cardHolderNameField = new JTextField();
        add(cardHolderNameField);

        // Confirm Payment Button
        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmPayment();
            }
        });
        add(confirmButton);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            parent.setVisible(true); // Show the shopping cart again
            dispose(); // Close the checkout page
        });
        add(cancelButton);

        // Return to Shopping Cart Button
        JButton returnButton = new JButton("Return to Shopping Cart");
        returnButton.addActionListener(e -> {
            parent.setVisible(true); // Show the shopping cart
            dispose(); // Close the checkout page
        });
        add(returnButton);
    }

    private void confirmPayment() {
        String cardNumber = cardNumberField.getText();
        String expDate = expDateField.getText();
        String cvv = cvvField.getText();
        String cardHolderName = cardHolderNameField.getText();

        // Validate that a card type is selected
        if (!creditCardButton.isSelected() && !debitCardButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a payment method.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate that all fields are filled
        if (cardNumber.isEmpty() || expDate.isEmpty() || cvv.isEmpty() || cardHolderName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Here you can add payment processing logic (not implemented for brevity)
        JOptionPane.showMessageDialog(this, "Payment confirmed! Thank you!", "Success", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); // Close the application after payment
    }
}
