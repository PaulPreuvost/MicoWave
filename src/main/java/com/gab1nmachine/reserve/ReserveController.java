package com.gab1nmachine.reserve;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ReserveController {
    @GetMapping("/reserve")
    public String index() {
        return "reserve";
    }
}
