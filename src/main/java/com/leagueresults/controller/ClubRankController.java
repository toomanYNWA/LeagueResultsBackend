package com.leagueresults.controller;

import com.leagueresults.model.ClubRank;
import com.leagueresults.service.ClubRankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("clubRank")
public class ClubRankController {
    private final ClubRankService clubRankService;

    public ClubRankController(ClubRankService clubRankService) {
        this.clubRankService = clubRankService;
    }

    @PostMapping("/uploadData")
    public ResponseEntity<?> uploadClubRanksData(@RequestParam("file")MultipartFile file){
        this.clubRankService.saveClubRanksToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Club ranks data uploaded and saved to database successfully"));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ClubRank>> getAll(){
        return new ResponseEntity<>(clubRankService.getAllClubRanks(), HttpStatus.FOUND) ;
    }
}
