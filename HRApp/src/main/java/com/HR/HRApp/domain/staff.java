package com.HR.HRApp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

public class staff extends account{

    public staff() {
        super(1, "John", "Adams", "Staff Username", "password123");
    }
}