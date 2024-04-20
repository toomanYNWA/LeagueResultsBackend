package com.leagueresults.service;

import com.leagueresults.dtos.StatsDTO;
import com.leagueresults.model.Match;
import com.leagueresults.model.Statistics;
import com.leagueresults.repository.StatisticsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StatisticsService {
    private final ExcelUploadService excelUploadService;
    private final StatisticsRepository statsRepositoty;
    private final StatsConverterService statsConverterService;
    private final MatchService matchService;
    public StatisticsService(ExcelUploadService excelUploadService, StatisticsRepository statsRepositoty, StatsConverterService statsConverterService, MatchService matchService) {
        this.excelUploadService = excelUploadService;
        this.statsRepositoty = statsRepositoty;
        this.statsConverterService = statsConverterService;
        this.matchService = matchService;
    }

    public void saveStatsToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Statistics> stats = excelUploadService.getStatsDataFromExcel(file.getInputStream());
                this.statsRepositoty.saveAll(stats);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public StatsDTO getStatByMatchId(Long matchId) {
        Match match = matchService.findMatchById(matchId);
        StatsDTO statsDTO = statsConverterService.entityToDto(statsRepositoty.findByMatch(match));
        return statsDTO;
    }
}
