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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_main_referee_id")
    private MainReferee mainReferee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_host_id")
    private Club host;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_guest_id")
    private Club guest;

    public Match() {
    }

    public Match(Long id, LocalDateTime kickoff, String result, Round round, MainReferee mainReferee, Club host, Club guest) {
        this.id = id;
        this.kickoff = kickoff;
        this.result = result;
        this.round = round;
        this.mainReferee = mainReferee;
        this.host = host;
        this.guest = guest;
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

    public MainReferee getMainReferee() {
        return mainReferee;
    }

    public void setMainReferee(MainReferee mainReferee) {
        this.mainReferee = mainReferee;
    }

    public Club getHost() {
        return host;
    }

    public void setHost(Club host) {
        this.host = host;
    }

    public Club getGuest() {
        return guest;
    }

    public void setGuest(Club guest) {
        this.guest = guest;
    }
}
