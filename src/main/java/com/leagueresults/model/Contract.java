package com.leagueresults.model;

import com.leagueresults.enums.ContractType;
import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;
    private Date beginning;
    private Date ending;
    private ContractType contractType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pl_id")
    private Player player;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cl_id")
    private Club club;

    public Contract() {
    }

    public Contract(Long id, Date beginning, Date ending, ContractType contractType) {
        this.id = id;
        this.beginning = beginning;
        this.ending = ending;
        this.contractType = contractType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginning() {
        return beginning;
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
