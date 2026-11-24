package com.bryan.banking.model;

import java.time.LocalDateTime;

public class Customer {

    private int id;
    private String username;
    private String passwordHash;
    private String fullName;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

    public Customer() {}

    public Customer(int id, String username, String passwordHash,
                    String fullName, String email, String phone,
                    LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public int getId()                     { return id; }
    public void setId(int id)              { this.id = id; }

    public String getUsername()                        { return username; }
    public void setUsername(String username)           { this.username = username; }

    public String getPasswordHash()                    { return passwordHash; }
    public void setPasswordHash(String passwordHash)   { this.passwordHash = passwordHash; }

    public String getFullName()                        { return fullName; }
    public void setFullName(String fullName)           { this.fullName = fullName; }

    public String getEmail()                           { return email; }
    public void setEmail(String email)                 { this.email = email; }

    public String getPhone()                           { return phone; }
    public void setPhone(String phone)                 { this.phone = phone; }

    public LocalDateTime getCreatedAt()                { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt)  { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", username='" + username + "', fullName='" + fullName + "'}";
    }
}
