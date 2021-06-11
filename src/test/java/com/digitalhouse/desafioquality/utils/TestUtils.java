package com.digitalhouse.desafioquality.utils;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public interface TestUtils {
    static final ObjectMapper MAPPER = new ObjectMapper();

    static PropertyRequest getPropertyRequest() {
        var rooms = getListRoomRequest();
        return new PropertyRequest("Condominio de Casas", "Adalgisa", rooms);
    }

    static List<RoomRequest> getListRoomRequest() {
        var rooms = new ArrayList<RoomRequest>();
        rooms.add(new RoomRequest("Cozinha", 4.0, 6.0));
        rooms.add(new RoomRequest("Sala", 5.0, 7.0));
        rooms.add(new RoomRequest("Quarto", 2.5, 4.0));
        return rooms;
    }

    static RoomRequest getRoomRequest() {
        return new RoomRequest("Cozinha", 4.0, 6.0);
    }

    static PropertyRequest getPropertyRequestInvalid() {
        var rooms = getListRoomRequest();
        return new PropertyRequest("con", "ada", rooms);
    }

    static String getValidRequest() throws JsonProcessingException {
        var request = getPropertyRequest();
        return MAPPER.writeValueAsString(request);
    }

    static String getInvalidRequest() throws JsonProcessingException {
        var request = getPropertyRequestInvalid();
        return MAPPER.writeValueAsString(request);
    }
}
