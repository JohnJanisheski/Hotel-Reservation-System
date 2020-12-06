package com.HR.HRApp.controllers;


import com.HR.HRApp.repositories.accountRepository;
import com.HR.HRApp.repositories.staffRepository;
import com.HR.HRApp.service.staffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class staffController {
    //display list of staff

    private final staffRepository staffRepository;

    public staffController(com.HR.HRApp.repositories.staffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @RequestMapping("/staff")
    public String getSignUp(Model model) {
        model.addAttribute("Accounts", staffRepository.findAll());
        return "stafflist";
    }

}
