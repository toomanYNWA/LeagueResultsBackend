package com.leagueresults.model;

import jakarta.persistence.*;

@Entity
public class Competitors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_home_club_id")
    private Club homeClub;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_away_club_id")
    private Club awayClub;

    public Competitors() {
    }

    public Competitors(Long id, Club homeClub, Club awayClub) {
        this.id = id;
        this.homeClub = homeClub;
        this.awayClub = awayClub;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public Club getAwayClub() {
        return awayClub;
    }

    public void setAwayClub(Club awayClub) {
        this.awayClub = awayClub;
    }
}
