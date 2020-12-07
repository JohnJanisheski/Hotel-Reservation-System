package com.HR.HRApp.service;

import com.HR.HRApp.domain.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public abstract class staffService {

    @Autowired
    private com.HR.HRApp.repositories.staffRepository staffRepository;

    public abstract List<staff> getAllStaff();

    public void saveStaff(staff staff) {
        this.staffRepository.save(staff);
    }
}
