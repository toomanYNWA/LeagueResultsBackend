package com.leagueresults.model;

import jakarta.persistence.*;
@Entity
public class ClubRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "club_rank_id")
    private Long id;
    private Long points;
    private Long goalDifference;
    private Long won;
    private Long drawn;
    private Long lost;
    private Long matchesPlayed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_club_id")
    private Club club;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_league_id")
    private League league;

    public ClubRank() {
    }

    public ClubRank(Long id, Long points, Long goalDifference, Long won, Long drawn, Long lost, Club club, League league,Long matchesPlayed) {
        this.id = id;
        this.points = points;
        this.goalDifference = goalDifference;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.club = club;
        this.league = league;
        this.matchesPlayed = matchesPlayed;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Long getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Long matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

}
