package app.mapper;

import app.domain.entities.Schedule;
import app.domain.entities.dto.ScheduleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(
        uses = {MyDateMapper.class, ShipMapper.class, CraneMapper.class}
        , componentModel = "spring"
)
public interface ScheduleMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "arrivalDate", source = "arrivalDate")
    @Mapping(target = "realArrivalDate", source = "realArrivalDate")
    @Mapping(target = "ship", source = "ship")
    @Mapping(target = "crane", source = "crane")
    @Mapping(target = "weightCargo", source = "weightCargo")
    @Mapping(target = "startOfUnloading", source = "startOfUnloading")
    @Mapping(target = "endOfUnloading", source = "endOfUnloading")
    Schedule toScheduleModel(ScheduleDto schedule);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "arrivalDate", source = "arrivalDate")
    @Mapping(target = "realArrivalDate", source = "realArrivalDate")
    @Mapping(target = "ship", source = "ship")
    @Mapping(target = "crane", source = "crane")
    @Mapping(target = "weightCargo", source = "weightCargo")
    @Mapping(target = "startOfUnloading", source = "startOfUnloading")
    @Mapping(target = "endOfUnloading", source = "endOfUnloading")
    ScheduleDto toSchedule(Schedule scheduleModel);
}
