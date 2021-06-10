package com.digitalhouse.desafioquality.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PropertyResponse {

    private String propertyName;
    private String propertyNeighborhood;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double squareMetersTotal;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double squareMeterValue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double propertyValue;

    public PropertyResponse(String propertyName, String propertyNeighborhood, Double squareMetersTotal, Double squareMeterValue, Double propertyValue) {
        this.propertyName = propertyName;
        this.propertyNeighborhood = propertyNeighborhood;
        this.squareMetersTotal = squareMetersTotal;
        this.squareMeterValue = squareMeterValue;
        this.propertyValue = propertyValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyNeighborhood() {
        return propertyNeighborhood;
    }

    public Double getSquareMetersTotal() {
        return squareMetersTotal;
    }

    public Double getSquareMeterValue() {
        return squareMeterValue;
    }

    public Double getPropertyValue() {
        return propertyValue;
    }
}
