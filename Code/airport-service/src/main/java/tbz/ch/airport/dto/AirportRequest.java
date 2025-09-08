package tbz.ch.airport.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AirportRequest {

    private String name;
    private String code;
    private Integer capacity;

}
