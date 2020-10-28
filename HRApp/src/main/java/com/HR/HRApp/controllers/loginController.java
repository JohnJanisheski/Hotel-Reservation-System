package com.HR.HRApp.controllers;

import com.HR.HRApp.repositories.accountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

    private final accountRepository accountRepository;

    public loginController(accountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping("/")
    public String getLogin(Model model){

        model.addAttribute("Accounts", accountRepository.findAll());
        return "accounts/list";
    }

    @RequestMapping("/Login")
    public String getOtherLogin(Model model){

        model.addAttribute("Accounts", accountRepository.findAll());
        return "accounts/list";
    }
}