package com.HR.HRApp.controllers;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class loginController {

    @Autowired
    private accountService accountService;

    @RequestMapping("/login_start")
    public String login_start(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "login.html";
    }

    @PostMapping("/signInAction")
    public String signInAction(@ModelAttribute("account") Account account) {

        System.out.println(account.getEmail()+account.getPassword()+account.getType());
        List<Account> accounts = accountService.getAccountByEmailAndPassword(account.getEmail(), account.getPassword());
        System.out.println(accounts.size());
        if(accounts.size()>=1) // find the account based on email and password
        {
            Account loggedinAccount = new Account();
            loggedinAccount = accounts.get(0);

            // the user is a customer
            if(loggedinAccount.getType() == 0)
                return "person";
            // the user is a staff
            else if(loggedinAccount.getType() == 1)
                return "staffHomePage";
            // the user is a manager
            else if(loggedinAccount.getType() == 2)
                return "managerHomePage";
        }
        else
            try {
                throw new Exception("Account not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "redirect:/login_start";
    }


}