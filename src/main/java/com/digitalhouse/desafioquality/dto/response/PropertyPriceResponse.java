package com.digitalhouse.desafioquality.dto.response;

public class PropertyPriceResponse {

    private String propertyName;
    private Double propertyPrice;

    public PropertyPriceResponse(String propertyName, Double propertyPrice) {
        this.propertyName = propertyName;
        this.propertyPrice = propertyPrice;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Double getPropertyPrice() {
        return propertyPrice;
    }
}
