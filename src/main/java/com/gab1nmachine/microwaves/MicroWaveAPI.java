package com.gab1nmachine.microwaves;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "search", url = "http://localhost:8080/")
public interface MicroWaveAPI {
    @PostMapping("/micro-waves/add")
    MicroWavesOutputDTO postDuration(MicroWavesInputDTO newMicroWave);
}




