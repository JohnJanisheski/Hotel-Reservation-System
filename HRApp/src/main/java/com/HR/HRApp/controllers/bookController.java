package com.HR.HRApp.controllers;

import com.HR.HRApp.HrAppApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class bookController {

    @RequestMapping("/book")
    public String about() {
        return "index.html";
    }
}