package app.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ship_name")
    private String name;
    @Column(name = "ship_weight")
    private int weightCargo;

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

    public int getWeightCargo() {
        return weightCargo;
    }

    public void setWeightCargo(int weightCargo) {
        this.weightCargo = weightCargo;
    }
}
