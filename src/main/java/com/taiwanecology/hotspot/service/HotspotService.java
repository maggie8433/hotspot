package com.taiwanecology.hotspot.service;

import com.taiwanecology.hotspot.dto.HotspotResponse;

import java.util.List;

public interface HotspotService {

    List<HotspotResponse> getAllHotspots();

    HotspotResponse getHotspotByCityName(
            String cityNameEn
    );

   String getHotspotGeo();
}