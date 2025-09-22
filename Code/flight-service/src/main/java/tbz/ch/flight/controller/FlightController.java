package tbz.ch.flight.controller;

import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbz.ch.flight.dto.FlightRequest;
import tbz.ch.flight.dto.FlightResponse;
import tbz.ch.flight.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public FlightResponse createFlight(@Valid @RequestBody FlightRequest request) throws BadRequestException {
        return this.flightService.createFlight(request);
    }

    @GetMapping
    public List<FlightResponse> getAllFlights() {
        return this.flightService.getAllFlights();
    }
}
