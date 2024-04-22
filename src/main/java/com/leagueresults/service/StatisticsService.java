package com.leagueresults.service;

import com.leagueresults.dtos.StatsDTO;
import com.leagueresults.model.Club;
import com.leagueresults.model.Match;
import com.leagueresults.model.MinutesPerPeriods;
import com.leagueresults.model.Statistics;
import com.leagueresults.repository.StatisticsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticsService {
    private final ExcelUploadService excelUploadService;
    private final StatisticsRepository statsRepository;
    private final StatsConverterService statsConverterService;
    private final MatchService matchService;
    private final ClubService clubService;
    public StatisticsService(ExcelUploadService excelUploadService, StatisticsRepository statsRepository, StatsConverterService statsConverterService, MatchService matchService, ClubService clubService) {
        this.excelUploadService = excelUploadService;
        this.statsRepository = statsRepository;
        this.statsConverterService = statsConverterService;
        this.matchService = matchService;
        this.clubService = clubService;
    }

    public void saveStatsToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Statistics> stats = excelUploadService.getStatsDataFromExcel(file.getInputStream());
                this.statsRepository.saveAll(stats);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public StatsDTO getStatByMatchId(Long matchId) {
        Match match = matchService.findMatchById(matchId);
        StatsDTO statsDTO = statsConverterService.entityToDto(statsRepository.findByMatch(match));
        return statsDTO;
    }

    public List<Long> getAllMinutes(Long clubId){
        List<Long> allMinutes = new ArrayList<>();
        Club club = clubService.getClubById(clubId);

        if (club != null) {
            List<Match> matchHostList = matchService.findAllByClubNameIsHost(club.getName());
            if (matchHostList != null) {
                matchHostList.forEach(match -> {
                    Statistics stats = statsRepository.findByMatch(match);
                    if (stats != null && stats.getHostMinutes() != null) {
                        allMinutes.addAll(stats.getHostMinutes());
                    }
                });
            }

            List<Match> matchGuestList = matchService.findAllByClubIdIsGuest(club.getName());
            if (matchGuestList != null) {
                matchGuestList.forEach(match -> {
                    Statistics stats = statsRepository.findByMatch(match);
                    if (stats != null && stats.getGuestMinutes() != null) {
                        allMinutes.addAll(stats.getGuestMinutes());
                    }
                });
            }
        }

        return allMinutes;
    }

    public MinutesPerPeriods getMPPByClubId(Long clubId){
        int stPeriodCounter = 0;
        int ndPeriodCounter = 0;
        int rdPeriodCounter = 0;
        int injTimeCounter = 0;
        List<Long> listMinutes = getAllMinutes(clubId);
        for (Long minute : listMinutes) {
            switch ((int) (minute / 30)) {
                case 0:
                    stPeriodCounter++;
                    break;
                case 1:
                    ndPeriodCounter++;
                    break;
                case 2:
                    rdPeriodCounter++;
                    break;
                default:
                    injTimeCounter++;
                    break;
            }
        }

        MinutesPerPeriods minutesPerPeriods = new MinutesPerPeriods();
        minutesPerPeriods.setFirstPeriod(stPeriodCounter);
        minutesPerPeriods.setSecondPeriod(ndPeriodCounter);
        minutesPerPeriods.setThirdPeriod(rdPeriodCounter);
        minutesPerPeriods.setInjuryTime(injTimeCounter);

        return minutesPerPeriods;
    }
}
