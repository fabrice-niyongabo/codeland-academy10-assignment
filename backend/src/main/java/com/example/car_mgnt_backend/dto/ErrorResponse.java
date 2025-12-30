package com.example.car_mgnt_backend.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private Integer statusCode;
}
