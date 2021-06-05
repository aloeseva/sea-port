package app.mapper;

import app.domain.entities.CargoType;
import app.domain.entities.Crane;
import app.domain.entities.dto.CargoTypeDto;
import app.domain.entities.dto.CraneDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-06T16:39:47+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_282 (Amazon.com Inc.)"
)
@Component
public class CraneMapperImpl implements CraneMapper {

    @Override
    public Crane toCraneModel(CraneDto crane) {
        if ( crane == null ) {
            return null;
        }

        Crane crane1 = new Crane();

        crane1.setId( crane.getId() );
        crane1.setSpeed( crane.getSpeed() );
        crane1.setCargo( cargoTypeDtoToCargoType( crane.getCargoType() ) );
        crane1.setActive( crane.isActive() );

        return crane1;
    }

    @Override
    public CraneDto toCrane(Crane craneModel) {
        if ( craneModel == null ) {
            return null;
        }

        CraneDto craneDto = new CraneDto();

        craneDto.setId( craneModel.getId() );
        craneDto.setSpeed( craneModel.getSpeed() );
        craneDto.setCargoType( cargoTypeToCargoTypeDto( craneModel.getCargo() ) );
        craneDto.setActive( craneModel.isActive() );

        return craneDto;
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
