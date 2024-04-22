package com.leagueresults.model;

public class MinutesPerPeriods {
    private int firstPeriod;
    private int secondPeriod;
    private int thirdPeriod;
    private int injuryTime;

    public MinutesPerPeriods() {
    }

    public MinutesPerPeriods(int firstPeriod, int secondPeriod, int thirdPeriod, int injuryTime) {
        this.firstPeriod = firstPeriod;
        this.secondPeriod = secondPeriod;
        this.thirdPeriod = thirdPeriod;
        this.injuryTime = injuryTime;
    }

    public int getFirstPeriod() {
        return firstPeriod;
    }

    public void setFirstPeriod(int firstPeriod) {
        this.firstPeriod = firstPeriod;
    }

    public int getSecondPeriod() {
        return secondPeriod;
    }

    public void setSecondPeriod(int secondPeriod) {
        this.secondPeriod = secondPeriod;
    }

    public int getThirdPeriod() {
        return thirdPeriod;
    }

    public void setThirdPeriod(int thirdPeriod) {
        this.thirdPeriod = thirdPeriod;
    }

    public int getInjuryTime() {
        return injuryTime;
    }

    public void setInjuryTime(int injuryTime) {
        this.injuryTime = injuryTime;
    }
}
