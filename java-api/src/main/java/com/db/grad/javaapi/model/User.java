//package com.db.grad.javaapi.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    private long user_id;
//    private String issuer;
//    private String email;
//    private String role;
//
//    @Id
//    @Column(name = "user_id", nullable = false)
//    public long getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(long user_id) {
//        this.user_id = user_id;
//    }
//
//    @Column(name = "issuer", nullable = false)
//    public String getIssuer() {
//        return issuer;
//    }
//
//    public void setIssuer(String issuer) {
//        this.issuer = issuer;
//    }
//
//    @Column(name = "email", nullable = false)
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Column(name = "role", nullable = false)
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "user_id=" + user_id +
//                ", issuer='" + issuer + '\'' +
//                ", email='" + email + '\'' +
//                ", role='" + role + '\'' +
//                '}';
//    }
//}
