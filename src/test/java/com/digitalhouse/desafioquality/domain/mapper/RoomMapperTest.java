package com.digitalhouse.desafioquality.domain.mapper;

import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomMapperTest {

    @Test
    public void shouldAssembleRoom() {
        var expected = TestUtils.getRoomRequest();
        var got = RoomMapper.assembleRoomOf(expected);

        assertEquals(expected.getRoomName(), got.getRoomName());
    }

}
