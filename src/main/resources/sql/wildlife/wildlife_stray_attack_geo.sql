WITH attack_summary AS (
    SELECT
        COUNT(*) AS total_attacks,

        COUNT(*) FILTER (
            WHERE LOWER(attack_cause_en) = 'dog'
        ) AS dog_attacks,

        COUNT(*) FILTER (
            WHERE LOWER(attack_cause_en) = 'cat'
        ) AS cat_attacks,

        COUNT(*) FILTER (
            WHERE final_outcome_en IN (
                'Died',
                'Died Before Rescue',
                'Euthanized'
            )
        ) AS deaths,

        COUNT(DISTINCT species_en) FILTER (
            WHERE conservation_level_en = 'Level II Protected Species'
        ) AS protected_species_count,

        COUNT(DISTINCT species_en) FILTER (
            WHERE conservation_level_en = 'General Wildlife'
        ) AS general_species_count

    FROM taiwan_ecology.wildlife_attack_cases

    WHERE LOWER(attack_cause_en) IN (
        'dog',
        'cat'
    )
),

taitung AS (
    SELECT
        id,
        "COUNTYNAME",
        "COUNTYENG",
        geom

    FROM taiwan_ecology.city_boundary

    WHERE "COUNTYNAME" = '臺東縣'
       OR LOWER("COUNTYENG") LIKE '%taitung%'

    LIMIT 1
),

feature AS (
    SELECT
        t.id,

        t."COUNTYNAME" AS city_name_zh,
        t."COUNTYENG" AS city_name_en,

        a.total_attacks,
        a.dog_attacks,
        a.cat_attacks,
        a.deaths,

        CASE
            WHEN a.total_attacks = 0
                THEN 0
            ELSE
                ROUND(
                    (
                        a.deaths::numeric
                        / a.total_attacks::numeric
                    ) * 100,
                    2
                )
        END AS death_rate,

        a.protected_species_count,
        a.general_species_count,

        ST_Transform(
            t.geom,
            4326
        ) AS geom

    FROM taitung t
    CROSS JOIN attack_summary a
)

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
                    feature.geom
                )::jsonb,

                'properties',
                jsonb_build_object(
                    'id',
                    feature.id,

                    'cityNameZh',
                    feature.city_name_zh,

                    'cityNameEn',
                    feature.city_name_en,

                    'totalAttacks',
                    feature.total_attacks,

                    'dogAttacks',
                    feature.dog_attacks,

                    'catAttacks',
                    feature.cat_attacks,

                    'deaths',
                    feature.deaths,

                    'deathRate',
                    feature.death_rate,

                    'protectedSpeciesCount',
                    feature.protected_species_count,

                    'generalSpeciesCount',
                    feature.general_species_count
                )
            )
        ),
        '[]'::jsonb
    )
)

FROM feature;