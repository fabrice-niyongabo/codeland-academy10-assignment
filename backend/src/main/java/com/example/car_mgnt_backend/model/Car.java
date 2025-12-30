package com.example.car_mgnt_backend.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Car {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private List<FuelEntry> fuelEntries = new ArrayList<>();
}
