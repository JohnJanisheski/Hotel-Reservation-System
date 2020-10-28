package com.HR.HRApp.controllers;

import com.HR.HRApp.repositories.accountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class signUpController {

    private final accountRepository accountRepository;

    public signUpController(accountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping("/signUp")
    public String getAccounts(Model model){

        model.addAttribute("Accounts", accountRepository.findAll());
        return "accounts/signUp";
    }
}