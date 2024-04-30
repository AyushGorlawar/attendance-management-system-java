package com.example.attendance;
//Student class
class Student {
 private String name;
 private String enrollment;
 private String username;
 private String password;

 // Constructor
 public Student(String name, String enrollment, String username, String password) {
     this.name = name;
     this.enrollment = enrollment;
     this.username = username;
     this.password = password;
 }

 // Getters
 public String getName() {
     return name;
 }

 public String getEnrollment() {
     return enrollment;
 }

 public String getUsername() {
     return username;
 }

 public String getPassword() {
     return password;
 }
}
