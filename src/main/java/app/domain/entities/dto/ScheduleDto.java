package app.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScheduleDto implements Comparable<ScheduleDto> {
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
    private ShipDto shipDto;
    /**
     * @param crane -   кран, который разгружает корабль
     */
    private CraneDto craneDto;
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

    public ScheduleDto(MyDate arrivalDate, ShipDto shipDto) {
        this.arrivalDate = arrivalDate;
        this.shipDto = shipDto;
        this.weightCargo = shipDto.getWeightCargo();

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
