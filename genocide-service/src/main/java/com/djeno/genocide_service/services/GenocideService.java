package com.djeno.genocide_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class GenocideService {

    private final RestTemplate restTemplate;
    @Value("city-service.base-url")
    private final String baseUrl;

    public void killPopulationOfCity(int id) {

    }

    public void movePopulationToPoorestCity(int id) {

    }
}
