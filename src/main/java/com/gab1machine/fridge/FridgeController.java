package com.gab1machine.fridge;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class FridgeController {
    private final FridgeClient fridgeClient;

    @PostMapping(value = "/fridge/confirm/{storageId}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String confirmReservation(@PathVariable UUID storageId, Model model, @RequestBody MultiValueMap<String, Object> mapp) throws JsonProcessingException {
        String reservationsJsonEncoded = (String) mapp.getFirst("reservations");
        List<ReservationConfirmationInputDto> reservations = ReservationConfirmationInputDto.fromJsonList(reservationsJsonEncoded);
        for (ReservationConfirmationInputDto reservation : reservations) {
            System.out.println(reservation.getSize());
        }

        return fridgeOverview(storageId, model);
    }

    @GetMapping("/fridge/{storageId}")
    public String fridgeOverview(@PathVariable UUID storageId, Model model) {
        Optional<StorageOutputDto> storage = fridgeClient.getStorage(storageId);
        if (storage.isEmpty()) {
            model.addAttribute("message", "Storage not found");
            return "error";
        }

        model.addAttribute("reservations", fridgeClient.getReservations(storageId));
        model.addAttribute("storageSize", storage.get().size());
        return "fridge";
    }

}
