package com.digitalhouse.desafioquality.dto.request;

import com.digitalhouse.desafioquality.dto.request.validation.PropertyNameValidation;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PropertyRequest {

    @PropertyNameValidation
    private String propertyName;

    @Size(min = 3, max = 45, message = "The property district must be between 3 or 45 characters.")
    @NotBlank(message = "Mandatory filling")
    private String propertyDistrict;

    @NotNull
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
