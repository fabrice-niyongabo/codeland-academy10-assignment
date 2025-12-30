package com.example.car_mgnt_backend.dto;

public class AddFuelResponse {
    private String message;

    public AddFuelResponse(String msg){
        message = msg;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
