package com.digitalhouse.desafioquality.service.impl;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.digitalhouse.desafioquality.dto.response.PropertyPriceResponse;
import com.digitalhouse.desafioquality.dto.response.PropertySquareMeterResponse;
import com.digitalhouse.desafioquality.dto.response.RoomResponse;
import com.digitalhouse.desafioquality.dto.response.mapper.PropertyPriceResponseMapper;
import com.digitalhouse.desafioquality.dto.response.mapper.PropertySquareMeterResponseMapper;
import com.digitalhouse.desafioquality.dto.response.mapper.RoomResponseMapper;
import com.digitalhouse.desafioquality.repository.NeighborhoodRepository;
import com.digitalhouse.desafioquality.service.HomeEvaluateService;
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
        return PropertySquareMeterResponseMapper.assemblePropertySquareMeterResponseOf(request, squareMetersProperty);
    }

    @Override
    public PropertyPriceResponse calculatePropertyPrice(PropertyRequest request) {
        var propertyValue = this.calculatePrice(request);
        return PropertyPriceResponseMapper.assemblePropertyPriceResponseOf(request, propertyValue);
    }

    private Double calculatePrice(PropertyRequest request) {
        var squareMeterValue = this.neighborhoodRepository.getSquareMeterValue(request.getPropertyDistrict());
        var squareMetersProperty = this.calculateSquareMetersProperty(request.getRooms());

        return squareMetersProperty * squareMeterValue;
    }

    private Double calculateSquareMetersProperty(List<RoomRequest> rooms) {
        return rooms.stream().map(RoomRequest::calculateSquareMeters).reduce(Double::sum).get();
    }

    @Override
    public RoomResponse calculateGreaterRoom(PropertyRequest request) {
        var higherRoom = request.getRooms().stream().max(Comparator.comparing(r -> r.calculateSquareMeters())).get();

        return RoomResponseMapper.assembleRoomResponseOf(higherRoom);
    }

    @Override
    public List<RoomResponse> calculateEachRoomsSquareMeters(PropertyRequest request) {
        return request.getRooms().stream().map(r -> RoomResponseMapper.assembleRoomResponseOf(r)).collect(Collectors.toList());
    }

}
