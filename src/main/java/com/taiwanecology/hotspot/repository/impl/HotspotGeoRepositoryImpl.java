package com.taiwanecology.hotspot.repository.impl;

import com.taiwanecology.hotspot.repository.HotspotGeoRepository;
import com.taiwanecology.hotspot.util.SqlFileLoader;

import jakarta.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class HotspotGeoRepositoryImpl
        implements HotspotGeoRepository {

    private static final String HOTSPOT_GEO_SQL =
            "sql/hotspot/hotspot_geo.sql";

    private final EntityManager entityManager;

    private final SqlFileLoader sqlFileLoader;


    public HotspotGeoRepositoryImpl(
            EntityManager entityManager,
            SqlFileLoader sqlFileLoader
    ) {

        this.entityManager =
                entityManager;

        this.sqlFileLoader =
                sqlFileLoader;
    }


    @Override
    public String findHotspotGeo() {

        String sql =
                sqlFileLoader.load(
                        HOTSPOT_GEO_SQL
                );


        Object result =
                entityManager
                        .createNativeQuery(sql)
                        .getSingleResult();


        return result.toString();
    }
}