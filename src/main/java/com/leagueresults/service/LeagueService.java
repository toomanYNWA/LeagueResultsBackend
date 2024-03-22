package com.leagueresults.service;

import com.leagueresults.model.League;
import com.leagueresults.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public League getLeagueBySeason(String stringCellValue) {
        return this.leagueRepository.findOneBySeason(stringCellValue);
    }
    public Optional<League> getLeagueById(Long id){
        return this.leagueRepository.findById(id);
    }
}
