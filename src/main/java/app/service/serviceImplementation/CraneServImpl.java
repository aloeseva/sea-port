package app.service.serviceImplementation;

import app.domain.entities.Crane;
import app.domain.entities.dto.CargoTypeDto;
import app.domain.entities.dto.CraneDto;
import app.mapper.CraneMapper;
import app.repos.CraneRepository;
import app.service.CraneServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CraneServImpl implements CraneServ {
    private final CraneRepository craneRepository;
    private final CraneMapper craneMapper;

    @Autowired
    public CraneServImpl(CraneRepository craneRepository, CraneMapper craneMapper) {
        this.craneRepository = craneRepository;
        this.craneMapper = craneMapper;
    }

    @Override
    public void initCranes() {

        Crane c1 = craneMapper.toCraneModel(new CraneDto(new CargoTypeDto(1), 2000.0));
        Crane c2 = craneMapper.toCraneModel(new CraneDto(new CargoTypeDto(2), 2000.0));
        Crane c3 = craneMapper.toCraneModel(new CraneDto(new CargoTypeDto(3), 2000.0));
        craneRepository.save(c1);
        craneRepository.save(c2);
        craneRepository.save(c3);
    }

    @Override
    public void startOfUnload(CraneDto crane) {
        Crane craneModel = craneMapper.toCraneModel(crane);
        if (craneModel == null) return;
        craneModel.setActive(true);
        craneRepository.save(craneModel);
    }

    @Override
    public void endOfUnload(CraneDto crane) {

        Crane craneModel = craneMapper.toCraneModel(crane);
        if (craneModel == null) return;
        craneModel.setActive(false);
        craneRepository.save(craneModel);

    }

    @Override
    public CraneDto getFreeCraneByType(CargoTypeDto type) {
        Crane craneModel = craneRepository.findFirstByActiveFalseAndCargo_Name(type.getName());
        return craneMapper.toCrane(craneModel);
    }

}
