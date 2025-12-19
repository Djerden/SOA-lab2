package com.djeno.city_service.controllers;

import com.djeno.city_service.persistence.dto.CreateCityRequest;
import com.djeno.city_service.persistence.dto.NumberOfCitiesResponse;
import com.djeno.city_service.persistence.dto.ResponseMessage;
import com.djeno.city_service.persistence.dto.UpdateCityRequest;
import com.djeno.city_service.persistence.enums.Climate;
import com.djeno.city_service.persistence.models.City;
import com.djeno.city_service.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/cities")
@RestController
public class CityController {

    private final CityService cityService;

    //@PostMapping("/filter")

    @PostMapping()
    public ResponseEntity<ResponseMessage> createCity(@RequestBody CreateCityRequest request) {
        cityService.createCity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage("City with name '" + request.name() + "' was created"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable int id) {
        City city = cityService.getCity(id);
        return ResponseEntity.ok().body(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateCity(@PathVariable Integer id, @RequestBody UpdateCityRequest request) {

        cityService.updateCity(id, request);
        return ResponseEntity.ok().body(new ResponseMessage("City with id '" + id + "' was updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteCity(@PathVariable Integer id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok().body(new ResponseMessage("City with id '" + id + "' was deleted"));
    }

    @DeleteMapping("/by-governor")
    public ResponseEntity<ResponseMessage> deleteCityByGovernor(@RequestParam Long age) {
        int countOfCities = cityService.deleteCityByGovernorAge(age);
        return ResponseEntity.ok().body(new ResponseMessage("Cities with governor age '" + age + "' was deleted. Cities deleted: " + countOfCities));
    }

    @GetMapping("/by-min-coordinates")
    public ResponseEntity<City> getCityWithMinCoordinates() {
        City city = cityService.getCityWithMinCoordinates();
        return ResponseEntity.ok().body(city);
    }

    @PostMapping("/count-by-climate")
    public ResponseEntity<NumberOfCitiesResponse> countCitiesByClimate(@RequestParam Climate climate) {
        int count = cityService.countCitiesByClimate(climate);
        return ResponseEntity.ok().body(new NumberOfCitiesResponse(count));
    }
}
