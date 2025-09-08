package tbz.ch.airport;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import tbz.ch.airport.controller.AirportController;
import tbz.ch.airport.dto.AirportResponse;
import tbz.ch.airport.repository.AirportRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AirportControllerTests {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportController airportController;

    @Test
    void testGetAllAirports_returnsEmptyList() {
        when(airportRepository.findAll()).thenReturn(Collections.emptyList());

        List<AirportResponse> result = airportController.getAllAirports();

        assertEquals(0, result.size());
    }
}
