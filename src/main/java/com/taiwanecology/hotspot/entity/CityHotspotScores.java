package com.taiwanecology.hotspot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "city_hotspot_scores",
        schema = "taiwan_ecology"
)
public class CityHotspotScores {

    @Id
    private Long id;

    @Column(name = "city_name_zh")
    private String cityNameZh;

    @Column(name = "city_name_en")
    private String cityNameEn;

    @Column(name = "stray_score")
    private Double strayScore;

    @Column(name = "ecological_score")
    private Double ecologicalScore;

    @Column(name = "shelter_score")
    private Double shelterScore;

    @Column(name = "hotspot_score")
    private Double hotspotScore;

    @Column(name = "risk_rank")
    private Integer riskRank;

    @Column(name = "risk_level")
    private String riskLevel;

    @Column(name = "calculated_time")
    private LocalDateTime calculatedTime;

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