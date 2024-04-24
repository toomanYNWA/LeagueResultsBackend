package com.leagueresults.repository;

import com.leagueresults.model.Club;
import com.leagueresults.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {
    List<Manager> findAllByClub(Club club);
}
