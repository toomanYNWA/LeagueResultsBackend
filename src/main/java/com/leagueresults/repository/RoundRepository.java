package com.leagueresults.repository;

import com.leagueresults.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round,Long> {
    Round findByRoundNumber(long number);
}
