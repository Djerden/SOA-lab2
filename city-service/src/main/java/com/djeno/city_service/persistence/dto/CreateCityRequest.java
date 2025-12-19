package com.djeno.city_service.persistence.dto;

import com.djeno.city_service.persistence.enums.Climate;
import com.djeno.city_service.persistence.enums.StandardOfLiving;
import com.djeno.city_service.persistence.models.City;
import com.djeno.city_service.persistence.models.Coordinates;
import com.djeno.city_service.persistence.models.Human;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCityRequest(
        @NotBlank @NotNull
        String name,
        @NotNull
        Coordinates coordinates,
        @Min(1)
        long area,
        @Min(1)
        long population,
        Double metersAboveSeaLevel,
        boolean capital,
        Climate climate,
        StandardOfLiving standardOfLiving,
        @NotNull
        Human governor
) {
    public City toCity() {
        City city = new City();
        city.setName(this.name());
        city.setCoordinates(this.coordinates());
        city.setArea(this.area());
        city.setPopulation(this.population());
        city.setMetersAboveSeaLevel(this.metersAboveSeaLevel());
        city.setCapital(this.capital());
        city.setClimate(this.climate());
        city.setStandardOfLiving(this.standardOfLiving());
        city.setGovernor(this.governor());
        return city;
    }
}
