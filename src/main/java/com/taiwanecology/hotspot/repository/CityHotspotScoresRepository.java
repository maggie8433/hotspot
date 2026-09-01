package com.taiwanecology.hotspot.repository;

import com.taiwanecology.hotspot.entity.CityHotspotScores;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityHotspotScoresRepository
        extends JpaRepository<
                CityHotspotScores,
                Long
                > {

    List<CityHotspotScores>
    findAllByOrderByRiskRankAsc();


    Optional<CityHotspotScores>
    findByCityNameEn(
            String cityNameEn
    );
}