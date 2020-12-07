package com.HR.HRApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//The User class is meant to be the basis of all of the users
//This will be extended by customer, manager and Staff.
@Entity
public class account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //This will represent what kind of user the account is
    //0 - Customer
    //1 - Staff Member
    //2 - Manager
    private int type;

    //Every account will have a first and last name
    private String firstName;
    private String lastName;

    //Every account will have a Email and password
    private String Email;
    private String password;

    public account() {
    }
    public account(staff k){

        this.firstName = k.getFirstName();
        this.lastName = k.getLastName();
        this.Email = k.getEmail();
        this.password = k.getPassword();
    }
    public account(int type, String firstName, String lastName, String Email, String password) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Email = Email;
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
