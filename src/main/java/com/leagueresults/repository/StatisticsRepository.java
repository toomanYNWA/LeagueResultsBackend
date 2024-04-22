package com.leagueresults.repository;

import com.leagueresults.model.ClubRank;
import com.leagueresults.model.Match;
import com.leagueresults.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics,Long> {
    Statistics findByMatch(Match match);

}
