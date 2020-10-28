package com.HR.HRApp.controllers;

import com.HR.HRApp.repositories.accountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class createStaffController {

    private final accountRepository accountRepository;

    public createStaffController(accountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @RequestMapping("/createStaff")
    public String getSignUp(Model model){

        model.addAttribute("Accounts", accountRepository.findAll());
        return "accounts/signUp";
    }
}