package app.repos;

import app.domain.entities.Crane;
import org.springframework.data.repository.CrudRepository;

public interface CraneRepository extends CrudRepository<Crane, Integer> {
    Crane findFirstByActiveFalseAndCargo_Name(String cargoName);
}
