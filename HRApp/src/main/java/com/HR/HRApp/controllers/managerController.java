package com.HR.HRApp.controllers;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class managerController {

    @Autowired
    private accountService accountService;

    //display list of staff
    @GetMapping("/managerHomePage")
    public String managerHomePage(Model model)
    {
        //List<Account> Employees = accountService.getAllAccountByType(1);
        //System.out.println(Employees.size());
        //model.addAttribute("listEmployees", Employees);
        Account Employee = new Account();
        model.addAttribute("employee", Employee);
        return "managerHomePage";
    }

    @GetMapping("/showEmployeeList")
    public String showNewEmployeeList(Model model) {
        // create model attribute to bind form data
        List<Account> Employees = accountService.getAllAccountByType(1);
        System.out.println(Employees.size());
        model.addAttribute("listEmployees", Employees);
        return "staffList";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Account employee = new Account();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Account employee) {
        // save employee to database
        accountService.saveEmployee(employee);
        return "managerHomePage";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.accountService.deleteAccountById(id);
        return "redirect:/managerHomePage";
    }
}
