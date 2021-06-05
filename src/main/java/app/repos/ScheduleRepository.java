package app.repos;

import app.domain.entities.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    Schedule findScheduleModelByShipId(Integer id);

    List<Schedule> findSchedulesByShipId(Integer id);
}
