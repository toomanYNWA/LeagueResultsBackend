package com.leagueresults.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headline;
    private String text;
    private LocalDateTime time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_club_id")
    private Club club;

    public News() {
    }

    public News(Long id, String headline, String text, LocalDateTime time, Club club) {
        this.id = id;
        this.headline = headline;
        this.text = text;
        this.time = time;
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
