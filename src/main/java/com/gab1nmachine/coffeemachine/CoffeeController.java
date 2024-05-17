package com.gab1nmachine.coffeemachine;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CoffeeController {
    @GetMapping("/book_coffee_machine")
    public String authenticate(Model model) {
        List<String> timeSlots = generateTimeSlots(LocalTime.of(8, 30), LocalTime.of(17, 0));
        model.addAttribute("timeSlots", timeSlots);

        List<String> days = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            days.add("Day " + i);
        }
        model.addAttribute("days", days);

        return "book_coffee_machine";
    }

    private List<String> generateTimeSlots(LocalTime startTime, LocalTime endTime) {
        List<String> timeSlots = new ArrayList<>();
        LocalTime currentTime = startTime;

        while (!currentTime.isAfter(endTime)) {
            timeSlots.add(currentTime.toString());
            currentTime = currentTime.plusMinutes(5);
        }

        return timeSlots;
    }
}
