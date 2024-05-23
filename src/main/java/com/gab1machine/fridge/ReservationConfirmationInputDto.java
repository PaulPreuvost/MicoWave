package com.gab1machine.fridge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
public class ReservationConfirmationInputDto {

    private final int index;
    private final int size;

    @JsonCreator
    public ReservationConfirmationInputDto(@JsonProperty("index") int index, @JsonProperty("size") int size) {
        this.index = index;
        this.size = size;
    }

    public static List<ReservationConfirmationInputDto> fromJsonList(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, ReservationConfirmationInputDto.class));
    }

}
