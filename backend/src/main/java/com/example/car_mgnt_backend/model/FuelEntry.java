package com.example.car_mgnt_backend.model;

import lombok.Data;

@Data
public class FuelEntry {
    private double liters;
    private double price;
    private int odometer;
}
