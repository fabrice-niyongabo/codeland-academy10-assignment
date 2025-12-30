# 🚗 Car Management & Fuel Tracking System

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
git clone <repository-url>
cd car-management-system
```

### 2. Build and Run Backend Server
```bash
# Navigate to backend directory
cd backend

# Build the project
mvn clean package

# Run the server
java -jar target/car-management-backend-1.0.0.jar
```
The server will start at: `http://localhost:8080`

### 3. Build and Run CLI Client
```bash
# Open a new terminal
cd cli-client

# Build the CLI
mvn clean package

# Run the CLI
java -jar target/car-management-cli-1.0.0.jar
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

## 💻 CLI Commands

Once the CLI is running, use these commands:

### 1. Create a Car
```
create-car --brand Toyota --model Corolla --year 2018
```

### 2. Add Fuel Entry
```
add-fuel --carId 1 --liters 40 --price 52.5 --odometer 45000
```

### 3. Get Fuel Statistics
```
fuel-stats --carId 1
```

### 4. Exit Application
```
exit
```

## 📊 Example Workflow

```bash
# Start the backend server
java -jar backend/target/car-management-backend-1.0.0.jar

# In another terminal, run the CLI
java -jar cli-client/target/car-management-cli-1.0.0.jar

# Use the following commands in the CLI:
> create-car --brand Toyota --model Camry --year 2020
> add-fuel --carId 1 --liters 40.5 --price 1.85 --odometer 15000
> add-fuel --carId 1 --liters 38.2 --price 1.90 --odometer 15480
> fuel-stats --carId 1
```

**Expected Statistics Output:**
```json
{
  "totalFuel": 78.7,
  "totalCost": 147.25,
  "averageConsumptionPer100km": 8.18,
  "totalDistance": 480,
  "numberOfRefuels": 2
}
```

## 🛠️ Technical Features

### Backend Features
- **In-Memory Storage**: Uses ConcurrentHashMap for thread-safe data storage
- **RESTful API**: Clean REST endpoints with proper HTTP status codes
- **Servlet Implementation**: Manual HttpServlet with query parameter parsing
- **Error Handling**: Comprehensive error handling with meaningful responses
- **Input Validation**: Validates all inputs (positive values, increasing odometer)
- **Thread Safety**: Concurrent data structures for safe multi-threaded access

### CLI Features
- **HTTP Client**: Uses `java.net.http.HttpClient` for API communication
- **Interactive Interface**: User-friendly command-line interface
- **Error Feedback**: Clear error messages for invalid commands
- **JSON Processing**: Handles JSON requests and responses

## 🔧 Development

### Building from Source
```bash
# Build both modules
mvn clean package -f backend/pom.xml
mvn clean package -f cli/pom.xml
```
## 🧪 Testing Examples

### API Testing with curl
```bash
# Create a car
curl -X POST http://localhost:8080/api/cars \
  -H "Content-Type: application/json" \
  -d '{"brand":"Honda","model":"Civic","year":2019}'

# Add fuel entry
curl -X POST http://localhost:8080/api/cars/1/fuel \
  -H "Content-Type: application/json" \
  -d '{"liters":35.5,"price":1.75,"odometer":25000}'

# Get statistics via REST API
curl http://localhost:8080/api/cars/1/fuel/stats

# Get statistics via Servlet
curl "http://localhost:8080/servlet/fuel-stats?carId=1"
```


## 📝 Implementation Details

### Key Classes

**Backend:**
- `CarService`: Manages car data in memory and handles fuel entries and statistics calculation
- `CarController`, `FuelController`: REST endpoint handlers
- `FuelStatsServlet`: Manual servlet implementation
- `StatsResponse`: DTO for statistics data

**CLI:**
- `CarCLI`: Main CLI application with command parsing
- Uses Java 11+ HttpClient for HTTP requests

### Data Models
- **Car**: `id`, `brand`, `model`, `year`
- **FuelEntry**: `id`, `carId`, `liters`, `pricePerLiter`, `odometer`, `timestamp`

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
