package com.HR.HRApp.controllers;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.domain.Room;
import com.HR.HRApp.service.reservationService;
import com.HR.HRApp.service.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;

@Controller
public class staffController {

    @Autowired
    private reservationService reservationService;

    @Autowired
    private roomService roomService;

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
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "new_reservation";
    }

    //@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    //public String addUser(@ModelAttribute("SpringWeb")User user,
    //                      ModelMap model) {
    //    model.addAttribute("username", user.getUsername());
    //    model.addAttribute("password", user.getPassword());
    //    model.addAttribute("address", user.getAddress());
    //    model.addAttribute("receivePaper", user.isReceivePaper());
    //    model.addAttribute("favoriteFrameworks", user.getFavoriteFrameworks());
    //    return "users";
    //}

    @PostMapping("saveReservationStaff")
    public String saveReservationStaff(@ModelAttribute("reservation") Reservation reservation){
        //save new reservation to database
        reservationService.saveReservation(reservation);
        return "staffHomePage";
    }


    @ModelAttribute("availableRoomList")
    public Set<Room> getAvailableRoomList()
    {
        System.out.println(roomService.getAvailableRoomList().size());
        return roomService.getAvailableRoomList();
    }

    @GetMapping("/addRoomForReservation/{id}")
    public String addRoomForReservation(@PathVariable(value = "id") long id) {

        // add this room to the reservation
        // id = room.id
        // add this room to the email?


        //tood: redict to this page, record ids of room, set the availablity of room
        //this.reservationService.saveRoomToReservation(id);
        return "redirect:/managerHomePage";
    }


}
