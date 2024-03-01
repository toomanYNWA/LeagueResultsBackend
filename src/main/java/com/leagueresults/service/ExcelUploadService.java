package com.leagueresults.service;

import com.leagueresults.enums.ContractType;
import com.leagueresults.enums.PlayerPosition;
import com.leagueresults.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.lang.Long.parseLong;

@Service
public class ExcelUploadService {
    private ClubService clubService;
    private RoundService roundService;
    private MainRefereeService mainRefereeService;
    private PlayerService playerService;

    @Autowired
    public ExcelUploadService(@Lazy ClubService clubService, RoundService roundService, MainRefereeService mainRefereeService,@Lazy PlayerService playerService) {
        this.clubService = clubService;
        this.roundService = roundService;
        this.mainRefereeService = mainRefereeService;
        this.playerService = playerService;
    }

    public  static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }
    public List<ClubRank> getRankingsDataFromExcel(InputStream inputStream){
        List<ClubRank> clubRanks = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("rankings");

            int rowIndex = 0;

            for (Row row : sheet){
                if(rowIndex == 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                ClubRank clubRank = new ClubRank();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 -> clubRank.setMatchesPlayed((long) cell.getNumericCellValue());
                        case 1 -> clubRank.setClub(clubService.GetClubByName(cell.getStringCellValue()));
                        case 2 -> clubRank.setWon((long) cell.getNumericCellValue());
                        case 3 -> clubRank.setDrawn((long) cell.getNumericCellValue());
                        case 4 -> clubRank.setLost((long) cell.getNumericCellValue());
                        case 7 -> clubRank.setGoalDifference((long) cell.getNumericCellValue());
                        case 8 -> clubRank.setPoints((long) cell.getNumericCellValue());
                        default -> {}
                    }
                    cellIndex++;
                }
                clubRanks.add(clubRank);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
//        clubRanks.forEach(club -> club.setLeague());
        return clubRanks;
    }
    public List<Player> getPlayersDataFromExcel(InputStream inputStream){
        List<Player> players = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("players");

            int rowIndex = 0;

            for (Row row : sheet){
                if(rowIndex == 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Player player = new Player();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 -> player.setFullName( cell.getStringCellValue());
                        case 2 -> player.setGoals((long)cell.getNumericCellValue());
                        case 3 -> player.setAssists((long) cell.getNumericCellValue());
                        case 4 -> player.setPlayerPosition(PlayerPosition.valueOf(cell.getStringCellValue()));
                        default -> {}
                    }
                    cellIndex++;
                }
                players.add(player);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
//        players.forEach(player -> player.setLeague());
        return players;
    }
    public List<Match> getMatchesDataFromExcel(InputStream inputStream){
        List<Match> matches = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("fixtures");

            int rowIndex = 0;

            for (Row row : sheet){
                if(rowIndex == 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Match match = new Match();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 1 -> match.setRound(roundService.getRoundByNumber(parseLong(cell.getStringCellValue())));
                        case 2 -> match.setKickoff(cell.getLocalDateTimeCellValue());
                        case 4 -> match.setHost(clubService.GetClubByName(cell.getStringCellValue()));
                        case 5 -> match.setGuest(clubService.GetClubByName(cell.getStringCellValue()));
                        case 6 -> match.setResult( cell.getStringCellValue());
                        case 7 -> match.setMainReferee(mainRefereeService.getMainRefereeById((long)cell.getNumericCellValue()));
                        default -> {}
                    }
                    cellIndex++;
                }
                matches.add(match);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
//        clubRanks.forEach(club -> club.setLeague());
        return matches;
    }
    public List<Contract> getContractsDataFromExcel(InputStream inputStream) {
        List<Contract> contracts = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("contract");

            int rowIndex = 0;

            for (Row row : sheet) {
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Contract contract = new Contract();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 0:
                            contract.setPlayer(playerService.getPlayerByName(cell.getStringCellValue()));
                            break;
                        case 1:
                            contract.setClub(clubService.GetClubByName(cell.getStringCellValue()));
                            break;
                        case 2:
                            contract.setContractType(ContractType.valueOf(cell.getStringCellValue()));
                            break;
                        case 3:
                            // Assuming the date format is "dd.MM.yyyy"
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
                            LocalDate endingDate = LocalDate.parse(cell.getStringCellValue(), formatter);
                            contract.setEnding(endingDate.atStartOfDay());  // Set to start of the day
                            break;
                        default:
                            break;
                    }
                    cellIndex++;
                }
                contracts.add(contract);
            }
        } catch (IOException e) {
            e.printStackTrace();  // Use printStackTrace to see the exception details
        }
        return contracts;
    }
}

