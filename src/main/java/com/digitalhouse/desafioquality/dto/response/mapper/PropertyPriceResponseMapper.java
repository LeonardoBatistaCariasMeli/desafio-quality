package com.digitalhouse.desafioquality.dto.response.mapper;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.response.PropertyPriceResponse;

public interface PropertyPriceResponseMapper {

    static PropertyPriceResponse assemblePropertyPriceResponseOf(PropertyRequest request, Double propertyValue) {
        return new PropertyPriceResponse(request.getPropertyName(), propertyValue);
    }

}
