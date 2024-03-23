package com.leagueresults.controller;

import com.leagueresults.dtos.PlayerDTO;
import com.leagueresults.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<?> uploadPlayersData(@RequestParam("file") MultipartFile file) {
        this.playerService.savePlayersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message", "Players data uploaded and saved to database successfully"));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PlayerDTO>> getAll() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/get-player-by-club/{id}")
    public ResponseEntity<List<PlayerDTO>> getPlayerByClubId(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.getPlayersByClubId(id), HttpStatus.OK);
    }

    @GetMapping("/players-goals")
    public ResponseEntity<List<PlayerDTO>> getPlayerByGoals() {
        return new ResponseEntity<>(playerService.getPlayersByGoals(), HttpStatus.OK);
    }
    @GetMapping("/players-assists")
    public ResponseEntity<List<PlayerDTO>> getPlayerByAssists() {
        return new ResponseEntity<>(playerService.getPlayersByAssists(), HttpStatus.OK);
    }
    @GetMapping("/get-all-page/{pageNumber}")
    public ResponseEntity<Page<PlayerDTO>> getAll(
            @RequestParam(defaultValue = "10") int pageSize,
            @PathVariable int pageNumber) {

        Page<PlayerDTO> playersPage = playerService.getAllPlayersPage(PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok(playersPage);
    }
}