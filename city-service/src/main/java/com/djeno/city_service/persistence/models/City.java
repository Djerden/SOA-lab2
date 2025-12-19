package com.djeno.city_service.persistence.models;

import com.djeno.city_service.persistence.enums.Climate;
import com.djeno.city_service.persistence.enums.StandardOfLiving;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Table(name = "cities")
@Entity
public class City {
    //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Поле не может быть null, Строка не может быть пустой
    @NotNull
    @NotBlank
    private String name;

    //Поле не может быть null
    @NotNull
    @Embedded
    private Coordinates coordinates;

    //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @NotNull
    private LocalDateTime creationDate;

    //Значение поля должно быть больше 0
    @Min(1)
    private long area;

    //Значение поля должно быть больше 0
    @Min(1)
    private long population;

    private Double metersAboveSeaLevel;

    private boolean capital;

    //Поле может быть null
    @Enumerated(EnumType.STRING)
    private Climate climate;

    //Поле может быть null
    @Enumerated(EnumType.STRING)
    private StandardOfLiving standardOfLiving;

    //Поле не может быть null
    @NotNull
    @Embedded
    private Human governor;

    // Вызывается только раз перед сохранением объекта в БД (INSERT)
    @PrePersist
    protected void prePersist() {
        creationDate = LocalDateTime.now();
    }
}
