package com.djeno.city_service.persistence.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Embeddable
public class Human {

    //Значение поля должно быть больше 0
    @Min(1)
    private long age;
}
