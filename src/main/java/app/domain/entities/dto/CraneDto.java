package app.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CraneDto {
    private Integer id;
    /**
     * @param cargoType -  тип разгрузочного крана (по грузу)
     */
    private CargoTypeDto cargoType;

    /**
     * @param speed -   скорость разгрузки, тонн в час
     */
    private Double speed;

    /**
     * @param isActive -   занят ли кран разгрузкой
     */
    private boolean isActive = false;

    public CraneDto(CargoTypeDto cargoType, Double speed) {
        this.cargoType = cargoType;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Кран " + cargoType + " ,скорость " + speed + " ,активен? " + isActive;
    }
}
