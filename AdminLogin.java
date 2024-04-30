// AdminLogin.java
package com.example.attendance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin {

    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton adminLoginButton;

    public AdminLogin() {
        frame = new JFrame("Admin Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 25);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);

        adminLoginButton = new JButton("Login");
        adminLoginButton.setBounds(150, 150, 100, 30);
        adminLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Admin login button action logic goes here
                System.out.println("Admin Login Button Clicked");
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(adminLoginButton);

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin();
            }
        });
    }
}
