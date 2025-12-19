package com.djeno.city_service.persistence.dto;

import com.djeno.city_service.persistence.enums.Climate;
import com.djeno.city_service.persistence.enums.StandardOfLiving;
import com.djeno.city_service.persistence.models.City;
import com.djeno.city_service.persistence.models.Coordinates;
import com.djeno.city_service.persistence.models.Human;

public record UpdateCityRequest(
        String name,
        Coordinates coordinates,
        Long area,
        Long population,
        Double metersAboveSeaLevel,
        Boolean capital,
        Climate climate,
        StandardOfLiving standardOfLiving,
        Human governor
) {
    public void applyTo(City city) {
        if (this.name != null) city.setName(this.name);
        if (this.coordinates != null) city.setCoordinates(this.coordinates);
        if (this.area != null) city.setArea(this.area);
        if (this.population != null) city.setPopulation(this.population);
        if (this.metersAboveSeaLevel != null) city.setMetersAboveSeaLevel(this.metersAboveSeaLevel);
        if (this.capital != null) city.setCapital(this.capital);
        if (this.climate != null) city.setClimate(this.climate);
        if (this.standardOfLiving != null) city.setStandardOfLiving(this.standardOfLiving);
        if (this.governor != null) city.setGovernor(this.governor);
    }
}
