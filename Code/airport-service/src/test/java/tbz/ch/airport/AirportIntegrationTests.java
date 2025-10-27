package tbz.ch.airport;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tbz.ch.airport.dto.AirportRequest;
import tbz.ch.airport.entity.Airport;
import tbz.ch.airport.repository.AirportRepository;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AirportIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AirportRepository airportRepository;

    @BeforeEach
    void setUp() {
        airportRepository.deleteAll();
    }

    @Nested
    @DisplayName("POST /airports - Create Airport")
    class CreateAirportTests {

        @Test
        @DisplayName("Should create airport with valid data and save to database")
        void shouldCreateAirportWithValidData() throws Exception {
            AirportRequest request = new AirportRequest();
            request.setName("Zurich Airport");
            request.setCode("ZUR");
            request.setCapacity(1000);

            mockMvc.perform(post("/airports")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").exists())
                    .andExpect(jsonPath("$.name").value("Zurich Airport"))
                    .andExpect(jsonPath("$.code").value("ZUR"))
                    .andExpect(jsonPath("$.capacity").value(1000))
                    .andExpect(jsonPath("$.createdAt").exists());

            assertThat(airportRepository.count()).isEqualTo(1);
            Airport savedAirport = airportRepository.findByCode("ZUR").orElseThrow();
            assertThat(savedAirport.getName()).isEqualTo("Zurich Airport");
            assertThat(savedAirport.getCode()).isEqualTo("ZUR");
            assertThat(savedAirport.getCapacity()).isEqualTo(1000);
            assertThat(savedAirport.getCreatedAt()).isNotNull();
        }

        @Test
        @DisplayName("Should return 400 when code is invalid (less than 3 characters)")
        void shouldReturn400WhenCodeIsInvalid() throws Exception {
            AirportRequest request = new AirportRequest();
            request.setName("Test Airport");
            request.setCode("ZU");
            request.setCapacity(100);

            mockMvc.perform(post("/airports")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isBadRequest());

            assertThat(airportRepository.count()).isEqualTo(0);
        }

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

            assertThat(airportRepository.count()).isEqualTo(0);
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

            assertThat(airportRepository.count()).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("GET /airports - Get All Airports")
    class GetAllAirportsTests {

        @Test
        @DisplayName("Should return all airports when airports exist")
        void shouldReturnAllAirportsWhenAirportsExist() throws Exception {
            Airport airport1 = new Airport();
            airport1.setName("Zurich Airport");
            airport1.setCode("ZUR");
            airport1.setCapacity(1000);
            airport1.setCreatedAt(LocalDateTime.now());
            airportRepository.save(airport1);

            Airport airport2 = new Airport();
            airport2.setName("Geneva Airport");
            airport2.setCode("GVA");
            airport2.setCapacity(800);
            airport2.setCreatedAt(LocalDateTime.now());
            airportRepository.save(airport2);

            mockMvc.perform(get("/airports"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(2))
                    .andExpect(jsonPath("$[0].name").value("Zurich Airport"))
                    .andExpect(jsonPath("$[0].code").value("ZUR"))
                    .andExpect(jsonPath("$[0].capacity").value(1000))
                    .andExpect(jsonPath("$[1].name").value("Geneva Airport"))
                    .andExpect(jsonPath("$[1].code").value("GVA"))
                    .andExpect(jsonPath("$[1].capacity").value(800));

            assertThat(airportRepository.count()).isEqualTo(2);
        }

        @Test
        @DisplayName("Should return empty list when no airports exist")
        void shouldReturnEmptyListWhenNoAirportsExist() throws Exception {
            mockMvc.perform(get("/airports"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(0));

            assertThat(airportRepository.count()).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("GET /airports/{code} - Get Airport by Code")
    class GetAirportByCodeTests {

        @Test
        @DisplayName("Should return airport when code exists")
        void shouldReturnAirportWhenCodeExists() throws Exception {
            Airport airport = new Airport();
            airport.setName("Zurich Airport");
            airport.setCode("ZUR");
            airport.setCapacity(1000);
            airport.setCreatedAt(LocalDateTime.now());
            airportRepository.save(airport);

            mockMvc.perform(get("/airports/ZUR"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value("Zurich Airport"))
                    .andExpect(jsonPath("$.code").value("ZUR"))
                    .andExpect(jsonPath("$.capacity").value(1000))
                    .andExpect(jsonPath("$.createdAt").exists());

            assertThat(airportRepository.count()).isEqualTo(1);
        }

    }
}