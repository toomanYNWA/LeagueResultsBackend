package com.leagueresults.service;

import com.leagueresults.model.ClubRank;
import com.leagueresults.model.Player;
import com.leagueresults.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final ExcelUploadService excelUploadService;

    public PlayerService(PlayerRepository playerRepository, ExcelUploadService excelUploadService) {
        this.playerRepository = playerRepository;
        this.excelUploadService = excelUploadService;
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
}
