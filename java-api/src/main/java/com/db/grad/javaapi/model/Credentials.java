package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name="credentials")
public class Credentials {
    @Id
    private int credentialsId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Id
    @Column(name = "credentials_id", nullable = false)
    public int getCredentialsId()
    {
        return credentialsId;
    }

    public void setCredentialsId(int credentialsId) {
        this.credentialsId = credentialsId;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
