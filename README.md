Event Management System
Overview
The Event Management System is a web-based application designed to help users create, manage, and register for events. It is built with Java, using JPA (Java Persistence API) for data persistence and JUnit for unit testing. The system allows event organizers to create events, while users can register for and view upcoming events. It also supports features like event creation, registration, and event cancellation.

This system provides a simple yet powerful solution for managing events, handling registrations, and maintaining an organized event lifecycle from creation to participation.

Features
Event Management:

Create and manage events with details like name, date, and location.
Edit or delete events.
View event details and participant lists.
User Registration & Management:

Users can register to the system.
Users can register for specific events.
Users can cancel their registrations for events.
Registration Management:

Users can view their registered events.
Check if a user is already registered for an event.
Delete registrations if necessary.
Database Integration:

Uses JPA for database interactions to persist users, events, and registrations.
Integration with relational databases like MySQL, PostgreSQL, or an in-memory database like H2 for testing.
Unit Testing:

Unit tests for core functionalities such as event creation, registration, and user management.
Technology Stack
Java: Core programming language used to develop the backend.
JPA (Java Persistence API): For database interactions (CRUD operations).
JUnit: For unit testing to ensure functionality.
H2 Database: Used for testing (in-memory database).
Maven: Build tool to manage dependencies and run tests.
