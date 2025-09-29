package tbz.ch.flight.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
public class FlightRequest {
    private String departureAirportCode;
    private String arrivalAirportCode;
    private LocalDateTime departureDatetime;
    private LocalDateTime arrivalDatetime;
    private String aircraftType;


    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public LocalDateTime getDepartureDatetime() {
        return departureDatetime;
    }

    public LocalDateTime getArrivalDatetime() {
        return arrivalDatetime;
    }

    public String getAircraftType() {
        return aircraftType;
    }
}