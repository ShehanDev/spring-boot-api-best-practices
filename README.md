# Spring Boot API Best Practices: Exception Handling & Swagger Documentation

[![Java Version](https://img.shields.io/badge/Java-17-blue.svg)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## 📌 Overview

A production‑ready reference implementation of a REST API built with **Spring Boot**. This project demonstrates two critical aspects of professional backend development:

- **Global Exception Handling** – Transforming stack traces into structured, client‑friendly error responses using `@RestControllerAdvice`.
- **Interactive API Documentation** – Auto‑generating and customising OpenAPI 3.0 specifications with SpringDoc and Swagger UI.

> **📖 Companion Article:** This repository accompanies the article **[“Building Interview‑Ready REST APIs: Exception Handling and Swagger in Spring Boot”](#)**
> (link coming soon). It provides a deep dive into *why* these patterns matter .

## 🚀 Key Features Demonstrated

| Feature | Implementation Details |
|---------|----------------------|
| **Global Exception Handling** | `@RestControllerAdvice` + `@ExceptionHandler` for consistent error JSON structure. |
| **Custom Business Exceptions** | `EmployeeNotFoundException`, `InvalidRequestException` with appropriate HTTP status mapping. |
| **Input Validation** | Jakarta Bean Validation (`@Valid`) with meaningful error messages. |
| **OpenAPI 3 / Swagger** | SpringDoc OpenAPI starter with customised `@Operation` and `@ApiResponse` annotations. |
| **DTO Pattern** | Clear separation between entity models and API contracts. |
| **RESTful Endpoints** | Full CRUD operations for `Employee` resource following REST conventions. |

## 🛠 Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3.4.0
- **API Documentation:** SpringDoc OpenAPI 2.6.0
- **Build Tool:** Maven
- **Web Server:** Apache Tomcat (embedded)

## 📂 Project Structure

src/
├── main/
│ ├── java/com/shehan/workflow_service/
│ │ ├── controller/ # REST endpoints with Swagger annotations
│ │ ├── dto/ # Data Transfer Objects
│ │ ├── exception/ # Custom exceptions and global handler
│ │ ├── model/ # JPA entities (if applicable)
│ │ └── service/ # Business logic layer
│ └── resources/
│ └── application.yml # Configuration properties


## ⚙️ Getting Started

### Prerequisites
- JDK 17 or higher
- Maven 3.6+

### Run Locally

```bash
# Clone the repository
git clone https://github.com/ShehanDev/spring-boot-api-best-practices.git
cd spring-boot-api-best-practices

# Build and run
./mvnw spring-boot:run

The application will start on http://localhost:8080.
📖 API Documentation (Swagger UI)

Once the application is running, access the interactive API documentation at:

🔗 http://localhost:8080/swagger-ui/index.html

You can also retrieve the raw OpenAPI JSON spec from:

    http://localhost:8080/v3/api-docs

📝 Article Companion: Deep Dive Explained

This repository is designed to support the following technical article structure:
1. The Problem with Default Error Responses

Why raw stack traces in production are harmful and what a well‑structured error response looks like.
2. Implementing Global Exception Handling
java

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(...) { ... }
}

3. Enriching Controllers with Swagger Annotations
java

@Operation(summary = "Create a new employee")
@ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Employee created"),
    @ApiResponse(responseCode = "400", description = "Invalid input")
})
@PostMapping
public ResponseEntity<EmployeeDto> createEmployee(...) { ... }

4. Customising OpenAPI Info & Servers

Using @OpenAPIDefinition to add contact details, license, and server URLs.
5. Testing the API with Postman/cURL

Examples of valid requests and expected error responses.
🧪 Sample API Requests
Create Employee (Success)
bash

curl -X POST http://localhost:8080/v1/api/employees \
  -H "Content-Type: application/json" \
  -d '{"firstName":"John","lastName":"Doe","email":"john.doe@example.com"}'

Employee Not Found (Error Response)
bash

curl -X GET http://localhost:8080/v1/api/employees/999

Response (HTTP 404):
json

{
  "timestamp": "2026-04-15T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Employee with id '999' not found",
  "path": "/v1/api/employees/999"
}

🎯 Why This Matters f

    Demonstrates Clean Code Principles: Separation of concerns, meaningful naming, DTO pattern.

    Shows Production Awareness: You understand that raw exceptions should never leak to clients.

    Highlights Documentation Skills: Teams value developers who document APIs in code using Swagger.

    Proves Framework Mastery: Using @RestControllerAdvice and SpringDoc effectively.

📄 License

This project is licensed under the MIT License – see the LICENSE file for details.
👤 Author

Shehan Dev
