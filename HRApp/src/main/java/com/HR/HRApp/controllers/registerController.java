package com.HR.HRApp.controllers;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class registerController {

    @Autowired
    private accountService accountService;

    @GetMapping("/register_start")
    public String register_start(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "register.html";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account account) {
        // save new customer account to database
        account.setType(0);
        accountService.saveAccount(account);
        System.out.println(account.getId());
        return "redirect:/login_start";
    }
}
