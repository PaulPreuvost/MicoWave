package com.gab1machine.fridge;

import java.util.Date;
import java.util.UUID;

public record StorageOutputDto(UUID id, Date date, int size) {
}
