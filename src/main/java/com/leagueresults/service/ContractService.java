package com.leagueresults.service;

import com.leagueresults.dtos.ContractDTO;
import com.leagueresults.dtos.PlayerDTO;
import com.leagueresults.model.Contract;
import com.leagueresults.model.Player;
import com.leagueresults.repository.ContractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final ExcelUploadService excelUploadService;
    private final ContractConverterService contractConverterService;

    public ContractService(ContractRepository contractRepository, ExcelUploadService excelUploadService, ContractConverterService contractConverterService) {
        this.contractRepository = contractRepository;
        this.excelUploadService = excelUploadService;
        this.contractConverterService = contractConverterService;
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
    public List<ContractDTO> getAllContracts(){
        List<ContractDTO> contractDTOS = new ArrayList<>();
        this.contractRepository.findAll().forEach(contract -> {
            ContractDTO contractDTO = contractConverterService.entityToDto(contract);
            contractDTOS.add(contractDTO);
        });
        return contractDTOS;
    }

    public List<ContractDTO> getContractsByClubId(Long id) {
        List<ContractDTO> contractDTOS = new ArrayList<>();
        this.contractRepository.findAllByClubId(id).forEach(contract -> {
            ContractDTO contractDTO = contractConverterService.entityToDto(contract);
            contractDTOS.add(contractDTO);
        });
        return contractDTOS;
    }

    public Page<ContractDTO> getAllPlayersPage(PageRequest pageRequest) {
        Page<Contract> contracts = contractRepository.findAll(pageRequest);
        return contracts.map(ContractDTO::fromContract);
    }
}
