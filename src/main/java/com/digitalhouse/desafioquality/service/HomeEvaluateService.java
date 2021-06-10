package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.dto.request.HomeRequest;
import com.digitalhouse.desafioquality.dto.response.HomeResponse;
import com.digitalhouse.desafioquality.dto.response.SquareMeterResponse;

public interface HomeEvaluateService {

    public SquareMeterResponse calculateSquareMeters(HomeRequest request);
    public HomeResponse calculatePropertyPrice(HomeRequest request);
    public HomeResponse calculateGreaterRoom(HomeRequest request);
    public HomeResponse calculateEachRoomsSquareMeters(HomeRequest request);
}
