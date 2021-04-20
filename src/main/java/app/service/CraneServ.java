package app.service;

import app.domain.entities.dto.CraneDto;
import app.domain.enums.CargoType;

import java.util.List;

public interface CraneServ {
    List<CraneDto> getCranes();

    void initCranes();

    void startOfUnload(CraneDto craneDto);

    void endOfUnload(CraneDto craneDto);

    CraneDto getFreeCraneByType(CargoType type);
}
