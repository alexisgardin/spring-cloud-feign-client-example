package fr.unice.polytech.jboss.dronazonedronemanagement.controller;

import fr.unice.polytech.jboss.dronazonedronemanagement.feign.DroneClient;
import fr.unice.polytech.jboss.dronazonedronemanagement.model.Drone;
import fr.unice.polytech.jboss.dronazonedronemanagement.model.DroneAvailability;
import fr.unice.polytech.jboss.dronazonedronemanagement.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private DroneClient droneClient;

    @Autowired
    public TestController(DroneClient droneClient) {
        this.droneClient = droneClient;
    }

    @GetMapping("/testFeignClient")
    public List<Drone> testFeignClient(){
        Drone drone = new Drone(0, 99d, DroneAvailability.AVAILABLE,
                new Location(90,90));

        //On utilise le feign client pour appeler l'api et on va pouvoir ajouter le drone dans la BD
        droneClient.createDrones(drone);
        //On va récupérer le drone avec l'id 1
        Drone drone1 = droneClient.getDroneById(1);
        //On va le mettre a jour avec des position aléatoire
        drone1.setLocation(new Location(Math.random()*100, Math.random()*100));
        droneClient.updateDrones(drone1, drone1.getId());
        //On retourne tous les drones
        return droneClient.getDrones();
    }
}
