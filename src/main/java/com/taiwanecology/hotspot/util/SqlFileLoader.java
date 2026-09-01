package com.taiwanecology.hotspot.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class SqlFileLoader {

    public String load(String path) {

        try {

            ClassPathResource resource =
                    new ClassPathResource(path);

            return new String(
                    resource.getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load SQL file: " + path,
                    e
            );
        }
    }
}