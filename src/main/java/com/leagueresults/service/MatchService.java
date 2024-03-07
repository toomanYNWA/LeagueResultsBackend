package com.leagueresults.service;

import com.leagueresults.dtos.MatchDTO;
import com.leagueresults.model.Match;
import com.leagueresults.repository.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final ExcelUploadService excelUploadService;
    private final MatchConverterService matchConverterService;
    public MatchService(MatchRepository matchRepository, ExcelUploadService excelUploadService, MatchConverterService matchConverterService) {
        this.matchRepository = matchRepository;
        this.excelUploadService = excelUploadService;
        this.matchConverterService = matchConverterService;
    }

    public void saveMatchesToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Match> matches = excelUploadService.getMatchesDataFromExcel(file.getInputStream());
//                this.matchRepository.deleteAll();
                this.matchRepository.saveAll(matches);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<MatchDTO> getAll() {
        List<MatchDTO> matchDTOS = new ArrayList<>();

        this.matchRepository.findAll().forEach(match -> {
            MatchDTO matchDTO = matchConverterService.entityToDto(match);
            matchDTOS.add(matchDTO);
        });

        return matchDTOS;
    }
}
