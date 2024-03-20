package com.leagueresults.controller;

import com.leagueresults.dtos.MatchDTO;
import com.leagueresults.model.Match;
import com.leagueresults.service.MatchService;
import com.leagueresults.service.RoundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("match")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    @PostMapping("/upload-data")
    public ResponseEntity<?> uploadMatchesData(@RequestParam("file") MultipartFile file){
        this.matchService.saveMatchesToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Matches data uploaded and saved to database successfully"));
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<MatchDTO>> getAll(){
        return new ResponseEntity<>(matchService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/get-results")
    public ResponseEntity<List<MatchDTO>> getResults(){
        return new ResponseEntity<>(matchService.getResults(), HttpStatus.OK);
    }
    @GetMapping("/get-fixtures")
    public ResponseEntity<List<MatchDTO>> getFixtures(){
        return new ResponseEntity<>(matchService.getFixtures(), HttpStatus.OK);
    }
}
