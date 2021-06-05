package app.service;

import app.domain.entities.dto.CargoTypeDto;
import app.domain.entities.dto.CraneDto;

public interface CraneServ {
    void initCranes();

    void startOfUnload(CraneDto craneDto);

    void endOfUnload(CraneDto craneDto);

    CraneDto getFreeCraneByType(CargoTypeDto type);
}
