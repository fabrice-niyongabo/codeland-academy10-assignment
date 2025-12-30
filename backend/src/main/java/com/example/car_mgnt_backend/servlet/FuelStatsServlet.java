package com.example.car_mgnt_backend.servlet;

import com.example.car_mgnt_backend.dto.FuelStatsResponse;
import com.example.car_mgnt_backend.service.CarService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/fuel-stats")
public class FuelStatsServlet extends HttpServlet {
    @Autowired
    private CarService carService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String carIdParam = request.getParameter("carId");

        if (carIdParam == null || carIdParam.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{\"error\":\"carId parameter is required\"}");
            return;
        }

        Long carId;
        try {
            carId = Long.parseLong(carIdParam);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{\"error\":\"Invalid carId format\"}");
            return;
        }

        FuelStatsResponse stats;
        try{
            stats = carService.calculateStats(carId);
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print("{\"error\":\""+ e.getMessage() +"\"}");
            return;
        }

        response.setContentType("application/json");

        if (stats == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            PrintWriter out = response.getWriter();
            out.print("{\"error\":\"Car not found\"}");
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        String json = objectMapper.writeValueAsString(stats);
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}