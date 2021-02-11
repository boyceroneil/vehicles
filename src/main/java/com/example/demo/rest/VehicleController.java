package com.example.demo.rest;

import com.example.demo.crud.CRUD;
import com.example.demo.entity.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class VehicleController {
//qualifier is not needed unless have multiple IMPL
    private final CRUD crud;
    @Autowired
    public VehicleController(@Qualifier("vehicleIMPL") CRUD crud) {//why does vehicleIMPL need to be lower case

        this.crud = crud;
    }

    @GetMapping("/receiveAllVehicles")
    public List<Object> searchAll(){
        return crud.searchAll();
    }

    @PostMapping("/addVehicle")
    public Vehicles addVehicle(@RequestBody Vehicles veh){
        veh.setId(0);
        crud.saveUpdate(veh);
        return veh;
    }
    @PutMapping("/updateVehicle")
    public Vehicles updateVehicle(@RequestBody Vehicles veh){
        crud.saveUpdate(veh);
        return veh;
    }
    @DeleteMapping("/deleteVehicle/{veh}")
    public String deleteVehicles(@PathVariable int veh){
        Vehicles temp = (Vehicles) crud.searchId(veh);
        if(temp == null){
            throw new RuntimeException("Vehicle is not here" + veh);
        }
        crud.deleteId(veh);
        return "removed vehicle id: " + veh;
    }
}
