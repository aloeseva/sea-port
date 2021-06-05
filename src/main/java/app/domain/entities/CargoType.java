package app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cargo_type")
public class CargoType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "cargo_name")
    String name;

    @Column(name = "cargo_unloading_ratio")
    Double unloadingRatio;

    public CargoType(String name, Double unloadingRatio) {
        this.name = name;
        this.unloadingRatio = unloadingRatio;
    }

}
