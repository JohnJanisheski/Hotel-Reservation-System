package com.HR.HRApp.domain;

import javax.persistence.*;


import java.util.HashSet;
import java.util.Set;

//The User class is meant to be the basis of all of the users
//This will be extended by customer, manager and Staff.
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long account_id;

    //This will represent what kind of user the account is
    //0 - Customer
    //1 - Staff Member
    //2 - Manager
    @Column(name = "account_type")
    private int type;

    //Every account will have a first and last name
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;

    //Every account will have a Email and password
    @Column(name = "Email")
    private String Email;
    @Column(name = "password")
    private String password;

    private Boolean isLoggedin;

    @Column(name = "order_History")
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "reservation_id")
    private Set<reservation> orderHistory = new HashSet<>();

    public Account(int type, String firstName, String lastName, String Email, String password){
        // com.HR.HRApp.repositories.managerRepository managerRepository, com.HR.HRApp.repositories.customerRepository customerRepository) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Email = Email;
        this.password = password;
        this.isLoggedin = false;
    }

    public Account() {

    }

    public long getId() {
        return account_id;
    }
    public void setId(long id) {
        this.account_id = id;
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

    public Boolean getLoggedin() {
        return isLoggedin;
    }

    //log in
    public void setLoggedin(Boolean loggedin) {
        isLoggedin = loggedin;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
