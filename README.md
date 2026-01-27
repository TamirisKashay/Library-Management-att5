Library Management API (Assignment 3)
Project Overview
This project is a Java-based Library Management system that allows managing books and authors using a relational database (PostgreSQL). It is built with a multi-layer architecture (Controller -> Service -> Repository) to ensure clean code and separation of concerns.

Features & Requirements
1. Object-Oriented Programming (OOP)

Encapsulation: All fields in models (e.g., BookBase, Author) are private, accessed via public getters and setters. 

Inheritance: PrintedBook and EBook extend the abstract BookBase class, reusing common logic. 

Abstraction: BookBase is an abstract class with abstract methods like calculateLateFee() and getBookType(). 

Polymorphism: Used interfaces Displayable and Validatable. The system processes different book types through a single BookBase reference in the Main controller. 

Composition: The Book entity is logically linked to the Author entity, demonstrating an "is-part-of" relationship. 

2. Database & JDBC

JDBC Connection: Implemented via DriverManager in the DatabaseConnection utility class. 

CRUD Operations: The BookRepository performs Create and Delete operations using PreparedStatement to prevent SQL injection. 

Schema: A normalized database with authors and books tables connected by a Foreign Key. 

3. Business Logic & Exceptions

Service Layer: LibraryService handles input validation (e.g., checking for empty titles) before data reaches the database. 

Custom Exceptions: A hierarchy starting from DatabaseOperationException is used to handle runtime SQL errors gracefully. 

Project Structure
Plaintext
src/main/java/org/example/
├── controller/   # Main entry point (Driver program)
├── service/      # Validation & Business logic
├── repository/   # JDBC & SQL queries
├── model/        # OOP Entities & Inheritance
├── interfaces/   # Displayable & Validatable
├── exception/    # Custom exception classes
└── utils/        # Database connection helper
How to Run
Database Setup: Run the SQL script located in docs/schema.sql (or see below) in your DataGrip/PostgreSQL console.

Configuration: Update the URL, USER, and PASSWORD in src/main/java/utils/DatabaseConnection.java.

Build: Run mvn clean install to download the PostgreSQL driver.

Execute: Run the Main.java file in the controller package.

Screenshots & Documentation
Screenshots of the working application are located in the /docs folder.

Console Output: Showing successful polymorphism and service execution.

Database State: Showing tables in DataGrip after running the program.
