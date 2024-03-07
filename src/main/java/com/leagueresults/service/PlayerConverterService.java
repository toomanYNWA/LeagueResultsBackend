package com.leagueresults.service;

import com.leagueresults.dtos.PlayerDTO;
import com.leagueresults.model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerConverterService {
    public PlayerDTO entityToDto(Player player){
        PlayerDTO dto = new PlayerDTO();
        dto.setFullName(player.getFullName());
        dto.setPlayerPosition(player.getPlayerPosition());
        dto.setId(player.getId());
        dto.setAssists(player.getAssists());
        dto.setGoals(player.getGoals());
        return dto;
    }
}
