# Blood Bank Management System

A console-based Blood Bank Management System developed using Java, JDBC, and MySQL.

The system is designed to improve the efficiency and accuracy of blood bank management by providing functions for managing blood information, donors, blood groups, blood cells, stock, and blood orders.

## Features

### User Functions

- Search blood information
- Search blood group information
- Search blood cell information
- Search donor information
- Search stock information
- Search order information

### Administrator Functions

- Add records
- Edit records
- Delete records
- Update records
- Save records
- Search records

## Main Modules

The system contains the following modules:

- Blood Management
- Blood Group Management
- Blood Cell Management
- Donor Management
- Stock Management
- Order Management

## Technologies Used

- Java
- JDBC
- MySQL
- Navicat

## Database

The project uses a MySQL database named `bloodbankmanagementsystem`.

## Requirements

Before running the project, install:

- Java Development Kit (JDK)
- MySQL Server
- MySQL Connector/J
- An IDE such as IntelliJ IDEA, Eclipse, or NetBeans

Navicat or MySQL Workbench may be used to manage the database.

## Configuration

Update the database configuration in the Java connection class:

```java
String url = "jdbc:mysql://localhost:3306/bloodbankmanagementsystem";
String username = "root";
String password = "YOUR_MYSQL_PASSWORD";
```

Do not upload your real database password to GitHub.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/blood-bank-management-system.git
```

2. Open the project in a Java IDE.
3. Create the MySQL database:

```sql
CREATE DATABASE bloodbankmanagementsystem;
```

4. Import the provided SQL database file.
5. Add MySQL Connector/J to the project dependencies.
6. Update the database username and password.
7. Run the `Main.java` class.
