// StudentLogin.java
package com.example.attendance;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentLogin {

    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton studentLoginButton;

    // List to store student credentials
    private static final String[][] studentCredentials = {{"student1", "password1"}, {"student2", "password2"}};

    public StudentLogin() {
        frame = new JFrame("Student Login");
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

        studentLoginButton = new JButton("Login");
        studentLoginButton.setBounds(150, 150, 100, 30);
        studentLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if entered username and password match any student credentials
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                boolean loginSuccessful = false;
                for (String[] credentials : studentCredentials) {
                    if (credentials[0].equals(username) && credentials[1].equals(password)) {
                        loginSuccessful = true;
                        break;
                    }
                }
                if (loginSuccessful) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                    // Here you can open the student dashboard or perform any other action
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password!");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(studentLoginButton);

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentLogin();
            }
        });
    }
}
