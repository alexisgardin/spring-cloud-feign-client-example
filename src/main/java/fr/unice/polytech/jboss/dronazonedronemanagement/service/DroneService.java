package fr.unice.polytech.jboss.dronazonedronemanagement.service;

import fr.unice.polytech.jboss.dronazonedronemanagement.model.Drone;
import fr.unice.polytech.jboss.dronazonedronemanagement.model.DroneAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  DroneService extends JpaRepository<Drone, Long> {

    List<Drone> findByDroneAvailability(DroneAvailability availabilty);
}
