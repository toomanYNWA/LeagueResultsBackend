package com.leagueresults.dtos;

import com.leagueresults.model.Club;
import com.leagueresults.model.League;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ClubRankDTO {
    private Long id;
    private Long points;
    private Long goalDifference;
    private Long won;
    private Long drawn;
    private Long lost;
    private Long matchesPlayed;
    private Long clubId;
    private Long leagueId;

    public ClubRankDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Long getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Long goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Long getWon() {
        return won;
    }

    public void setWon(Long won) {
        this.won = won;
    }

    public Long getDrawn() {
        return drawn;
    }

    public void setDrawn(Long drawn) {
        this.drawn = drawn;
    }

    public Long getLost() {
        return lost;
    }

    public void setLost(Long lost) {
        this.lost = lost;
    }

    public Long getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Long matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public ClubRankDTO(Long id, Long points, Long goalDifference, Long won, Long drawn, Long lost, Long matchesPlayed, Long clubId, Long leagueId) {
        this.id = id;
        this.points = points;
        this.goalDifference = goalDifference;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.matchesPlayed = matchesPlayed;
        this.clubId = clubId;
        this.leagueId = leagueId;
    }
}
