package com.leagueresults.controller;

import com.leagueresults.dtos.StatsDTO;
import com.leagueresults.model.MinutesPerPeriods;
import com.leagueresults.service.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("stats")
public class StatisticsController {
    private final StatisticsService statsService;

    public StatisticsController(StatisticsService statsService) {
        this.statsService = statsService;
    }

    @PostMapping("/upload-data")
    public ResponseEntity<?> uploadMatchesData(@RequestParam("file") MultipartFile file){
        this.statsService.saveStatsToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Stats data uploaded and saved to database successfully"));
    }
    @GetMapping("/get-by-match-id/{matchId}")
    private ResponseEntity<StatsDTO> getStatByMatchId (@PathVariable Long matchId){
        return new ResponseEntity<>(this.statsService.getStatByMatchId(matchId), HttpStatus.OK);
    }
    @GetMapping("/period-goals-by-club-id/{clubId}")
    private ResponseEntity<MinutesPerPeriods> getMPPByClubId(@PathVariable Long clubId){
        return new ResponseEntity<>(this.statsService.getMPPByClubId(clubId), HttpStatus.OK);
    }
}
