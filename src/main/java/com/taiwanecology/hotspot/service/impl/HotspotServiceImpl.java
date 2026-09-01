package com.taiwanecology.hotspot.service.impl;

import com.taiwanecology.hotspot.dto.HotspotResponse;
import com.taiwanecology.hotspot.entity.CityHotspotScores;
import com.taiwanecology.hotspot.repository.CityHotspotScoresRepository;
import com.taiwanecology.hotspot.repository.HotspotGeoRepository;
import com.taiwanecology.hotspot.service.HotspotService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotspotServiceImpl
        implements HotspotService {

    private final CityHotspotScoresRepository repository;

    private final HotspotGeoRepository hotspotGeoRepository;


    public HotspotServiceImpl(
            CityHotspotScoresRepository repository,
            HotspotGeoRepository hotspotGeoRepository
    ) {

        this.repository =
                repository;

        this.hotspotGeoRepository =
                hotspotGeoRepository;
    }


    @Override
    public List<HotspotResponse> getAllHotspots() {

        return repository
                .findAllByOrderByRiskRankAsc()
                .stream()
                .map(
                        this::toResponse
                )
                .toList();
    }


    @Override
    public HotspotResponse getHotspotByCityName(
            String cityNameEn
    ) {

        CityHotspotScores entity =
                repository
                        .findByCityNameEn(
                                cityNameEn
                        )
                        .orElseThrow(
                                () ->
                                        new RuntimeException(
                                                "City hotspot not found: "
                                                        + cityNameEn
                                        )
                        );


        return toResponse(
                entity
        );
    }


    @Override
    public String getHotspotGeo() {

        return hotspotGeoRepository
                .findHotspotGeo();
    }


    private HotspotResponse toResponse(
            CityHotspotScores entity
    ) {

        return new HotspotResponse(
                entity.getId(),
                entity.getCityNameZh(),
                entity.getCityNameEn(),
                entity.getStrayScore(),
                entity.getEcologicalScore(),
                entity.getShelterScore(),
                entity.getHotspotScore(),
                entity.getRiskRank(),
                entity.getRiskLevel(),
                entity.getCalculatedTime()
        );
    }
}