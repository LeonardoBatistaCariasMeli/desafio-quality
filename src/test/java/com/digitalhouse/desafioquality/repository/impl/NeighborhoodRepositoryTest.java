package com.digitalhouse.desafioquality.repository.impl;

import com.digitalhouse.desafioquality.exceptions.ObjectNotFoundException;
import com.digitalhouse.desafioquality.repository.NeighborhoodRepository;
import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class NeighborhoodRepositoryTest {

    private NeighborhoodRepository neighborhoodRepository = new NeighborhoodRepositoryImpl();

    @Test
    public void shouldVerifyIfNeighborhoodExists() {
        var request = TestUtils.getPropertyRequest();
        var got = neighborhoodRepository.getSquareMeterValue(request.getPropertyDistrict());

        assertEquals(100.0, got);
    }

    @Test
    public void shouldVerifyIfNeighborhoodExistsWithInvalidName() {
        var districtFake = "Guaianazes";
        try {
            neighborhoodRepository.getSquareMeterValue(districtFake);
            fail("Should throw ObjectNotFoundException");
        } catch (ObjectNotFoundException ex) {
            assertEquals("This neighborhood not exists", ex.getMessage());
        }
    }

    @Test
    public void shouldVerifyIfNeighborhoodsIsLoaded() {
        var neighborhoods = neighborhoodRepository.findAll();
        assertEquals(60, neighborhoods.size());
    }
}
