package com.leagueresults.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roundNumber;
    @ManyToOne
    @JoinColumn(name = "fk_league_id")
    private League league;

    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL)
    private List<Match> matches;

    public Round() {
    }

    public Round(Long roundNumber, League league, List<Match> matches) {
        this.roundNumber = roundNumber;
        this.league = league;
        this.matches = matches;
    }

    public Round(Long id, Long roundNumber, League league) {
        this.id = id;
        this.roundNumber = roundNumber;
        this.league = league;
    }

    public Long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Long roundNumber) {
        this.roundNumber = roundNumber;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
