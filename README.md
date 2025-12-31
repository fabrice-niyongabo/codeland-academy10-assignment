# Car Management & Fuel Tracking System

A complete Java-based system for managing cars and tracking fuel consumption with a REST API backend, servlet implementation, and CLI client.

## 📋 Project Overview

This project consists of two main components:
- **Backend REST API**: Java application with in-memory storage
- **CLI Client**: Standalone Java application that communicates with the backend via HTTP

## 🚀 Quick Start

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Git

### 1. Clone and Setup
```bash
# Clone the repository
git clone https://github.com/fabrice-niyongabo/codeland-academy10-assignment.git
cd codeland-academy10-assignment
```

### 2. Build and Run Backend Server
open terminal and run the following commands
```bash
# Navigate to backend directory
cd backend

# Run the server
mvn spring-boot:run
```
The server will start at: `http://localhost:8080`

### 3. Build and Run CLI Client
While the previous terminal is still open (and the backend server is running), open another separate terminal and
```bash
cd cli

# Build the CLI
mvn clean package

# Run the CLI
java -jar target/cli.jar

# Create car
java -jar target/cli.jar create-car --brand Toyota --model Camry --year 2020
# Add Fuel
java -jar target/cli.jar add-fuel --carId 1 --liters 40.5 --price 1.85 --odometer 15000
java -jar target/cli.jar add-fuel --carId 1 --liters 38.2 --price 1.90 --odometer 15480
# Get fuel stats
java -jar target/cli.jar fuel-stats --carId 1
```

## 📡 API Endpoints

### REST API Endpoints
| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| POST | `/api/cars` | Create a new car | `{"brand":"Toyota","model":"Camry","year":2020}` |
| GET | `/api/cars` | List all cars | N/A |
| POST | `/api/cars/{id}/fuel` | Add fuel entry for a car | `{"liters":40.5,"price":1.85,"odometer":15000}` |
| GET | `/api/cars/{id}/fuel/stats` | Get fuel statistics | N/A |

### Servlet Endpoint
- **GET** `/servlet/fuel-stats?carId={id}` - Servlet implementation demonstrating manual request handling


## 🎯 Assignment Requirements Checklist

- [x] Backend REST API with all required endpoints
- [x] In-memory storage (no database)
- [x] Manual Java Servlet implementation
- [x] CLI client using java.net.http.HttpClient
- [x] Proper error handling (404, 400 status codes)
- [x] Statistics calculation (total fuel, cost, avg/100km)
- [x] Input validation
- [x] Separate modules for backend and CLI
- [x] Clean, readable code structure
