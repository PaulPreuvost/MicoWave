package com.gab1nmachine.microwaves;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "search", url = "http://localhost:8081/")
public interface MicroWaveAPI {
    @PostMapping("/reserve")
    MicroWavesOutputDTO postDuration(@RequestBody MicroWavesInputDTO newMicroWave);
}




