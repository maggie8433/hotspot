package com.taiwanecology.hotspot.controller;

import com.taiwanecology.hotspot.service.WildlifeRescueCentreService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/wildlife-rescue-centres")
public class WildlifeRescueCentreController {

    private final WildlifeRescueCentreService
            wildlifeRescueCentreService;


    public WildlifeRescueCentreController(
            WildlifeRescueCentreService
                    wildlifeRescueCentreService
    ) {

        this.wildlifeRescueCentreService =
                wildlifeRescueCentreService;
    }


    @GetMapping(
            value = "/geo",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String>
    getWildlifeRescueCentresGeo() {

        return ResponseEntity.ok(
                wildlifeRescueCentreService
                        .getWildlifeRescueCentresGeo()
        );
    }
}