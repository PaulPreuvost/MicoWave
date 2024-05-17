package com.gab1nmachine.reserve;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ReserveController {
    @GetMapping("/reserve")
    public String index() {
        return "reserve";
    }
}

