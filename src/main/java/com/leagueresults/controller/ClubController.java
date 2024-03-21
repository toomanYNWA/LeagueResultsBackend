package com.leagueresults.controller;

import com.leagueresults.dtos.ClubDTO;
import com.leagueresults.dtos.PlayerDTO;
import com.leagueresults.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("club")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }
    @GetMapping("/get-all-in-league")
    public ResponseEntity<List<ClubDTO>> getAll(){
        return new ResponseEntity<>(clubService.getAllClubs(), HttpStatus.OK) ;
    }
}
