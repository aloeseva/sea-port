package app.service.serviceImplementation;

import app.domain.entities.dto.CraneDto;
import app.domain.entities.dto.MyDate;
import app.domain.entities.dto.ScheduleDto;
import app.domain.entities.dto.ShipDto;
import app.service.CraneServ;
import app.service.MyDateServ;
import app.service.PortServ;
import app.service.ShipServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class PortServImpl implements PortServ {
    private static List<ScheduleDto> scheduleDtoList = new ArrayList<>();
    private final ShipServ shipRep;
    private final MyDateServ myDate;
    private final CraneServ craneService;
    private final Random random = new Random();

    @Value("${result.count}")
    private int count;

    @Autowired
    public PortServImpl(ShipServ shipRep, MyDateServ myDate, CraneServ craneService) {
        this.shipRep = shipRep;
        this.craneService = craneService;
        this.myDate = myDate;
    }

    @Override
    public void initPort() {
        shipRep.initShips();
        craneService.initCranes();
        List<ShipDto> shipDtos = shipRep.getShipList();
        for (int i = 0; i < count; i++) {
            scheduleDtoList.add(new ScheduleDto(myDate.getRandomDate(), shipDtos.get(i)));
        }
    }

    @Override
    public List<ScheduleDto> getScheduleList() {
        return scheduleDtoList;
    }

    @Override
    public void unloadShips(MyDate date) {
        List<ScheduleDto> scheduleDtos = getScheduleList();
        for (ScheduleDto sc : scheduleDtos) {
            //разгружаем корабль
            if (sc.getCraneDto() != null && sc.getEndOfUnloading() == null) {
                int unWeight = (int) (sc.getCraneDto().getSpeed() * sc.getCraneDto().getCargoType().getRate());

                sc.setShipDto(shipRep.doUnloading(sc.getShipDto(), unWeight));
                if (sc.getShipDto().getWeightCargo() != 0) {
                    System.out.print("Разгружаем корабль " + sc.getShipDto().getName() + " " + sc.getShipDto().getCargoType().name());
                    System.out.println(" начальный вес : " + sc.getWeightCargo() + " ,текущий вес " + sc.getShipDto().getWeightCargo());
                }
            }
            //не закончилась ли разгрузка
            if (sc.getShipDto().getWeightCargo() == 0 && sc.getEndOfUnloading() == null) {
                System.out.println("Завершение разгрузки корабля " + sc.getShipDto().getName() + " " + sc.getShipDto().getCargoType().name());
                sc.setEndOfUnloading(date);
                craneService.endOfUnload(sc.getCraneDto());
            }
        }
        scheduleDtoList = new ArrayList<>(scheduleDtos);
    }


    @Override
    public void shipArrival(ShipDto shipDto, MyDate date) {
        if (shipDto != null) {
            System.out.print("Прибытие корабля " + shipDto.getName() + " , информация  о  расписании: ");
            List<ScheduleDto> list = getScheduleList();
            for (ScheduleDto sch : list) {
                if (sch.getShipDto().equals(shipDto)) {
                    sch.setRealArrivalDate(date);
                    System.out.println(sch);
                }
            }
            scheduleDtoList = new ArrayList<>(list);
        }
    }

    @Override
    public ShipDto getNotArrivedShipOrEmpty() {
        List<ScheduleDto> list = getScheduleList();
        int indOfSchedule = random.nextInt(count - 1);
        ScheduleDto scheduleDto = list.get(indOfSchedule);
        if (scheduleDto.getRealArrivalDate() == null) {
            return scheduleDto.getShipDto();
        }
        return null;
    }

    static int ll = 0;

    @Override
    public void checkUnload(MyDate date) {
        ll++;
        List<ScheduleDto> scheduleDtos = getScheduleList();
        Collections.sort(scheduleDtos);
        if (ll == 7) {
            int y;
            System.out.print("");
        }
        for (ScheduleDto scheduleDto : scheduleDtos) {
            if (scheduleDto.getRealArrivalDate() != null && scheduleDto.getCraneDto() == null) {
                CraneDto craneDto = craneService.getFreeCraneByType(scheduleDto.getShipDto().getCargoType());
                //Начинаем разгрузку
                if (craneDto != null) {
                    int indexSchedule = scheduleDtos.indexOf(scheduleDto);
                    System.out.println("Начинаем разгрузку корабля " + scheduleDto.getShipDto().getName() + " " + scheduleDto.getShipDto().getCargoType().name());
                    scheduleDtos.get(indexSchedule).setCraneDto(craneDto);
                    scheduleDtos.get(indexSchedule).setStartOfUnloading(date);
                    craneService.startOfUnload(craneDto);
                } else {
                    System.out.println("Корабль " + scheduleDto.getShipDto().getName() + " " + scheduleDto.getShipDto().getCargoType().name() + " ожидает разгрузки");
                }
            }
        }
        scheduleDtoList = new ArrayList<>(scheduleDtos);
    }
}
