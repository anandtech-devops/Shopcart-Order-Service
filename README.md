# ShopCart Order Management Service

Developer handover for a database-free Spring Boot REST API.

## Requirements
- Java 21
- Maven 3.9+

## Build
mvn clean package

## Test
mvn test

## Run
mvn spring-boot:run

## Endpoints
GET /actuator/health
POST /api/orders
GET /api/orders
GET /api/orders/{id}
PUT /api/orders/{id}/status

## Configuration
PORT=8080 (optional environment variable)

Orders are stored in memory for this exercise. Restarting the application clears them.
