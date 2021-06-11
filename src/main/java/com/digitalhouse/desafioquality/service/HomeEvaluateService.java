package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.response.PropertyPriceResponse;
import com.digitalhouse.desafioquality.dto.response.PropertySquareMeterResponse;
import com.digitalhouse.desafioquality.dto.response.RoomResponse;

import java.util.List;

public interface HomeEvaluateService {

    public PropertySquareMeterResponse calculatePropertySquareMeters(PropertyRequest request);

    public PropertyPriceResponse calculatePropertyPrice(PropertyRequest request);

    public RoomResponse calculateGreaterRoom(PropertyRequest request);

    public List<RoomResponse> calculateEachRoomsSquareMeters(PropertyRequest request);
}
