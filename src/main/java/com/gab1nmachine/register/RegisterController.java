package com.gab1nmachine.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController{
    @GetMapping("/register")
    public String authenticate() {
        return "register";
    }
}