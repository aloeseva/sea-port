package app.mapper;

import app.domain.entities.CargoType;
import app.domain.entities.Ship;
import app.domain.entities.dto.CargoTypeDto;
import app.domain.entities.dto.ShipDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-06T16:39:47+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_282 (Amazon.com Inc.)"
)
@Component
public class ShipMapperImpl implements ShipMapper {

    @Override
    public Ship toShipModel(ShipDto ship) {
        if ( ship == null ) {
            return null;
        }

        Ship ship1 = new Ship();

        ship1.setId( ship.getId() );
        ship1.setCargo( cargoTypeDtoToCargoType( ship.getCargoType() ) );
        ship1.setName( ship.getName() );
        ship1.setWeight( (double) ship.getWeightCargo() );

        return ship1;
    }

    @Override
    public ShipDto toShip(Ship shipModel) {
        if ( shipModel == null ) {
            return null;
        }

        ShipDto shipDto = new ShipDto();

        shipDto.setId( shipModel.getId() );
        shipDto.setCargoType( cargoTypeToCargoTypeDto( shipModel.getCargo() ) );
        shipDto.setName( shipModel.getName() );
        if ( shipModel.getWeight() != null ) {
            shipDto.setWeightCargo( shipModel.getWeight().intValue() );
        }

        return shipDto;
    }

    protected CargoType cargoTypeDtoToCargoType(CargoTypeDto cargoTypeDto) {
        if ( cargoTypeDto == null ) {
            return null;
        }

        CargoType cargoType = new CargoType();

        cargoType.setId( cargoTypeDto.getId() );
        cargoType.setName( cargoTypeDto.getName() );
        cargoType.setUnloadingRatio( cargoTypeDto.getUnloadingRatio() );

        return cargoType;
    }

    protected CargoTypeDto cargoTypeToCargoTypeDto(CargoType cargoType) {
        if ( cargoType == null ) {
            return null;
        }

        CargoTypeDto cargoTypeDto = new CargoTypeDto();

        cargoTypeDto.setId( cargoType.getId() );
        cargoTypeDto.setName( cargoType.getName() );
        cargoTypeDto.setUnloadingRatio( cargoType.getUnloadingRatio() );

        return cargoTypeDto;
    }
}
