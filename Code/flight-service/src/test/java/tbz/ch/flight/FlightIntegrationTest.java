package tbz.ch.flight;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.context.DynamicPropertySource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FlightIntegrationTest {

    @Container
    @ServiceConnection
    static final MySQLContainer<?> MYSQL =
            new MySQLContainer<>("mysql:8.0.36") // LTS
                    .withDatabaseName("flightdb")
                    .withUsername("test")
                    .withPassword("test");

    // RestTemplate, falls im Produktivcode keine Bean definiert ist
    @TestConfiguration
    static class TestBeans {
        @Bean RestTemplate restTemplate() { return new RestTemplate(); }
    }

    // ---------- WireMock auf 8080, weil FlightService auf http://localhost:8080/airports zeigt ----------
    static WireMockServer wireMock;

    @BeforeAll
    static void startWireMock() {
        wireMock = new WireMockServer(8080);
        wireMock.start();
        wireMock.stubFor(
                com.github.tomakehurst.wiremock.client.WireMock.get(urlEqualTo("/airports"))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("""
                    [
                      {"id":1,"name":"Zurich","code":"ZRH","capacity":100,"createdAt":"2025-01-01T10:00:00"},
                      {"id":2,"name":"London Heathrow","code":"LHR","capacity":200,"createdAt":"2025-01-01T10:00:00"}
                    ]
                    """)
                                .withStatus(200)));
    }

    @AfterAll
    static void stopWireMock() {
        if (wireMock != null) wireMock.stop();
    }

    @Autowired
    MockMvc mockMvc;

    @Test
    void createFlight_success_returns200_andPersists() throws Exception {
        String body = """
      {
        "departureAirportCode": "ZRH",
        "arrivalAirportCode": "LHR",
        "departureDatetime": "%s",
        "arrivalDatetime": "%s",
        "aircraftType": "A320"
      }
      """.formatted(
                java.time.LocalDateTime.now().plusHours(3),
                java.time.LocalDateTime.now().plusHours(5)
        );

        mockMvc.perform(post("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.departureAirportCode").value("ZRH"))
                .andExpect(jsonPath("$.arrivalAirportCode").value("LHR"))
                .andExpect(jsonPath("$.aircraftType").value("A320"));
    }

    @Test
    void createFlight_pastDeparture_returns400() throws Exception {
        String body = """
      {
        "departureAirportCode": "ZRH",
        "arrivalAirportCode": "LHR",
        "departureDatetime": "%s",
        "arrivalDatetime": "%s",
        "aircraftType": "A320"
      }
      """.formatted(
                java.time.LocalDateTime.now().minusHours(1),
                java.time.LocalDateTime.now().plusHours(2)
        );

        mockMvc.perform(post("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Departure time must be in the future."));
    }

    @Test
    void getAllFlights_returnsList() throws Exception {
        mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void createFlight_sameAirports_returns400() throws Exception {
        String body = """
      {
        "departureAirportCode": "ZRH",
        "arrivalAirportCode": "ZRH",
        "departureDatetime": "%s",
        "arrivalDatetime": "%s",
        "aircraftType": "B737"
      }
      """.formatted(
                java.time.LocalDateTime.now().plusHours(3),
                java.time.LocalDateTime.now().plusHours(4)
        );

        mockMvc.perform(post("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Arrival and departure airports must be different."));
    }

    @Test
    void createFlight_invalidTimeSequence_returns400() throws Exception {
        String body = """
      {
        "departureAirportCode": "ZRH",
        "arrivalAirportCode": "LHR",
        "departureDatetime": "%s",
        "arrivalDatetime": "%s",
        "aircraftType": "A321"
      }
      """.formatted(
                java.time.LocalDateTime.now().plusHours(5),
                java.time.LocalDateTime.now().plusHours(3)
        );

        mockMvc.perform(post("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid time sequence: Arrival must be after departure."));
    }

    @Test
    void createFlight_unknownAirport_returns400() throws Exception {
        String body = """
      {
        "departureAirportCode": "ZRH",
        "arrivalAirportCode": "XXX",
        "departureDatetime": "%s",
        "arrivalDatetime": "%s",
        "aircraftType": "A220"
      }
      """.formatted(
                java.time.LocalDateTime.now().plusHours(3),
                java.time.LocalDateTime.now().plusHours(5)
        );

        mockMvc.perform(post("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Arrival airport doesn't exist."));
    }
}
