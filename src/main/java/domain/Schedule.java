package domain;

import domain.enums.CargoType;

import java.util.Date;

public class Schedule {
    private Date comingDate;
    private String shipName;
    private Double weight;
    private CargoType type;
    private Integer anchorageTime;

    public Schedule(Date comingDate, String shipName, Double weight, CargoType type, Integer anchorageTime) {
        this.comingDate = comingDate;
        this.shipName = shipName;
        this.weight = weight;
        this.type = type;
        this.anchorageTime = anchorageTime;
    }

    public Date getComingDate() {
        return comingDate;
    }

    public void setComingDate(Date comingDate) {
        this.comingDate = comingDate;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public CargoType getType() {
        return type;
    }

    public void setType(CargoType type) {
        this.type = type;
    }

    public Integer getAnchorageTime() {
        return anchorageTime;
    }

    public void setAnchorageTime(Integer anchorageTime) {
        this.anchorageTime = anchorageTime;
    }
}
