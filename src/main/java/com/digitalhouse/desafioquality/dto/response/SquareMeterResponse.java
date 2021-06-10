package com.digitalhouse.desafioquality.dto.response;

public class SquareMeterResponse {

    private String propertyName;
    private String propertyNeighborhood;
    private Double squareMetersTotal;
    private Double squareMeterValue;
    private Double propertyValue;

    public SquareMeterResponse(String propertyName, String propertyNeighborhood, Double squareMetersTotal, Double squareMeterValue, Double propertyValue) {
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
