package com.taiwanecology.hotspot.controller;

import com.taiwanecology.hotspot.service.WildlifeAttackService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wildlife-attacks")
public class WildlifeAttackController {

    private final WildlifeAttackService wildlifeAttackService;


    public WildlifeAttackController(
            WildlifeAttackService wildlifeAttackService
    ) {

        this.wildlifeAttackService =
                wildlifeAttackService;
    }


    @GetMapping(
            value = "/geo",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> getWildlifeAttackGeo() {

        return ResponseEntity.ok(
                wildlifeAttackService
                        .getWildlifeAttackGeo()
        );
    }
}