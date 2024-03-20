package com.leagueresults.controller;

import com.leagueresults.dtos.ContractDTO;
import com.leagueresults.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("contract")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }
    @PostMapping("/upload-data")
    public ResponseEntity<?> uploadContractsData(@RequestParam("file") MultipartFile file){
        this.contractService.saveContractsToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message","Contracts data uploaded and saved to database successfully"));
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<ContractDTO>> getAllContracts(){
        return new ResponseEntity<>(contractService.getAllContracts(), HttpStatus.OK);
    }
}
