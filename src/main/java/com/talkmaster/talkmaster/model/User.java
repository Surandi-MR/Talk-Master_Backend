package com.talkmaster.talkmaster.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") //map this class to a MongoDB collection.
public class User {
    @Id //mark a field as the unique identifier of a MongoDB document.
    private String id; // MongoDB document ID
    private String firstName;
    private String lastName;
    private String email;
    private int phone_no;
    private String gender;
    private String proficiency;
    private String username;
    private String password;
    private String role;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_no() { return phone_no; }

    public void setPhone_no(int phone_no) { this.phone_no = phone_no; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProficiency() { return proficiency; }

    public void setProficiency(String proficiency) { this.proficiency = proficiency; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password;}

}
