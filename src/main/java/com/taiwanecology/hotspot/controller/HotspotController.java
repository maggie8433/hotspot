package com.taiwanecology.hotspot.controller;

import com.taiwanecology.hotspot.dto.HotspotResponse;
import com.taiwanecology.hotspot.service.HotspotService;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotspots")
public class HotspotController {

    private final HotspotService hotspotService;


    public HotspotController(
            HotspotService hotspotService
    ) {

        this.hotspotService =
                hotspotService;
    }


    // Get all hotspot scores
    @GetMapping
    public List<HotspotResponse> getAllHotspots() {

        return hotspotService
                .getAllHotspots();
    }


    // Get hotspot GeoJSON data for the map
    @GetMapping(
            value = "/geo",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getHotspotGeo() {

        return hotspotService
                .getHotspotGeo();
    }


    // Get hotspot information for one city
    @GetMapping(
            "/city/{cityName}"
    )
    public HotspotResponse getHotspotByCityName(
            @PathVariable String cityName
    ) {

        return hotspotService
                .getHotspotByCityName(
                        cityName
                );
    }
}