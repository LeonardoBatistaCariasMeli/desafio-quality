package com.digitalhouse.desafioquality.domain;

import com.digitalhouse.desafioquality.domain.mapper.RoomMapper;
import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {

    @Test
    public void shouldCalculateSquareMeterRoom() {
        var room = TestUtils.getRoom();
        var got = room.calculateSquareMeters();
        assertEquals(24.0, got);
    }
}
