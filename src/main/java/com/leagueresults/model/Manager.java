package com.leagueresults.model;

import com.leagueresults.enums.Hierarchy;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Hierarchy managerType;
    @OneToMany
    private List<Manager> assistants;
    @ManyToOne
    private Manager headManager;
    @ManyToOne
    @JoinColumn(name = "fk_club_id")
    private Club club;

    public Manager() {
    }

    public Manager(Long id, String name, String surname, Hierarchy managerType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.managerType = managerType;
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

    public Hierarchy getManagerType() {
        return managerType;
    }

    public void setManagerType(Hierarchy managerType) {
        this.managerType = managerType;
    }
}
