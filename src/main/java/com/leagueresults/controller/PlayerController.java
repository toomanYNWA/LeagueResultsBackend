package com.leagueresults.controller;

import com.leagueresults.dtos.PlayerDTO;
import com.leagueresults.model.ClubRank;
import com.leagueresults.model.Player;
import com.leagueresults.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping("/upload-data")
    public ResponseEntity<?> uploadPlayersData(@RequestParam("file") MultipartFile file){
        this.playerService.savePlayersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Players data uploaded and saved to database successfully"));
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<PlayerDTO>> getAll(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK) ;
    }
}
