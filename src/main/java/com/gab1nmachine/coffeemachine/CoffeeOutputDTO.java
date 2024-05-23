package com.gab1nmachine.coffeemachine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CoffeeOutputDTO {
    private UUID id;
    private UUID user_id;
    private UUID timeslot_id;
    private boolean isAvailable;
}
