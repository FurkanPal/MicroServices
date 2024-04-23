# MicroServiceDemo Application

This is a simple microservice application built for testing and learning purpose.
Built with Java, Maven, and Spring Boot. The application consists of four sections and three services: ProductService, InventoryService, OrderService and Eureka server.

## ProductService

The ProductService is the main entry point for this microservice application. It is built with Spring Boot and is annotated with `@SpringBootApplication` and `@EnableDiscoveryClient` to enable service discovery. This service is responsible for managing the products in the system.

### Running the ProductService separately

1. Navigate to the ProductService directory
2. Run `mvn spring-boot:run` to start the ProductService

## InventoryService

The InventoryService is a key component of this microservice application. It is responsible for managing the inventory of products. It has methods for adding to the stock and checking if a product is in stock. The service uses `InventoryRepository` to interact with the database.

### Running the InventoryService separately

1. Navigate to the InventoryService directory
2. Run `mvn spring-boot:run` to start the InventoryService

## OrderService

The OrderService is another crucial part of this microservice application. It is responsible for managing orders in the system. It interacts with both the ProductService and the InventoryService to ensure that orders can be placed if and only if the products are available in the inventory.

### Running the OrderService separately

1. Navigate to the OrderService directory
2. Run `mvn spring-boot:run` to start the OrderService

## Eureka Server

The Eureka Server is a service discovery server used in this microservice application. It allows the microservices to register themselves and to discover other services to interact with.

### Running the Eureka Server separately

1. Navigate to the Eureka Server directory
2. Run `mvn spring-boot:run` to start the Eureka Server

### Accessing the Eureka Dashboard

Once the Eureka Server is running, you can access the Eureka Dashboard by navigating to `http://localhost:8761` in your web browser. The dashboard provides a view of all the registered services.

### Integrating with Eureka Server

The microservices in this application are configured to register with the Eureka Server. This is done by adding the `@EnableDiscoveryClient` annotation in the main application class and configuring the application name and Eureka Server URL in the `application.properties` file.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or higher
- Maven

### Installing

1. Clone the repository
2. Navigate to the project directory
3. Run `mvn clean install` to build the project

### Running the application

1. Navigate to the ProductService directory
2. Run `mvn spring-boot:run` to start the ProductService
3. Navigate to the InventoryService directory
4. Run `mvn spring-boot:run` to start the InventoryService

## Built With

- [Java](https://www.java.com/) - The programming language used
- [Maven](https://maven.apache.org/) - Dependency Management
- [Spring Boot](https://spring.io/projects/spring-boot) - The framework used for creating standalone, production-grade Spring based Applications

## Authors

- [FurkanPala](https://github.com/FurkanPal)
