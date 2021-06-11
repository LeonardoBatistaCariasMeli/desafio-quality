package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.repository.NeighborhoodRepository;
import com.digitalhouse.desafioquality.service.impl.HomeEvaluateServiceImpl;
import com.digitalhouse.desafioquality.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HomeEvaluateServiceImplTest {

    @InjectMocks
    private HomeEvaluateServiceImpl homeEvaluateService;

    @Mock
    private NeighborhoodRepository neighborhoodRepository;

    @Test
    public void shouldCalculatePropertySquareMeters() {
        var request = TestUtils.getPropertyRequest();
        var got = homeEvaluateService.calculatePropertySquareMeters(request);
        assertEquals(69.0, got.getSquareMeters());
    }

    @Test
    public void shouldCalculatePropertyPrice() {
        var request = TestUtils.getPropertyRequest();

        BDDMockito.given(this.neighborhoodRepository.getSquareMeterValue(Mockito.anyString())).willReturn(100.0);
        var got = homeEvaluateService.calculatePropertyPrice(request);

        assertEquals(6900.0, got.getPropertyPrice());
    }

    @Test
    public void shouldCalculateGreaterRoom() {
        var request = TestUtils.getPropertyRequest();
        var expected = request.getRooms().get(1);
        var got = homeEvaluateService.calculateGreaterRoom(request);

        assertEquals(expected.getRoomName(), got.getRoomName());
    }

    @Test
    public void shouldCalculateEachRoomsSquareMeters() {
        var request = TestUtils.getPropertyRequest();
        var got = homeEvaluateService.calculateEachRoomsSquareMeters(request);

        assertEquals(24, got.get(0).getSquareMeters());
        assertEquals(35, got.get(1).getSquareMeters());
        assertEquals(10, got.get(2).getSquareMeters());
    }

}
