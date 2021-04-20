package app.service;


import app.domain.entities.dto.MyDate;
import app.domain.entities.dto.ScheduleDto;
import app.domain.entities.dto.ShipDto;

import java.util.List;


public interface PortServ {
    void initPort();

    List<ScheduleDto> getScheduleList();

    void unloadShips(MyDate date);

    void checkUnload(MyDate date);

    void shipArrival(ShipDto shipDto, MyDate date);

    ShipDto getNotArrivedShipOrEmpty();


}
