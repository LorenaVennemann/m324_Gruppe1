package tbz.ch.airport.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tbz.ch.airport.dto.AirportResponse;
import tbz.ch.airport.entity.Airport;
import tbz.ch.airport.repository.AirportRepository;

import java.time.LocalDateTime;
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

        assertEquals(0, result.size(), "Liste sollte leer sein, wenn keine Airports existieren");
    }

    @Test
    void testGetAllAirports_returnsAirportList() {
        Airport airport = new Airport();
        airport.setId(1);
        airport.setName("Zürich Airport");
        airport.setCode("ZRH");
        airport.setCapacity(50000);
        airport.setCreatedAt(LocalDateTime.of(2025, 1, 1, 12, 0));

        when(airportRepository.findAll()).thenReturn(List.of(airport));

        List<AirportResponse> result = airportController.getAllAirports();

        assertEquals(1, result.size(), "Liste sollte genau 1 Airport enthalten");

        AirportResponse response = result.get(0);
        assertEquals(1, response.getId());
        assertEquals("Zürich Airport", response.getName());
        assertEquals("ZRH", response.getCode());
        assertEquals(50000, response.getCapacity());
        assertEquals(LocalDateTime.of(2025, 1, 1, 12, 0), response.getCreatedAt());
    }
}
