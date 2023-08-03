package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {

    @Id
    private long id;
    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role){
        this.name = name;
        this.email = email;
        this.role = role;
    }
    @Column(name = "name", nullable = false)
    public String getUserName(){
        return name;
    }
    @Column(name = "email", nullable = false)
    public String getUserEmail(){
        return email;
    }
    @Column(name = "role", nullable = false)
    public String getUserRole(){
        return role;
    }

    public void setUserName(String name){
        this.name = name;
    }

    public void setUserEmail(String email){
        this.email = email;
    }

    public void setUserRole(String role){
        this.role = role;
    }
}
