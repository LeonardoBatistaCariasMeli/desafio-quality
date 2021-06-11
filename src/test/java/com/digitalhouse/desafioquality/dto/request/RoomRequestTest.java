package com.digitalhouse.desafioquality.dto.request;

import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomRequestTest {

    @Test
    public void shouldCalculateSquareMeterRoom() {
        var room = TestUtils.getRoomRequest();
        var got = room.calculateSquareMeters();
        assertEquals(24.0, got);
    }
}
