package com.gab1nmachine.microwaves;
import com.gab1nmachine.web.MicroWaves;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MicroWavesController {

    private final MicroWaveAPI microWaveApi;

    @GetMapping("/micro-waves")
    public String index(Model model) {
        MicroWaves defaultMicroWaves = new MicroWaves(0, 0);
        model.addAttribute("duration", defaultMicroWaves);
        return "micro-waves";
    }

    @PostMapping("/reserve")
    public String postDuration(@ModelAttribute MicroWaves microWaves){
        String target;
        int minutes = microWaves.getMinutes();
        int seconds = microWaves.getSeconds();
        try{
            MicroWavesInputDTO newMicroWaves = new MicroWavesInputDTO(minutes, seconds);
            this.microWaveApi.postDuration(newMicroWaves);
            target = "redirect:/reserve";
        }
        catch (FeignException.FeignClientException e){
            log.error(" Erreur lors de la création ", e);
            target = "redirect:/micro-waves";
        }

        return target;
    }
}
