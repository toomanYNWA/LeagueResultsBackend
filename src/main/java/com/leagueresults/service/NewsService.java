package com.leagueresults.service;

import com.leagueresults.dtos.NewsDTO;
import com.leagueresults.model.News;
import com.leagueresults.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;


@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final NewsConverterService newsConverterService;
    public NewsService(NewsRepository newsRepository, NewsConverterService newsConverterService) {
        this.newsRepository = newsRepository;
        this.newsConverterService = newsConverterService;
    }

    public void saveNews(NewsDTO newsDTO) {
        News news = this.newsConverterService.dtoToEntity(newsDTO);
        this.newsRepository.save(news);
    }

    public List<NewsDTO> getAll() {
        List<News> news = this.newsRepository.findAll();
        List<NewsDTO> newsDTOS = new ArrayList<>();
        news.forEach(news1 -> {
            newsDTOS.add(newsConverterService.entityToDto(news1));
        });
        return newsDTOS;
    }
}
