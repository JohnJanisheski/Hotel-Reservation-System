package com.HR.HRApp.service;

import com.HR.HRApp.domain.staff;
import com.HR.HRApp.repositories.staffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class staffServiceImp extends staffService {
    @Autowired
    private com.HR.HRApp.repositories.staffRepository staffRepository;

    @Override
    public List<staff> getAllStaff(){
        return (List<staff>) staffRepository.findAll();

    }

    @Override
    public void saveStaff(staff staff) {
        this.staffRepository.save(staff);
    }



}
