package app.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto implements Comparable<ScheduleDto> {
    private Integer id;
    /**
     * @param arrivalDate - предварительная дата  прибытия корабля
     */
    private MyDate arrivalDate;
    /**
     * @param realArrivalDate - реальная дата  прибытия корабля
     */
    private MyDate realArrivalDate;
    /**
     * @param ship -   корабль
     */
    private ShipDto ship;
    /**
     * @param crane -   кран, который разгружает корабль
     */
    private CraneDto crane;
    /**
     * @param weight -  вес груза, тонн
     */
    private int weightCargo;
    /**
     * @param startOfUnloading -  начало разгрузки
     */
    private MyDate startOfUnloading;
    /**
     * @param endOfUnloading -  завершение разгрузки
     */
    private MyDate endOfUnloading;

    public ScheduleDto(MyDate arrivalDate, ShipDto ship) {
        this.arrivalDate = arrivalDate;
        this.ship = ship;
        this.weightCargo = ship.getWeightCargo();

    }

    @Override
    public String toString() {
        return " ожидаемая дата прибытия " + arrivalDate + ", реальная " + realArrivalDate + ", вес груза " + weightCargo;
    }

    @Override
    public int compareTo(ScheduleDto o) {
        if (this.realArrivalDate == null) return 1;
        return this.realArrivalDate.compareTo(o.realArrivalDate);
    }
}
