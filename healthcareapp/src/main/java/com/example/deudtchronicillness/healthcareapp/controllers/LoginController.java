package com.example.deudtchronicillness.healthcareapp.controllers;

import com.example.deudtchronicillness.healthcareapp.entities.User;
import com.example.deudtchronicillness.healthcareapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController



public class LoginController {

    @Autowired
    private UserRepository userRepository;

    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String logging(@RequestParam String username, @RequestParam String password){

        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            return "/users"; // Redirect to the dashboard or any other page
        } else {
            // Failed login
            return "redirect:/login?error=true"; // Redirect back to the login page with an error parameter
        }


    }






}
