package com.digitalhouse.desafioquality.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RoomResponse {
    private String roomName;
    private Double roomWidth;
    private Double roomLength;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double squareMeters;

    public RoomResponse(String roomName, Double roomWidth, Double roomLength, Double squareMeters) {
        this.roomName = roomName;
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
        this.squareMeters = squareMeters;
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

    public Double getSquareMeters() {
        return squareMeters;
    }
}
