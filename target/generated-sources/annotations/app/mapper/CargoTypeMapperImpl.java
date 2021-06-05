package app.mapper;

import app.domain.entities.CargoType;
import app.domain.entities.dto.CargoTypeDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-06T16:39:48+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_282 (Amazon.com Inc.)"
)
@Component
public class CargoTypeMapperImpl implements CargoTypeMapper {

    @Override
    public CargoTypeDto toCargoType(CargoType craneModel) {
        if ( craneModel == null ) {
            return null;
        }

        CargoTypeDto cargoTypeDto = new CargoTypeDto();

        cargoTypeDto.setId( craneModel.getId() );
        cargoTypeDto.setName( craneModel.getName() );
        cargoTypeDto.setUnloadingRatio( craneModel.getUnloadingRatio() );

        return cargoTypeDto;
    }
}
