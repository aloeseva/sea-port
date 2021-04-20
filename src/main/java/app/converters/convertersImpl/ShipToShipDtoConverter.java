package app.converters.convertersImpl;

import app.converters.BaseObjectConverter;
import app.domain.entities.Ship;
import app.domain.entities.dto.ShipDto;
import org.springframework.stereotype.Component;

@Component
public class ShipToShipDtoConverter extends BaseObjectConverter<Ship, ShipDto> {

    @Override
    public ShipDto convert(Ship obj) {
        //TODO: complete ship to ship dto converter
        return null;
    }

    @Override
    public Class<Ship> getInClass() {
        return Ship.class;
    }

    @Override
    public Class<ShipDto> getOutClass() {
        return ShipDto.class;
    }
}
