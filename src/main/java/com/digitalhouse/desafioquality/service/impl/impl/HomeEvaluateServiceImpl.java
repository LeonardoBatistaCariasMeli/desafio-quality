package com.digitalhouse.desafioquality.service.impl.impl;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.digitalhouse.desafioquality.dto.response.PropertyPriceResponse;
import com.digitalhouse.desafioquality.dto.response.PropertySquareMeterResponse;
import com.digitalhouse.desafioquality.dto.response.RoomResponse;
import com.digitalhouse.desafioquality.repository.NeighborhoodRepository;
import com.digitalhouse.desafioquality.service.impl.HomeEvaluateService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeEvaluateServiceImpl implements HomeEvaluateService {

    private final NeighborhoodRepository neighborhoodRepository;

    public HomeEvaluateServiceImpl(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    @Override
    public PropertySquareMeterResponse calculatePropertySquareMeters(PropertyRequest request) {
        var squareMetersProperty = this.calculateSquareMetersProperty(request.getRooms());
        return new PropertySquareMeterResponse(request.getPropertyName(), squareMetersProperty);
    }

    @Override
    public PropertyPriceResponse calculatePropertyPrice(PropertyRequest request) {
        var propertyValue = this.calculatePrice(request);
        return new PropertyPriceResponse(request.getPropertyName(), propertyValue);
    }

    private Double calculatePrice(PropertyRequest request) {
        var squareMeterValue = neighborhoodRepository.getSquareMeterValue(request.getPropertyDistrict());
        var squareMetersProperty = this.calculateSquareMetersProperty(request.getRooms());

        return squareMetersProperty * squareMeterValue;
    }

    private Double calculateSquareMetersProperty(List<RoomRequest> rooms) {
        return rooms.stream().map(RoomRequest::calculateSquareMeters).reduce(Double::sum).get();
    }

    @Override
    public RoomResponse calculateGreaterRoom(PropertyRequest request) {
        var higherRoom = request.getRooms().stream().max(Comparator.comparing(r -> r.calculateSquareMeters())).get();

        return this.assembleRoomResponseOf(higherRoom);
    }

    private RoomResponse assembleRoomResponseOf(RoomRequest request) {
        return new RoomResponse(request.getRoomName(), request.getRoomWidth(), request.getRoomLength(), request.calculateSquareMeters());
    }

    @Override
    public List<RoomResponse> calculateEachRoomsSquareMeters(PropertyRequest request) {
        return request.getRooms().stream().map(r -> this.assembleRoomResponseOf(r)).collect(Collectors.toList());
    }

}
