package com.leagueresults.repository;

import com.leagueresults.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    Player findByFullName(String stringCellValue);
}
