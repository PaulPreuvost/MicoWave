package com.gab1machine.fridge;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@FeignClient(name = "Back", url = "http://localhost:8181")
public interface FridgeClient {
    @RequestMapping(method = RequestMethod.GET, value = "/reservations", consumes = "application/json")
    List<ReservationsOutputDto> getReservations(@RequestParam("storageId") UUID storageId);

    @RequestMapping(method = RequestMethod.GET, value = "/storage/{id}", consumes = "application/json")
    Optional<StorageOutputDto> getStorage(@PathVariable UUID id);
}
