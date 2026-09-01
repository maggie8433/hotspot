package com.taiwanecology.hotspot.service.impl;

import com.taiwanecology.hotspot.repository.WildlifeAttackRepository;
import com.taiwanecology.hotspot.service.WildlifeAttackService;

import org.springframework.stereotype.Service;

@Service
public class WildlifeAttackServiceImpl
        implements WildlifeAttackService {

    private final WildlifeAttackRepository wildlifeAttackRepository;


    public WildlifeAttackServiceImpl(
            WildlifeAttackRepository wildlifeAttackRepository
    ) {

        this.wildlifeAttackRepository =
                wildlifeAttackRepository;
    }


    @Override
    public String getWildlifeAttackGeo() {

        return wildlifeAttackRepository
                .findWildlifeAttackGeo();
    }
}