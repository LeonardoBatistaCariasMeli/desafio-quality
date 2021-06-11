package com.digitalhouse.desafioquality.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoomRequest {
    @Size(min = 3, max = 30, message = "The room name must be between 3 or 30 characters.")
    @NotNull
    private String roomName;
    private Double roomWidth;
    private Double roomLength;

    public RoomRequest(String roomName, Double roomWidth, Double roomLength) {
        this.roomName = roomName;
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
    }

    public String getRoomName() {
        return roomName;
    }

    public Double getRoomWidth() {
        return roomWidth;
    }

    public Double getRoomLength() {
        return roomLength;
    }

    public Double calculateSquareMeters() {
        return this.roomWidth * this.roomLength;
    }
}
