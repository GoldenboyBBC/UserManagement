# User Management Application

This project is a simple User Management web application built with Java and the Spring Boot framework. It serves as a learning project to understand the fundamentals of Java and Spring Boot development.

## Purpose

The primary purpose of this application is to provide a hands-on learning experience with:
*   Building web applications using Spring Boot.
*   Implementing user authentication (registration and login).
*   Managing user data.

## Features

Currently, the application provides the following functionalities:
*   **User Registration:** Allows new users to create an account.
*   **User Login:** Authenticates existing users.
*   **View Users:** Displays a list of all registered users.

## Technology Stack

*   **Java:** The core programming language.
*   **Spring Boot:** The main framework for building the application.
*   **Spring Web:** Used for creating the web-based API and handling HTTP requests.
*   **Thymeleaf:** A server-side Java template engine for dynamic web pages.
*   **Maven:** Used for project build automation and dependency management.

## Future Goals

*   **Organization Management:** Implement features to organize users into groups or departments.
*   **Role-Based Access Control (RBAC):** Introduce roles and permissions to control user access to different parts of the application.

## Getting Started

### Prerequisites

To run this application, you will need:
*   Java Development Kit (JDK) - Version 17 or higher recommended.
*   Apache Maven - Version 3.6 or higher.

### Running the Application

You can run the application using the provided `start.bat` script (for Windows) or directly with Maven. The application will start on `http://localhost:80`.

```bash
# On Windows
./start.bat

# On other systems (or as an alternative)
./mvnw spring-boot:run
```

### Building the Project

To compile the project and package it into a JAR file, use the following Maven command:

```bash
./mvnw clean install
```

### Running Tests

To execute the unit and integration tests, use the following command:

```bash
./mvnw test
```

## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, please feel free to DM me on Discord: *Goldenboyi*
