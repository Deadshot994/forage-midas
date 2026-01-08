# JPMorgan & Chase – Forage Midas Software Engineering Work Simulation

This repository contains my completed work for the JPMorgan & Chase Advanced Software Engineering Virtual Work Simulation on the Forage platform.  
In this simulation, I assumed the role of a backend engineer responsible for building backend services and integrating data systems that handle transactions and user balances.

---

## Project Overview

The Midas Core project is a backend application designed to process financial transactions, integrate with message queues and external services, and expose APIs for retrieving user balance information. Key objectives included:

- Processing streaming transaction data via Kafka
- Implementing persistence with an H2 database using Spring Data JPA
- Integrating with an external Incentive REST service
- Designing REST endpoints for client interaction

---

## Completed Tasks

### 1. Kafka Integration & Initial Setup
- Configured Spring Boot to consume transaction messages from Kafka.
- Implemented a Kafka listener that receives and deserializes transaction messages.
- Verified message flow using tests with an embedded Kafka instance.

### 2. Database Integration & Transaction Persistence
- Designed JPA entities based on the required domain model.
- Stored valid transactions in an H2 in-memory database.
- Updated user balances correctly based on transaction rules.

### 3. Incentive API Integration
- Integrated with an external Incentive REST API to enrich transactions.
- Adjusted user balances based on incentive responses.
- Ensured external service interaction was correct and tested.

### 4. REST API & Balance Endpoint
- Exposed a REST endpoint to retrieve user balances.
- Configured the application to run on a custom port.
- Returned balance information in a client-friendly JSON format.

### 5. Unit Testing
- Created JUnit tests to validate business logic.
- Covered scenarios for transaction processing and balance handling.
- Ensured core behaviors worked correctly under automated test runs.

---

## Skills Demonstrated

- **Spring Boot Development**
  - REST API Design
  - Kafka Messaging Integration
  - External REST API Integration
- **Data Persistence**
  - JPA Entities and In-Memory H2 Database
  - Transactional Data Management
- **Testing**
  - Embedded Kafka Tests
  - JUnit Unit Tests
- **Version Control**
  - Git, branching, and clean commit history

---

## Simulation Reference

[Advanced Software Engineering – JPMorgan & Chase Forage Simulation](https://www.theforage.com/simulations/jpmorgan/advanced-software-engineering-r0fm)  
Powered by **Forage**

---

Thank you for visiting this repository and for your interest in my work.

## Author 
Sanjeeth Manikandan
