package com.booking_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.booking_system.entity.Customer;
import com.repository.CustomerRepository;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/register")
    public String registerPage(Model model){

        model.addAttribute("customer", new Customer());

        return "register";
    }
  @PostMapping("/register")
    public String registerCustomer(@ModelAttribute Customer customer){

        customerRepository.save(customer);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "customer-login";
    }
}
