package com.digitalhouse.desafioquality.dto.response;

public class RoomResponse {
    private String roomName;
    private Double roomWidth;
    private Double roomLength;

    public RoomResponse(String roomName, Double roomWidth, Double roomLength) {
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
