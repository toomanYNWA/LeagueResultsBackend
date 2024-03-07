package com.leagueresults.service;

import com.leagueresults.dtos.ClubRankDTO;
import com.leagueresults.model.ClubRank;
import com.leagueresults.repository.ClubRankRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClubRankService {
    private final ClubRankRepository clubRankRepository;
    private final ExcelUploadService excelUploadService;
    private final ClubRankConverterService clubRankConverterService;


    public ClubRankService(ClubRankRepository clubRankRepository, ExcelUploadService excelUploadService, ClubRankConverterService clubRankConverterService) {
        this.clubRankRepository = clubRankRepository;
        this.excelUploadService = excelUploadService;
        this.clubRankConverterService = clubRankConverterService;
    }

    public void saveClubRanksToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<ClubRank> clubRanks = excelUploadService.getRankingsDataFromExcel(file.getInputStream());
                this.clubRankRepository.saveAll(clubRanks);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<ClubRankDTO> getAllClubRanks() {
        List<ClubRankDTO> clubRankDTOS = new ArrayList<>();
        this.clubRankRepository.findAll().forEach(clubRank -> {
            ClubRankDTO clubRankDTO = clubRankConverterService.entityToDto(clubRank);
            clubRankDTOS.add(clubRankDTO);
        });
        return clubRankDTOS;
    }
}
