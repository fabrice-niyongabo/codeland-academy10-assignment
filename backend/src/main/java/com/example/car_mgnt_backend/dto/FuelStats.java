package com.example.car_mgnt_backend.dto;

import lombok.Data;

@Data
public class FuelStats {
    private double totalFuel;
    private double totalCost;
    private double avgConsumption;
}
