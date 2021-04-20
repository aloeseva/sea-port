package app.domain.entities.dto;

import app.domain.enums.CargoType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CraneDto {
    /**
     * @param cargoType -  тип разгрузочного крана (по грузу)
     */
    private CargoType cargoType;

    /**
     * @param speed -   скорость разгрузки, тонн в час
     */
    private Integer speed;

    /**
     * @param isActive -   занят ли кран разгрузкой
     */
    private boolean isActive = false;

    public CraneDto(CargoType cargoType, Integer speed) {
        this.cargoType = cargoType;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Кран " + cargoType + " ,скорость " + speed + " ,активен? " + isActive;
    }
}
