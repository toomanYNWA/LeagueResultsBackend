package com.leagueresults.controller;

import com.leagueresults.service.MatchService;
import com.leagueresults.service.RoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("match")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    @PostMapping("/uploadData")
    public ResponseEntity<?> uploadMatchesData(@RequestParam("file") MultipartFile file){
        this.matchService.saveMatchesToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Matches data uploaded and saved to database successfully"));
    }
}
