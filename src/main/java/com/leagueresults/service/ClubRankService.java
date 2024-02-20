package com.leagueresults.service;

import com.leagueresults.model.ClubRank;
import com.leagueresults.repository.ClubRankRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ClubRankService {
    private final ClubRankRepository clubRankRepository;
    private final ExcelUploadService excelUploadService;

    public ClubRankService(ClubRankRepository clubRankRepository, ExcelUploadService excelUploadService) {
        this.clubRankRepository = clubRankRepository;
        this.excelUploadService = excelUploadService;
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

    public List<ClubRank> getAllClubRanks() {
        return this.clubRankRepository.findAll();
    }
}
