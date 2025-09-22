package tbz.ch.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tbz.ch.flight.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
