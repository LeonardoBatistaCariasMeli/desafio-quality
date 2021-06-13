package com.digitalhouse.desafioquality.domain.mapper;

import com.digitalhouse.desafioquality.domain.Room;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;

import java.util.List;
import java.util.stream.Collectors;

public interface RoomMapper {

    static List<Room> assembleListRoomOf(List<RoomRequest> list) {
        return list.stream().map(RoomMapper::assembleRoomOf).collect(Collectors.toList());
    }

    static Room assembleRoomOf(RoomRequest request) {
        return new Room(request.getRoomName(), request.getRoomWidth(), request.getRoomLength());
    }
}
