package com.HR.HRApp.controllers;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.service.accountService;
import org.apache.juli.logging.Log;
import org.hibernate.type.TrueFalseType;
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
        if(accounts.size()==1) // find the account based on email and password
        {
            Account loggedinAccount = new Account();
            loggedinAccount = accounts.get(0);

            loggedinAccount.setLoggedin(true);

            System.out.println(loggedinAccount.getLoggedin());
            System.out.println(loggedinAccount.getId());

            //save the changed Bool to database
            accountService.changeLoggedIn(loggedinAccount);

            // the user is a customer
            if(loggedinAccount.getType() == 0)
                return "home_loggedIn";
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

    @GetMapping("/logout")
    public String logout(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        Account LogInaccount =  accountService.getLoggedInAccount();
        LogInaccount.setLoggedin(false);
        accountService.setAccountLogOut(LogInaccount);
        return "home";
    }


}