package com.leagueresults.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//za svaku klasu koja nasledi ovu, napravi tabelu!
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String surname;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<League> leagues;

}
