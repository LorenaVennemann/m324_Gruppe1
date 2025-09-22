package tbz.ch.flight.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class FlightResponse {

    private Integer id;
    private String departureAirportCode;
    private String arrivalAirportCode;
    private LocalDateTime departureDatetime;
    private LocalDateTime arrivalDatetime;
    private String aircraftType;
    private LocalDateTime createdAt;
}
