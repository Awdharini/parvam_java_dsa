package com.booking_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.repository.DriverRepository;

@Controller
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/driver/panel")
    public String driverPanel(Model model){

        model.addAttribute("drivers", driverRepository.findAll());

        return "driver-panel";
    }
}
