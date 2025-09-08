package tbz.ch.airport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "code")
public class Airport {
    @Id
    private int id;
    private String name;
    private String code;
    private Integer capacity;
    private LocalDateTime createdAt;
}