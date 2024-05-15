package com.leagueresults.service;

import com.leagueresults.dtos.ClubDTO;
import com.leagueresults.model.Club;
import org.springframework.stereotype.Service;

@Service
public class ClubConverterService {
    public ClubDTO entityToDto(Club club){
        ClubDTO dto = new ClubDTO();
        dto.setId(club.getId());
        dto.setName(club.getName());
        dto.setOwnerName(club.getOwner().getFullName());
        dto.setStadiumName(club.getStadium().getName());
        dto.setYearOfEstablishment(club.getYearOfEstablishment());
        dto.setInFirstLeague(club.getInFirstLeague());
        dto.setStadiumCap(club.getStadium().getCapacity());
        dto.setCityName(club.getStadium().getCity().getName());
        return dto;
    }
}
