package tbz.ch.flight.validator;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;
import tbz.ch.flight.dto.AirportResponse;
import tbz.ch.flight.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FlightValidator {

    public void validate(Flight flight, List<AirportResponse> airports) throws BadRequestException {
        validateFutureDeparture(flight);
        validateFutureArrival(flight);
        validateTimeSequence(flight);
        validateDifferentAirports(flight);
        validateAirportExistence(flight, airports);
    }

    private void validateFutureDeparture(Flight flight) throws BadRequestException {
        if (!flight.getDepartureDatetime().isAfter(LocalDateTime.now())) {
            throw new BadRequestException("Departure time must be in the future.");
        }
    }

    private void validateFutureArrival(Flight flight) throws BadRequestException {
        if (!flight.getArrivalDatetime().isAfter(LocalDateTime.now())) {
            throw new BadRequestException("Arrival time must be in the future.");
        }
    }

    private void validateTimeSequence(Flight flight) throws BadRequestException {
        if (!flight.isValidTimeSequence()) {
            throw new BadRequestException("Invalid time sequence: Arrival must be after departure.");
        }
    }

    private void validateDifferentAirports(Flight flight) throws BadRequestException {
        if (!flight.isDifferentAirports()) {
            throw new BadRequestException("Arrival and departure airports must be different.");
        }
    }

    private void validateAirportExistence(Flight flight, List<AirportResponse> airports) throws BadRequestException {
        boolean arrivalExists = airports.stream()
                .anyMatch(a -> a.getCode().equals(flight.getArrivalAirportCode()));

        if (!arrivalExists) {
            throw new BadRequestException("Arrival airport doesn't exist.");
        }

        boolean departureExists = airports.stream()
                .anyMatch(a -> a.getCode().equals(flight.getDepartureAirportCode()));

        if (!departureExists) {
            throw new BadRequestException("Departure airport doesn't exist.");
        }
    }
}

