package com.example.car_mgnt_backend.controller;

import com.example.car_mgnt_backend.dto.AddFuelResponse;
import com.example.car_mgnt_backend.dto.CreateCarRequest;
import com.example.car_mgnt_backend.dto.FuelStatsResponse;
import com.example.car_mgnt_backend.model.Car;
import com.example.car_mgnt_backend.model.FuelEntry;
import com.example.car_mgnt_backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CreateCarRequest req) {
        return ResponseEntity.ok(
                carService.createCar(req.getBrand(), req.getModel(), req.getYear())
        );
    }

    @GetMapping
    public List<Car> listCars() {
        return carService.getAllCars();
    }

    @PostMapping("/{id}/fuel")
    public ResponseEntity<AddFuelResponse> addFuel(
            @PathVariable Long id,
            @RequestBody FuelEntry entry
    ) {
        carService.addFuel(id, entry);
        return ResponseEntity.ok(new AddFuelResponse("Fuel added successfully"));
    }

    @GetMapping("/{id}/fuel/stats")
    public FuelStatsResponse getStats(@PathVariable Long id) {
        return carService.calculateStats(id);
    }
}
