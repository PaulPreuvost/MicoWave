package com.gab1nmachine.reserve;
import com.gab1nmachine.microwaves.MicroWaveAPI;
import com.gab1nmachine.microwaves.MicroWavesController;
import com.gab1nmachine.microwaves.MicroWavesOutputDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ReserveController {
    private final MicroWaveAPI microWaveAPI;
    @GetMapping("/reserve")
    public String index(HttpSession httpSession) {
        List<MicroWavesOutputDTO> availabilities = (List<MicroWavesOutputDTO>) httpSession.getAttribute("availabilities");
        return "reserve";
    }
}

