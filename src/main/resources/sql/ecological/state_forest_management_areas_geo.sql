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

                    'forestDistrictName',
                    "WKNG_C",
                    'forestDistrictNameEn',
                    "wkng_c_en"
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

FROM taiwan_ecology.state_forest_management_areas

WHERE geom IS NOT NULL;