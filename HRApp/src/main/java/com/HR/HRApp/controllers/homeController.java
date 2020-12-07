package com.HR.HRApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class homeController {

    @RequestMapping("/home")
    public String welcome() {
        return "/home.html";
    }
}
