package app.service.serviceImplementation;

import app.domain.entities.Ship;
import app.domain.entities.dto.ShipDto;
import app.mapper.ShipMapper;
import app.repos.ShipRepository;
import app.service.CargoTypeServ;
import app.service.ShipServ;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:application.properties")
public class ShipServImpl implements ShipServ {
    private final static int max = 15000;
    private final static int min = 3200;
    private final ShipMapper shipMapper;
    private final CargoTypeServ cargoTypeService;
    private final ShipRepository shipRepository;
    @Value("${result.count}")
    private int count;

    @Autowired
    public ShipServImpl(ShipRepository shipRepository, CargoTypeServ cargoTypeService, ShipMapper shipMapper) {
        this.shipRepository = shipRepository;
        this.shipMapper = shipMapper;
        this.cargoTypeService = cargoTypeService;
    }

    @Override
    public void initShips() {
        String name;
        int weight;
        for (int i = 0; i < count; i++) {
            name = RandomStringUtils.random(5, true, true);
            weight = (int) (Math.random() * (max - min) + min);
            Ship shipModel = shipMapper.toShipModel(new ShipDto(cargoTypeService.getRandomCargoType(), name, weight));
            shipRepository.save(shipModel);
        }
    }


    @Override
    public ShipDto doUnloading(ShipDto ship, int weight) {
        Optional<Ship> shipModel = shipRepository.findById(ship.getId());
        if (shipModel.isPresent()) {
            if (shipModel.get().getWeight() - weight < 0) {
                shipModel.get().setWeight(0.0);
            } else {
                shipModel.get().setWeight(shipModel.get().getWeight() - weight);
            }
            shipRepository.save(shipModel.get());
            return shipMapper.toShip(shipModel.get());
        }
        return null;
    }

    @Override
    public List<ShipDto> getShipList() {
        List<Ship> cranes = new ArrayList<>();
        shipRepository.findAll().iterator().forEachRemaining(cranes::add);
        return cranes.stream()
                .map(shipMapper::toShip)
                .collect(Collectors.toList());
    }
}
