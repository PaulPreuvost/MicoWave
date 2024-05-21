package com.gab1nmachine.register;

import com.gab1nmachine.web.User;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Slf4j
@Controller
public class RegisterController{

    private final RegisterAPI registerAPI;

    public RegisterController(RegisterAPI registerAPI) {
        this.registerAPI = registerAPI;
    }

    @GetMapping("/register")
    public String authenticate() {
        return "register";
    }

    @PostMapping("/register")
    public String postUserInfo(@ModelAttribute User user) {
        String target;
        String name = user.getName();
        String surname = user.getSurname();
        String email = user.getEmail();
        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();

        try{
            RegisterInputDTO newRegisterInput = new RegisterInputDTO(UUID.randomUUID(), name, surname, email, password, confirmPassword);
            this.registerAPI.postUserInfo(newRegisterInput);
            target = "redirect:/index";
        }
        catch (FeignException.FeignClientException e){
            log.error(" Erreur lors de la création ", e);
            target = "redirect:/micro-waves";
        }

        return target;
    }
}