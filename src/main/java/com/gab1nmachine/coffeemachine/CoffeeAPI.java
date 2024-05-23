package com.gab1nmachine.coffeemachine;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "reserveCoffee", url = "http://localhost:8081")
public interface CoffeeAPI {
    @PutMapping(value = "/coffee")
    CoffeeOutputDTO updateCoffeeState(@RequestBody CoffeeInputDTO newCoffeeState);
}
