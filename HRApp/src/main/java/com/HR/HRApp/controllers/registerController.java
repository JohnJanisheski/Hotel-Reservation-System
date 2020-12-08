package com.HR.HRApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class registerController {

    @RequestMapping("/register")
    public String welcome() {
        return "/register.html";
    }
}
