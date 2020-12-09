package com.HR.HRApp.controllers;

import com.HR.HRApp.HrAppApplication;
import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class accountController {

    @RequestMapping("/account")
    public String about() {
        return "account.html";
    }

    @GetMapping("/showAccount")
    public String showAccount(Model model) {
        // create model attribute to bind form data
        Account account = new Account();
        model.addAttribute("account", account);
        return "accountReservations";
    }

    @ModelAttribute("roomListByAccount")
    public Set<Room> roomListByAccount(@ModelAttribute("account") Account account)
    {
        //System.out.println(account.addReservation());
        return account.getOrderHistory();
    }
}