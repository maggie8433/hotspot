package com.taiwanecology.hotspot.repository.impl;

import com.taiwanecology.hotspot.repository.WildlifeRescueCentreRepository;
import com.taiwanecology.hotspot.util.SqlFileLoader;

import jakarta.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class WildlifeRescueCentreRepositoryImpl
        implements WildlifeRescueCentreRepository {

    private static final String
            WILDLIFE_RESCUE_CENTRES_GEO_SQL =
            "sql/wildlife/"
                    + "wildlife_rescue_centres_geo.sql";

    private final EntityManager entityManager;

    private final SqlFileLoader sqlFileLoader;


    public WildlifeRescueCentreRepositoryImpl(
            EntityManager entityManager,
            SqlFileLoader sqlFileLoader
    ) {

        this.entityManager =
                entityManager;

        this.sqlFileLoader =
                sqlFileLoader;
    }


    @Override
    public String findWildlifeRescueCentresGeo() {

        String sql =
                sqlFileLoader.load(
                        WILDLIFE_RESCUE_CENTRES_GEO_SQL
                );

        Object result =
                entityManager
                        .createNativeQuery(sql)
                        .getSingleResult();

        return result.toString();
    }
}