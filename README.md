# TDD-Workshop-Task-App

A simple Task Management application built with Spring Boot, Thymeleaf, and JPA.  
Used for practicing clean architecture, testing, and TDD fundamentals.

## Features

- Add new tasks
- Mark tasks as done / undone
- Delete tasks
- Store tasks in an H2 database
- Minimal UI with Thymeleaf

## Project Structure

src/main/java/com/tdd/workshop/taskapp
├─ TaskappApplication.java
└─ task
├─ model → JPA entity (Task)
├─ persistence → Spring Data repository
├─ service → Business logic
└─ web → MVC controller


## Tests

Unit and integration tests are included:

- `TaskServiceTest` (Mockito)
- `TaskControllerTest` (WebMvcTest)
- `TaskRepositoryTest` (DataJpaTest)

All test methods follow the naming convention:

testXxxYyyZzz()


## How to Run

```bash
./mvnw spring-boot:run

```

Open the app:

http://localhost:8080


## How to Run Tests

```bash
./mvnw test
```

## Requirements

- Java 17+

- Maven (wrapper included)

