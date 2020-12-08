package com.HR.HRApp.controllers;

import com.HR.HRApp.repositories.accountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

    @RequestMapping("/login")
    public String login() {
        return "/login.html";
    }
}