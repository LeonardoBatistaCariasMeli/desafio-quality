package com.digitalhouse.desafioquality.repository;

import java.util.Map;

public interface NeighborhoodRepository {

    public Double getSquareMeterValue(String neighborhoodName);

    public Map<String, Double> findAll();
}
