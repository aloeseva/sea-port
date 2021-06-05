package app.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipDto {
    private Integer id;
    /**
     * @param cargoType -  тип корабля
     */
    private CargoTypeDto cargoType;
    /**
     * @param name -  название корабля
     */
    private String name;

    /**
     * @param weight -  осталось для разгрузки, тонн
     */
    private int weightCargo;

    public ShipDto(CargoTypeDto cargoType, String name, int weightCargo) {
        this.cargoType = cargoType;
        this.name = name;
        this.weightCargo = weightCargo;
    }

    @Override
    public String toString() {
        return "Корабль " + name + ", с грузом " + cargoType + "  " + weightCargo + "тонн";
    }
}
