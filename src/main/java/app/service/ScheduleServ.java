package app.service;

import app.domain.entities.dto.MyDate;
import app.domain.entities.dto.ScheduleDto;

import java.util.List;

public interface ScheduleServ {
    List<ScheduleDto> getAll();

    void initSchedule();

    void updateScheduleEndOfUnloading(Integer id, MyDate date);

    ScheduleDto updateScheduleRealDate(Integer id, MyDate date);

    ScheduleDto getScheduleByShip(Integer id);

    void updateScheduleCraneAndStart(Integer id, Integer craneId, MyDate date);
}
