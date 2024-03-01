package com.leagueresults.service;

import com.leagueresults.model.Contract;
import com.leagueresults.model.Match;
import com.leagueresults.repository.ContractRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final ExcelUploadService excelUploadService;

    public ContractService(ContractRepository contractRepository, ExcelUploadService excelUploadService) {
        this.contractRepository = contractRepository;
        this.excelUploadService = excelUploadService;
    }

    public void saveContractsToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Contract> contracts = excelUploadService.getContractsDataFromExcel(file.getInputStream());
                this.contractRepository.saveAll(contracts);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }
}
