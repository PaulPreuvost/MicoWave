package com.gab1nmachine.coffeemachine;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "timeslotInfos", url = "http://localhost:8081")
public interface TimeSlotAPI {
    @PostMapping(value = "/timeslot")
    TimeSlotOutputDTO createTimeSlots(@RequestBody TimeSlotInputDTO newTimeslot);
}
