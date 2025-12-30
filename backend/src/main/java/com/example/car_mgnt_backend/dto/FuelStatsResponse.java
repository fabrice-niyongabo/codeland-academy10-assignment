package com.example.car_mgnt_backend.dto;

import lombok.Data;

@Data
public class FuelStatsResponse {
    private double totalFuel;
    private double totalCost;
    private double avgConsumption;
}
