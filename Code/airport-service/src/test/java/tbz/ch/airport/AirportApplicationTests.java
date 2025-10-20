package tbz.ch.airport;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tbz.ch.airport.controller.AirportController;
import tbz.ch.airport.dto.AirportRequest;
import tbz.ch.airport.entity.Airport;
import tbz.ch.airport.repository.AirportRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AirportController.class)
class AirportApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @MockitoBean
    private AirportRepository airportRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Airport sampleAirport;

    @BeforeEach
    void setUp() {
        sampleAirport = new Airport();
        sampleAirport.setId(1);
        sampleAirport.setName("Zurich Airport");
        sampleAirport.setCode("ZUR");
        sampleAirport.setCapacity(1000);
        sampleAirport.setCreatedAt(LocalDateTime.now());
    }

    @Nested
    @DisplayName("POST /airports - Create Airport")
    class CreateAirportTests {

        @Nested
        @DisplayName("Happy Path Tests")
        class HappyPathTests {

            @Test
            @DisplayName("Should create airport with valid data")
            void shouldCreateAirportWithValidData() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Zurich Airport");
                request.setCode("ZUR");
                request.setCapacity(1000);

                when(airportRepository.save(any(Airport.class))).thenReturn(sampleAirport);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.id").value(1))
                        .andExpect(jsonPath("$.name").value("Zurich Airport"))
                        .andExpect(jsonPath("$.code").value("ZUR"))
                        .andExpect(jsonPath("$.capacity").value(1000));
            }

            @Test
            @DisplayName("Should create airport with minimum valid capacity")
            void shouldCreateAirportWithMinimumCapacity() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Small Airport");
                request.setCode("SML");
                request.setCapacity(1);

                Airport smallAirport = new Airport();
                smallAirport.setId(2);
                smallAirport.setName("Small Airport");
                smallAirport.setCode("SML");
                smallAirport.setCapacity(1);
                smallAirport.setCreatedAt(LocalDateTime.now());

                when(airportRepository.save(any(Airport.class))).thenReturn(smallAirport);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.capacity").value(1));
            }

            @Test
            @DisplayName("Should create airport with uppercase code")
            void shouldCreateAirportWithUppercaseCode() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Frankfurt Airport");
                request.setCode("FRA");
                request.setCapacity(500);

                Airport airport = new Airport();
                airport.setId(3);
                airport.setName("Frankfurt Airport");
                airport.setCode("FRA");
                airport.setCapacity(500);
                airport.setCreatedAt(LocalDateTime.now());

                when(airportRepository.save(any(Airport.class))).thenReturn(airport);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.code").value("FRA"));
            }
        }

        @Nested
        @DisplayName("Sad Path Tests - Code Validation")
        class CodeValidationTests {

            @Test
            @DisplayName("Should return 400 when code is empty")
            void shouldReturn400WhenCodeIsEmpty() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Test Airport");
                request.setCode("");
                request.setCapacity(100);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when code is null")
            void shouldReturn400WhenCodeIsNull() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Test Airport");
                request.setCode(null);
                request.setCapacity(100);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when code has only 1 character")
            void shouldReturn400WhenCodeHasOneCharacter() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Test Airport");
                request.setCode("Z");
                request.setCapacity(100);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when code has only 2 characters")
            void shouldReturn400WhenCodeHasTwoCharacters() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Test Airport");
                request.setCode("ZU");
                request.setCapacity(100);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when code has more than 3 characters")
            void shouldReturn400WhenCodeHasMoreThanThreeCharacters() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Test Airport");
                request.setCode("ZURH");
                request.setCapacity(100);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }
        }

        @Nested
        @DisplayName("Sad Path Tests - Capacity Validation")
        class CapacityValidationTests {

            @Test
            @DisplayName("Should return 400 when capacity is negative")
            void shouldReturn400WhenCapacityIsNegative() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Test Airport");
                request.setCode("TST");
                request.setCapacity(-1);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when capacity is zero")
            void shouldReturn400WhenCapacityIsZero() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Test Airport");
                request.setCode("TST");
                request.setCapacity(0);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when capacity is too large")
            void shouldReturn400WhenCapacityIsTooLarge() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("Test Airport");
                request.setCode("TST");
                request.setCapacity(Integer.MAX_VALUE);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }
        }

        @Nested
        @DisplayName("Sad Path Tests - Name Validation")
        class NameValidationTests {

            @Test
            @DisplayName("Should return 400 when name is empty")
            void shouldReturn400WhenNameIsEmpty() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName("");
                request.setCode("TST");
                request.setCapacity(100);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when name is null")
            void shouldReturn400WhenNameIsNull() throws Exception {
                AirportRequest request = new AirportRequest();
                request.setName(null);
                request.setCode("TST");
                request.setCapacity(100);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when name is too long")
            void shouldReturn400WhenNameIsTooLong() throws Exception {
                String longName = "A".repeat(256);
                AirportRequest request = new AirportRequest();
                request.setName(longName);
                request.setCode("TST");
                request.setCapacity(100);

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }
        }

        @Nested
        @DisplayName("Sad Path Tests - Malformed JSON")
        class MalformedJsonTests {

            @Test
            @DisplayName("Should return 400 when JSON is malformed")
            void shouldReturn400WhenJsonIsMalformed() throws Exception {
                String malformedJson = "{\"name\": \"Test\", \"code\": \"TST\", \"capacity\":";

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(malformedJson))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("Should return 400 when capacity is not a number")
            void shouldReturn400WhenCapacityIsNotANumber() throws Exception {
                String jsonWithInvalidCapacity = "{\"name\": \"Test Airport\", \"code\": \"TST\", \"capacity\": \"not-a-number\"}";

                mockMvc.perform(post("/airports")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonWithInvalidCapacity))
                        .andExpect(status().isBadRequest());
            }
        }
    }

    @Nested
    @DisplayName("GET /airports - Get All Airports")
    class GetAllAirportsTests {

        @Test
        @DisplayName("Should return all airports when airports exist")
        void shouldReturnAllAirportsWhenAirportsExist() throws Exception {
            Airport airport1 = new Airport();
            airport1.setId(1);
            airport1.setName("Zurich Airport");
            airport1.setCode("ZUR");
            airport1.setCapacity(1000);
            airport1.setCreatedAt(LocalDateTime.now());

            Airport airport2 = new Airport();
            airport2.setId(2);
            airport2.setName("Geneva Airport");
            airport2.setCode("GVA");
            airport2.setCapacity(800);
            airport2.setCreatedAt(LocalDateTime.now());

            List<Airport> airports = Arrays.asList(airport1, airport2);
            when(airportRepository.findAll()).thenReturn(airports);

            mockMvc.perform(get("/airports"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(2))
                    .andExpect(jsonPath("$[0].id").value(1))
                    .andExpect(jsonPath("$[0].name").value("Zurich Airport"))
                    .andExpect(jsonPath("$[0].code").value("ZUR"))
                    .andExpect(jsonPath("$[0].capacity").value(1000))
                    .andExpect(jsonPath("$[1].id").value(2))
                    .andExpect(jsonPath("$[1].name").value("Geneva Airport"))
                    .andExpect(jsonPath("$[1].code").value("GVA"))
                    .andExpect(jsonPath("$[1].capacity").value(800));
        }

        @Test
        @DisplayName("Should return empty list when no airports exist")
        void shouldReturnEmptyListWhenNoAirportsExist() throws Exception {
            when(airportRepository.findAll()).thenReturn(List.of());

            mockMvc.perform(get("/airports"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(0));
        }
    }

}

