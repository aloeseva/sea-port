package app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "crane")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Crane {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    @Column(name = "crane_speed")
    Double speed;
    @Column(name = "crane_active")
    boolean active = false;
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    CargoType cargo;

    public Crane(Integer id) {
        this.id = id;
    }
}
