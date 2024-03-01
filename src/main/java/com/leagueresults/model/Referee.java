package com.leagueresults.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//za svaku klasu koja nasledi ovu, napravi tabelu!
@MappedSuperclass
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<League> leagues;

    public Referee() {
    }

    public Referee(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Referee(String name, String surname, List<League> leagues) {
        this.name = name;
        this.surname = surname;
        this.leagues = leagues;
    }

    public Referee(Long id, String name, String surname, List<League> leagues) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.leagues = leagues;
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

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }
}
