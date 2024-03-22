package com.leagueresults.repository;

import com.leagueresults.model.City;
import com.leagueresults.model.ClubRank;
import com.leagueresults.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRankRepository extends JpaRepository<ClubRank,Long> {
    List<ClubRank> findAllByLeague_Id(long seasonId);
}
