package domain.entities;

import domain.enums.CargoType;
import domain.enums.ShipState;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @Column(
            name = "id",
            updatable = false
    )
    private UUID uuid = UUID.randomUUID();

    @Column(
            name = "date",
            updatable = false
    )
    private Date date;

    @Column(
            name = "name"
    )
    private String name;

    @Column(
            name = "state"
    )
    private ShipState state;

    @Column(
            name = "weight"
    )
    private Double weight;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "cargoType"
    )
    private CargoType cargoType;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShipState getState() {
        return state;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
