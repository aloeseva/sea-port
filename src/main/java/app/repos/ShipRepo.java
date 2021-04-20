package app.repos;

import app.domain.entities.Ship;
import app.domain.entities.dto.ShipDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipRepo extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);
}
