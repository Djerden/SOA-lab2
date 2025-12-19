package com.djeno.city_service.persistence.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Embeddable
public class Coordinates {


    //Поле не может быть null
    @NotNull
    private Long x;

    //Максимальное значение поля: 554, Поле не может быть null
    @NotNull
    @Max(554)
    private Double y;
}
