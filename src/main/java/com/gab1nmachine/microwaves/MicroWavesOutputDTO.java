package com.gab1nmachine.microwaves;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class MicroWavesOutputDTO {
    private long microWaveId;
    private LocalTime startDate;
    private LocalTime endDate;
}
