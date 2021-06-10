package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.response.PropertyResponse;
import com.digitalhouse.desafioquality.dto.response.RoomResponse;

public interface HomeEvaluateService {

    public PropertyResponse calculateSquareMeters(PropertyRequest request);

    public PropertyResponse calculatePropertyPrice(PropertyRequest request);

    public RoomResponse calculateGreaterRoom(PropertyRequest request);

    public PropertyResponse calculateEachRoomsSquareMeters(PropertyRequest request);
}
