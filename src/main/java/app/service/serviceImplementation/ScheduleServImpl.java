package app.service.serviceImplementation;

import app.domain.entities.Crane;
import app.domain.entities.Schedule;
import app.domain.entities.dto.MyDate;
import app.domain.entities.dto.ScheduleDto;
import app.domain.entities.dto.ShipDto;
import app.mapper.ScheduleMapper;
import app.repos.ScheduleRepository;
import app.service.MyDateServ;
import app.service.ScheduleServ;
import app.service.ShipServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleServImpl implements ScheduleServ {

    private final ScheduleMapper scheduleMapper;
    private final ScheduleRepository scheduleRepository;
    private final ShipServ shipService;
    private final MyDateServ myDate;

    @Autowired
    public ScheduleServImpl(ScheduleMapper scheduleMapper, ScheduleRepository scheduleRepository, ShipServ shipService, MyDateServ myDate) {
        this.scheduleMapper = scheduleMapper;
        this.scheduleRepository = scheduleRepository;
        this.shipService = shipService;
        this.myDate = myDate;
    }

    @Value("${result.count}")
    private int count;


    @Override
    public List<ScheduleDto> getAll() {
        List<Schedule> scheduleList = new ArrayList<>();
        scheduleRepository.findAll().iterator().forEachRemaining(scheduleList::add);

        return scheduleList
                .stream()
                .map(scheduleMapper::toSchedule)
                .collect(Collectors.toList());
    }

    @Override
    public void initSchedule() {
        List<ShipDto> ships = shipService.getShipList();
        for (int i = 0; i < count; i++) {
            Schedule scheduleModel = scheduleMapper.toScheduleModel(new ScheduleDto(myDate.getRandomDate(), ships.get(i)));
            scheduleRepository.save(scheduleModel);
        }
    }


    @Override
    public void updateScheduleEndOfUnloading(Integer id, MyDate date) {
        Optional<Schedule> scheduleModel = scheduleRepository.findById(id);
        scheduleModel.get().setEndOfUnloading(myDate.toString(date));
        scheduleRepository.save(scheduleModel.get());
    }

    @Override
    public ScheduleDto updateScheduleRealDate(Integer id, MyDate date) {
        Optional<Schedule> scheduleModel = scheduleRepository.findById(id);
        scheduleModel.get().setRealArrivalDate(myDate.toString(date));
        scheduleRepository.save(scheduleModel.get());
        return scheduleMapper.toSchedule(scheduleModel.get());
    }

    @Override
    public ScheduleDto getScheduleByShip(Integer id) {
//        Schedule scheduleModel = scheduleRepository.findScheduleModelByShipId(id);
        Schedule scheduleModel = scheduleRepository.findSchedulesByShipId(id).get(0);
        return scheduleMapper.toSchedule(scheduleModel);
    }

    @Override
    public void updateScheduleCraneAndStart(Integer id, Integer craneId, MyDate date) {
        Optional<Schedule> scheduleModel = scheduleRepository.findById(id);
        scheduleModel.get().setCrane(new Crane(craneId));
        scheduleModel.get().setStartOfUnloading(myDate.toString(date));
        scheduleRepository.save(scheduleModel.get());
    }

}
