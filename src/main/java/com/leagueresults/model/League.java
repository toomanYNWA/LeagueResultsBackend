package com.leagueresults.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "league_id")
    private Long id;
    private String name;
    private String season;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Round> rounds = new ArrayList<>(38);

    @OneToMany(mappedBy = "league" ,cascade = CascadeType.ALL)
    private List<ClubRank> clubRankings;

    public League() {
    }

    public League(Long id, String name, String season) {
        this.id = id;
        this.name = name;
        this.season = season;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
