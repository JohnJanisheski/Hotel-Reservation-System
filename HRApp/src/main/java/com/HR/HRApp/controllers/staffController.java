package com.HR.HRApp.controllers;


import com.HR.HRApp.domain.staff;
import com.HR.HRApp.repositories.staffRepository;
import com.HR.HRApp.service.staffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class staffController {
    //display list of staff

    private staffRepository staffRepository;
    @Autowired
    private staffService staffService;

    public staffController(com.HR.HRApp.repositories.staffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping("/staff")
    public String getSignUp(Model model) {
        model.addAttribute("Accounts", staffRepository.findAll());
        return "Yuhui/stafflist";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model)
    {
        staff staff = new staff();
        model.addAttribute("staff", staff);
        return "Yuhui/new_staff";
    }

    @PostMapping("/saveStaff")
    public String saveStaff(@ModelAttribute("staff") staff staff){
        // save staff to db
        staffService.saveStaff(staff);
        return "redirect:/";
    }


}
