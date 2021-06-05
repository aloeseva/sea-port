package app.mapper;

import app.domain.entities.Ship;
import app.domain.entities.dto.ShipDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShipMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "cargo", source = "cargoType")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "weight", source = "weightCargo")
    Ship toShipModel(ShipDto ship);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cargoType", source = "cargo")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "weightCargo", source = "weight")
    ShipDto toShip(Ship shipModel);
}
