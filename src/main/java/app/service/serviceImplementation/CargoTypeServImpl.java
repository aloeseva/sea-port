package app.service.serviceImplementation;

import app.domain.entities.CargoType;
import app.domain.entities.dto.CargoTypeDto;
import app.mapper.CargoTypeMapper;
import app.repos.CargoTypeRepository;
import app.service.CargoTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CargoTypeServImpl implements CargoTypeServ {

    private final CargoTypeRepository cargoTypeRepository;
    private final CargoTypeMapper cargoTypeMapper;

    @Autowired
    public CargoTypeServImpl(CargoTypeRepository cargoTypeRepository, CargoTypeMapper cargoTypeMapper) {
        this.cargoTypeRepository = cargoTypeRepository;
        this.cargoTypeMapper = cargoTypeMapper;
    }

    @Override
    public CargoTypeDto getRandomCargoType() {
        List<CargoType> craneModels = new ArrayList<>();
        cargoTypeRepository.findAll().iterator().forEachRemaining(craneModels::add);
        List<CargoTypeDto> cranes = craneModels.stream()
                .map(cargoTypeMapper::toCargoType)
                .collect(Collectors.toList());
        int x = new Random().nextInt(cranes.size());
        return cranes.get(x);
    }

    @Override
    public void init() {
        CargoType c = new CargoType("BULK_CARGO", 1.3);
        CargoType c2 = new CargoType("LIQUID_CARGO", 1.5);
        CargoType c3 = new CargoType("CONTAINERS", 0.9);

        cargoTypeRepository.save(c);
        cargoTypeRepository.save(c2);
        cargoTypeRepository.save(c3);
    }
}
