package com.leagueresults.dtos;

import java.util.List;

public class StatsDTO {
        private Long id;
        private Long shotsHost;
        private Long onTargetHost;
        private Long shotsGuest;
        private Long onTargetGuest;
        private Double possessionHost;
        private Double possessionGuest;
        private List<Long> hostMinutes;
        private List<Long> guestMinutes;
        private Long matchId;

    public StatsDTO() {
    }

    public StatsDTO(Long id, Long shotsHost, Long onTargetHost, Long shotsGuest, Long onTargetGuest, Double possessionHost, Double possessionGuest, List<Long> hostMinutes, List<Long> guestMinutes, Long matchId) {
        this.id = id;
        this.shotsHost = shotsHost;
        this.onTargetHost = onTargetHost;
        this.shotsGuest = shotsGuest;
        this.onTargetGuest = onTargetGuest;
        this.possessionHost = possessionHost;
        this.possessionGuest = possessionGuest;
        this.hostMinutes = hostMinutes;
        this.guestMinutes = guestMinutes;
        this.matchId = matchId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShotsHost() {
        return shotsHost;
    }

    public void setShotsHost(Long shotsHost) {
        this.shotsHost = shotsHost;
    }

    public Long getOnTargetHost() {
        return onTargetHost;
    }

    public void setOnTargetHost(Long onTargetHost) {
        this.onTargetHost = onTargetHost;
    }

    public Long getShotsGuest() {
        return shotsGuest;
    }

    public void setShotsGuest(Long shotsGuest) {
        this.shotsGuest = shotsGuest;
    }

    public Long getOnTargetGuest() {
        return onTargetGuest;
    }

    public void setOnTargetGuest(Long onTargetGuest) {
        this.onTargetGuest = onTargetGuest;
    }

    public Double getPossessionHost() {
        return possessionHost;
    }

    public void setPossessionHost(Double possessionHost) {
        this.possessionHost = possessionHost;
    }

    public Double getPossessionGuest() {
        return possessionGuest;
    }

    public void setPossessionGuest(Double possessionGuest) {
        this.possessionGuest = possessionGuest;
    }

    public List<Long> getHostMinutes() {
        return hostMinutes;
    }

    public void setHostMinutes(List<Long> hostMinutes) {
        this.hostMinutes = hostMinutes;
    }

    public List<Long> getGuestMinutes() {
        return guestMinutes;
    }

    public void setGuestMinutes(List<Long> guestMinutes) {
        this.guestMinutes = guestMinutes;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
}
