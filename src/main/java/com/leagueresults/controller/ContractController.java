package com.leagueresults.controller;

import com.leagueresults.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("contract")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }
    @PostMapping("/uploadData")
    public ResponseEntity<?> uploadContractsData(@RequestParam("file") MultipartFile file){
        this.contractService.saveContractsToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Contracts data uploaded and saved to database successfully"));
    }
}
