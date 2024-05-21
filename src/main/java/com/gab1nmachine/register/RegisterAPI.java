package com.gab1nmachine.register;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "search", url = "http://localhost:8081")
public interface RegisterAPI {
    @PostMapping("/register")
    RegisterOutputDTO postUserInfo(@RequestBody RegisterInputDTO newRegistration);
}
