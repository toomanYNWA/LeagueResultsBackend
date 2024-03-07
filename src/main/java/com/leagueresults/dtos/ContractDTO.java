package com.leagueresults.dtos;

import com.leagueresults.enums.ContractType;
import com.leagueresults.model.Club;
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
    private Long clubId;

    public ContractDTO() {
    }

    public ContractDTO(Long id, LocalDateTime ending, ContractType contractType, Long playerId, Long clubId) {
        this.id = id;
        this.ending = ending;
        this.contractType = contractType;
        this.playerId = playerId;
        this.clubId = clubId;
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
}
