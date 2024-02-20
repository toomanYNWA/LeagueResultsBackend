package com.leagueresults.model;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;
    private String name;
    private Long yearOfEstablishment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_st_id")
    private Stadium stadium;
    private Boolean inFirstLeague;

    public Club() {
    }

    public Club(Long id, String name, Long yearOfEstablishment, Stadium stadium, Boolean inFirstLeague) {
        this.id = id;
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
        this.stadium = stadium;
        this.inFirstLeague = inFirstLeague;
    }

    public Boolean getInFirstLeague() {
        return inFirstLeague;
    }

    public void setInFirstLeague(Boolean inFirstLeague) {
        this.inFirstLeague = inFirstLeague;
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

    public Long getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(Long yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
