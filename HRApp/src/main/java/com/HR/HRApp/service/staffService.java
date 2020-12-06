package com.HR.HRApp.service;

import com.HR.HRApp.domain.staff;
import org.springframework.stereotype.Service;

import java.util.List;

public abstract class staffService {
    public abstract List<staff> getAllStaff();
}
