package com.leagueresults.controller;

import com.leagueresults.dtos.NewsDTO;
import com.leagueresults.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping("get-all")
    public ResponseEntity<List<NewsDTO>> getAllNews(){
        return new ResponseEntity<>(newsService.getAll(),HttpStatus.OK);
    }
}
