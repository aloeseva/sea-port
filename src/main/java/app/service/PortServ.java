package app.service;

import app.domain.entities.dto.MyDate;
import app.domain.entities.dto.ShipDto;

public interface PortServ {
    void initPort();

    void unloadShips(MyDate date);

    void checkUnload(MyDate date);

    void shipArrival(ShipDto shipDto, MyDate date);

    ShipDto getNotArrivedShipOrEmpty();
}
