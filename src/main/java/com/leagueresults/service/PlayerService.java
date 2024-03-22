package com.leagueresults.service;

import com.leagueresults.CustomExceptions.PlayerNotFoundException;
import com.leagueresults.dtos.ContractDTO;
import com.leagueresults.dtos.PlayerDTO;
import com.leagueresults.model.Contract;
import com.leagueresults.model.Player;
import com.leagueresults.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.io.IOException;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final ExcelUploadService excelUploadService;
    private final PlayerConverterService playerConverterService;
    private final ContractService contractService;

    public PlayerService(PlayerRepository playerRepository, ExcelUploadService excelUploadService, PlayerConverterService playerConverterService, ContractService contractService) {
        this.playerRepository = playerRepository;
        this.excelUploadService = excelUploadService;
        this.playerConverterService = playerConverterService;
        this.contractService = contractService;
    }
    public void savePlayersToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Player> players = excelUploadService.getPlayersDataFromExcel(file.getInputStream());
                this.playerRepository.saveAll(players);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public Player getPlayerByName(String stringCellValue) {
        return this.playerRepository.findByFullName(stringCellValue);
    }

    public List<PlayerDTO> getAllPlayers() {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        this.playerRepository.findAll().forEach(player -> {
            PlayerDTO playerDTO = playerConverterService.entityToDto(player);
            playerDTOS.add(playerDTO);
        });
        return playerDTOS;
    }

    public List<PlayerDTO> getPlayersByClubId(Long id) {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        List<ContractDTO> contracts = this.contractService.getContractsByClubId(id);
        contracts.forEach(contract -> {
            Optional<Player> playerOptional = this.playerRepository.findById(contract.getPlayerId());
            if (playerOptional.isPresent()) {
                PlayerDTO playerDTO = playerConverterService.entityToDto(playerOptional.get());
                playerDTOS.add(playerDTO);
            } else {
                throw new PlayerNotFoundException("Player not found for contract ID: " + contract.getId());
            }
        });
        return playerDTOS;
    }
    public List<PlayerDTO> getPlayersByGoals() {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        this.playerRepository.findAllByGoalsNot(0).forEach(player -> {
            PlayerDTO playerDTO = playerConverterService.entityToDto(player);
            playerDTOS.add(playerDTO);
        });
        Collections.sort(playerDTOS,Comparator.comparingLong(PlayerDTO::getGoals).reversed());
        return playerDTOS;
    }

    public List<PlayerDTO> getPlayersByAssists() {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        this.playerRepository.findAllByAssistsNot(0).forEach(player -> {
            PlayerDTO playerDTO = playerConverterService.entityToDto(player);
            playerDTOS.add(playerDTO);
        });
        Collections.sort(playerDTOS,Comparator.comparingLong(PlayerDTO::getAssists).reversed());
        return playerDTOS;
    }

}
