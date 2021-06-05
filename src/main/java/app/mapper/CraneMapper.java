package app.mapper;

import app.domain.entities.Crane;
import app.domain.entities.dto.CraneDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CraneMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "speed", source = "speed")
    @Mapping(target = "cargo", source = "cargoType")
    @Mapping(target = "active", source = "active")
    Crane toCraneModel(CraneDto crane);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "speed", source = "speed")
    @Mapping(target = "cargoType", source = "cargo")
    @Mapping(target = "active", source = "active")
    CraneDto toCrane(Crane craneModel);
}
