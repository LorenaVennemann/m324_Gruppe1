package tbz.ch.flight;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tbz.ch.flight.controller.FlightController;
import tbz.ch.flight.dto.FlightRequest;
import tbz.ch.flight.dto.FlightResponse;
import tbz.ch.flight.service.FlightService;
import org.apache.coyote.BadRequestException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FlightController.class)
class FlightApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @MockBean
    private FlightService flightService;

    @Autowired
    private ObjectMapper objectMapper;

    private FlightResponse sampleFlight;

    @BeforeEach
    void setUp() {
        sampleFlight = new FlightResponse();
        sampleFlight.setId(1);
        sampleFlight.setDepartureAirportCode("ZUR");
        sampleFlight.setArrivalAirportCode("LHR");
        sampleFlight.setAircraftType("Boeing 737");
        sampleFlight.setCreatedAt(LocalDateTime.now());
    }

    @Nested
    @DisplayName("POST /flights - Create Flight")
    class CreateFlightTests {

        @Nested
        @DisplayName("Happy Path Tests")
        class HappyPathTests {

            @Test
            @DisplayName("Should create flight with valid data")
            void shouldCreateFlightWithValidData() throws Exception {
                FlightRequest request = new FlightRequest();
                request.setDepartureAirportCode("ZUR");
                request.setArrivalAirportCode("LHR");
                request.setDepartureDatetime(LocalDateTime.now().plusHours(2));
                request.setArrivalDatetime(LocalDateTime.now().plusHours(4));
                request.setAircraftType("Boeing 737");

                when(flightService.createFlight(any(FlightRequest.class))).thenReturn(sampleFlight);

                mockMvc.perform(post("/flights")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.departureAirportCode").value("ZUR"))
                        .andExpect(jsonPath("$.arrivalAirportCode").value("LHR"))
                        .andExpect(jsonPath("$.aircraftType").value("Boeing 737"));
            }

            @Test
            @DisplayName("Should create flight with different airports")
            void shouldCreateFlightWithDifferentAirports() throws Exception {
                FlightRequest request = new FlightRequest();
                request.setDepartureAirportCode("GVA");
                request.setArrivalAirportCode("FRA");
                request.setDepartureDatetime(LocalDateTime.now().plusHours(3));
                request.setArrivalDatetime(LocalDateTime.now().plusHours(5));
                request.setAircraftType("Airbus A320");

                when(flightService.createFlight(any(FlightRequest.class))).thenReturn(sampleFlight);

                mockMvc.perform(post("/flights")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isOk());
            }
        }

        @Test
        void shouldReturn400WhenDepartureAirportInvalid() throws Exception {
            FlightRequest request = new FlightRequest();
            request.setDepartureAirportCode("XXX");
            request.setArrivalAirportCode("LHR");
            request.setDepartureDatetime(LocalDateTime.now().plusHours(2));
            request.setArrivalDatetime(LocalDateTime.now().plusHours(4));
            request.setAircraftType("Boeing 737");

            when(flightService.createFlight(any(FlightRequest.class)))
                    .thenThrow(new BadRequestException("Departure airport doesn't exist."));

            mockMvc.perform(post("/flights")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }

        @Test
        void shouldReturn400WhenArrivalAirportInvalid() throws Exception {
            FlightRequest request = new FlightRequest();
            request.setDepartureAirportCode("ZUR");
            request.setArrivalAirportCode("XXX");
            request.setDepartureDatetime(LocalDateTime.now().plusHours(2));
            request.setArrivalDatetime(LocalDateTime.now().plusHours(4));
            request.setAircraftType("Boeing 737");

            when(flightService.createFlight(any(FlightRequest.class)))
                    .thenThrow(new BadRequestException("Arrival airport doesn't exist."));

            mockMvc.perform(post("/flights")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }

        @Test
        void shouldReturn400WhenSameAirports() throws Exception {
            FlightRequest request = new FlightRequest();
            request.setDepartureAirportCode("ZUR");
            request.setArrivalAirportCode("ZUR");
            request.setDepartureDatetime(LocalDateTime.now().plusHours(2));
            request.setArrivalDatetime(LocalDateTime.now().plusHours(4));
            request.setAircraftType("Boeing 737");

            when(flightService.createFlight(any(FlightRequest.class)))
                    .thenThrow(new BadRequestException("Airports must be different."));

            mockMvc.perform(post("/flights")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }

        @Test
        void shouldReturn400WhenDepartureInPast() throws Exception {
            FlightRequest request = new FlightRequest();
            request.setDepartureAirportCode("ZUR");
            request.setArrivalAirportCode("LHR");
            request.setDepartureDatetime(LocalDateTime.now().minusHours(1));
            request.setArrivalDatetime(LocalDateTime.now().plusHours(2));
            request.setAircraftType("Boeing 737");

            when(flightService.createFlight(any(FlightRequest.class)))
                    .thenThrow(new BadRequestException("Departure must be in future."));

            mockMvc.perform(post("/flights")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }

        @Test
        void shouldReturn400WhenArrivalBeforeDeparture() throws Exception {
            FlightRequest request = new FlightRequest();
            request.setDepartureAirportCode("ZUR");
            request.setArrivalAirportCode("LHR");
            request.setDepartureDatetime(LocalDateTime.now().plusHours(4));
            request.setArrivalDatetime(LocalDateTime.now().plusHours(2));
            request.setAircraftType("Boeing 737");

            when(flightService.createFlight(any(FlightRequest.class)))
                    .thenThrow(new BadRequestException("Arrival must be after departure."));

            mockMvc.perform(post("/flights")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());
        }

        @Test
        void shouldReturnEmptyListWhenNoFlights() throws Exception {
            when(flightService.getAllFlights()).thenReturn(List.of());

            mockMvc.perform(get("/flights"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(0));
        }
    }

    @Nested
    @DisplayName("GET /flights - Get All Flights")
    class GetAllFlightsTests {

        @Test
        @DisplayName("Should return all flights when flights exist")
        void shouldReturnAllFlightsWhenFlightsExist() throws Exception {
            FlightResponse flight1 = new FlightResponse();
            flight1.setId(1);
            flight1.setDepartureAirportCode("ZUR");
            flight1.setArrivalAirportCode("LHR");

            List<FlightResponse> flights = Arrays.asList(flight1);
            when(flightService.getAllFlights()).thenReturn(flights);

            mockMvc.perform(get("/flights"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].departureAirportCode").value("ZUR"));
        }

        @Test
        @DisplayName("Should return empty list when no flights exist")
        void shouldReturnEmptyListWhenNoFlightsExist() throws Exception {
            when(flightService.getAllFlights()).thenReturn(List.of());

            mockMvc.perform(get("/flights"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(0));
        }
    }
}