package com.example.attendance;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDashboard extends JFrame {

    private JPanel panel;
    private JLabel nameLabel;
    private JLabel enrollmentLabel;
    private JLabel dateLabel;
    private JTable attendanceTable;
    private JScrollPane scrollPane;

    public StudentDashboard(String name, String enrollment) {
        setTitle("Student Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Student Name: " + name);
        nameLabel.setBounds(50, 50, 300, 25);

        enrollmentLabel = new JLabel("Enrollment Number: " + enrollment);
        enrollmentLabel.setBounds(50, 80, 300, 25);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dateLabel = new JLabel("Date: " + currentDate.format(formatter));
        dateLabel.setBounds(400, 50, 150, 25);

        // Sample data for demonstration
        String[] subjects = {"ICCT", "TOC", "ADS"};
        String[] attendanceStatus = {"Present", "Absent", "Present"};

        String[] columnNames = {"Subject", "Attendance"}; // Column names for the table
        Object[][] data = new Object[subjects.length][2]; // Data for the table

        for (int i = 0; i < subjects.length; i++) {
            data[i][0] = subjects[i]; // Setting subject name
            data[i][1] = attendanceStatus[i]; // Setting attendance status
        }

        attendanceTable = new JTable(data, columnNames); // Creating the table
        scrollPane = new JScrollPane(attendanceTable); // Adding table to scroll pane
        scrollPane.setBounds(50, 120, 500, 200);

        panel.add(nameLabel);
        panel.add(enrollmentLabel);
        panel.add(dateLabel);
        panel.add(scrollPane);

        add(panel);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard("Ruchita Vairagade", "MITU22BTCS667");
            }
        });
    }
}
