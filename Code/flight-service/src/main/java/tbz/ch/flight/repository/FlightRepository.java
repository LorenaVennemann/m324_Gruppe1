package tbz.ch.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tbz.ch.flight.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
