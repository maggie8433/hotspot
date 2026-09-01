package com.taiwanecology.hotspot.repository.impl;

import com.taiwanecology.hotspot.repository.WildlifeAttackRepository;
import com.taiwanecology.hotspot.util.SqlFileLoader;

import jakarta.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class WildlifeAttackRepositoryImpl
        implements WildlifeAttackRepository {

    private static final String WILDLIFE_ATTACK_GEO_SQL =
            "sql/wildlife/wildlife_stray_attack_geo.sql";

    private final EntityManager entityManager;

    private final SqlFileLoader sqlFileLoader;


    public WildlifeAttackRepositoryImpl(
            EntityManager entityManager,
            SqlFileLoader sqlFileLoader
    ) {

        this.entityManager =
                entityManager;

        this.sqlFileLoader =
                sqlFileLoader;
    }


    @Override
    public String findWildlifeAttackGeo() {

        String sql =
                sqlFileLoader.load(
                        WILDLIFE_ATTACK_GEO_SQL
                );


        Object result =
                entityManager
                        .createNativeQuery(sql)
                        .getSingleResult();


        return result.toString();
    }
}