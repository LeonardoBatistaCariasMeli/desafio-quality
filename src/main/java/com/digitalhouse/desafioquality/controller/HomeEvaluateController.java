package com.digitalhouse.desafioquality.controller;


import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.response.PropertyPriceResponse;
import com.digitalhouse.desafioquality.dto.response.PropertySquareMeterResponse;
import com.digitalhouse.desafioquality.dto.response.RoomResponse;
import com.digitalhouse.desafioquality.service.HomeEvaluateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/home-evaluate")
public class HomeEvaluateController {

    private final HomeEvaluateService homeEvaluateService;

    public HomeEvaluateController(HomeEvaluateService homeEvaluateService) {
        this.homeEvaluateService = homeEvaluateService;
    }

    @PostMapping("/square-meters")
    public ResponseEntity<PropertySquareMeterResponse> calculatePropertySquareMeters(@Valid @RequestBody PropertyRequest request) {
        var response = this.homeEvaluateService.calculatePropertySquareMeters(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/property-price")
    public ResponseEntity<PropertyPriceResponse> calculatePropertyPrice(@Valid @RequestBody PropertyRequest request) {
        var response = this.homeEvaluateService.calculatePropertyPrice(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/greater-room")
    public ResponseEntity<RoomResponse> calculateGreaterRoom(@Valid @RequestBody PropertyRequest request) {
        var response = this.homeEvaluateService.calculateGreaterRoom(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/square-meters-rooms")
    public ResponseEntity<List<RoomResponse>> calculateEachRoomsSquareMeters(@Valid @RequestBody PropertyRequest request) {
        var response = this.homeEvaluateService.calculateEachRoomsSquareMeters(request);
        return ResponseEntity.ok().body(response);
    }
}
