//  makes counter_party sql table columns into objects 
//  counter_party_id and counter_party_name

package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Counter_Party")
public class Counter_Party
{
    @Id

    //  creates variables
     private int counter_party_id;
     private String counter_party_name;

    //  primary key to counter_party_id object
    @Id
    @Column(name = "counter_party_id", nullable = false)
     public int getid() {
         return counter_party_id;
     }
     public void setid(int cp_id) {
         this.counter_party_id = cp_id;
     }
    //  column counter_party_name to counter_party_name object
     @Column(name = "counter_party_name", nullable = false)
     public String getname() {
         return counter_party_name;
     }
     public void setname(String cp_name) {
         this.counter_party_name = cp_name;
     }
} 