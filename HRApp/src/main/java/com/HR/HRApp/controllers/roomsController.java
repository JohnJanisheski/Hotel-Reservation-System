package com.HR.HRApp.controllers;

import com.HR.HRApp.domain.room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class roomsController {

    @RequestMapping("/rooms")
    public String about() {
        return "/booking.html";
    }

    @GetMapping("/showRooms")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        room room = new room();
        model.addAttribute("room", room);
        return "roomShow";
    }
}
