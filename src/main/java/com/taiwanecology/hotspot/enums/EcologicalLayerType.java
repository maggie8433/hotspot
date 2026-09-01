package com.taiwanecology.hotspot.enums;

public enum EcologicalLayerType {

    ECOLOGICAL_CONSERVATION_CORRIDORS(
            "ecological-conservation-corridors",
            "sql/ecological/ecological_conservation_corridors_geo.sql"
    ),

    FOREST_WILDLIFE_DISTRIBUTION(
            "forest-wildlife-distribution",
            "sql/ecological/forest_wildlife_distribution_geo.sql"
    ),

    IMPORTANT_WILDLIFE_HABITATS(
            "important-wildlife-habitats",
            "sql/ecological/important_wildlife_habitats_geo.sql"
    ),

    NATURAL_RESERVE_AREAS(
            "natural-reserve-areas",
            "sql/ecological/natural_reserve_areas_geo.sql"
    ),

    NATURE_RESERVES(
            "nature-reserves",
            "sql/ecological/nature_reserves_geo.sql"
    ),

    STATE_FOREST_MANAGEMENT_AREAS(
            "state-forest-management-areas",
            "sql/ecological/state_forest_management_areas_geo.sql"
    ),

    TERRESTRIAL_WILDLIFE_PROTECTED_AREAS(
            "terrestrial-wildlife-protected-areas",
            "sql/ecological/terrestrial_wildlife_protected_areas_geo.sql"
    );

    private final String urlName;
    private final String sqlPath;

    EcologicalLayerType(
            String urlName,
            String sqlPath
    ) {
        this.urlName = urlName;
        this.sqlPath = sqlPath;
    }

    public String getUrlName() {
        return urlName;
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public static EcologicalLayerType fromUrlName(
            String urlName
    ) {

        for (EcologicalLayerType layer : values()) {

            if (
                    layer.getUrlName()
                            .equalsIgnoreCase(urlName)
            ) {
                return layer;
            }
        }

        throw new IllegalArgumentException(
                "Unknown ecological layer: "
                        + urlName
        );
    }
}