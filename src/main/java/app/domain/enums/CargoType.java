package app.domain.enums;

import java.util.Random;

public enum CargoType {
    BULK_CARGO(1.3),
    LIQUID_CARGO(1.5),
    CONTAINERS(0.9);
    /**
     * @param unloadingRatio -  коэффициент скорости разгрузки
     */
    private final double unloadingRatio;

    CargoType(double rate) {

        this.unloadingRatio = rate;
    }

    public double getRate() {
        return unloadingRatio;
    }


    public static CargoType randomEnum() {
        int x = new Random().nextInt(CargoType.values().length);
        return CargoType.values()[x];
    }
}
