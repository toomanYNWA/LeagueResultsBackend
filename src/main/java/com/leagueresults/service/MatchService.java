package com.leagueresults.service;

import com.leagueresults.dtos.MatchDTO;
import com.leagueresults.model.Match;
import com.leagueresults.model.Statistics;
import com.leagueresults.repository.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

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

    public List<MatchDTO> getResults() {
        String result = "";
        List<MatchDTO> matchDTOS = new ArrayList<>();
        this.matchRepository.findAllByResultNot(result).forEach(match -> {
            MatchDTO matchDTO = matchConverterService.entityToDto(match);
            matchDTOS.add(matchDTO);
        });
        Collections.reverse(matchDTOS);
        return matchDTOS;
    }

    public List<MatchDTO> getFixtures() {
        String result = "";
        List<MatchDTO> matchDTOS = new ArrayList<>();
        this.matchRepository.findAllByResult(result).forEach(match -> {
            MatchDTO matchDTO = matchConverterService.entityToDto(match);
            matchDTOS.add(matchDTO);
        });

        return matchDTOS;
    }
    public Match findMatchById(Long id){
        Optional<Match> matchOptional = this.matchRepository.findById(id);
        // Check if the match is present in the Optional
        if (matchOptional.isPresent()) {
            // Return the match if it exists
            return matchOptional.get();
        } else {
            // Handle the case where match is not found, for example, you can return null or throw an exception
            return null; // Or throw a custom exception
        }
    }

    public List<MatchDTO> getAllByClub(String name) {
        String result = "";
        List<MatchDTO> matchDTOS = new ArrayList<>();
        this.matchRepository.findAllByResultNot(result).forEach(match -> {
            MatchDTO matchDTO = matchConverterService.entityToDto(match);
            matchDTOS.add(matchDTO);
        });
        if(name.equals("all")){
            Collections.reverse(matchDTOS);
            return matchDTOS;
        }
        List<MatchDTO> matchDTOS2 = new ArrayList<>();
        matchDTOS.forEach(matchDTO -> {
                    if (matchDTO.getHostName().equals(name) || matchDTO.getGuestName().equals(name)) {
                        matchDTOS2.add(matchDTO);
                    }
                });
        Collections.reverse(matchDTOS2);
        return matchDTOS2;

    }
}
