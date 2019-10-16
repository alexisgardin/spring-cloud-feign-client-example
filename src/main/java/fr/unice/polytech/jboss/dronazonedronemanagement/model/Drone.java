package fr.unice.polytech.jboss.dronazonedronemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private double batteryPercentage;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private DroneAvailability droneAvailability;

    @Embedded
    @NotNull
    @Column(nullable = false)
    private Location location;

}
