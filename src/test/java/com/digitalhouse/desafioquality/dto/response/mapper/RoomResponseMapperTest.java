package com.digitalhouse.desafioquality.dto.response.mapper;

import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomResponseMapperTest {

    @Test
    public void shouldAssembleRoomResponse() {
        var expected = TestUtils.getRoom();

        var got = RoomResponseMapper.assembleRoomResponseOf(expected);

        assertEquals(expected.getRoomName(), got.getRoomName());
        assertEquals(expected.calculateSquareMeters(), got.getSquareMeters());
    }
}
