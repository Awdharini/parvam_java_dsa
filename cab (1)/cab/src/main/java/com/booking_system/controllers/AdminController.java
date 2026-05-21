package com.booking_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.repository.CustomerRepository;
import com.repository.DriverRepository;
import com.repository.RideRepository;

@Controller
public class AdminController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RideRepository rideRepository;

    @GetMapping("/admin")
    public String adminDashboard(Model model){
  model.addAttribute("customers", customerRepository.count());
        model.addAttribute("drivers", driverRepository.count());
        model.addAttribute("rides", rideRepository.count());

        return "admin-dashboard";
    }
}
