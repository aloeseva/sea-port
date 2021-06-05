package app.mapper;

import app.domain.entities.Schedule;
import app.domain.entities.dto.ScheduleDto;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-06T16:39:48+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_282 (Amazon.com Inc.)"
)
@Component
public class ScheduleMapperImpl implements ScheduleMapper {

    @Autowired
    private ShipMapper shipMapper;
    @Autowired
    private CraneMapper craneMapper;

    @Override
    public Schedule toScheduleModel(ScheduleDto schedule) {
        if ( schedule == null ) {
            return null;
        }

        Schedule schedule1 = new Schedule();

        schedule1.setId( schedule.getId() );
        schedule1.setArrivalDate( MyDateMapper.map( schedule.getArrivalDate() ) );
        schedule1.setRealArrivalDate( MyDateMapper.map( schedule.getRealArrivalDate() ) );
        schedule1.setShip( shipMapper.toShipModel( schedule.getShip() ) );
        schedule1.setCrane( craneMapper.toCraneModel( schedule.getCrane() ) );
        schedule1.setWeightCargo( (double) schedule.getWeightCargo() );
        schedule1.setStartOfUnloading( MyDateMapper.map( schedule.getStartOfUnloading() ) );
        schedule1.setEndOfUnloading( MyDateMapper.map( schedule.getEndOfUnloading() ) );

        return schedule1;
    }

    @Override
    public ScheduleDto toSchedule(Schedule scheduleModel) {
        if ( scheduleModel == null ) {
            return null;
        }

        ScheduleDto scheduleDto = new ScheduleDto();

        scheduleDto.setId( scheduleModel.getId() );
        scheduleDto.setArrivalDate( MyDateMapper.toMyDate( scheduleModel.getArrivalDate() ) );
        scheduleDto.setRealArrivalDate( MyDateMapper.toMyDate( scheduleModel.getRealArrivalDate() ) );
        scheduleDto.setShip( shipMapper.toShip( scheduleModel.getShip() ) );
        scheduleDto.setCrane( craneMapper.toCrane( scheduleModel.getCrane() ) );
        if ( scheduleModel.getWeightCargo() != null ) {
            scheduleDto.setWeightCargo( scheduleModel.getWeightCargo().intValue() );
        }
        scheduleDto.setStartOfUnloading( MyDateMapper.toMyDate( scheduleModel.getStartOfUnloading() ) );
        scheduleDto.setEndOfUnloading( MyDateMapper.toMyDate( scheduleModel.getEndOfUnloading() ) );

        return scheduleDto;
    }
}
