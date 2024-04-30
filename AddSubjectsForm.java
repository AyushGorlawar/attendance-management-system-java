// AddSubjectsForm.java
package com.example.attendance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class AddSubjectsForm {

    private JFrame frame;
    private JPanel panel;
    private JTextField subjectField;
    private JButton addButton;

    public AddSubjectsForm() {
        frame = new JFrame("Add Subjects");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window on close

        panel = new JPanel();
        panel.setLayout(null);

        JLabel subjectLabel = new JLabel("Subject Name:");
        subjectLabel.setBounds(50, 50, 100, 25);

        subjectField = new JTextField();
        subjectField.setBounds(150, 50, 200, 25);

        addButton = new JButton("Add");
        addButton.setBounds(150, 100, 100, 30);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add button action logic goes here
                String subjectName = subjectField.getText();
                // Logic to add subject to database or perform any other action
                JOptionPane.showMessageDialog(frame, "Subject \"" + subjectName + "\" added successfully!");
                subjectField.setText(""); // Clear subject field after adding
            }
        });

        panel.add(subjectLabel);
        panel.add(subjectField);
        panel.add(addButton);

        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
