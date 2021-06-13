package com.digitalhouse.desafioquality.domain;

public class Room {
    private String roomName;
    private Double roomWidth;
    private Double roomLength;

    public Room(String roomName, Double roomWidth, Double roomLength) {
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
