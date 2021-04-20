package app.service.serviceImplementation;

import app.domain.entities.dto.ShipDto;
import app.domain.enums.CargoType;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import app.service.ShipServ;

import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource("classpath:application.properties")
public class ShipServImpl implements ShipServ {

    private final static int max = 15000;
    private final static int min = 3200;
    private List<ShipDto> shipDtoList = new ArrayList<>();

    @Value("${result.count}")
    private int count;

    @Override
    public void initShips() {
        String name;
        int weight;
        for (int i = 0; i < count; i++) {
            name = RandomStringUtils.random(5, true, true);
            weight = (int)( Math.random() * (max - min) + min);
            shipDtoList.add(new ShipDto(CargoType.randomEnum(), name, weight));
        }
    }


    @Override
    public ShipDto doUnloading(ShipDto shipDto, int weight) {
        List<ShipDto> shipDtos = getShipList();
        for (ShipDto sc : shipDtos) {
            if (sc.equals(shipDto)) {
                if (sc.getWeightCargo() - weight < 0) {
                    sc.setWeightCargo(0);
                } else {
                    sc.setWeightCargo(shipDto.getWeightCargo() - weight);
                }
                return sc;
            }
        }
        shipDtoList = new ArrayList<>(shipDtos);

        return null;
    }

    @Override
    public List<ShipDto> getShipList() {
        return shipDtoList;
    }
}
