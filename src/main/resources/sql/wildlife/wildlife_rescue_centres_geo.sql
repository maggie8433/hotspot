SELECT jsonb_build_object(
    'type',
    'FeatureCollection',

    'features',
    COALESCE(
        jsonb_agg(
            jsonb_build_object(
                'type',
                'Feature',

                'geometry',
                ST_AsGeoJSON(
                    ST_Transform(
                        geom,
                        4326
                    )
                )::jsonb,

                'properties',
                jsonb_build_object(
                    'id',
                    id,

                    'nameZh',
                    name_zh,

                    'nameEn',
                    name_en,

                    'addressZh',
                    address_zh,

                    'addressEn',
                    address_en,

                    'cityNameZh',
                    city_name_zh,

                    'cityNameEn',
                    city_name_en,

                    'phone',
                    phone,

                    'animalScopeZh',
                    animal_scope_zh,

                    'animalScopeEn',
                    animal_scope_en,

                    'notesZh',
                    notes_zh,

                    'notesEn',
                    notes_en,

                    'latitude',
                    latitude,

                    'longitude',
                    longitude
                )
            )
            ORDER BY id
        ),

        '[]'::jsonb
    )
)
FROM taiwan_ecology.wildlife_rescue_centres
WHERE geom IS NOT NULL;