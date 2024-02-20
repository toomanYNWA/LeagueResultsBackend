package com.leagueresults.service;

import com.leagueresults.model.ClubRank;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
@Service
public class ExcelUploadService {
    private ClubService clubService;

    public ExcelUploadService(ClubService clubService) {
        this.clubService = clubService;
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
}
