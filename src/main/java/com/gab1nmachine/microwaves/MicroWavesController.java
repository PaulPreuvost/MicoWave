package com.gab1nmachine.microwaves;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MicroWavesController {
    @GetMapping("/micro-waves")
    public String index() {
        return "micro-waves";
    }
}
