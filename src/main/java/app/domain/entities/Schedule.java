package app.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedule")
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
     @Column(name = "id")
    private Integer id;

    @Column(name = "schedule_arrival_date")
    private String arrivalDate;

    @Column(name = "schedule_real_arrival_date")
    private String realArrivalDate;

    @OneToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "crane_id")
    private Crane crane;

    @Column(name = "schedule_weight")
    private Double weightCargo;

    @Column(name = "schedule_start_of_unloading")
    private String startOfUnloading;

    @Column(name = "schedule_end_of_unloading")
    private String endOfUnloading;
}
