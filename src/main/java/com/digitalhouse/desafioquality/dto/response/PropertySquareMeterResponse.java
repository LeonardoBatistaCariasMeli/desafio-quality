package com.digitalhouse.desafioquality.dto.response;

public class PropertySquareMeterResponse {

    private String propertyName;
    private Double squareMeters;

    public PropertySquareMeterResponse(String propertyName, Double squareMeters) {
        this.propertyName = propertyName;
        this.squareMeters = squareMeters;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Double getSquareMeters() {
        return squareMeters;
    }
}
