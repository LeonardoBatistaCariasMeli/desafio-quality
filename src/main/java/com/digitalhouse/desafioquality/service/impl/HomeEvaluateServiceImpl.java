package com.digitalhouse.desafioquality.service.impl;

import com.digitalhouse.desafioquality.dto.request.HomeRequest;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.digitalhouse.desafioquality.dto.response.HomeResponse;
import com.digitalhouse.desafioquality.dto.response.SquareMeterResponse;
import com.digitalhouse.desafioquality.repository.NeighborhoodRepository;
import com.digitalhouse.desafioquality.service.HomeEvaluateService;
import org.springframework.stereotype.Service;

@Service
public class HomeEvaluateServiceImpl implements HomeEvaluateService {

    private final NeighborhoodRepository neighborhoodRepository;

    public HomeEvaluateServiceImpl(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    @Override
    public SquareMeterResponse calculateSquareMeters(HomeRequest request) {
        var squareMeterValue = neighborhoodRepository.getSquareMeterValue(request.getPropertyDistrict());
        var squareMetersTotal = request.getRooms().stream().map(RoomRequest::calculateSquareMeters).reduce(Double::sum).get();
        var propertyValue = squareMetersTotal * squareMeterValue;
        return new SquareMeterResponse(request.getPropertyName(), request.getPropertyDistrict(), squareMetersTotal, squareMeterValue, propertyValue);
    }

    @Override
    public HomeResponse calculatePropertyPrice(HomeRequest request) {
        return null;
    }

    @Override
    public HomeResponse calculateGreaterRoom(HomeRequest request) {
        return null;
    }

    @Override
    public HomeResponse calculateEachRoomsSquareMeters(HomeRequest request) {
        return null;
    }
}
