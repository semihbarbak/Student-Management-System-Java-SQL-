# Student Management System (Java & SQL Server)

A simple, modular student management console application built with Java and Microsoft SQL Server. This project demonstrates the core concepts of Object-Oriented Programming (OOP) and database integration using JDBC.

## 🚀 Features
* Add new students to the database.
* View and list all registered students.
* Interactive console-based menu using `Scanner`.
* Auto-incrementing ID management in SQL.

## 🛠️ Technologies Used
* **Java:** Core logic, OOP principles (Model-DAO architecture).
* **Microsoft SQL Server:** Relational database for persistent storage.
* **JDBC:** Database connection and PreparedStatement implementation (Preventing SQL injection).

## 📂 Project Structure
* `com.okul.model`: Contains the `Student` entity class.
* `com.okul.dao`: Data Access Object class for database operations.
* `com.okul.util`: JDBC connection configuration (Windows Authentication enabled).
* `com.okul.main`: The main interactive loop.
