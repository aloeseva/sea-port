package app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    @Column(name = "ship_name")
    String name;
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    CargoType cargo;
    @Column(name = "ship_weight")
    Double weight;
}
