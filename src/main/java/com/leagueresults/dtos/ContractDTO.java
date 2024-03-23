package com.leagueresults.dtos;

import com.leagueresults.enums.ContractType;
import com.leagueresults.model.Club;
import com.leagueresults.model.Contract;
import com.leagueresults.model.Player;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class ContractDTO {
    private Long id;
    private LocalDateTime ending;
    private ContractType contractType;
    private Long playerId;
    private String playerName;
    private Long clubId;
    private String clubName;

    public ContractDTO() {
    }

    public ContractDTO(String playerName,String clubName,Long id, LocalDateTime ending, ContractType contractType, Long playerId, Long clubId) {
        this.id = id;
        this.ending = ending;
        this.contractType = contractType;
        this.playerId = playerId;
        this.clubId = clubId;
        this.clubName = clubName;
        this.playerName = playerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getEnding() {
        return ending;
    }

    public void setEnding(LocalDateTime ending) {
        this.ending = ending;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public static ContractDTO fromContract(Contract contract) {
        ContractDTO dto = new ContractDTO();
        dto.setPlayerId(contract.getPlayer().getId());
        dto.setId(contract.getId());
        dto.setEnding(contract.getEnding());
        dto.setContractType(contract.getContractType());
        dto.setClubName(contract.getClub().getName());
        dto.setPlayerName(contract.getPlayer().getFullName());
        dto.setClubId(contract.getClub().getId());

        return dto;
    }
}
