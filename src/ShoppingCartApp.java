import javax.swing.*;

public class ShoppingCartApp {
    public static void main(String[] args) {
        UserDatabase userDatabase = new UserDatabase();
        LoginPage loginPage = new LoginPage(userDatabase);

        // Show the login page and wait for successful login
        boolean loggedIn = loginPage.displayLogin();

        // If the user logged in successfully, proceed to the shopping cart
        if (loggedIn) {
            SwingUtilities.invokeLater(() -> {
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting application.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
