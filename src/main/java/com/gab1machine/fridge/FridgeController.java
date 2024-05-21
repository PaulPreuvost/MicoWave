package com.gab1machine.fridge;

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
    public String confirmReservation(@PathVariable UUID storageId, Model model, @RequestBody MultiValueMap<String, Object> mapp) {
//        Date date = new Date(Long.parseLong(mapp.getFirst("date").toString()));
        List<Object> reservations = mapp.get("reservations");
        // Decode reservations (List<Object> into List<ReservationDto>)
        List<ReservationConfirmationInputDto> reservationDtos = null;
        for (Object reservation : reservations) {
            MultiValueMap<String, Integer> reservationMap = (MultiValueMap<String, Integer>) reservation;
            ReservationConfirmationInputDto reservationDto = new ReservationConfirmationInputDto(reservationMap.getFirst("index"), reservationMap.getFirst("size"));
            reservationDtos.add(reservationDto);
            System.out.println(reservationDto);
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
