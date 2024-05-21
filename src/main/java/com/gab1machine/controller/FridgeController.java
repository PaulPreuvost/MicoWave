package com.gab1machine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FridgeController {
    @RequestMapping("/fridge")
    public String login() {
        return "fridge";
    }
}

