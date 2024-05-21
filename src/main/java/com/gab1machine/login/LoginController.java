package com.gab1machine.login;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String loginPost(@RequestParam MultiValueMap<String, String> paramMap) {
        String email = paramMap.getFirst("email");
        String password = paramMap.getFirst("password");
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return "login";
        }
        // Redirect to the home page
        return "redirect:/";
    }
}