package com.HR.HRApp.controllers;

import com.HR.HRApp.HrAppApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class aboutController {

    @RequestMapping("/about")
    public String about() {
        return "/about.html";
    }

    @RequestMapping("/about_loggedIn")
    public String aboutLoggedIn() {
        return "/about_loggedIn.html";
    }

}
