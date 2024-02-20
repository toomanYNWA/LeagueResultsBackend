package com.leagueresults.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;
    private LocalDateTime kickoff;
    @Column(nullable = true)
    private String result;
    @ManyToOne
    @JoinColumn(name = "fk_round_id")
    private Round round;
    @ManyToOne
    @JoinColumn(name = "fk_main_referee_id")
    private MainReferee mainReferee;
    @ManyToOne(cascade = CascadeType.ALL)
    private Competitors competitors;

    public Match() {
    }

    public Match(Long id, LocalDateTime kickoff, String result, Round round, Competitors competitors) {
        this.id = id;
        this.kickoff = kickoff;
        this.result = result;
        this.round = round;
        this.competitors = competitors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getKickoff() {
        return kickoff;
    }

    public void setKickoff(LocalDateTime kickoff) {
        this.kickoff = kickoff;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Competitors getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Competitors competitors) {
        this.competitors = competitors;
    }
}
