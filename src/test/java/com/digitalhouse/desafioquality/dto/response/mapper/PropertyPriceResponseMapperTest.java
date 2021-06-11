package com.digitalhouse.desafioquality.dto.response.mapper;

import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyPriceResponseMapperTest {

    @Test
    public void shouldAssemblePropertyPriceResponse() {
        var expected = TestUtils.getPropertyRequest();
        var propertyPrice = 6900.0;
        var got = PropertyPriceResponseMapper.assemblePropertyPriceResponseOf(expected, propertyPrice);

        assertEquals(expected.getPropertyName(), got.getPropertyName());
        assertEquals(propertyPrice, got.getPropertyPrice());
    }

}
