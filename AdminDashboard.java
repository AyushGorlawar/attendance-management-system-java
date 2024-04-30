package com.example.attendance;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame {

    private JPanel panel;
    private JLabel welcomeLabel;
    private JButton addSubjectsButton;
    private JButton addStudentInfoButton;
    private JButton markAttendanceButton;

    // List to store added students
    private List<Student> students;

    // List to store added subjects
    private List<String> subjectNames;

    // Map to store students for each subject
    private Map<String, List<Student>> subjectStudentsMap;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(600, 700); // Increased height to accommodate the image
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null); // Using absolute positioning

        welcomeLabel = new JLabel("Welcome to Admin Dashboard");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Increased font size to 24
        welcomeLabel.setBounds(150, 20, 400, 30); // Changed width to 400 to accommodate larger text
        panel.add(welcomeLabel);

        // Add image
        ImageIcon icon = new ImageIcon("C:\\Users\\ayush\\eclipse-workspace\\Attendance_SystemGUI\\src\\com\\example\\attendance\\Admin+Panel.png");
        Image image = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH); // Resized image
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(50, 60, 500, 300);
        panel.add(imageLabel);

        addSubjectsButton = new JButton("Add Subjects");
        addSubjectsButton.setBounds(230, 400, 200, 30); // Centered vertically
        addSubjectsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddSubjectsForm(); // Open form to add subjects
            }
        });

        addStudentInfoButton = new JButton("Add Student Info");
        addStudentInfoButton.setBounds(230, 440, 200, 30); // Centered vertically
        addStudentInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddStudentInfoForm(); // Open form to add student information
            }
        });

        markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setBounds(230, 480, 200, 30); // Centered vertically
        markAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMarkAttendanceForm(); // Open form to mark attendance
            }
        });

        panel.add(addSubjectsButton);
        panel.add(addStudentInfoButton);
        panel.add(markAttendanceButton);

        add(panel);

        setLocationRelativeTo(null); // Center the frame on screen

        // Initialize the list of students
        students = new ArrayList<>();
        // Initialize the list of subjects
        subjectNames = new ArrayList<>();
        // Initialize the map of subjects and students
        subjectStudentsMap = new HashMap<>();
    }

    private void openAddStudentInfoForm() {
        // Create form to add student information
        JFrame addStudentFrame = new JFrame("Add Student Information");
        addStudentFrame.setSize(500, 300);
        addStudentFrame.setLayout(new FlowLayout());

        // Labels and text fields for student information
        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField(20);
        JLabel enrollmentLabel = new JLabel("Enrollment:");
        JTextField enrollmentField = new JTextField(10);
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        // Button to add student
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String enrollment = enrollmentField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (!name.isEmpty() && !enrollment.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
                    // Create a new Student object and add it to the list
                    Student student = new Student(name, enrollment, username, password);
                    students.add(student);
                    JOptionPane.showMessageDialog(addStudentFrame, "Student added successfully!");
                } else {
                    JOptionPane.showMessageDialog(addStudentFrame, "Please fill in all fields!");
                }
            }
        });

        // Button to get data (Display student information)
        JButton getDataButton = new JButton("Get Data");
        getDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display student data
                StringBuilder data = new StringBuilder();
                for (Student student : students) {
                    data.append("Name: ").append(student.getName()).append(", ");
                    data.append("Enrollment: ").append(student.getEnrollment()).append(", ");
                    data.append("Username: ").append(student.getUsername()).append(", ");
                    data.append("Password: ").append(student.getPassword()).append("\n");
                }
                JOptionPane.showMessageDialog(addStudentFrame, data.toString());
            }
        });

        // Add components to the frame
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // Grid layout for form components
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(enrollmentLabel);
        formPanel.add(enrollmentField);
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(addButton);
        formPanel.add(getDataButton);

        addStudentFrame.add(formPanel);

        addStudentFrame.setVisible(true);
        addStudentFrame.setLocationRelativeTo(null); // Center the frame on screen
    }

    private void openAddSubjectsForm() {
        // Create form to add subjects
        JFrame addSubjectsFrame = new JFrame("Add Subjects");
        addSubjectsFrame.setSize(400, 200);
        addSubjectsFrame.setLayout(new FlowLayout());

        // Labels and text fields for subject information
        JLabel subjectLabel = new JLabel("Subject Name:");
        JTextField subjectField = new JTextField(15);

        // Button to add subject
        JButton addButton = new JButton("Add Subject");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String subject = subjectField.getText();
                if (!subject.isEmpty()) {
                    // Add subject to the list
                    subjectNames.add(subject);
                    // Initialize an empty list for the subject in the map
                    subjectStudentsMap.put(subject, new ArrayList<>());
                    JOptionPane.showMessageDialog(addSubjectsFrame, "Subject added successfully!");
                } else {
                    JOptionPane.showMessageDialog(addSubjectsFrame, "Please enter subject name!");
                }
            }
        });

        // Add components to the frame
        JPanel formPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // Grid layout for form components
        formPanel.add(subjectLabel);
        formPanel.add(subjectField);
        formPanel.add(addButton);

        addSubjectsFrame.add(formPanel);

        addSubjectsFrame.setVisible(true);
        addSubjectsFrame.setLocationRelativeTo(null); // Center the frame on screen
    }

    private void openMarkAttendanceForm() {
        JFrame markAttendanceFrame = new JFrame("Mark Attendance");
        markAttendanceFrame.setSize(800, 600);
        markAttendanceFrame.setLayout(new BorderLayout());

        JPanel attendancePanel = new JPanel(new GridLayout(students.size() + 1, 3 + subjectNames.size()));

        // Add Enrollment, Name, and Subject Name labels
        attendancePanel.add(new JLabel("Enrollment"));
        attendancePanel.add(new JLabel("Name"));
        for (String subjectName : subjectNames) {
            attendancePanel.add(new JLabel(subjectName));
        }

        // Add radio buttons for attendance
        ButtonGroup[][] buttonGroups = new ButtonGroup[students.size()][subjectNames.size()];
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            JLabel enrollmentLabel = new JLabel(student.getEnrollment());
            JLabel nameLabel = new JLabel(student.getName());
            attendancePanel.add(enrollmentLabel);
            attendancePanel.add(nameLabel);

            for (int j = 0; j < subjectNames.size(); j++) {
                JPanel radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JRadioButton presentButton = new JRadioButton("Present");
                JRadioButton absentButton = new JRadioButton("Absent");
                buttonGroups[i][j] = new ButtonGroup();
                buttonGroups[i][j].add(presentButton);
                buttonGroups[i][j].add(absentButton);
                radioButtonPanel.add(presentButton);
                radioButtonPanel.add(absentButton);
                attendancePanel.add(radioButtonPanel);
            }
        }

        JButton submitButton = new JButton("Submit Attendance");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to save attendance data
                // You can use the 'buttonGroups' array here to get the selected attendance
            }
        });

        JButton getDataButton = new JButton("Get Data");
        getDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to show attendance data
                StringBuilder data = new StringBuilder();
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    data.append("Enrollment: ").append(student.getEnrollment()).append(", ");
                    data.append("Name: ").append(student.getName()).append(", ");
                    for (int j = 0; j < subjectNames.size(); j++) {
                        String subjectName = subjectNames.get(j);
                        Enumeration<AbstractButton> buttons = buttonGroups[i][j].getElements();
                        while (buttons.hasMoreElements()) {
                            AbstractButton button = buttons.nextElement();
                            if (button.isSelected()) {
                                String attendanceStatus = button.getText();
                                data.append(subjectName).append(": ").append(attendanceStatus).append(", ");
                            }
                        }
                    }
                    data.append("\n");
                }
                JOptionPane.showMessageDialog(markAttendanceFrame, data.toString());
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        buttonPanel.add(getDataButton);

        JScrollPane attendanceScrollPane = new JScrollPane(attendancePanel);
        markAttendanceFrame.add(attendanceScrollPane, BorderLayout.CENTER);
        markAttendanceFrame.add(buttonPanel, BorderLayout.SOUTH);

        markAttendanceFrame.setVisible(true);
        markAttendanceFrame.setLocationRelativeTo(null); // Center the frame on screen
    }

    private void openSubjectAttendanceForm(String subjectName) {
        JFrame subjectAttendanceFrame = new JFrame("Mark Attendance for " + subjectName);
        subjectAttendanceFrame.setSize(800, 600);
        subjectAttendanceFrame.setLayout(new BorderLayout());

        // Fetch students for the selected subject
        List<Student> subjectStudents = subjectStudentsMap.get(subjectName);
        JPanel attendancePanel = new JPanel(new GridLayout(subjectStudents.size() + 1, 4));

        JLabel enrollmentLabel = new JLabel("Enrollment");
        JLabel nameLabel = new JLabel("Name");
        JLabel attendanceLabel = new JLabel("Attendance");
        attendancePanel.add(enrollmentLabel);
        attendancePanel.add(nameLabel);
        attendancePanel.add(attendanceLabel);

        ButtonGroup[] buttonGroups = new ButtonGroup[subjectStudents.size()];
        for (int i = 0; i < subjectStudents.size(); i++) {
            Student student = subjectStudents.get(i);
            JLabel enrollment = new JLabel(student.getEnrollment());
            JLabel name = new JLabel(student.getName());
            JPanel radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JRadioButton presentButton = new JRadioButton("Present");
            JRadioButton absentButton = new JRadioButton("Absent");
            buttonGroups[i] = new ButtonGroup();
            buttonGroups[i].add(presentButton);
            buttonGroups[i].add(absentButton);
            radioButtonPanel.add(presentButton);
            radioButtonPanel.add(absentButton);
            attendancePanel.add(enrollment);
            attendancePanel.add(name);
            attendancePanel.add(radioButtonPanel);
        }

        JButton submitButton = new JButton("Submit Attendance");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < subjectStudents.size(); i++) {
                    Student student = subjectStudents.get(i);
                    Enumeration<AbstractButton> buttons = buttonGroups[i].getElements();
                    while (buttons.hasMoreElements()) {
                        AbstractButton button = buttons.nextElement();
                        if (button.isSelected()) {
                            String attendanceStatus = button.getText();
                            // Save attendance status for the student
                            // You can use student.getName() and attendanceStatus to save attendance data
                            // Add your logic here
                            System.out.println("Attendance for " + student.getName() + " is " + attendanceStatus);
                        }
                    }
                }
            }
        });

        subjectAttendanceFrame.add(new JScrollPane(attendancePanel), BorderLayout.CENTER);
        subjectAttendanceFrame.add(submitButton, BorderLayout.SOUTH);

        subjectAttendanceFrame.setVisible(true);
        subjectAttendanceFrame.setLocationRelativeTo(null); // Center the frame on screen
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }
}