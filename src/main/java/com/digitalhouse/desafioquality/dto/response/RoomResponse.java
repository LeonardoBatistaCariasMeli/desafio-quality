package com.digitalhouse.desafioquality.dto.response;

public class RoomResponse {
    private String roomName;
    private Double roomWidth;
    private Double roomLength;
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
