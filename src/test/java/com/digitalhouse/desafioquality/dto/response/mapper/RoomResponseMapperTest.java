package com.digitalhouse.desafioquality.dto.response.mapper;

import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomResponseMapperTest {

    @Test
    public void shouldAssembleRoomResponse() {
        var expected = TestUtils.getPropertyRequest();
        var expectedRoom = expected.getRooms().get(0);

        var got = RoomResponseMapper.assembleRoomResponseOf(expectedRoom);

        assertEquals(expectedRoom.getRoomName(), got.getRoomName());
        assertEquals(expectedRoom.calculateSquareMeters(), got.getSquareMeters());
    }
}
