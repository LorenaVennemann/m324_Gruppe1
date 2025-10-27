package tbz.ch.flight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import tbz.ch.flight.dto.FlightRequest;
import tbz.ch.flight.entity.Flight;
import tbz.ch.flight.repository.FlightRepository;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@WireMockTest(httpPort = 8083)
@TestPropertySource(properties = {
        "airport.service.url=http://localhost:8083"
})
public class FlightIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FlightRepository flightRepository;

    private void setupAirportMocks() {
        String[] airportCodes = {"BER", "VIE", "MUC", "CDG", "OSL", "HEL"};
        for (String code : airportCodes) {
            WireMock.stubFor(WireMock.get(WireMock.urlMatching("/airports/" + code))
                    .willReturn(WireMock.aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody("{\"code\": \"" + code + "\", \"name\": \"Flughafen " + code + "\", \"capacity\": \"10000\"}")));
        }
    }

    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();
        setupAirportMocks();
    }

    @Test
    void shouldCreateFlight_and_SaveToDatabase() throws Exception {
        FlightRequest request = new FlightRequest();
        request.setDepartureAirportCode("BER");
        request.setArrivalAirportCode("VIE");
        request.setDepartureDatetime(LocalDateTime.now().plusHours(5));
        request.setArrivalDatetime(LocalDateTime.now().plusHours(7));
        request.setAircraftType("Airbus A321");

        mockMvc.perform(post("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departureAirportCode").value("BER"));

        assertThat(flightRepository.count()).isEqualTo(1);
        Flight savedFlight = flightRepository.findAll().getFirst();
        assertThat(savedFlight.getDepartureAirportCode()).isEqualTo("BER");
        assertThat(savedFlight.getArrivalAirportCode()).isEqualTo("VIE");

        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/airports/BER")));
        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/airports/VIE")));
    }

    @Test
    void shouldReturnFlights_FromDatabase() throws Exception {
        LocalDateTime now = LocalDateTime.now();

        Flight flight1 = new Flight();
        flight1.setDepartureAirportCode("MUC");
        flight1.setArrivalAirportCode("CDG");
        flight1.setDepartureDatetime(now.plusHours(5));
        flight1.setArrivalDatetime(now.plusHours(7));
        flight1.setAircraftType("Airbus A321");
        flightRepository.save(flight1);

        Flight flight2 = new Flight();
        flight2.setDepartureAirportCode("OSL");
        flight2.setArrivalAirportCode("HEL");
        flight2.setDepartureDatetime(now.plusHours(10));
        flight2.setArrivalDatetime(now.plusHours(12));
        flight2.setAircraftType("Boeing 737");
        flightRepository.save(flight2);

        mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].departureAirportCode").value("MUC"))
                .andExpect(jsonPath("$[1].arrivalAirportCode").value("HEL"));
    }
}