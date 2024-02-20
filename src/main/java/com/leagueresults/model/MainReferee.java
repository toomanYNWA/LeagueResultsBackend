package com.leagueresults.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class MainReferee extends Referee{
    @OneToMany(mappedBy = "mainReferee",cascade = CascadeType.ALL)
    private List<Match> matches;

    public MainReferee() {
    }

    public MainReferee(List<Match> matches) {
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
