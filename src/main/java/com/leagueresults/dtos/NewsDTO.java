package com.leagueresults.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewsDTO {
    private String headline;
    private String text;
    private LocalDate date;

    public NewsDTO() {
    }

    public NewsDTO(String headline, String text, LocalDate date) {
        this.headline = headline;
        this.text = text;
        this.date = date;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
