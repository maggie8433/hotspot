package com.taiwanecology.hotspot.service.impl;

import com.taiwanecology.hotspot.repository.WildlifeRescueCentreRepository;
import com.taiwanecology.hotspot.service.WildlifeRescueCentreService;

import org.springframework.stereotype.Service;

@Service
public class WildlifeRescueCentreServiceImpl
        implements WildlifeRescueCentreService {

    private final WildlifeRescueCentreRepository
            wildlifeRescueCentreRepository;


    public WildlifeRescueCentreServiceImpl(
            WildlifeRescueCentreRepository
                    wildlifeRescueCentreRepository
    ) {

        this.wildlifeRescueCentreRepository =
                wildlifeRescueCentreRepository;
    }


    @Override
    public String getWildlifeRescueCentresGeo() {

        return wildlifeRescueCentreRepository
                .findWildlifeRescueCentresGeo();
    }
}