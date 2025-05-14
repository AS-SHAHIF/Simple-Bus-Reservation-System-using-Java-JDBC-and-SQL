# Simple-Bus-Reservation-System-using-Java-JDBC-and-SQL
## 🚌 Simple Bus Reservation System (Java + JDBC + SQL)

This is a **console-based Java project** for managing a **Bus Reservation System** using **JDBC** for database connectivity and **MySQL** as the backend database. It allows users to **book tickets**, and **view available buses** through a simple command-line interface.

## 🔧 Features

* Add new bus details
* Book tickets
* View bus and booking information
* Admin and user options

## ✅ Requirements

* **Java JDK** (version 8 or above)
* **MySQL Server**
* **JDBC Connector for MySQL** (e.g., `mysql-connector-java.jar`)
* IDE (like **Eclipse**, **IntelliJ**, or **VS Code**) or use **terminal** to compile and run

## 🚀 How to Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/AS-SHAHIF/Simple-Bus-Reservation-System-using-Java-JDBC-and-SQL
cd Simple-Bus-Reservation-System-using-Java-JDBC-and-SQL
```

### Step 2: Set Up MySQL Database

1. Open **MySQL**.
2. Run the `bus_db.sql` file (if provided) or manually create the required tables using the SQL queries in the code.
3. Use your MySQL credentials to update the connection string in the Java code.

```java
// Example:
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_reservation", "root", "your_password");
```

### Step 3: Add MySQL JDBC Connector

* Download the JDBC JAR from [MySQL Official Site](https://dev.mysql.com/downloads/connector/j/)
* Add it to your project’s build path or classpath

### Step 4: Compile and Run
#### Using Command Line:


## 📌 Note

* Make sure your MySQL server is running
* Use correct credentials in the Java code
* Customize database name and table schema if needed

