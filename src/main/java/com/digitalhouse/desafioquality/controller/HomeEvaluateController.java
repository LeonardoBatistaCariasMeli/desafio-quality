package com.digitalhouse.desafioquality.controller;


import com.digitalhouse.desafioquality.dto.request.HomeRequest;
import com.digitalhouse.desafioquality.dto.response.HomeResponse;
import com.digitalhouse.desafioquality.dto.response.SquareMeterResponse;
import com.digitalhouse.desafioquality.service.HomeEvaluateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home-evaluate")
public class HomeEvaluateController {

    private final HomeEvaluateService homeEvaluateService;

    public HomeEvaluateController(HomeEvaluateService homeEvaluateService) {
        this.homeEvaluateService = homeEvaluateService;
    }

    @PostMapping("/square-meters")
    public ResponseEntity<SquareMeterResponse> calculateSquareMeters(@RequestBody HomeRequest request) {
        var response = this.homeEvaluateService.calculateSquareMeters(request);
        return ResponseEntity.ok().body(response);
    }

}
