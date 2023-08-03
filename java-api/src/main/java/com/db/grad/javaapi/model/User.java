package com.db.grad.javaapi.model;

public class User {

    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role){
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getUserName(){
        return name;
    }

    public String getUserEmail(){
        return email;
    }

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
