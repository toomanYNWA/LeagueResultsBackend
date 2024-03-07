package com.leagueresults.service;

import com.leagueresults.dtos.ClubRankDTO;
import com.leagueresults.model.ClubRank;
import org.springframework.stereotype.Service;

@Service
public class ClubRankConverterService {
    public ClubRankDTO entityToDto(ClubRank clubRank){
        ClubRankDTO dto = new ClubRankDTO();
        dto.setId(clubRank.getId());
        dto.setClubId(clubRank.getClub().getId());
        dto.setDrawn(clubRank.getDrawn());
        dto.setLost(clubRank.getLost());
        dto.setWon(clubRank.getWon());
        dto.setPoints(clubRank.getPoints());
        dto.setGoalDifference(clubRank.getGoalDifference());
        dto.setLeagueId(clubRank.getLeague().getId());
        dto.setMatchesPlayed(clubRank.getMatchesPlayed());
        return dto;
    }
}
