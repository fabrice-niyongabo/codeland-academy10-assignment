package com.example.car_mgnt_backend.service;

import com.example.car_mgnt_backend.dto.FuelStatsResponse;
import com.example.car_mgnt_backend.exceptions.NotFoundException;
import com.example.car_mgnt_backend.model.Car;
import com.example.car_mgnt_backend.model.FuelEntry;
import com.example.car_mgnt_backend.service.map.CarMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CarService {
    private final Map<Long, Car> cars = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Car createCar(String brand, String model, int year) {
        Car car = CarMapper.mapToCar(idGenerator.getAndIncrement(), brand, model, year);
        cars.put(car.getId(), car);
        return car;
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars.values());
    }

    public Car getCarById(Long id) {
        Car car = cars.get(id);
        if (car == null) {
            throw new NotFoundException("Car not found");
        }
        return car;
    }

    public void addFuel(Long carId, FuelEntry entry) {
        Car car = getCarById(carId);
        car.getFuelEntries().add(entry);
    }

    public FuelStatsResponse calculateStats(Long carId) {
        Car car = getCarById(carId);

        List<FuelEntry> entries = car.getFuelEntries();
        if (entries.size() < 2) {
            return CarMapper.mapToFuelStats(0, 0, 0);
        }

        double totalFuel = entries.stream().mapToDouble(FuelEntry::getLiters).sum();
        double totalCost = entries.stream().mapToDouble(FuelEntry::getPrice).sum();

        int firstOdometer = entries.get(0).getOdometer();
        int lastOdometer = entries.get(entries.size() - 1).getOdometer();
        double distance = lastOdometer - firstOdometer;

        double avg = (totalFuel / distance) * 100;

        return CarMapper.mapToFuelStats(totalFuel, totalCost, avg);
    }
}
