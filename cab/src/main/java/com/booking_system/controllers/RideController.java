package com.booking_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking_system.entity.Ride;
import com.booking_system.service.RideService;

@Controller
@RequestMapping("/ride")
public class RideController {

    @Autowired
    private RideService rideService;

    // BOOK PAGE
    @GetMapping("/book")
    public String bookPage(Model model){

        model.addAttribute("ride", new Ride());

        return "book-cab";
    }

    // SAVE BOOKING
    @PostMapping("/book")
    public String saveRide(@ModelAttribute Ride ride){

        rideService.bookRide(ride);

        return "redirect:/ride/history";
    }

    // RIDE HISTORY
    @GetMapping("/history")
    public String rideHistory(Model model){

        model.addAttribute(
                "rides",
                rideService.getAllRides()
        );

        return "ride-history";
    }

    // MY RIDES PAGE
    @GetMapping("/myrides")
    public String myRides(Model model){

        model.addAttribute(
                "rides",
                rideService.getAllRides()
        );

        return "my-rides";
    }

    // START RIDE
    @GetMapping("/start/{id}")
    public String startRide(@PathVariable Long id){

        rideService.startRide(id);

        return "redirect:/ride/history";
    }

    // END RIDE
    @GetMapping("/end/{id}")
    public String endRide(@PathVariable Long id){

        rideService.endRide(id);

        return "redirect:/ride/history";
    }
}