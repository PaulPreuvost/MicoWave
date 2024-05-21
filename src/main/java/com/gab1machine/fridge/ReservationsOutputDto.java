package com.gab1machine.fridge;

import java.util.Date;
import java.util.UUID;

public record ReservationsOutputDto(UUID id, Date date, int size, UUID storage) {
}
