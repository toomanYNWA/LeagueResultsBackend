package com.leagueresults.service;

import com.leagueresults.dtos.ContractDTO;
import com.leagueresults.model.Contract;
import org.springframework.stereotype.Service;

@Service
public class ContractConverterService {
    public ContractDTO entityToDto(Contract contract){
        ContractDTO dto = new ContractDTO();
        dto.setId(contract.getId());
        dto.setClubId(contract.getClub().getId());
        dto.setContractType(contract.getContractType());
        dto.setEnding(contract.getEnding());
        dto.setPlayerId(contract.getPlayer().getId());
        dto.setPlayerName(contract.getPlayer().getFullName());
        dto.setClubName(contract.getClub().getName());

        return dto;
    }
}

