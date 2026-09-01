package com.taiwanecology.hotspot.repository;

import com.taiwanecology.hotspot.enums.EcologicalLayerType;

public interface EcologicalLayerRepository {

    String getGeoJson(
            EcologicalLayerType layerType
    );
}