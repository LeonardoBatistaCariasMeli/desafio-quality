package com.digitalhouse.desafioquality.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class HomeRequest {

    @Size(min = 3, max = 30, message = "The property name must be between 3 or 30 characters.")
    @NotNull
    private String propertyName;
    @Size(min = 3, max = 30, message = "The property district must be between 3 or 45 characters.")
    @NotNull
    private String propertyDistrict;
    @NotEmpty
    @NotNull
    private List<RoomRequest> rooms;

    public HomeRequest(String propertyName, String propertyDistrict, List<RoomRequest> rooms) {
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
}
