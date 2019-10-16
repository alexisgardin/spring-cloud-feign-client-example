package fr.unice.polytech.jboss.dronazonedronemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @NotNull @Column(nullable = false)
        private double latitude;

    @NotNull @Column(nullable = false)
        private double longitude;
}
