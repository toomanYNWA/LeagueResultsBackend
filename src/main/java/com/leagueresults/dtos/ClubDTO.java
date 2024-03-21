package com.leagueresults.dtos;

public class ClubDTO {
    private Long id;
    private String name;
    private Long yearOfEstablishment;
    private Boolean inFirstLeague;
    private String stadiumName;
    private String ownerName;

    public ClubDTO() {
    }

    public ClubDTO(Long id, String name, Long yearOfEstablishment, Boolean inFirstLeague, String stadiumName, String ownerName) {
        this.id = id;
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
        this.inFirstLeague = inFirstLeague;
        this.stadiumName = stadiumName;
        this.ownerName = ownerName;
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

    public Long getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(Long yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public Boolean getInFirstLeague() {
        return inFirstLeague;
    }

    public void setInFirstLeague(Boolean inFirstLeague) {
        this.inFirstLeague = inFirstLeague;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
