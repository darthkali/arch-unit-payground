# ArchUnit Playground

This repository contains a playground for ArchUnit with a simple pizza ordering system as an example.

## Overview

The pizza ordering system allows users to place orders for pizzas and track the status of their orders. It provides functionalities for ordering pizzas, tracking orders, and managing payments.

## Project Structure

The project follows a hexagonal architecture approach:

- **Application:**
  - Ports:
    - In: Define input ports for use cases.
    - Out: Define output ports for .
  - Service: Implement business logic and application services.
  - Adapter: Manage communication with external systems.


# Pizza Ordering System

This repository contains the source code for a simple pizza ordering system.

## Overview

The pizza ordering system allows users to place orders for pizzas and track the status of their orders. It provides functionalities for ordering pizzas, tracking orders, and managing payments.

## Project Structure

The project follows a clean architecture approach, separating concerns into different layers:

- **Application:**
  - Port:
    - In: Define input ports for use cases.
    - Out: Define output ports for a repository.
  - Service: Implement business logic and application services.
 
- **Adapter:**
    - In: Define input Adapter for a Rest Controller.
    - Out: Define output ports for database.

- **Domain:**
  - Define domain models.



## Usage

To run the pizza ordering system locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/darthkali/arch-unit-playground.git
   ```

2. Navigate to the project directory:

   ```bash
   cd pizza-ordering-system
   ```

3. Build and run the project:

   ```bash
   ./gradlew run
   ```


### Branches
...
