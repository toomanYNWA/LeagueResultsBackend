package com.leagueresults.service;

import com.leagueresults.model.ClubRank;
import com.leagueresults.model.Match;
import com.leagueresults.repository.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final ExcelUploadService excelUploadService;

    public MatchService(MatchRepository matchRepository, ExcelUploadService excelUploadService) {
        this.matchRepository = matchRepository;
        this.excelUploadService = excelUploadService;
    }

    public void saveMatchesToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Match> matches = excelUploadService.getMatchesDataFromExcel(file.getInputStream());
                this.matchRepository.saveAll(matches);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }
}
