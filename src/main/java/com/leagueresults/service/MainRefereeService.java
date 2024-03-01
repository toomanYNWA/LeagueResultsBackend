package com.leagueresults.service;

import com.leagueresults.model.MainReferee;
import com.leagueresults.repository.MainRefereeRepository;
import org.springframework.stereotype.Service;

@Service
public class MainRefereeService {
    private final MainRefereeRepository mainRefereeRepository;

    public MainRefereeService(MainRefereeRepository mainRefereeRepository) {
        this.mainRefereeRepository = mainRefereeRepository;
    }

    public MainReferee getMainRefereeById(long numericCellValue) {
        return this.mainRefereeRepository.getReferenceById(numericCellValue);
    }
}
