package domain.entities;

import domain.enums.CargoType;
import domain.enums.CraneState;

import javax.persistence.*;

@Entity
@Table(name = "crane")
public class Crane {
    @Id
    @SequenceGenerator(
            name = "crane_sequence",
            sequenceName = "crane_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "crane_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "craneName",
            unique = true
    )
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "craneState"
    )
    private CraneState craneState;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "cargoType"
    )
    private CargoType cargoType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CraneState getCraneState() {
        return craneState;
    }

    public void setCraneState(CraneState craneState) {
        this.craneState = craneState;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }
}
