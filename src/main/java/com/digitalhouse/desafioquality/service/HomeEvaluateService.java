package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.response.PropertyResponse;

public interface HomeEvaluateService {

    public PropertyResponse calculateSquareMeters(PropertyRequest request);

    public PropertyResponse calculatePropertyPrice(PropertyRequest request);

    public PropertyResponse calculateGreaterRoom(PropertyRequest request);

    public PropertyResponse calculateEachRoomsSquareMeters(PropertyRequest request);
}
