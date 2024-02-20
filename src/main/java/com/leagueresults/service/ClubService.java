package com.leagueresults.service;

import com.leagueresults.model.Club;
import com.leagueresults.repository.CityRepository;
import com.leagueresults.repository.ClubRepository;
import org.springframework.stereotype.Service;

@Service
public class ClubService {
    private final ClubRepository clubRepository;
    public ClubService(ClubRepository clubRepository){ this.clubRepository = clubRepository; }

    public Club GetClubByName(String name){
        return this.clubRepository.getClubByName(name);
    }
}
