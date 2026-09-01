package com.taiwanecology.hotspot.controller;

import com.taiwanecology.hotspot.service.EcologicalLayerService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ecological-layers")
public class EcologicalLayerController {

    private final EcologicalLayerService ecologicalLayerService;

    public EcologicalLayerController(
            EcologicalLayerService ecologicalLayerService
    ) {
        this.ecologicalLayerService =
                ecologicalLayerService;
    }


    @GetMapping(
            value = "/{layerName}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getEcologicalLayer(
            @PathVariable String layerName
    ) {

        return ecologicalLayerService
                .getEcologicalLayer(
                        layerName
                );
    }
}