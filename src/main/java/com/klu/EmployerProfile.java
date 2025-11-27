package com.klu;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class EmployerProfile {
 @Id
 private String email; // Set email as the primary key

 private String name;
 private String phone;
 private String companyName;

 // Getters and Setters
 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getPhone() {
     return phone;
 }

 public void setPhone(String phone) {
     this.phone = phone;
 }

 public String getCompanyName() {
     return companyName;
 }

 public void setCompanyName(String companyName) {
     this.companyName = companyName;
 }
}