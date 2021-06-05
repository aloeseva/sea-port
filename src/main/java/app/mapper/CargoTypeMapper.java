package app.mapper;

import app.domain.entities.dto.CargoTypeDto;
import app.domain.entities.CargoType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CargoTypeMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "unloadingRatio", source = "unloadingRatio")
    CargoTypeDto toCargoType(CargoType craneModel);
}
