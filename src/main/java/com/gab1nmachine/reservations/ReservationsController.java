package com.gab1nmachine.reservations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ReservationsController {
    @GetMapping("/reservations")
    public String index() {
        return "reservations";
    }
}
