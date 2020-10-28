package com.HR.HRApp.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

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

    //Every account will have a username and password
    private String userName;
    private char[] password;

    public account() {
    }
    public account(staff k){
        this.type = k.getType();
        this.firstName = k.getFirstName();
        this.lastName = k.getLastName();
        this.userName = k.getUserName();
        this.password = k.getPassword();
    }
    public account(int type, String firstName, String lastName, String userName, char[] password) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
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
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public char[] getPassword() {
        return password;
    }
    public void setPassword(char[] password) {
        this.password = password;
    }
}
