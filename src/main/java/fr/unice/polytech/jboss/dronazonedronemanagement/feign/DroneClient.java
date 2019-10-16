package fr.unice.polytech.jboss.dronazonedronemanagement.feign;

import fr.unice.polytech.jboss.dronazonedronemanagement.model.Drone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "drones", url = "http://localhost:8080")
public interface DroneClient {

    @GetMapping("/drones/{id}")
    Drone getDroneById(@PathVariable("id") long id);

    @GetMapping("/drones")
    List<Drone> getDrones();

    @PostMapping("/drones")
    void createDrones(Drone drone);

    @PutMapping("/drones/{id}")
    public void updateDrones(Drone drone, @PathVariable long id);
}
