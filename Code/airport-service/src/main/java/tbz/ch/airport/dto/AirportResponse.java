package tbz.ch.airport.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AirportResponse {

    private Integer id;
    private String name;
    private String code;
    private Integer capacity;
    private LocalDateTime createdAt;

}
