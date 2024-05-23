package com.gab1nmachine.microwaves;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "search", url = "http://localhost:8081/")
public interface MicroWaveAPI {
    @PostMapping("/api/microwaves/reserve")
    List<MicroWavesOutputDTO> postDuration(@RequestBody MicroWavesInputDTO newMicroWave);
}




