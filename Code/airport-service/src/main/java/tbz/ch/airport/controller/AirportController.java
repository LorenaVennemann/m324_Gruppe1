package tbz.ch.airport.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbz.ch.airport.dto.AirportRequest;
import tbz.ch.airport.dto.AirportResponse;
import tbz.ch.airport.entity.Airport;
import tbz.ch.airport.repository.AirportRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @PostMapping
    public AirportResponse createAirport(@Valid @RequestBody AirportRequest request) {
        Airport airport = new Airport();
        airport.setName(request.getName());
        airport.setCode(request.getCode());
        airport.setCapacity(request.getCapacity());

        Airport saved = airportRepository.save(airport);
        return mapToResponse(saved);
    }

    @GetMapping
    public List<AirportResponse> getAllAirports() {
        return airportRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private AirportResponse mapToResponse(Airport airport) {
        AirportResponse response = new AirportResponse();
        response.setId(airport.getId());
        response.setName(airport.getName());
        response.setCode(airport.getCode());
        response.setCapacity(airport.getCapacity());
        response.setCreatedAt(airport.getCreatedAt());
        return response;
    }
}
