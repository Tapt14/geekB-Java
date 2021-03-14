package AppSwing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginInterface extends JPanel{

    private final JButton connectServerButton;
    private final JTextField loginField;
    private final JTextField passwordField;


    public LoginInterface() {

        JPanel loginPanel = new JPanel();

        JLabel loginLabel = new JLabel("Login");
        loginField = new JTextField();
        loginField.setBorder(new EmptyBorder(5,5,5,5));
        loginField.setBackground(new Color(252,252,252));
        loginField.setPreferredSize(new Dimension(130,20));
        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JTextField();
        passwordField.setBorder(new EmptyBorder(5,5,5,5));
        passwordField.setBackground(new Color(252,252,252));
        passwordField.setPreferredSize(new Dimension(130,20));
        connectServerButton = new JButton("Connect");

        loginPanel.add(loginLabel);
        loginPanel.add(loginField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(connectServerButton);

        add(loginPanel, BorderLayout.CENTER);
    }

    public JButton getConnectServerButton() {
        return connectServerButton;
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }
}
