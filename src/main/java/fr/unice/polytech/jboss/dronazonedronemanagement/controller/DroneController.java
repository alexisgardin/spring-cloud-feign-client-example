package fr.unice.polytech.jboss.dronazonedronemanagement.controller;

import fr.unice.polytech.jboss.dronazonedronemanagement.feign.DroneClient;
import fr.unice.polytech.jboss.dronazonedronemanagement.model.Drone;
import fr.unice.polytech.jboss.dronazonedronemanagement.model.DroneAvailability;
import fr.unice.polytech.jboss.dronazonedronemanagement.model.Location;
import fr.unice.polytech.jboss.dronazonedronemanagement.service.DroneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class DroneController {
    private DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }


    @ApiOperation(value = "Drones in the fleet", nickname = "getDrones")
    @GetMapping("/drones")
    public List<Drone> getDrones(@ApiParam("State of drone") @Valid @RequestParam(value = "availability", required = false) DroneAvailability droneAvailability){
        if(droneAvailability!=null)
            return droneService.findByDroneAvailability(droneAvailability);
        return droneService.findAll();
    }




    @ApiOperation(value = "Add a new drone in the fleet", nickname = "createDrone")
    @PostMapping("/drones")
    public  void createDrones(@Valid @RequestBody Drone drone){
         droneService.save(drone);
    }


    @ApiOperation(value = "Update a drones of the fleet", nickname = "updateDrone")
    @PutMapping("/drones/{id}")
    public ResponseEntity<Drone> updateDrone(@Valid @RequestBody Drone drone, @PathVariable long id) {

        drone.setId(id);
        droneService.save(drone);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete a drone of the fleet", nickname = "deleteDrone")
    @DeleteMapping("/drones/{id}")
    public void deleteStudent(@PathVariable long id) {
        droneService.deleteById(id);
    }

    @ApiOperation(value = "Get a drone of the fleet", nickname = "getDroneById")
    @GetMapping("/drones/{id}")
    public Optional<Drone> getDroneById(@PathVariable long id) {
        return droneService.findById(id);
    }

}
