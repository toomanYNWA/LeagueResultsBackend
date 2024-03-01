package com.leagueresults.controller;

import com.leagueresults.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping("/uploadData")
    public ResponseEntity<?> uploadPlayersData(@RequestParam("file") MultipartFile file){
        this.playerService.savePlayersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Players data uploaded and saved to database successfully"));
    }
}
