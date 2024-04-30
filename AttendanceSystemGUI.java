package com.example.attendance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AttendanceSystemGUI {

    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton studentLoginButton;
    private JButton adminLoginButton;
    
    // User credentials
    private static final String[] STUDENT_NAMES = {"Ayush Gorlawar", "Radha Patil"};
    private static final String[] STUDENT_ENROLLMENTS = {"U24BTCSd016", "U24BTCS0572"};
    private static final String[] STUDENT_USERNAMES = {"ayush", "radha"};
    private static final String[] STUDENT_PASSWORDS = {"ayush@123", "radha@123"};
    // Admin credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public AttendanceSystemGUI() {
        frame = new JFrame("Attendance System");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon("C:\\Users\\ayush\\eclipse-workspace\\Attendance_SystemGUI\\src\\com\\example\\attendance\\image.png");
        Image image = icon.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon resizedIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(0, 0, 500, 400);
        panel.add(imageLabel);

        JLabel titleLabel = new JLabel("Student Login");
        titleLabel.setBounds(200, 420, 100, 25);
        panel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(100, 460, 80, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(190, 460, 160, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 500, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 500, 160, 25);
        panel.add(passwordField);

        studentLoginButton = new JButton("Student Login");
        studentLoginButton.setBounds(100, 540, 150, 30);
        studentLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Student login button action logic
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if the entered credentials match any student's credentials
                boolean validUser = false;
                for (int i = 0; i < STUDENT_USERNAMES.length; i++) {
                    if (username.equals(STUDENT_USERNAMES[i]) && password.equals(STUDENT_PASSWORDS[i])) {
                        validUser = true;
                        openStudentDashboard(STUDENT_NAMES[i], STUDENT_ENROLLMENTS[i]);
                        break;
                    }
                }

                if (!validUser) {
                    // Invalid login
                    JOptionPane.showMessageDialog(frame, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(studentLoginButton);

        adminLoginButton = new JButton("Admin Login");
        adminLoginButton.setBounds(260, 540, 150, 30);
        adminLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Admin login button action logic
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    openAdminDashboard();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(adminLoginButton);

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void openAdminDashboard() {
        frame.dispose(); // Close current frame
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true); // Open Admin Dashboard
    }

    private void openStudentDashboard(String name, String enrollment) {
        frame.dispose(); // Close current frame
        StudentDashboard studentDashboard = new StudentDashboard(name, enrollment);
        studentDashboard.setVisible(true); // Open Student Dashboard
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AttendanceSystemGUI();
            }
        });
    }
}
