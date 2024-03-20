package com.leagueresults.dtos;

import java.time.LocalDateTime;

public class MatchDTO {
    private Long id;
    private LocalDateTime kickoff;
    private String result;
    private Long roundId;
    private Long roundNumber;
    private Long mainRefereeId;
    private String refereeName;
    private String refereeSurname;
    private Long hostId;
    private String hostName;
    private Long guestId;
    private String guestName;
    public MatchDTO() {
    }

    public MatchDTO(Long id, LocalDateTime kickoff, String result, Long roundId, Long roundNumber, Long mainRefereeId, String refereeName, String refereeSurname, Long hostId, String hostName, Long guestId, String guestName) {
        this.id = id;
        this.kickoff = kickoff;
        this.result = result;
        this.roundId = roundId;
        this.roundNumber = roundNumber;
        this.mainRefereeId = mainRefereeId;
        this.refereeName = refereeName;
        this.refereeSurname = refereeSurname;
        this.hostId = hostId;
        this.hostName = hostName;
        this.guestId = guestId;
        this.guestName = guestName;
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

    public Long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Long roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRefereeSurname() {
        return refereeSurname;
    }

    public void setRefereeSurname(String refereeSurname) {
        this.refereeSurname = refereeSurname;
    }
}
