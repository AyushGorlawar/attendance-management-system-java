// AddStudentInfoForm.java
package com.example.attendance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class AddStudentInfoForm {

    private JFrame frame;
    private JPanel panel;
    private JTextField nameField;
    private JTextField enrollmentField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> subjectsComboBox;
    private JButton addButton;

    public AddStudentInfoForm() {
        frame = new JFrame("Add Student Info");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window on close

        panel = new JPanel();
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(50, 30, 100, 25);
        JLabel enrollmentLabel = new JLabel("Enrollment Number:");
        enrollmentLabel.setBounds(50, 70, 150, 25);
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 110, 100, 25);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 25);
        JLabel subjectsLabel = new JLabel("Enroll Subjects:");
        subjectsLabel.setBounds(50, 190, 100, 25);

        nameField = new JTextField();
        nameField.setBounds(200, 30, 150, 25);
        enrollmentField = new JTextField();
        enrollmentField.setBounds(200, 70, 150, 25);
        usernameField = new JTextField();
        usernameField.setBounds(200, 110, 150, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 150, 25);

        String[] subjects = {"Mathematics", "Science", "English"}; // Sample subjects, you can replace with actual subjects
        subjectsComboBox = new JComboBox<>(subjects);
        subjectsComboBox.setBounds(200, 190, 150, 25);

        addButton = new JButton("Add");
        addButton.setBounds(150, 230, 100, 30);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add button action logic goes here
                String name = nameField.getText();
                String enrollment = enrollmentField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String selectedSubject = (String) subjectsComboBox.getSelectedItem();
                // Logic to add student info to database or perform any other action
                JOptionPane.showMessageDialog(frame, "Student info added successfully:\nName: " + name +
                        "\nEnrollment: " + enrollment + "\nUsername: " + username + "\nPassword: " + password +
                        "\nSubject Enrolled: " + selectedSubject);
                // Clear fields after adding
                nameField.setText("");
                enrollmentField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        panel.add(nameLabel);
        panel.add(enrollmentLabel);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(subjectsLabel);
        panel.add(nameField);
        panel.add(enrollmentField);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(subjectsComboBox);
        panel.add(addButton);

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
