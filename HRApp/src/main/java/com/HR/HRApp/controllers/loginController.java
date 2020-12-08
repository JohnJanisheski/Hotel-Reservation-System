package com.HR.HRApp.controllers;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.repositories.accountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.channels.AcceptPendingException;
import java.util.List;

@Controller
public class loginController {

    @Autowired
    private accountRepository accountRepository;

    @RequestMapping("/login_start")
    public String login_start(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "login";
    }

    @PostMapping("/signInAction")
    public String signInAction(@ModelAttribute("account") Account account) throws Exception {

        List<Account> accounts = accountRepository.findByEmail(account.getEmail());
        if(account == null) throw new Exception("Account not found");

        System.out.println("mapped log in");
        return "home";
    }
}