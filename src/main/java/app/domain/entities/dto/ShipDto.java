package app.domain.entities.dto;

import app.domain.enums.CargoType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
public class ShipDto {
    /**
     * @param cargoType -  тип корабля
     */
    private CargoType cargoType;
    /**
     * @param name -  название корабля
     */
    private String name;

    /**
     * @param weight -  осталось для разгрузки, тонн
     */
    private int weightCargo;

    @Override
    public String toString() {
        return "Корабль " + name + ", с грузом " + cargoType + "  " + weightCargo + "тонн";
    }
}
