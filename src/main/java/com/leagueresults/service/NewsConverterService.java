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
    public NewsDTO entityToDto(News news){
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(news.getId());
        newsDTO.setHeadline(news.getHeadline());
        newsDTO.setText(news.getText());
        newsDTO.setDate(news.getDate());
        return newsDTO;
    }
}
