package com.leagueresults.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Linesman extends Referee {
    @ManyToMany
    private List<Match> matches;

    public Linesman() {
    }

    public Linesman(List<Match> matches) {
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
