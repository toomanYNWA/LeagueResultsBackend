package com.leagueresults.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.leagueresults.dtos.StatsDTO;
import com.leagueresults.model.*;
import com.leagueresults.repository.StatisticsRepository;
import org.apache.catalina.manager.ManagerServlet;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class StatisticsService {
    private final ExcelUploadService excelUploadService;
    private final StatisticsRepository statsRepository;
    private final StatsConverterService statsConverterService;
    private final MatchService matchService;
    private final ClubService clubService;
    private final ClubRankService clubRankService;
    private final ManagerService managerService;

    public StatisticsService(ExcelUploadService excelUploadService, StatisticsRepository statsRepository, StatsConverterService statsConverterService, MatchService matchService, ClubService clubService, ClubRankService clubRankService, ManagerService managerService) {
        this.excelUploadService = excelUploadService;
        this.statsRepository = statsRepository;
        this.statsConverterService = statsConverterService;
        this.matchService = matchService;
        this.clubService = clubService;
        this.clubRankService = clubRankService;
        this.managerService = managerService;
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

    public List<Long> getAllMinutes(Long clubId) {
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

    public MinutesPerPeriods getMPPByClubId(Long clubId) {
        int stPeriodCounter = 0;
        int ndPeriodCounter = 0;
        int rdPeriodCounter = 0;
        int injTimeCounter = 0;
        Club club = clubService.getClubById(clubId);
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
        generatePDF(minutesPerPeriods, club);
        return minutesPerPeriods;
    }

    public void generatePDF(MinutesPerPeriods mpp, Club club) {
        Document document = new Document();
        ClubRank clubRank = clubRankService.getByClub(club);
        List<Manager> managers = managerService.getManagersByClub(club);
        int goals = mpp.getFirstPeriod()+ mpp.getSecondPeriod()+mpp.getThirdPeriod()+ mpp.getInjuryTime();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(club.getName() + "GoalsStats.pdf"));
            document.open();

            PdfPTable table = new PdfPTable(1); // Create a table with one column
            table.setWidthPercentage(100); // Set table width to 100% of the page width

            // Add the image to the first cell of the table
            PdfPCell cell = new PdfPCell();
            Image logo = Image.getInstance("src/main/resources/static/logoPL.png");
            float scale = 0.3f; // Adjust the scale factor to make the image 3x smaller
            logo.scalePercent(scale * 100); // Scale the image
            cell.addElement(logo);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Align the cell content to the right
            cell.setBorder(Rectangle.NO_BORDER); // Remove border from the cell
            table.addCell(cell);

            cell = new PdfPCell();

            Font font = FontFactory.getFont(FontFactory.COURIER, 22, Font.BOLD, BaseColor.BLACK);
            Paragraph paragraph = new Paragraph(club.getName() + " FC Stats", font);
            paragraph.setSpacingAfter(10);
            paragraph.setAlignment(Element.ALIGN_CENTER); // Align the paragraph to the right
            cell.addElement(paragraph);
            cell.setBorder(Rectangle.NO_BORDER); // Remove border from the cell
            table.addCell(cell);

            document.add(table);

            Font headerFont = FontFactory.getFont(FontFactory.COURIER, 18, Font.BOLD, BaseColor.BLACK);
            Paragraph header2 = new Paragraph(club.getName()+" FC General Stats",headerFont);
            header2.setAlignment(Element.ALIGN_LEFT);
            header2.setSpacingAfter(10);
            document.add(header2);

            Paragraph paragraph11 = new Paragraph("Games Played: " +clubRank.getMatchesPlayed());
            Paragraph paragraph22 = new Paragraph("Games Won: " +clubRank.getWon());
            Paragraph paragraph33 = new Paragraph("Games Drawn: " +clubRank.getDrawn());
            Paragraph paragraph44 = new Paragraph("Games Lost: " +clubRank.getLost());
            Paragraph paragraph5 = new Paragraph("Win rate: "+ formatDecimal((float)clubRank.getWon()/(float) clubRank.getMatchesPlayed()*100)+"%");

            document.add(paragraph11);
            document.add(paragraph22);
            document.add(paragraph33);
            document.add(paragraph44);
            document.add(paragraph5);

            Paragraph header3 = new Paragraph("League Goals By Periods", headerFont);
            header3.setAlignment(Element.ALIGN_LEFT);
            header3.setSpacingAfter(10);
            document.add(header3);

            Paragraph paragraph1 = new Paragraph("Goals in first 30 minutes: " + formatDecimal(((float) mpp.getFirstPeriod() / (float) goals * 100)) + "% (" + mpp.getFirstPeriod() + ")");
            Paragraph paragraph2 = new Paragraph("Goals in second 30 minutes: " + formatDecimal(((float) mpp.getSecondPeriod() / (float) goals * 100)) + "% (" + mpp.getSecondPeriod() + ")");
            Paragraph paragraph3 = new Paragraph("Goals in third 30 minutes: " + formatDecimal(((float) mpp.getThirdPeriod() / (float) goals * 100)) + "% (" + mpp.getThirdPeriod() + ")");
            Paragraph paragraph4 = new Paragraph("Goals in injury time: " + formatDecimal(((float) mpp.getInjuryTime() / (float) goals * 100)) + "% (" + mpp.getInjuryTime() + ")");
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);

            Paragraph managerHeader = new Paragraph("Coaching Staff", headerFont);
            managerHeader.setAlignment(Element.ALIGN_LEFT);
            managerHeader.setSpacingAfter(10);
            document.add(managerHeader);
            Paragraph manager = new Paragraph("Head coach: "+ managers.get(0).getName() + " "+managers.get(0).getSurname());
            Paragraph manager2 = new Paragraph("Assistant coach: "+ managers.get(1).getName()+" "+ managers.get(1).getSurname());
            document.add(manager);
            document.add(manager2);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
            String formattedDate = LocalDate.now().format(formatter);
            Font dateFont = FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD, BaseColor.BLACK);
            Paragraph date = new Paragraph("Data Taken On: " + formattedDate, dateFont);

            date.setAlignment(Element.ALIGN_RIGHT);
            document.add(date);

            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
    public String formatDecimal(float value){
        return String.format("%.2f",value);
    }
}