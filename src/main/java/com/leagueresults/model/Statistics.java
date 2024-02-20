package com.leagueresults.model;

import jakarta.persistence.*;

@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long shots;
    private Double possession;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_match_id")
    private Match match;

    public Statistics() {
    }

    public Statistics(Long id, Long shots, Double possession, Match match) {
        this.id = id;
        this.shots = shots;
        this.possession = possession;
        this.match = match;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShots() {
        return shots;
    }

    public void setShots(Long shots) {
        this.shots = shots;
    }

    public Double getPossession() {
        return possession;
    }

    public void setPossession(Double possession) {
        this.possession = possession;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
