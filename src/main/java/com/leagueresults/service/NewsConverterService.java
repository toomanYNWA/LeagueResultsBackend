package com.leagueresults.service;

import com.leagueresults.dtos.NewsDTO;
import com.leagueresults.model.News;
import org.springframework.stereotype.Service;

@Service
public class NewsConverterService {
    public News dtoToEntity(NewsDTO dto){
        News news = new News();
        news.setHeadline(dto.getHeadline());
        news.setDate(dto.getDate());
        news.setText(dto.getText());
        return news;
    }
}
