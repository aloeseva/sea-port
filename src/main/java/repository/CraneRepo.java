package repository;

import domain.entities.Crane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CraneRepo extends JpaRepository<Crane, Long> {
    Optional<Crane> findCraneByName(String name);
}
