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
                    id,
                    'nameZh',
                    "name",
                    'nameEn',
                    "name_en"
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
FROM taiwan_ecology.natural_reserve_areas
WHERE geom IS NOT NULL;