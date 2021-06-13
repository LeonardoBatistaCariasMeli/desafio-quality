package com.digitalhouse.desafioquality.dto.request;

import com.digitalhouse.desafioquality.dto.request.validation.PropertyRequestValidation;

import javax.validation.Valid;
import java.util.List;

@PropertyRequestValidation
public class PropertyRequest {

    private String propertyName;
    private String propertyDistrict;

    @Valid
    private List<RoomRequest> rooms;

    public PropertyRequest(String propertyName, String propertyDistrict, List<RoomRequest> rooms) {
        this.propertyName = propertyName;
        this.propertyDistrict = propertyDistrict;
        this.rooms = rooms;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyDistrict() {
        return propertyDistrict;
    }

    public List<RoomRequest> getRooms() {
        return rooms;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setPropertyDistrict(String propertyDistrict) {
        this.propertyDistrict = propertyDistrict;
    }

    public void setRooms(List<RoomRequest> rooms) {
        this.rooms = rooms;
    }
}
