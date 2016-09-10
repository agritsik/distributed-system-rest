# Distributed systems via REST

The project demonstrates how to build a Resilient Distributed System which contains a set of microservices. 

## Motivation

In order to demonstrate how to:

1. Implement microservices which communicate using HTTP/REST protocol
2. Implement patterns for resilient distributed systems such as: API Gateway, Service Discovery, Circuit Breaker etc

## Tooling

The following techologies are used:

1. Java and Spring Boot are used for implementing microservices 
2. Spring Cloud Netflix is used for implementing Api Gateway, Service Discovery, Circuit Breaker etc

## How to run

In order to startup the whole system, you need to execute the following commands for each microservice:
- ```maven clean package``` creates an executable jar using spring-boot-maven-plugin
- ```java -jar target/*.jar``` runs an application

All registered microservices are available in Eureka's admin area http://localhost:8761/

All mapped routes are available via specific Zuul end-point http://localhost:8080/routes 


