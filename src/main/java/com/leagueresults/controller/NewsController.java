package com.leagueresults.controller;

import com.leagueresults.dtos.NewsDTO;
import com.leagueresults.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNews(@RequestBody NewsDTO newsDTO) {
        try {
            this.newsService.saveNews(newsDTO);
            return new ResponseEntity<>("News created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating news: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
