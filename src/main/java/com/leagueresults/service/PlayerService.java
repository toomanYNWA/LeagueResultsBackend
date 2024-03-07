package com.leagueresults.service;

import com.leagueresults.dtos.PlayerDTO;
import com.leagueresults.model.Player;
import com.leagueresults.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final ExcelUploadService excelUploadService;
    private final PlayerConverterService playerConverterService;

    public PlayerService(PlayerRepository playerRepository, ExcelUploadService excelUploadService, PlayerConverterService playerConverterService) {
        this.playerRepository = playerRepository;
        this.excelUploadService = excelUploadService;
        this.playerConverterService = playerConverterService;
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
}
