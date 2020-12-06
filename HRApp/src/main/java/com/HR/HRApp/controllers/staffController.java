package com.HR.HRApp.controllers;


import com.HR.HRApp.service.staffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class staffController {
    //display list of staff

    private staffService staffservice;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listStaff", staffservice.getAllStaff());
        return "index";
    }
}
