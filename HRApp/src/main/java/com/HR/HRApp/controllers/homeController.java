package com.HR.HRApp.controllers;

import com.HR.HRApp.repositories.accountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    private final accountRepository accountRepository;

    public homeController(com.HR.HRApp.repositories.accountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping("/home")
    public String getAccounts(Model model){

        model.addAttribute("Accounts", accountRepository.findAll());
        return "accounts/accountList";
    }
}