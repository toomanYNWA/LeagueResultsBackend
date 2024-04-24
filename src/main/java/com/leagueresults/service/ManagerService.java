package com.leagueresults.service;

import com.leagueresults.model.Club;
import com.leagueresults.model.Manager;
import com.leagueresults.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getManagersByClub(Club club) {
        return managerRepository.findAllByClub(club);
    }
}
