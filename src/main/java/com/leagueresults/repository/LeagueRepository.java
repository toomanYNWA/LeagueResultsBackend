package com.leagueresults.repository;

import com.leagueresults.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
    League findOneBySeason(String stringCellValue);
}
