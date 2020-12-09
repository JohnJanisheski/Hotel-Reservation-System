package com.HR.HRApp.controllers;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.service.reservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class staffController {

    @Autowired
    private reservationService reservationService;

    @GetMapping("/staffHomePage")
    public String managerHomePage(Model model)
    {
        //List<Account> Employees = accountService.getAllAccountByType(1);
        //System.out.println(Employees.size());
        //model.addAttribute("listEmployees", Employees);
        Account Employee = new Account();
        model.addAttribute("employee", Employee);
        return "staffHomePage";
    }

    @GetMapping("/showReservationList")
    public String showReservationList(Model model) {
        // create model attribute to bind form data
        //List<Account> Employees = accountService.getAllAccountByType(1);
        //System.out.println(Employees.size());
        //model.addAttribute("listEmployees", Employees);
        //return "staffList";

        List<Reservation> reservationList = reservationService.getAllReservtions();
        System.out.println(reservationList.size());
        model.addAttribute("listReservations", reservationList);
        return "staffReservationList";
    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.reservationService.deleteReservationById(id);
        return "redirect:/staffHomePage";
    }

    @GetMapping("/showNewReservationForm")
    public String showNewReservationForm(Model model) {
        // create model attribute to bind form data
        Reservation reservation = new Reservation(roomType);
        model.addAttribute("reservation", reservation);
        return "new_reservation";
    }
}
