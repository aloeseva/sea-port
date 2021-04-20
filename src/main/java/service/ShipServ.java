package service;

import domain.entities.Ship;

import java.util.List;

public interface ShipServ {
    void saveCrane(Ship ship);

    List<Ship> getAllShips();
}
