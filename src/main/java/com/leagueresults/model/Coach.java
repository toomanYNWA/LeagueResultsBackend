package com.leagueresults.model;

import com.leagueresults.enums.Hierarchy;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Hierarchy coachType;
    @OneToMany
    private List<Coach> assistants;
    @ManyToOne
    @JoinColumn(name = "fk_head_coach_id")
    private Coach headCoach;
    @ManyToOne
    @JoinColumn(name = "fk_club_id")
    private Club club;

    public Coach() {
    }

    public Coach(Long id, String name, String surname, Hierarchy coachType, Club club) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.coachType = coachType;
        this.club = club;
    }

    public Coach(Long id, String name, String surname, Hierarchy coachType, List<Coach> assistants, Coach headCoach, Club club) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.coachType = coachType;
        this.assistants = assistants;
        this.headCoach = headCoach;
        this.club = club;
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

    public Hierarchy getCoachType() {
        return coachType;
    }

    public void setCoachType(Hierarchy coachType) {
        this.coachType = coachType;
    }

    public List<Coach> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<Coach> assistants) {
        this.assistants = assistants;
    }

    public Coach getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(Coach headCoach) {
        this.headCoach = headCoach;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

}
