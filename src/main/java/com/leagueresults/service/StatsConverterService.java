package com.leagueresults.service;

import com.leagueresults.dtos.StatsDTO;
import com.leagueresults.model.Statistics;
import org.springframework.stereotype.Service;

@Service
public class StatsConverterService {
    public StatsDTO entityToDto(Statistics statistics){
        StatsDTO dto = new StatsDTO();
        dto.setId(statistics.getId());
        dto.setGuestMinutes(statistics.getGuestMinutes());
        dto.setHostMinutes(statistics.getHostMinutes());
        dto.setMatchId(statistics.getMatch().getId());
        dto.setShotsHost(statistics.getShotsHost());
        dto.setShotsGuest(statistics.getShotsGuest());
        dto.setOnTargetGuest(statistics.getOnTargetGuest());
        dto.setOnTargetHost(statistics.getOnTargetHost());
        dto.setPossessionGuest(statistics.getPossessionGuest());
        dto.setPossessionHost(statistics.getPossessionHost());
        return dto;
    }
}
