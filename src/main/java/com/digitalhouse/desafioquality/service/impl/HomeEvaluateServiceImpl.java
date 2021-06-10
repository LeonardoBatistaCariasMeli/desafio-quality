package com.digitalhouse.desafioquality.service.impl;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.digitalhouse.desafioquality.dto.response.PropertyResponse;
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
    public PropertyResponse calculateSquareMeters(PropertyRequest request) {
        var squareMetersTotal = request.getRooms().stream().map(RoomRequest::calculateSquareMeters).reduce(Double::sum).get();
        return new PropertyResponse(request.getPropertyName(), request.getPropertyDistrict(), squareMetersTotal, null, null);
    }

    @Override
    public PropertyResponse calculatePropertyPrice(PropertyRequest request) {
        var propertyValue = this.calculatePrice(request);
        return new PropertyResponse(request.getPropertyName(), request.getPropertyDistrict(), null, null, propertyValue);
    }

    private Double calculatePrice(PropertyRequest request) {
        var squareMeterValue = neighborhoodRepository.getSquareMeterValue(request.getPropertyDistrict());
        var squareMetersTotal = request.getRooms().stream().map(RoomRequest::calculateSquareMeters).reduce(Double::sum).get();

        return squareMetersTotal * squareMeterValue;
    }

    @Override
    public PropertyResponse calculateGreaterRoom(PropertyRequest request) {
        return null;
    }

    @Override
    public PropertyResponse calculateEachRoomsSquareMeters(PropertyRequest request) {
        return null;
    }
}
