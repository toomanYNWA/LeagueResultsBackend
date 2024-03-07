package com.leagueresults.controller;

import com.leagueresults.dtos.ClubRankDTO;
import com.leagueresults.model.ClubRank;
import com.leagueresults.service.ClubRankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("club-rank")
public class ClubRankController {
    private final ClubRankService clubRankService;

    public ClubRankController(ClubRankService clubRankService) {
        this.clubRankService = clubRankService;
    }
    @PostMapping("/upload-data")
    public ResponseEntity<?> uploadClubRanksData(@RequestParam("file")MultipartFile file){
        this.clubRankService.saveClubRanksToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Club ranks data uploaded and saved to database successfully"));
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<ClubRankDTO>> getAll(){
        return new ResponseEntity<>(clubRankService.getAllClubRanks(), HttpStatus.FOUND) ;
    }
}
