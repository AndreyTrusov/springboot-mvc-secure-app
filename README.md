# springboot-mvc-secure-app
A Spring Boot MVC web application with Thymeleaf featuring a custom theme, secure login, role-based access control, and multi-table database interactions. Designed for effective data management and seamless user interaction.

## Database Design and Structure
First I started with **creating** and filling database for this project, below is a **database schema** that describes the structure and relationships between the various entities in the system:

<img width="1178" alt="image" src="https://github.com/user-attachments/assets/2debf7e2-1bab-4fe2-ac08-c716992ac29c" />

## Screenshots

Below are some screenshots from the app that demonstrate its main features:

<img width="1287" alt="image" src="https://github.com/user-attachments/assets/b3fd9682-6c7a-46ae-a526-5541d6c57c81" />

## Key Features:
- User Authentication: Login and registration functionalities with hashed password.
- Role-based Access Control: Different user roles (Admin, Creator, User) with specific access rights.
- Profile Management: Users can update their profile with a clean UI.
- Event Creation: Users can create, update, and manage events.
- Location Creation: Admin can define and manage event locations.
- Security: Protection against CSRF, SQL injection, and other common security threats.
- Thymeleaf: Utilizes Thymeleaf templating engine for dynamic HTML content.

## Prerequisites

Before setting up the project, ensure you have the following installed:

Java 17+ or the latest stable version.
Maven for dependency management and project building.
MySQL or H2 Database (used for storing user and application data).

## Setup Instructions

1. Clone the Repository
Clone the project to your local machine:

`git clone https://github.com/AndreyTrusov/springboot-mvc-secure-app.git
cd spring-boot-mvc-secure-app`

2. Configure the Database

Edit the application.properties file located in src/main/resources to configure the database connection:

`spring.application.name=springboot-mvc-secure-app
spring.datasource.url=jdbc:mysql://localhost:3306/mvcproject_1
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`

3. Build the Project
Use Maven to build the project:

`mvn clean install
mvn spring-boot:run`

5. Access the Application
Login: Navigate to http://localhost:8080
