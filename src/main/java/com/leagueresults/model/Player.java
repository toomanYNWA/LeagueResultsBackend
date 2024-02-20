package com.leagueresults.model;

import com.leagueresults.enums.PlayerPosition;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ply_id")
    private Long id;
    private String name;
    private String surname;
    private PlayerPosition playerPosition;
    private Date dateOfBirth;
    private Long goals;
    private Long assists;
    public Player() {
    }

    public Player(Long id, String name, String surname, PlayerPosition playerPosition, Date dateOfBirth, Long goals, Long assists) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.playerPosition = playerPosition;
        this.dateOfBirth = dateOfBirth;
        this.goals = goals;
        this.assists = assists;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getGoals() {
        return goals;
    }

    public void setGoals(Long goals) {
        this.goals = goals;
    }

    public Long getAssists() {
        return assists;
    }

    public void setAssists(Long assists) {
        this.assists = assists;
    }
}
