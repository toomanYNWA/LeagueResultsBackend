package com.leagueresults.service;

import com.leagueresults.model.Round;
import com.leagueresults.repository.RoundRepository;
import org.springframework.stereotype.Service;

@Service
public class RoundService {
    private final RoundRepository roundRepository;

    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }
    public Round getRoundByNumber(long number){
        return roundRepository.findByRoundNumber(number);
    }
}
