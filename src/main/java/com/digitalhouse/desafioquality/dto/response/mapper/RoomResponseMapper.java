package com.digitalhouse.desafioquality.dto.response.mapper;

import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.digitalhouse.desafioquality.dto.response.RoomResponse;

public interface RoomResponseMapper {

    static RoomResponse assembleRoomResponseOf(RoomRequest request) {
        return new RoomResponse(request.getRoomName(), request.getRoomWidth(), request.getRoomLength(), request.calculateSquareMeters());
    }
}
