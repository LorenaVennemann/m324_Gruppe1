package tbz.ch.airport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "airports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "code")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Airport name cannot be blank")
    @Size(max = 50, message = "Airport name cannot exceed 50 characters")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotBlank(message = "Airport code cannot be blank")
    @Size(min = 3, max = 3, message = "Airport code must be exactly 3 characters")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Airport code must be 3 uppercase letters")
    @Column(name = "code", length = 3, nullable = false, unique = true)
    private String code;

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 1, message = "Capacity must be greater than 0")
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (code != null) {
            code = code.toUpperCase();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        if (code != null) {
            code = code.toUpperCase();
        }
    }
}