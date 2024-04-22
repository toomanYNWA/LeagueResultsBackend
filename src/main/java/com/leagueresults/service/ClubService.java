package com.leagueresults.service;

import com.leagueresults.dtos.ClubDTO;
import com.leagueresults.model.Club;
import com.leagueresults.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    private final ClubRepository clubRepository;
    private final ClubConverterService clubConverterService;
    public ClubService(ClubRepository clubRepository, ClubConverterService clubConverterService){ this.clubRepository = clubRepository;
        this.clubConverterService = clubConverterService;
    }

    public Club GetClubByName(String name){
        return this.clubRepository.getClubByName(name);
    }

    public List<ClubDTO> getAllClubs() {
        List<ClubDTO> clubDTOS = new ArrayList<>();
        this.clubRepository.findAllByInFirstLeague(true).forEach(club -> {
            ClubDTO clubDTO = clubConverterService.entityToDto(club);
            clubDTOS.add(clubDTO);
        });
        return clubDTOS;
    }

    public Club getClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).orElse(null);
        if (club != null) {
            return club;
        } else {
            // Handle the case where the club with the given ID is not found
            // You can throw an exception, return a default club, or handle it based on your application's requirements
            return null; // For simplicity, returning null
        }
    }
}
