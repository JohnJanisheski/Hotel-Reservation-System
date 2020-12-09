package com.HR.HRApp.controllers;

import com.HR.HRApp.HrAppApplication;
import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.service.reservationService;
import com.HR.HRApp.service.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class orderController {


    @Autowired
    private reservationService reservationService;

    @Autowired
    private roomService roomService;

    @RequestMapping("/order")
    public String about() {
        return "order.html";
    }


    @GetMapping("/showNewReservationFormMain")
    public String showNewReservationFormMain(Model model) {
        // create model attribute to bind form data
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "index";
    }


    @PostMapping("/saveReservationMain")
    public String saveReservationMain(@ModelAttribute("reservation") Reservation reservation) {
        // save employee to database
        int type =0;

        //roomService.setRoomsReserved(reservation.getRoomNum(), type);
        reservationService.save(reservation);
        return "booking";
    }
}