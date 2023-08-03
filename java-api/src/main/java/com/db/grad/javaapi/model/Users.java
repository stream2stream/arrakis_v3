//  makes counter_party sql table columns into objects
//  user_id, user_name, user_email, and user_email

package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users
{
    @Id
    //  creates variables
     private int user_id;
     private String user_name;
     private String user_email;
     private String user_password;

    @Id

    //  primary key user_id to id object
    @Column(name = "user_id", nullable = false)
     public int getuser_id() {
         return user_id;
     }
     public void setuser_id(int user_id) {
         this.user_id = user_id;
     }

    //  column user_name to user_name object
     @Column(name = "user_name", nullable = false)
     public String getuser_name() {
         return user_name;
     }
     public void setuser_name(String user_name) {
         this.user_name = user_name;
     }

     //  column  user_email to  user_email object
     @Column(name = " user_email", nullable = false)
     public String getuser_email() {
         return  user_email;
     }
     public void setuser_email(String  user_email) {
         this. user_email =  user_email;
     }

     //  column  user_password to  user_password object
     @Column(name = " user_password", nullable = false)
     public String getuser_password() {
         return  user_password;
     }
     public void setuser_password(String  user_password) {
         this. user_password =  user_password;
     }
    }