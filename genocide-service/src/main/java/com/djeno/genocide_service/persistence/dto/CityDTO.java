package com.djeno.genocide_service.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CityDTO {
    private int id;
    private String name;
    private CoordinatesDTO coordinates;
    private LocalDateTime creationDate;
    private long area;
    private long population;
    private Double metersAboveSeaLevel;
    private boolean capital;
    private String climate;
    private String standardOfLiving;
    private HumanDTO governor;
}
