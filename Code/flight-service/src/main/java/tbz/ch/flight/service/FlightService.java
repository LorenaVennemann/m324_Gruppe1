package tbz.ch.flight.service;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tbz.ch.flight.dto.AirportResponse;
import tbz.ch.flight.dto.FlightRequest;
import tbz.ch.flight.dto.FlightResponse;
import tbz.ch.flight.entity.Flight;
import tbz.ch.flight.repository.FlightRepository;
import tbz.ch.flight.validator.FlightValidator;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FlightValidator flightValidator;

    public FlightResponse createFlight(FlightRequest request) throws BadRequestException {
        Flight flight = new Flight();
        flight.setArrivalAirportCode(request.getArrivalAirportCode());
        flight.setDepartureAirportCode(request.getDepartureAirportCode());
        flight.setArrivalDatetime(request.getArrivalDatetime());
        flight.setDepartureDatetime(request.getDepartureDatetime());
        flight.setAircraftType(request.getAircraftType());

        flightValidator.validate(flight, getAirportByCode(flight.getArrivalAirportCode()), getAirportByCode(flight.getDepartureAirportCode()));

        Flight saved = flightRepository.save(flight);
        return mapToResponse(saved);
    }

    public List<FlightResponse> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public AirportResponse getAirportByCode(String code) {
        String uri = "http://localhost:8080/airports/" + code;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<AirportResponse> result = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );
        return result.getBody();
    }

    private FlightResponse mapToResponse(Flight flight) {
        FlightResponse response = new FlightResponse();
        response.setId(flight.getId());
        response.setArrivalAirportCode(flight.getArrivalAirportCode());
        response.setDepartureAirportCode(flight.getDepartureAirportCode());
        response.setArrivalDatetime(flight.getArrivalDatetime());
        response.setDepartureDatetime(flight.getDepartureDatetime());
        response.setAircraftType(flight.getAircraftType());
        response.setCreatedAt(flight.getCreatedAt());
        return response;
    }
}
