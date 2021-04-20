package service.serviceImplementation;

import domain.entities.Ship;
import org.springframework.stereotype.Service;
import repository.ShipRepo;
import service.ShipServ;

import java.util.List;

@Service
public class ShipServImpl implements ShipServ {
    private final ShipRepo shipRepo;

    public ShipServImpl(ShipRepo shipRepo) {
        this.shipRepo = shipRepo;
    }

    @Override
    public void saveCrane(Ship ship) {
        shipRepo.save(ship);
    }

    @Override
    public List<Ship> getAllShips() {
        return shipRepo.findAll();
    }
}
