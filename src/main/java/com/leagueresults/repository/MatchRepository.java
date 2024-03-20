package com.leagueresults.repository;

import com.leagueresults.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByResultNot(String result);

    Iterable<Match> findAllByResult(String result);
}
