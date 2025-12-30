package com.example.car_mgnt_backend.service.map;

import com.example.car_mgnt_backend.dto.FuelStatsResponse;
import com.example.car_mgnt_backend.model.Car;

public class CarMapper {
    public static Car mapToCar(Long id, String brand, String model, int year){
        Car car = new Car();
        car.setId(id);
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        return car;
    }

    public static FuelStatsResponse mapToFuelStats(double totalFuel, double totalCost, double avgConsumption){
        FuelStatsResponse stat = new FuelStatsResponse();
        stat.setTotalFuel(totalFuel);
        stat.setTotalCost(totalCost);
        stat.setAvgConsumption(avgConsumption);
        return stat;
    }
}
