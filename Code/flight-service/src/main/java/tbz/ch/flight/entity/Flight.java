package tbz.ch.flight.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 3, message = "Airport code must be exactly 3 characters")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Airport code must be 3 uppercase letters")
    @Column(name = "departure_airport_code", length = 3, nullable = false)
    private String departureAirportCode;

    @NotBlank
    @Size(min = 3, max = 3, message = "Airport code must be exactly 3 characters")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Airport code must be 3 uppercase letters")
    @Column(name = "arrival_airport_code", length = 3, nullable = false)
    private String arrivalAirportCode;

    @NotNull
    @Column(name = "departure_datetime", nullable = false)
    private LocalDateTime departureDatetime;

    @NotNull
    @Column(name = "arrival_datetime", nullable = false)
    private LocalDateTime arrivalDatetime;

    @NotBlank
    @Size(max = 50)
    @Column(name = "aircraft_type", length = 50, nullable = false)
    private String aircraftType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    public boolean isDifferentAirports() {
        return departureAirportCode == null || !departureAirportCode.equals(arrivalAirportCode);
    }

    public boolean isValidTimeSequence() {
        return departureDatetime == null || arrivalDatetime == null ||
                arrivalDatetime.isAfter(departureDatetime);
    }
}