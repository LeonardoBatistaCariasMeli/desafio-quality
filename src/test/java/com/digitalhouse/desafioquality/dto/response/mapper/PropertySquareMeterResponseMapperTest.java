package com.digitalhouse.desafioquality.dto.response.mapper;

import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertySquareMeterResponseMapperTest {

    @Test
    public void shouldAssemblePropertySquareMeterResponse() {
        var expected = TestUtils.getPropertyRequest();
        var squareMetersProperty = 69.0;
        var got = PropertySquareMeterResponseMapper.assemblePropertySquareMeterResponseOf(expected, squareMetersProperty);

        assertEquals(expected.getPropertyName(), got.getPropertyName());
        assertEquals(squareMetersProperty, got.getSquareMeters());
    }

}
