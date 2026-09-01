SELECT jsonb_build_object(
    'type',
    'FeatureCollection',

    'features',
    COALESCE(
        jsonb_agg(
            jsonb_build_object(
                'type',
                'Feature',

                'properties',
                jsonb_build_object(
                    'id',
                    id
                ),

                'geometry',
                ST_AsGeoJSON(
                    ST_Transform(
                        geom,
                        4326
                    )
                )::jsonb
            )
        ),
        '[]'::jsonb
    )
)::text
FROM taiwan_ecology.forest_wildlife_distribution
WHERE geom IS NOT NULL;