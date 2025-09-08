package tbz.ch.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tbz.ch.airport.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
