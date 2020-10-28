package com.HR.HRApp.controllers;

import com.HR.HRApp.repositories.roomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class roomController {

    private final roomRepository roomRepository;

    public roomController(roomRepository roomRepository)
    {
        this.roomRepository = roomRepository;
    }

    @RequestMapping("/rooms")
    public String getrooms(Model model)
    {
        model.addAttribute("rooms", roomRepository.findAll());

        return "authors/list";
    }

}
