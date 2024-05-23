package com.gab1nmachine.coffeemachine;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "timeslotInfos", url = "http://localhost:8081/api/timeslots")
public interface TimeSlotAPI {
    @PostMapping
    TimeSlotOutputDTO createTimeSlots(@RequestBody TimeSlotInputDTO newTimeslot);

    @GetMapping
    List<TimeSlotInputDTO> generateTimeSlots();
}
