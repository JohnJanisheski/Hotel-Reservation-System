package com.HR.HRApp.controllers;

import com.HR.HRApp.HrAppApplication;
import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.domain.Room;
import com.HR.HRApp.service.reservationService;
import com.HR.HRApp.service.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
        Room room = new Room();
        model.addAttribute("room", room);
        return "index";
    }

    @ModelAttribute("availableRoomList")
    public Set<Room> getAvailableRoomList()
    {
        System.out.println(roomService.getAvailableRoomList().size());
        return roomService.getAvailableRoomList();
    }

    @PostMapping("/saveReservationMain")
    public String saveReservationMain(@ModelAttribute("room") Room room) {
        // save employee to database
        int type =0;

        //roomService.setRoomsReserved(reservation.getRoomNum(), type);
        roomService.save(room);
        return "booking";
    }


    @GetMapping("/addRoomForReservationMain/{id}")
    public String addRoomForReservationMain(@PathVariable(value = "id") long id
            ) {
        System.out.println(id);
        this.roomService.setReservationforRoom(id);

        return "redirect:/payment";
    }
}