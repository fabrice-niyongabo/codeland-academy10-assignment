package com.example.car_mgnt_backend.service.map;

import com.example.car_mgnt_backend.dto.FuelStats;
import com.example.car_mgnt_backend.model.Car;
import com.example.car_mgnt_backend.model.FuelEntry;

public class CarMapper {
    public static Car mapToCar(Long id, String brand, String model, int year){
        Car car = new Car();
        car.setId(id);
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        return car;
    }

    public static FuelStats mapToFuelStats(double totalFuel, double totalCost, double avgConsumption){
        FuelStats stat = new FuelStats();
        stat.setTotalFuel(totalFuel);
        stat.setTotalCost(totalCost);
        stat.setAvgConsumption(avgConsumption);
        return stat;
    }
}
