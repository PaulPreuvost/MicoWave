package com.gab1nmachine.microwaves;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MicroWavesController {
    @GetMapping("/micro-waves")
    public String index() {
        return "micro-waves";
    }

    @PostMapping("/micro-waves/add")
    public String postDuration(){
        return null;
    }
}
