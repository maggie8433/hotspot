package com.taiwanecology.hotspot.repository.impl;

import com.taiwanecology.hotspot.enums.EcologicalLayerType;
import com.taiwanecology.hotspot.repository.EcologicalLayerRepository;
import com.taiwanecology.hotspot.util.SqlFileLoader;

import jakarta.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class EcologicalLayerRepositoryImpl
        implements EcologicalLayerRepository {

    private final EntityManager entityManager;
    private final SqlFileLoader sqlFileLoader;

    public EcologicalLayerRepositoryImpl(
            EntityManager entityManager,
            SqlFileLoader sqlFileLoader
    ) {
        this.entityManager = entityManager;
        this.sqlFileLoader = sqlFileLoader;
    }

    @Override
    public String getGeoJson(
            EcologicalLayerType layerType
    ) {

        String sqlPath = layerType.getSqlPath();

        String sql = sqlFileLoader.load(
                sqlPath
        );

        Object result = entityManager
                .createNativeQuery(sql)
                .getSingleResult();

        return result.toString();
    }
}