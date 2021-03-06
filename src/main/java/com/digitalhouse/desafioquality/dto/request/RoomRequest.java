package com.digitalhouse.desafioquality.dto.request;

import com.digitalhouse.desafioquality.dto.request.validation.RoomRequestValidation;

@RoomRequestValidation
public class RoomRequest {
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
}
