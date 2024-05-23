package com.gab1nmachine.coffeemachine;

import com.gab1nmachine.web.ReservationCoffee;
import com.gab1nmachine.web.TimeSlot;
import com.gab1nmachine.web.User;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Controller
public class CoffeeController {

    private final CoffeeAPI coffeeAPI;

    public CoffeeController(CoffeeAPI coffeeAPI) {
        this.coffeeAPI = coffeeAPI;
    }


    @GetMapping("/book_coffee_machine")
    public String createTimeSlots(Model model) {
        List<TimeSlotInputDTO> timeSlots = generateTimeSlots(getTime(8, 30), getTime(17, 0));
        model.addAttribute("timeSlots", timeSlots);

        List<String> formattedTimeSlots = new ArrayList<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        for (TimeSlotInputDTO timeSlot : timeSlots) {
            formattedTimeSlots.add(timeFormat.format(timeSlot.getDate()));
        }
        model.addAttribute("formattedTimeSlots", formattedTimeSlots);

        List<String> days = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            days.add("Day " + i);
        }
        model.addAttribute("days", days);

        return "book_coffee_machine";
    }

    private List<TimeSlotInputDTO> generateTimeSlots(Date startTime, Date endTime) {
        List<TimeSlotInputDTO> timeSlots = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);

        while (calendar.getTime().before(endTime) || calendar.getTime().equals(endTime)) {
            Date date = calendar.getTime();
            boolean isAvailable = false;
            TimeSlotInputDTO newTimeSlotInput = new TimeSlotInputDTO(UUID.randomUUID(), date, isAvailable);
            timeSlots.add(newTimeSlotInput);
            calendar.add(Calendar.MINUTE, 5);
        }
        return timeSlots;
    }

    private Date getTime(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    @PutMapping("/coffee")
    public String updateCoffeeState(@ModelAttribute ReservationCoffee reservationCoffee, @ModelAttribute User user, @ModelAttribute TimeSlot timeSlot) {
        String target;
        UUID user_id = user.getId();
        UUID timeslot_id = timeSlot.getId();
        try{
            CoffeeInputDTO newReservationInput = new CoffeeInputDTO(UUID.randomUUID(), user_id, timeslot_id, true);
            this.coffeeAPI.updateCoffeeState(newReservationInput);
            target = "redirect:/index";
        }
        catch (FeignException.FeignClientException e){
            log.error(" Erreur lors de la création ", e);
            target = "redirect:/micro-waves";
        }
        return target;
    }
}
