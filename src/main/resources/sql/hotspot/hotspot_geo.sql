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
                    h.id,

                    'cityNameZh',
                    h.city_name_zh,

                    'cityNameEn',
                    h.city_name_en,

                    'strayScore',
                    h.stray_score,

                    'ecologicalScore',
                    h.ecological_score,

                    'shelterScore',
                    h.shelter_score,

                    'hotspotScore',
                    h.hotspot_score,

                    'riskRank',
                    h.risk_rank,

                    'riskLevel',
                    h.risk_level,

                    'calculatedTime',
                    h.calculated_time,

                    'labelLat',
                    ST_Y(
                        ST_Transform(
                            label_data.label_point,
                            4326
                        )
                    ),

                    'labelLng',
                    ST_X(
                        ST_Transform(
                            label_data.label_point,
                            4326
                        )
                    )
                ),

                'geometry',
                ST_AsGeoJSON(
                    ST_Transform(
                        c.geom,
                        4326
                    )
                )::jsonb
            )
        ),
        '[]'::jsonb
    )
)::text

FROM taiwan_ecology.city_hotspot_scores h

JOIN taiwan_ecology.city_boundary c
    ON h.city_name_zh = c."COUNTYNAME"

CROSS JOIN LATERAL (

    SELECT
        ST_PointOnSurface(
            dumped.geom
        ) AS label_point

    FROM ST_Dump(
        c.geom
    ) AS dumped

    ORDER BY
        ST_Area(
            dumped.geom
        ) DESC

    LIMIT 1

) AS label_data

WHERE c.geom IS NOT NULL;