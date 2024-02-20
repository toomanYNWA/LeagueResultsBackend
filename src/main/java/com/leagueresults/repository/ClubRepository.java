package com.leagueresults.repository;

import com.leagueresults.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
    Club getClubByName(String name);
}
