package app.service.serviceImplementation;

import app.domain.entities.dto.CraneDto;
import app.domain.enums.CargoType;
import org.springframework.stereotype.Service;
import app.service.CraneServ;

import java.util.ArrayList;
import java.util.List;

@Service
public class CraneServImpl implements CraneServ {
    private static List<CraneDto> craneDtoList = new ArrayList<>();

    @Override
    public void initCranes() {
        craneDtoList.add(new CraneDto(CargoType.BULK_CARGO, 2000));
        craneDtoList.add(new CraneDto(CargoType.LIQUID_CARGO, 1500));
        craneDtoList.add(new CraneDto(CargoType.CONTAINERS, 6500));
        //  craneList.add(new Crane(EnumCargoType.LIQUID_CARGO, 6000));
    }

    @Override
    public void startOfUnload(CraneDto craneDto) {
        List<CraneDto> craneDtos = getCranes();
        for (CraneDto c : craneDtos) {
            if (c.equals(craneDto)) c.setActive(true);
        }
        craneDtoList = new ArrayList<>(craneDtos);
    }

    @Override
    public void endOfUnload(CraneDto craneDto) {
        List<CraneDto> craneDtos = getCranes();
        for (CraneDto c : craneDtos) {
            if (c.equals(craneDto)) c.setActive(false);
        }
        craneDtoList = new ArrayList<>(craneDtos);
    }

    @Override
    public CraneDto getFreeCraneByType(CargoType type) {
        List<CraneDto> craneDtos = getCranes();
        for (CraneDto c : craneDtos) {
            if (c.getCargoType().equals(type) && !c.isActive()) return c;
        }
        return null;
    }

    @Override
    public List<CraneDto> getCranes() {
        return craneDtoList;
    }
}
