package app.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoTypeDto {
    private Integer id;

    private String name;
    /**
     * @param unloadingRatio -  коэффициент скорости разгрузки
     */
    private Double unloadingRatio;

    public CargoTypeDto(Integer id) {
        this.id = id;
    }

}

