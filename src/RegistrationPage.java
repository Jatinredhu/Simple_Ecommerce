import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage {
    private UserDatabase userDatabase;

    public RegistrationPage(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public void displayRegistration() {
        JFrame frame = new JFrame("Register");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton registerButton = new JButton("Register");
        JLabel messageLabel = new JLabel("");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (userDatabase.registerUser(username, password)) {
                    messageLabel.setText("Registration successful!");
                    frame.dispose(); // Close the registration frame
                } else {
                    messageLabel.setText("Username already exists.");
                }
            }
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(registerButton);
        frame.add(messageLabel);

        frame.setVisible(true);
    }
}
