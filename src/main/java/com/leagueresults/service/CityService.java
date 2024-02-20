package com.leagueresults.service;

import com.leagueresults.model.City;
import com.leagueresults.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll(){
        return this.cityRepository.findAll();
    }
}
