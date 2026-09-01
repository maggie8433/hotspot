package com.taiwanecology.hotspot.service.impl;

import com.taiwanecology.hotspot.enums.EcologicalLayerType;
import com.taiwanecology.hotspot.repository.EcologicalLayerRepository;
import com.taiwanecology.hotspot.service.EcologicalLayerService;

import org.springframework.stereotype.Service;

@Service
public class EcologicalLayerServiceImpl
        implements EcologicalLayerService {

    private final EcologicalLayerRepository repository;

    public EcologicalLayerServiceImpl(
            EcologicalLayerRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public String getEcologicalLayer(
            String layerName
    ) {

        EcologicalLayerType layerType =
                EcologicalLayerType.fromUrlName(
                        layerName
                );

        return repository.getGeoJson(
                layerType
        );
    }
}