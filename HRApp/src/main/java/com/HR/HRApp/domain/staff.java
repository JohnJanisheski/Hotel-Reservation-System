package com.HR.HRApp.domain;

import javax.persistence.*;

@Entity

public class staff{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Every account will have a first and last name

    private String firstName;

    private String lastName;

    //Every account will have a username and password
    private String userName;
    private String password;

    public staff() {
    }
    public staff(staff k){
        //this.type = k.getType();
        this.firstName = k.getFirstName();
        this.lastName = k.getLastName();
        this.userName = k.getUserName();
        this.password = k.getPassword();
    }
    public staff(int type, String firstName, String lastName, String userName, String password) {
        //this.type = type;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}