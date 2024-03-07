package com.leagueresults.service;

import com.leagueresults.dtos.MatchDTO;
import com.leagueresults.model.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchConverterService {
    public MatchDTO entityToDto(Match match){
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setKickoff(match.getKickoff());
        dto.setResult(match.getResult());
        dto.setRoundId(match.getRound().getId());
        dto.setMainRefereeId(match.getMainReferee().getId());
        dto.setHostId(match.getHost().getId());
        dto.setGuestId(match.getGuest().getId());

        return dto;
    }
}
