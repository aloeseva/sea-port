package app.service;

import app.domain.entities.dto.ShipDto;

import java.util.List;

public interface ShipServ {
    void initShips();

    ShipDto doUnloading(ShipDto shipDto, int weight);

    List<ShipDto> getShipList();
}
