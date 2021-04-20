package repository;

import domain.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipRepo extends JpaRepository<Ship, Long> {
    Optional<Ship> findCraneByName(String name);
}
