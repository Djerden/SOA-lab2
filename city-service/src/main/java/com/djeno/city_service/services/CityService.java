package com.djeno.city_service.services;

import com.djeno.city_service.exceptions.CityNotFoundException;
import com.djeno.city_service.persistence.dto.CreateCityRequest;
import com.djeno.city_service.persistence.dto.UpdateCityRequest;
import com.djeno.city_service.persistence.enums.Climate;
import com.djeno.city_service.persistence.models.City;
import com.djeno.city_service.persistence.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;

    @Transactional
    public void createCity(CreateCityRequest request) {
        City city = request.toCity();
        cityRepository.save(city);
    }

    public City getCity(int id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City with id '" + id + "' not found"));
    }

    @Transactional
    public void updateCity(int id, UpdateCityRequest request) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City with id '" + id + "' not found"));

        request.applyTo(city); // провалидировать и переписать на более лаконичный код
        cityRepository.save(city);
    }

    @Transactional
    public void deleteCity(int id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City with id '" + id + "' not found"));
        cityRepository.delete(city);
    }

    public int deleteCityByGovernorAge(long age) {
        return cityRepository.deleteByGovernorAge(age);
    }

    public City getCityWithMinCoordinates() {
        return cityRepository.findFirstByOrderByCoordinates_XAscCoordinates_YAsc()
                .orElseThrow(() -> new CityNotFoundException("City with min coordinates not found"));
    }

    public int countCitiesByClimate(Climate climate) {
        return cityRepository.countByClimate(climate);
    }
}
