package com.leagueresults.service;

import com.leagueresults.dtos.ClubRankDTO;
import com.leagueresults.model.Club;
import com.leagueresults.model.ClubRank;
import com.leagueresults.model.League;
import com.leagueresults.repository.ClubRankRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClubRankService {
    private final ClubRankRepository clubRankRepository;
    private final ExcelUploadService excelUploadService;
    private final ClubRankConverterService clubRankConverterService;
    private final LeagueService leagueService;


    public ClubRankService(ClubRankRepository clubRankRepository, ExcelUploadService excelUploadService, ClubRankConverterService clubRankConverterService, LeagueService leagueService) {
        this.clubRankRepository = clubRankRepository;
        this.excelUploadService = excelUploadService;
        this.clubRankConverterService = clubRankConverterService;
        this.leagueService = leagueService;
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

    public List<ClubRankDTO> getAllClubRanks(Long seasonId) {
        List<ClubRankDTO> clubRankDTOS = new ArrayList<>();
//        Optional<League> league = this.leagueService.getLeagueById(seasonId);
        this.clubRankRepository.findAllByLeague_Id(seasonId).forEach(clubRank -> {
            ClubRankDTO clubRankDTO = clubRankConverterService.entityToDto(clubRank);
            clubRankDTOS.add(clubRankDTO);
        });
        return clubRankDTOS;
    }

    public ClubRank getByClub(Club club) {
        return clubRankRepository.findByClubAndLeagueId(club, (long)1);
    }
}
