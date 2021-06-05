package app.service.serviceImplementation;

import app.domain.entities.dto.CraneDto;
import app.domain.entities.dto.MyDate;
import app.domain.entities.dto.ScheduleDto;
import app.domain.entities.dto.ShipDto;
import app.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class PortServImpl implements PortServ {
    static Logger LOGGER = Logger.getLogger(PortServImpl.class);
    private final ShipServ shipRep;
    private final CargoTypeServ cargoTypeService;
    private final CraneServ craneService;
    private Random random = new Random();
    private final ScheduleServ scheduleService;

    @Autowired
    public PortServImpl(ShipServ shipRep, CargoTypeServ cargoTypeService, CraneServ craneService, ScheduleServ scheduleService) {
        this.shipRep = shipRep;
        this.cargoTypeService = cargoTypeService;
        this.craneService = craneService;
        this.scheduleService = scheduleService;
    }

    @Value("${result.count}")
    private int count;

    @Override
    public void initPort() {
        cargoTypeService.init();
        shipRep.initShips();
        craneService.initCranes();
        scheduleService.initSchedule();
    }


    @Override
    public void unloadShips(MyDate date) {
        List<ScheduleDto> schedules = scheduleService.getAll();
        for (ScheduleDto sc : schedules) {
            //разгружаем корабль
            if (sc.getCrane() != null && sc.getEndOfUnloading() == null) {
                int unWeight = (int) (sc.getCrane().getSpeed() * sc.getCrane().getCargoType().getUnloadingRatio());
                ShipDto ship = shipRep.doUnloading(sc.getShip(), unWeight);
                if (sc.getShip().getWeightCargo() != 0) {
//                    System.out.print("Разгружаем корабль " + sc.getShip().getName() + " " + sc.getShip().getCargoType().getName());
//                    System.out.println(" начальный вес : " + sc.getWeightCargo() + " ,текущий вес " + ship.getWeightCargo());
                    LOGGER.info("Разгружаем корабль " + sc.getShip().getName() + " " + sc.getShip().getCargoType().getName());
                    LOGGER.info(" начальный вес : " + sc.getWeightCargo() + " ,текущий вес " + ship.getWeightCargo());
                }
            }
            //не закончилась ли разгрузка
            if (sc.getShip().getWeightCargo() == 0 && sc.getEndOfUnloading() == null) {
//                System.out.println("Завершение разгрузки корабля " + sc.getShip().getName() + " " + sc.getShip().getCargoType().getName());
                LOGGER.info("Завершение разгрузки корабля " + sc.getShip().getName() + " " + sc.getShip().getCargoType().getName());
                scheduleService.updateScheduleEndOfUnloading(sc.getId(), date);
                craneService.endOfUnload(sc.getCrane());
            }
        }
    }


    @Override
    public void shipArrival(ShipDto ship, MyDate date) {
//        System.out.print("Прибытие корабля " + ship.getName() + " , информация  о  расписании: ");
        LOGGER.info("Прибытие корабля " + ship.getName() + " , информация  о  расписании: ");
        ScheduleDto schedule = scheduleService.getScheduleByShip(ship.getId());
        ScheduleDto schedule1 = scheduleService.updateScheduleRealDate(schedule.getId(), date);
        System.out.println(schedule1.toString());
    }

    @Override
    public ShipDto getNotArrivedShipOrEmpty() {
        List<ScheduleDto> list = scheduleService.getAll();
        int indOfSchedule = random.nextInt(count - 1);
        ScheduleDto schedule = list.get(indOfSchedule);
        if (schedule.getRealArrivalDate() == null) {
            return schedule.getShip();
        }
        return null;
    }

    @Override
    public void checkUnload(MyDate date) {

        List<ScheduleDto> schedules = scheduleService.getAll();
        Collections.sort(schedules);

        for (ScheduleDto schedule : schedules) {
            if (schedule.getRealArrivalDate() != null && schedule.getCrane() == null) {
                CraneDto crane = craneService.getFreeCraneByType(schedule.getShip().getCargoType());
                //Начинаем разгрузку
                if (crane != null) {
//                    System.out.println("Начинаем разгрузку корабля " + schedule.getShip().getName() + " " + schedule.getShip().getCargoType().getName());
                    LOGGER.info("Начинаем разгрузку корабля " + schedule.getShip().getName() + " " + schedule.getShip().getCargoType().getName());
                    scheduleService.updateScheduleCraneAndStart(schedule.getId(), crane.getId(), date);
                    craneService.startOfUnload(crane);
                } else {
//                    System.out.println("Корабль " + schedule.getShip().getName() + " " + schedule.getShip().getCargoType().getName() + " ожидает разгрузки");
                    LOGGER.info("Корабль " + schedule.getShip().getName() + " " + schedule.getShip().getCargoType().getName() + " ожидает разгрузки");
                }
            }
        }
    }
}
