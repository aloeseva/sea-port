package app.service;

import app.domain.entities.dto.CargoTypeDto;

public interface CargoTypeServ {
    CargoTypeDto getRandomCargoType();

    void init();
}
