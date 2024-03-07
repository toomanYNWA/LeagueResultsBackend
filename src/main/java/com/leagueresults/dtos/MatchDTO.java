package com.leagueresults.dtos;

import java.time.LocalDateTime;

public class MatchDTO {
    private Long id;
    private LocalDateTime kickoff;
    private String result;
    private Long roundId;
    private Long mainRefereeId;
    private Long hostId;
    private Long guestId;

    public MatchDTO() {
    }

    public MatchDTO(Long id, LocalDateTime kickoff, String result, Long roundId, Long mainRefereeId, Long hostId, Long guestId) {
        this.id = id;
        this.kickoff = kickoff;
        this.result = result;
        this.roundId = roundId;
        this.mainRefereeId = mainRefereeId;
        this.hostId = hostId;
        this.guestId = guestId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getKickoff() {
        return kickoff;
    }

    public void setKickoff(LocalDateTime kickoff) {
        this.kickoff = kickoff;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public Long getMainRefereeId() {
        return mainRefereeId;
    }

    public void setMainRefereeId(Long mainRefereeId) {
        this.mainRefereeId = mainRefereeId;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }
}
