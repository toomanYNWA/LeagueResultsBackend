package com.leagueresults.repository;

import com.leagueresults.model.City;
import com.leagueresults.model.ClubRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRankRepository extends JpaRepository<ClubRank,Long> {
}
