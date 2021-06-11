package com.digitalhouse.desafioquality.dto.response.mapper;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.response.PropertySquareMeterResponse;

public interface PropertySquareMeterResponseMapper {

    static PropertySquareMeterResponse assemblePropertySquareMeterResponseOf(PropertyRequest request, Double squareMetersProperty) {
        return new PropertySquareMeterResponse(request.getPropertyName(), squareMetersProperty);
    }

}
