package com.taiwanecology.hotspot.dto;

import java.time.LocalDateTime;

public class HotspotResponse {

    private final Long id;
    private final String cityNameZh;
    private final String cityNameEn;
    private final Double strayScore;
    private final Double ecologicalScore;
    private final Double shelterScore;
    private final Double hotspotScore;
    private final Integer riskRank;
    private final String riskLevel;
    private final LocalDateTime calculatedTime;

    public HotspotResponse(
            Long id,
            String cityNameZh,
            String cityNameEn,
            Double strayScore,
            Double ecologicalScore,
            Double shelterScore,
            Double hotspotScore,
            Integer riskRank,
            String riskLevel,
            LocalDateTime calculatedTime
    ) {
        this.id = id;
        this.cityNameZh = cityNameZh;
        this.cityNameEn = cityNameEn;
        this.strayScore = strayScore;
        this.ecologicalScore = ecologicalScore;
        this.shelterScore = shelterScore;
        this.hotspotScore = hotspotScore;
        this.riskRank = riskRank;
        this.riskLevel = riskLevel;
        this.calculatedTime = calculatedTime;
    }

    public Long getId() {
        return id;
    }

    public String getCityNameZh() {
        return cityNameZh;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public Double getStrayScore() {
        return strayScore;
    }

    public Double getEcologicalScore() {
        return ecologicalScore;
    }

    public Double getShelterScore() {
        return shelterScore;
    }

    public Double getHotspotScore() {
        return hotspotScore;
    }

    public Integer getRiskRank() {
        return riskRank;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public LocalDateTime getCalculatedTime() {
        return calculatedTime;
    }
}