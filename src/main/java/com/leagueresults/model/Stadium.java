package com.leagueresults.model;

import jakarta.persistence.*;

@Entity
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long capacity;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_city_id")
    private City city;

    public Stadium() {
    }

    public Stadium(Long id, Long capacity, String name) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
