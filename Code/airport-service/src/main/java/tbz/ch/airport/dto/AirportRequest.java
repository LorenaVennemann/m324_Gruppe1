package tbz.ch.airport.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AirportRequest {
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @NotBlank(message = "Code cannot be empty")
    @Size(min = 3, max = 3)
    private String code;

    @NotNull
    @Min(1)
    @Max(value = 999999, message = "Capacity too large")
    private Integer capacity;
}
