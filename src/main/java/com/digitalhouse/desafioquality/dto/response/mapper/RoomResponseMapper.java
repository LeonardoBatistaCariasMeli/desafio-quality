package com.digitalhouse.desafioquality.dto.response.mapper;

import com.digitalhouse.desafioquality.domain.Room;
import com.digitalhouse.desafioquality.dto.response.RoomResponse;

public interface RoomResponseMapper {

    static RoomResponse assembleRoomResponseOf(Room room) {
        return new RoomResponse(room.getRoomName(), room.getRoomWidth(), room.getRoomLength(), room.calculateSquareMeters());
    }
}
