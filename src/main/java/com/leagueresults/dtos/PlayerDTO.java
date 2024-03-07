package com.leagueresults.dtos;

import com.leagueresults.enums.PlayerPosition;

public class PlayerDTO {
    private Long id;
    private String fullName;
    private PlayerPosition playerPosition;
    private Long goals;
    private Long assists;

    public PlayerDTO() {
    }

    public PlayerDTO(Long id, String fullName, PlayerPosition playerPosition, Long goals, Long assists) {
        this.id = id;
        this.fullName = fullName;
        this.playerPosition = playerPosition;
        this.goals = goals;
        this.assists = assists;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Long getGoals() {
        return goals;
    }

    public void setGoals(Long goals) {
        this.goals = goals;
    }

    public Long getAssists() {
        return assists;
    }

    public void setAssists(Long assists) {
        this.assists = assists;
    }
}
