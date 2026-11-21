# Chapter 13: JDBC (Java Database Connectivity)

## 1. Introduction to JDBC

JDBC stands for **Java Database Connectivity**.

It is a Java API that allows Java applications to connect to databases, execute SQL queries, retrieve results, update records, and manage database transactions.

Using JDBC, Java applications can communicate with databases such as:

- MySQL
- PostgreSQL
- Oracle Database
- Microsoft SQL Server
- SQLite (using a suitable JDBC driver)

### Why do we need JDBC?

Consider a Student Management System.

The application needs to:

1. Register new students.
2. Store student information.
3. Retrieve student records.
4. Update student details.
5. Delete student records.

Java handles the application logic, while the database stores information permanently.

JDBC acts as the communication layer between Java and the database.

### Basic JDBC Architecture

```text
       Java Application
              |
              v
          JDBC API
              |
              v
         JDBC Driver
              |
              v
           Database
              |
              v
         Query Results
              |
              v
       Java Application
```

### Advantages of JDBC

1. Connects Java applications to relational databases.
2. Executes SQL statements from Java.
3. Supports CRUD operations.
4. Supports transaction management.
5. Supports batch processing.
6. Provides database metadata.
7. Supports stored procedures.
8. Provides a standard API across different database systems.

---

## 2. JDBC Architecture

JDBC architecture is generally explained using two approaches.

### 2.1 Two-Tier Architecture

In two-tier architecture, the Java application communicates directly with the database using a JDBC driver.

```text
+-----------------------+
|   Java Application    |
+-----------------------+
           |
           | JDBC
           v
+-----------------------+
|     JDBC Driver       |
+-----------------------+
           |
           v
+-----------------------+
|       Database        |
+-----------------------+
```

Example: A desktop Java application directly connecting to MySQL.

### 2.2 Three-Tier Architecture

In three-tier architecture, an application server or backend service sits between the client and the database.

```text
+-----------------------+
|    Client / Frontend  |
+-----------------------+
           |
           v
+-----------------------+
|   Application Server  |
|     Java Backend      |
+-----------------------+
           |
           v
+-----------------------+
|       JDBC API        |
+-----------------------+
           |
           v
+-----------------------+
|       Database        |
+-----------------------+
```

Example: A web application where a frontend communicates with a Java backend, and the backend uses JDBC to access MySQL.

---

## 3. JDBC Drivers

A JDBC Driver is software that enables communication between a Java application and a database.

### Types of JDBC Drivers

There are four traditional types of JDBC drivers.

| Driver Type | Name | Description |
|---|---|---|
| Type 1 | JDBC-ODBC Bridge | Converts JDBC calls into ODBC calls |
| Type 2 | Native API Driver | Uses database-specific native libraries |
| Type 3 | Network Protocol Driver | Sends JDBC requests to middleware |
| Type 4 | Thin Driver | Communicates directly using the database protocol |

### Type 1: JDBC-ODBC Bridge Driver

```text
Java Application
       |
       v
    JDBC API
       |
       v
 JDBC-ODBC Bridge
       |
       v
      ODBC
       |
       v
    Database
```

This driver depended on ODBC and is obsolete. The JDBC-ODBC Bridge was removed from the JDK in Java 8.

### Type 2: Native API Driver

Uses database-specific native libraries to communicate with the database.

### Type 3: Network Protocol Driver

Uses middleware to translate JDBC requests into database-specific communication.

### Type 4: Thin Driver

Directly communicates with the database using its network protocol.

**Most commonly used:** Type 4 drivers.

For example, MySQL Connector/J is a Type 4 JDBC driver.

---

## 4. JDBC API Components

JDBC provides several important interfaces and classes.

| Component | Purpose |
|---|---|
| DriverManager | Manages JDBC drivers and establishes connections |
| Connection | Represents a database connection |
| Statement | Executes static SQL statements |
| PreparedStatement | Executes parameterized SQL statements |
| CallableStatement | Executes stored procedures |
| ResultSet | Stores query results |
| SQLException | Represents database-related errors |
| DatabaseMetaData | Provides information about the database |
| ResultSetMetaData | Provides information about query result columns |

### JDBC Packages

Most JDBC interfaces are available in:

```java
java.sql
```

Additional database access functionality is available in:

```java
javax.sql
```

### Important JDBC Interfaces

**1. DriverManager**

Used to establish a connection between Java and a database.

```java
Connection con = DriverManager.getConnection(
    url, username, password
);
```

**2. Connection**

Represents an active connection to a database.

```java
Connection con = DriverManager.getConnection(
    url, username, password
);
```

**3. Statement**

Executes static SQL statements.

```java
Statement stmt = con.createStatement();
```

**4. PreparedStatement**

Executes parameterized SQL statements.

```java
PreparedStatement ps = con.prepareStatement(
    "SELECT * FROM students WHERE id = ?"
);
```

**5. CallableStatement**

Executes stored procedures.

```java
CallableStatement cs = con.prepareCall(
    "{CALL GetStudentById(?)}"
);
```

**6. ResultSet**

Stores and provides access to records returned by a SELECT query.

```java
ResultSet rs = stmt.executeQuery(
    "SELECT * FROM students"
);
```

---

## 5. Installing and Configuring MySQL JDBC Driver

To connect Java with MySQL, we need:

1. JDK.
2. MySQL Server.
3. MySQL database.
4. MySQL Connector/J.
5. Java IDE or editor.

### Step 1: Install MySQL

Install and start MySQL Server.

Verify that you can access MySQL:

```bash
mysql -u root -p
```

### Step 2: Create a Database

Execute this SQL query:

```sql
CREATE DATABASE java_jdbc;

USE java_jdbc;
```

### Step 3: Add MySQL Connector/J

If you are using Maven, add the following dependency to `pom.xml`.

For this Java 8 tutorial, Connector/J 8.0.33 is used as an example.

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

If you are not using Maven, download the MySQL Connector/J JAR and add it to your project's classpath.

### Step 4: Verify the Driver

The driver class for MySQL Connector/J 8 is:

```java
com.mysql.cj.jdbc.Driver
```

JDBC 4 drivers are normally discovered automatically when the driver JAR is on the classpath.

Explicit driver loading using `Class.forName()` is also shown in many educational examples.

---

## 6. Connecting Java to MySQL

The `DriverManager.getConnection()` method establishes a database connection.

### JDBC Connection Syntax

```java
Connection connection = DriverManager.getConnection(
    url,
    username,
    password
);
```

### MySQL Connection URL

```java
String url = "jdbc:mysql://localhost:3306/java_jdbc";
```

URL components:

| Component | Meaning |
|---|---|
| jdbc:mysql | MySQL JDBC protocol |
| localhost | Database server address |
| 3306 | Default MySQL port |
| java_jdbc | Database name |

### Example: Establishing a Connection

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection =
                DriverManager.getConnection(
                    url,
                    username,
                    password
                );

            System.out.println(
                "Database Connected Successfully!"
            );

            connection.close();

        } catch (ClassNotFoundException |
                 SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Output:**

```text
Database Connected Successfully!
```

The output assumes MySQL is running, the database exists, and the credentials are correct.

**Important:** Replace `your_password` with your actual database password. Never commit real database credentials to GitHub.

### Better Approach: Try-With-Resources

Try-with-resources automatically closes JDBC resources.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        try (
            Connection connection =
                DriverManager.getConnection(
                    url, username, password
                )
        ) {

            System.out.println("Connected Successfully!");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

This is the recommended approach for managing JDBC resources.

---

## 7. Creating a Table Using JDBC

Before inserting records, create a table.

### SQL Query

```sql
USE java_jdbc;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    age INT,
    marks DOUBLE
);
```

### Table Structure

| Column | Data Type | Description |
|---|---|---|
| id | INT | Student ID |
| name | VARCHAR(100) | Student name |
| email | VARCHAR(150) | Student email |
| age | INT | Student age |
| marks | DOUBLE | Student marks |

### Java Program to Create a Table

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query =
            "CREATE TABLE IF NOT EXISTS students (" +
            "id INT PRIMARY KEY AUTO_INCREMENT, " +
            "name VARCHAR(100) NOT NULL, " +
            "email VARCHAR(150) UNIQUE, " +
            "age INT, " +
            "marks DOUBLE)";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement()
        ) {

            stmt.executeUpdate(query);

            System.out.println(
                "Table Created Successfully!"
            );

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Output:**

```text
Table Created Successfully!
```

---

## 8. Statement Interface

The `Statement` interface is used to execute static SQL statements.

It belongs to the `java.sql` package.

A Statement object is created using the `createStatement()` method of the Connection interface.

### Syntax

```java
Statement stmt = connection.createStatement();
```

### Important Methods of Statement

| Method | Description | Return Type |
|---|---|---|
| `executeQuery(String sql)` | Executes SELECT queries and returns records | ResultSet |
| `executeUpdate(String sql)` | Executes INSERT, UPDATE, DELETE, and DDL statements | int |
| `execute(String sql)` | Executes general SQL statements | boolean |
| `addBatch(String sql)` | Adds an SQL command to a batch | void |
| `executeBatch()` | Executes all commands in the batch | int[] |
| `clearBatch()` | Removes pending commands from the batch | void |
| `getResultSet()` | Retrieves the current ResultSet | ResultSet |
| `getUpdateCount()` | Returns the number of affected rows | int |
| `getMoreResults()` | Moves to the next result when multiple results exist | boolean |
| `close()` | Closes the Statement object | void |

### 8.1 executeQuery()

The `executeQuery()` method is used to execute SELECT queries.

It returns a ResultSet containing the retrieved records.

**Syntax:**

```java
ResultSet rs = stmt.executeQuery(
    "SELECT * FROM students"
);
```

### Example: Retrieve All Students Using Statement

```java
import java.sql.*;

public class StatementSelectExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query = "SELECT * FROM students";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query)
        ) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(
                    id + " | " + name + " | " + age
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Possible Output:**

```text
1 | Ayush | 22
2 | Rahul | 23
3 | Priya | 21
```

### 8.2 executeUpdate()

The `executeUpdate()` method is used for:

- INSERT
- UPDATE
- DELETE
- DDL statements such as CREATE TABLE and ALTER TABLE

It returns the affected-row count. For DDL statements, it commonly returns 0.

**Syntax:**

```java
int rows = stmt.executeUpdate(sql);
```

### Example: INSERT Using Statement

```java
import java.sql.*;

public class StatementInsertExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query =
            "INSERT INTO students(name, email, age, marks) " +
            "VALUES('Ayush', 'ayush@example.com', 22, 85.5)";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement()
        ) {

            int rows = stmt.executeUpdate(query);

            System.out.println(
                rows + " record inserted."
            );

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Output:**

```text
1 record inserted.
```

### Example: UPDATE Using Statement

```java
String sql =
    "UPDATE students SET age = 23 WHERE id = 1";

try (Statement stmt = con.createStatement()) {

    int rows = stmt.executeUpdate(sql);

    System.out.println(
        rows + " record(s) updated."
    );
}
```

**Output:**

```text
1 record(s) updated.
```

### Example: DELETE Using Statement

```java
String sql =
    "DELETE FROM students WHERE id = 1";

try (Statement stmt = con.createStatement()) {

    int rows = stmt.executeUpdate(sql);

    System.out.println(
        rows + " record(s) deleted."
    );
}
```

### 8.3 execute()

The `execute()` method is used to execute general SQL statements when the result type may vary.

It returns:

- `true` if the first result is a ResultSet.
- `false` if the first result is an update count or there is no result.

**Example:**

```java
String sql = "SELECT * FROM students";

try (Statement stmt = con.createStatement()) {

    boolean hasResultSet = stmt.execute(sql);

    if (hasResultSet) {

        try (ResultSet rs = stmt.getResultSet()) {

            while (rs.next()) {

                System.out.println(
                    rs.getString("name")
                );
            }
        }

    } else {

        System.out.println(
            "Update Count: " + stmt.getUpdateCount()
        );
    }
}
```

For statements that return multiple results, JDBC also provides `getMoreResults()`.

**Important:** Statement is suitable for fixed SQL queries. Avoid concatenating untrusted user input into SQL strings because it can introduce SQL injection vulnerabilities.

---

## 9. ResultSet Interface

ResultSet stores the records returned by a SELECT query.

It provides methods to access individual column values.

### Important ResultSet Methods

| Method | Description |
|---|---|
| `next()` | Moves the cursor to the next row |
| `getInt()` | Retrieves an integer column |
| `getString()` | Retrieves a string column |
| `getDouble()` | Retrieves a double column |
| `getBoolean()` | Retrieves a boolean column |
| `getDate()` | Retrieves a SQL date |
| `getObject()` | Retrieves a column as an object |
| `getMetaData()` | Retrieves metadata about result columns |
| `wasNull()` | Checks whether the last retrieved SQL value was NULL |
| `close()` | Closes the ResultSet |

### Example: Retrieve All Students

```java
import java.sql.*;

public class ResultSetExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query = "SELECT * FROM students";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query)
        ) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                double marks = rs.getDouble("marks");

                System.out.println(
                    id + " | " + name + " | " +
                    email + " | " + age + " | " + marks
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Possible Output:**

```text
1 | Ayush | ayush@example.com | 22 | 85.5
```

### How does next() work?

Initially, the ResultSet cursor is positioned before the first row.

```text
Before first row
       |
       v
+----------------+
| Student 1      |
+----------------+
| Student 2      |
+----------------+
| Student 3      |
+----------------+
```

Each call to `next()` moves the cursor forward.

It returns:

- `true` if another row exists.
- `false` if there are no more rows.

### Types of ResultSet

| Type | Description |
|---|---|
| TYPE_FORWARD_ONLY | Cursor moves only forward |
| TYPE_SCROLL_INSENSITIVE | Cursor can move forward and backward; generally does not reflect changes made after creation |
| TYPE_SCROLL_SENSITIVE | Cursor can move forward and backward; may reflect certain database changes |

### Example: Scrollable ResultSet

```java
Statement stmt = con.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,
    ResultSet.CONCUR_READ_ONLY
);

ResultSet rs = stmt.executeQuery(
    "SELECT * FROM students"
);

rs.last();

System.out.println(
    "Last Student: " + rs.getString("name")
);

rs.first();

System.out.println(
    "First Student: " + rs.getString("name")
);

rs.absolute(2);

System.out.println(
    "Second Student: " + rs.getString("name")
);
```

Other useful navigation methods include:

- `first()`
- `last()`
- `previous()`
- `absolute(int row)`
- `relative(int rows)`
- `beforeFirst()`
- `afterLast()`

Scrollable ResultSets require a compatible driver and database configuration.

---

## 10. PreparedStatement Interface

`PreparedStatement` is a subinterface of `Statement`.

It is used to execute parameterized SQL queries.

It allows us to pass values dynamically using the `?` placeholder.

### Syntax

```java
PreparedStatement ps = connection.prepareStatement(
    "SELECT * FROM students WHERE id = ?"
);
```

The question mark represents a parameter.

**Important:** Parameter indexes start from 1, not 0.

### Advantages of PreparedStatement

1. Helps prevent SQL injection when parameters are used correctly.
2. Supports parameterized queries.
3. Improves readability.
4. Makes it easier to reuse the same SQL structure with different values.
5. Can improve performance when a statement is reused, depending on the driver and database.

### 10.1 Important Parameter-Setting Methods

| Method | Description |
|---|---|
| `setInt(index, value)` | Sets an integer value |
| `setString(index, value)` | Sets a String value |
| `setLong(index, value)` | Sets a long value |
| `setFloat(index, value)` | Sets a float value |
| `setDouble(index, value)` | Sets a double value |
| `setBoolean(index, value)` | Sets a boolean value |
| `setDate(index, value)` | Sets a SQL Date value |
| `setTime(index, value)` | Sets a SQL Time value |
| `setTimestamp(index, value)` | Sets a SQL Timestamp value |
| `setBigDecimal(index, value)` | Sets a BigDecimal value |
| `setObject(index, value)` | Sets a parameter using an object |
| `setNull(index, sqlType)` | Sets a parameter to SQL NULL |

### 10.2 Other Important PreparedStatement Methods

| Method | Description | Return Type |
|---|---|---|
| `executeQuery()` | Executes SELECT queries | ResultSet |
| `executeUpdate()` | Executes INSERT, UPDATE, DELETE, and DDL | int |
| `execute()` | Executes general SQL statements | boolean |
| `addBatch()` | Adds the current parameter values to a batch | void |
| `executeBatch()` | Executes the accumulated batch | int[] |
| `clearParameters()` | Clears the current parameter values | void |
| `clearBatch()` | Clears pending batch entries | void |
| `close()` | Closes the PreparedStatement | void |

### 10.3 INSERT Using PreparedStatement

```java
import java.sql.*;

public class PreparedStatementInsertExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query =
            "INSERT INTO students(name, email, age, marks) " +
            "VALUES(?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setString(1, "Rahul");
            ps.setString(2, "rahul@example.com");
            ps.setInt(3, 23);
            ps.setDouble(4, 90.5);

            int rows = ps.executeUpdate();

            System.out.println(
                rows + " record inserted."
            );

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Output:**

```text
1 record inserted.
```

### 10.4 SELECT Using PreparedStatement

```java
import java.sql.*;

public class PreparedStatementSelectExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String sql =
            "SELECT id, name, age FROM students WHERE id = ?";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, 1);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println(
                        "ID: " + rs.getInt("id")
                    );

                    System.out.println(
                        "Name: " + rs.getString("name")
                    );

                    System.out.println(
                        "Age: " + rs.getInt("age")
                    );

                } else {

                    System.out.println("Student not found.");
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Possible Output:**

```text
ID: 1
Name: Ayush
Age: 22
```

### 10.5 UPDATE Using PreparedStatement

```java
String sql =
    "UPDATE students SET age = ? WHERE id = ?";

try (PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setInt(1, 23);
    ps.setInt(2, 1);

    int rows = ps.executeUpdate();

    System.out.println(
        rows + " record(s) updated."
    );
}
```

Explanation:

- `setInt(1, 23)` sets the new age.
- `setInt(2, 1)` identifies the student.
- `executeUpdate()` executes the UPDATE query.

### 10.6 DELETE Using PreparedStatement

```java
String sql =
    "DELETE FROM students WHERE id = ?";

try (PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setInt(1, 1);

    int rows = ps.executeUpdate();

    System.out.println(
        rows + " record(s) deleted."
    );
}
```

### 10.7 Multiple Conditions Using PreparedStatement

We can use multiple placeholders in a single SQL query.

```java
String sql =
    "SELECT * FROM students WHERE age > ? AND name = ?";

try (PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setInt(1, 20);
    ps.setString(2, "Ayush");

    try (ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getInt("age")
            );
        }
    }
}
```

### 10.8 Reusing PreparedStatement

A PreparedStatement can be reused with different parameter values.

```java
String sql =
    "SELECT * FROM students WHERE age > ?";

try (PreparedStatement ps = con.prepareStatement(sql)) {

    // First execution
    ps.setInt(1, 18);

    try (ResultSet rs = ps.executeQuery()) {

        System.out.println("Students older than 18:");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }

    // Second execution
    ps.setInt(1, 21);

    try (ResultSet rs = ps.executeQuery()) {

        System.out.println("Students older than 21:");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }
}
```

The same PreparedStatement object is reused, but the parameter value changes for each execution.

### 10.9 SQL NULL Using setNull()

The `setNull()` method is used to pass SQL NULL as a parameter.

```java
String sql =
    "UPDATE students SET email = ? WHERE id = ?";

try (PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setNull(1, Types.VARCHAR);
    ps.setInt(2, 1);

    int rows = ps.executeUpdate();

    System.out.println(rows + " record updated.");
}
```

---

## 11. Difference Between executeQuery(), executeUpdate(), and execute()

These three methods are important in JDBC. They are available in both Statement and PreparedStatement.

| Method | Used For | Return Type |
|---|---|---|
| `executeQuery()` | SELECT queries | ResultSet |
| `executeUpdate()` | INSERT, UPDATE, DELETE, and DDL | int |
| `execute()` | General SQL execution | boolean |

### 11.1 executeQuery()

Used when the SQL query returns records.

```java
ResultSet rs = stmt.executeQuery(
    "SELECT * FROM students"
);
```

### 11.2 executeUpdate()

Used when the SQL statement modifies data or changes database structure.

```java
int rows = stmt.executeUpdate(
    "UPDATE students SET age = 23 WHERE id = 1"
);
```

### 11.3 execute()

Used when the result type may vary or is not known in advance.

```java
boolean result = stmt.execute(
    "SELECT * FROM students"
);

if (result) {

    ResultSet rs = stmt.getResultSet();

    while (rs.next()) {
        System.out.println(rs.getString("name"));
    }

} else {

    int count = stmt.getUpdateCount();

    System.out.println("Affected rows: " + count);
}
```

**Remember:**

- `executeQuery()` → SELECT.
- `executeUpdate()` → INSERT, UPDATE, DELETE, and DDL.
- `execute()` → General-purpose execution.

---

## 12. Statement vs PreparedStatement vs CallableStatement

| Feature | Statement | PreparedStatement | CallableStatement |
|---|---|---|---|
| Purpose | Static SQL | Parameterized SQL | Stored procedures |
| Parameters | No parameter setters | Supports `?` placeholders | Supports IN, OUT, and INOUT |
| SQL injection protection | Requires careful handling | Helps protect parameter values | Depends on procedure and parameter handling |
| Reusability | Can execute different SQL strings | Reuses SQL structure with different values | Calls stored procedures |
| Common methods | executeQuery(), executeUpdate() | executeQuery(), executeUpdate() | execute(), executeQuery() |

---

## 13. CRUD Operations Using JDBC

CRUD stands for:

- Create
- Read
- Update
- Delete

These are the four fundamental database operations.

### 13.1 CREATE – Insert Student

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertStudent {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query =
            "INSERT INTO students(name, email, age, marks) " +
            "VALUES(?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setString(1, "Amit");
            ps.setString(2, "amit@example.com");
            ps.setInt(3, 21);
            ps.setDouble(4, 78.5);

            int rows = ps.executeUpdate();

            System.out.println(
                rows + " student added successfully."
            );
        }
    }
}
```

### 13.2 READ – Retrieve Student

```java
import java.sql.*;

public class ReadStudent {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query =
            "SELECT * FROM students WHERE id = ?";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setInt(1, 1);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println(
                        "Name: " + rs.getString("name")
                    );

                    System.out.println(
                        "Marks: " + rs.getDouble("marks")
                    );

                } else {

                    System.out.println("Student Not Found");
                }
            }
        }
    }
}
```

### 13.3 UPDATE – Update Student

```java
import java.sql.*;

public class UpdateStudent {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query =
            "UPDATE students SET marks = ? WHERE id = ?";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setDouble(1, 95.0);
            ps.setInt(2, 1);

            int rows = ps.executeUpdate();

            System.out.println(
                rows + " record updated."
            );
        }
    }
}
```

### 13.4 DELETE – Delete Student

```java
import java.sql.*;

public class DeleteStudent {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query =
            "DELETE FROM students WHERE id = ?";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setInt(1, 1);

            int rows = ps.executeUpdate();

            System.out.println(
                rows + " record deleted."
            );
        }
    }
}
```

---

## 14. SQL Injection and Its Prevention

SQL Injection is a security vulnerability in which an attacker manipulates SQL queries by supplying malicious input.

### Example of Unsafe SQL

```java
String userInput = "' OR '1'='1";

String query =
    "SELECT * FROM students WHERE name = '" +
    userInput + "'";

Statement stmt = con.createStatement();

ResultSet rs = stmt.executeQuery(query);
```

The resulting SQL could become:

```sql
SELECT * FROM students
WHERE name = '' OR '1'='1';
```

The condition is always true and may return all records.

### Prevention Using PreparedStatement

```java
String query =
    "SELECT * FROM students WHERE name = ?";

PreparedStatement ps =
    con.prepareStatement(query);

ps.setString(1, userInput);

ResultSet rs = ps.executeQuery();
```

The user input is treated as a parameter value rather than executable SQL syntax.

### Security Best Practices

1. Use PreparedStatement for parameterized SQL.
2. Validate user input.
3. Use database accounts with minimum required privileges.
4. Never expose database passwords in source code.
5. Avoid constructing SQL queries by concatenating untrusted input.
6. Do not expose detailed SQL errors to end users.
7. Use secure configuration management for credentials.

**Important:** PreparedStatement protects parameter values, but dynamic SQL identifiers such as table names and column names cannot be supplied using `?`. If identifiers must be dynamic, validate them against an allowlist.

---

## 15. Batch Processing in JDBC

Batch processing allows multiple SQL commands to be grouped and executed together.

It can reduce communication overhead when inserting or updating many records.

### Important Methods

| Method | Description |
|---|---|
| `addBatch()` | Adds a statement or parameter set to a batch |
| `executeBatch()` | Executes the batch |
| `clearBatch()` | Clears pending batch commands |

### Example: Insert Multiple Students

```java
import java.sql.*;

public class BatchInsertExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String query =
            "INSERT INTO students(name, email, age, marks) " +
            "VALUES(?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            // First student
            ps.setString(1, "Student One");
            ps.setString(2, "one@example.com");
            ps.setInt(3, 20);
            ps.setDouble(4, 80.0);

            ps.addBatch();

            // Second student
            ps.setString(1, "Student Two");
            ps.setString(2, "two@example.com");
            ps.setInt(3, 21);
            ps.setDouble(4, 85.0);

            ps.addBatch();

            int[] results = ps.executeBatch();

            System.out.println(
                "Batch executed: " + results.length
            );

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Output:**

```text
Batch executed: 2
```

The result array contains an entry for each batch command. Depending on the driver, entries may contain an update count or a special JDBC constant.

**Important:** Each parameter set must assign the correct placeholder index. In this example, marks use `setDouble(4, ...)`.

---

## 16. Transaction Management in JDBC

A transaction is a group of database operations treated as one logical unit.

Transactions follow the ACID properties.

### ACID Properties

| Property | Meaning |
|---|---|
| Atomicity | All operations succeed or the transaction is rolled back |
| Consistency | Database constraints and rules remain satisfied |
| Isolation | Concurrent transactions are isolated according to the selected isolation level |
| Durability | Committed changes are persisted |

### Important Transaction Methods

| Method | Description |
|---|---|
| `setAutoCommit(false)` | Disables automatic commit |
| `commit()` | Saves transaction changes |
| `rollback()` | Reverts uncommitted changes |
| `setTransactionIsolation()` | Sets transaction isolation level |
| `getAutoCommit()` | Checks auto-commit mode |

### What is Auto-Commit?

By default, JDBC connections generally use auto-commit mode.

When auto-commit is enabled, each SQL statement is committed automatically after successful execution.

```java
con.setAutoCommit(false);
```

When disabled, we can group multiple operations into a single transaction and decide when to commit or roll back.

### Example: Bank Transfer

Suppose we have two accounts:

| Account ID | Balance |
|---|---:|
| 101 | 10000 |
| 102 | 5000 |

We want to transfer 2000 from account 101 to account 102.

### SQL Table

```sql
CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    balance DECIMAL(12, 2) NOT NULL
);

INSERT INTO accounts VALUES
(101, 10000.00),
(102, 5000.00);
```

### Java Transaction Example

```java
import java.sql.*;

public class BankTransfer {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        String debit =
            "UPDATE accounts SET balance = balance - ? " +
            "WHERE account_id = ? AND balance >= ?";

        String credit =
            "UPDATE accounts SET balance = balance + ? " +
            "WHERE account_id = ?";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            )
        ) {

            con.setAutoCommit(false);

            try (
                PreparedStatement debitStmt =
                    con.prepareStatement(debit);

                PreparedStatement creditStmt =
                    con.prepareStatement(credit)
            ) {

                double amount = 2000.00;

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, 101);
                debitStmt.setDouble(3, amount);

                int debitRows = debitStmt.executeUpdate();

                if (debitRows != 1) {
                    throw new SQLException(
                        "Insufficient balance or source account not found"
                    );
                }

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, 102);

                int creditRows = creditStmt.executeUpdate();

                if (creditRows != 1) {
                    throw new SQLException(
                        "Destination account not found"
                    );
                }

                con.commit();

                System.out.println(
                    "Transaction Successful"
                );

            } catch (SQLException e) {

                try {
                    con.rollback();
                } catch (SQLException rollbackError) {
                    e.addSuppressed(rollbackError);
                }

                System.out.println(
                    "Transaction Failed: " + e.getMessage()
                );

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Output:**

```text
Transaction Successful
```

### Why do we use rollback()?

Suppose the debit operation succeeds but the credit operation fails.

Without rollback, money could be deducted without being transferred.

Rollback restores the uncommitted transaction changes.

**Important:** In real applications, handle rollback failures as well, and avoid hiding the original exception. Verify affected-row counts for every operation that must succeed.

### Transaction Isolation Levels

JDBC provides four standard transaction isolation levels.

| Isolation Level | Description |
|---|---|
| TRANSACTION_READ_UNCOMMITTED | Allows dirty reads |
| TRANSACTION_READ_COMMITTED | Prevents dirty reads |
| TRANSACTION_REPEATABLE_READ | Prevents dirty and non-repeatable reads |
| TRANSACTION_SERIALIZABLE | Provides the strictest standard isolation |

Example:

```java
con.setTransactionIsolation(
    Connection.TRANSACTION_READ_COMMITTED
);
```

The database determines the exact supported behavior and may not support every isolation level.

---

## 17. CallableStatement and Stored Procedures

CallableStatement is used to execute database stored procedures.

A stored procedure is a collection of SQL statements stored inside the database.

### Create a Stored Procedure in MySQL

```sql
DELIMITER //

CREATE PROCEDURE GetStudentById(IN studentId INT)
BEGIN
    SELECT * FROM students
    WHERE id = studentId;
END //

DELIMITER ;
```

### Execute Stored Procedure Using JDBC

```java
import java.sql.*;

public class CallableStatementExample {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";
        String username = "root";
        String password = "your_password";

        try (
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            CallableStatement cs =
                con.prepareCall("{CALL GetStudentById(?)}")
        ) {

            cs.setInt(1, 1);

            try (ResultSet rs = cs.executeQuery()) {

                while (rs.next()) {

                    System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("name")
                    );
                }
            }
        }
    }
}
```

**Possible Output:**

```text
1 - Ayush
```

### IN, OUT, and INOUT Parameters

- IN: Sends a value into the procedure.
- OUT: Returns a value from the procedure.
- INOUT: Accepts an input value and returns an updated value.

### Example: OUT Parameter

Create a procedure:

```sql
DELIMITER //

CREATE PROCEDURE GetStudentCount(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total
    FROM students;
END //

DELIMITER ;
```

Call it using JDBC:

```java
import java.sql.*;

public class CallableOutExample {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";

        try (
            Connection con = DriverManager.getConnection(
                url, "root", "your_password"
            );

            CallableStatement cs =
                con.prepareCall("{CALL GetStudentCount(?)}")
        ) {

            cs.registerOutParameter(1, Types.INTEGER);

            cs.execute();

            int count = cs.getInt(1);

            System.out.println(
                "Total Students: " + count
            );
        }
    }
}
```

**Possible Output:**

```text
Total Students: 3
```

The count depends on the actual table records.

---

## 18. JDBC Exception Handling

JDBC operations can throw SQLException.

SQLException provides information about database-related failures.

### Important SQLException Methods

| Method | Description |
|---|---|
| `getMessage()` | Returns the error message |
| `getSQLState()` | Returns the SQL state |
| `getErrorCode()` | Returns the database-specific error code |
| `getNextException()` | Returns the next chained SQLException |

### Example

```java
import java.sql.*;

public class SQLExceptionExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";

        try (
            Connection con = DriverManager.getConnection(
                url, "root", "wrong_password"
            )
        ) {

            System.out.println("Connected");

        } catch (SQLException e) {

            System.out.println(
                "Database Error: " + e.getMessage()
            );

            System.out.println(
                "SQL State: " + e.getSQLState()
            );

            System.out.println(
                "Error Code: " + e.getErrorCode()
            );
        }
    }
}
```

The exact error message, SQL state, and error code depend on the database and driver.

---

## 19. DatabaseMetaData and ResultSetMetaData

JDBC provides metadata interfaces to retrieve information about a database and query results.

### 19.1 DatabaseMetaData

DatabaseMetaData provides information about the database, driver, and supported features.

### Example

```java
import java.sql.*;

public class DatabaseMetadataExample {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";

        try (
            Connection con = DriverManager.getConnection(
                url, "root", "your_password"
            )
        ) {

            DatabaseMetaData metaData = con.getMetaData();

            System.out.println(
                "Database: " +
                metaData.getDatabaseProductName()
            );

            System.out.println(
                "Driver: " +
                metaData.getDriverName()
            );

            System.out.println(
                "Database Version: " +
                metaData.getDatabaseProductVersion()
            );

            System.out.println(
                "Driver Version: " +
                metaData.getDriverVersion()
            );
        }
    }
}
```

**Possible Output:**

```text
Database: MySQL
Driver: MySQL Connector/J
Database Version: 8.0.x
Driver Version: 8.0.33
```

Actual version values depend on the installed database and driver.

### 19.2 ResultSetMetaData

ResultSetMetaData provides information about the columns returned by a query.

### Example

```java
import java.sql.*;

public class ResultSetMetadataExample {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";

        try (
            Connection con = DriverManager.getConnection(
                url, "root", "your_password"
            );

            Statement stmt = con.createStatement();

            ResultSet rs =
                stmt.executeQuery("SELECT * FROM students")
        ) {

            ResultSetMetaData metaData = rs.getMetaData();

            int columns = metaData.getColumnCount();

            for (int i = 1; i <= columns; i++) {

                System.out.println(
                    metaData.getColumnName(i) + " : " +
                    metaData.getColumnTypeName(i)
                );
            }
        }
    }
}
```

**Possible Output:**

```text
id : INT
name : VARCHAR
email : VARCHAR
age : INT
marks : DOUBLE
```

### Difference Between DatabaseMetaData and ResultSetMetaData

| DatabaseMetaData | ResultSetMetaData |
|---|---|
| Provides database information | Provides query-result information |
| Obtained using `Connection.getMetaData()` | Obtained using `ResultSet.getMetaData()` |
| Provides database and driver details | Provides column names and data types |
| Describes database capabilities | Describes the returned columns |

---

## 20. Retrieving Auto-Generated Keys

When a table uses AUTO_INCREMENT, MySQL generates an ID automatically.

JDBC allows us to retrieve that generated ID.

### Example

```java
import java.sql.*;

public class GeneratedKeyExample {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/java_jdbc";

        String sql =
            "INSERT INTO students(name, email, age, marks) " +
            "VALUES(?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(
                url, "root", "your_password"
            );

            PreparedStatement ps = con.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            )
        ) {

            ps.setString(1, "Amit");
            ps.setString(2, "amit@example.com");
            ps.setInt(3, 21);
            ps.setDouble(4, 88.5);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                try (ResultSet rs = ps.getGeneratedKeys()) {

                    if (rs.next()) {

                        System.out.println(
                            "Generated ID: " + rs.getInt(1)
                        );
                    }
                }
            }
        }
    }
}
```

**Possible Output:**

```text
Generated ID: 4
```

The generated ID depends on the current AUTO_INCREMENT value.

---

## 21. DAO Pattern in JDBC

DAO stands for Data Access Object.

It is a design pattern that separates database operations from application logic.

### Why use DAO?

Without DAO, SQL queries may be written directly inside business logic classes.

This makes the application difficult to maintain.

DAO separates responsibilities.

### DAO Architecture

```text
+----------------------+
|   Main Application   |
+----------------------+
          |
          v
+----------------------+
|    StudentService    |
+----------------------+
          |
          v
+----------------------+
|      StudentDAO      |
+----------------------+
          |
          v
+----------------------+
|    JDBC Connection   |
+----------------------+
          |
          v
+----------------------+
|        MySQL         |
+----------------------+
```

### Step 1: Create Student Class

```java
public class Student {

    private int id;
    private String name;
    private String email;
    private int age;
    private double marks;

    public Student(int id, String name,
                   String email, int age, double marks) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.marks = marks;
    }

    public Student(String name, String email,
                   int age, double marks) {

        this.name = name;
        this.email = email;
        this.age = age;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {

        return id + " | " + name + " | " +
               email + " | " + age + " | " + marks;
    }
}
```

### Step 2: Create Database Connection Class

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/java_jdbc";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "your_password";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
            URL, USERNAME, PASSWORD
        );
    }
}
```

For production applications, load credentials from secure configuration rather than hardcoding them.

### Step 3: Create StudentDAO Class

```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student student)
            throws SQLException {

        String query =
            "INSERT INTO students(name, email, age, marks) " +
            "VALUES(?, ?, ?, ?)";

        try (
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setDouble(4, student.getMarks());

            return ps.executeUpdate() == 1;
        }
    }

    public Student getStudentById(int id)
            throws SQLException {

        String query =
            "SELECT * FROM students WHERE id = ?";

        try (
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age"),
                        rs.getDouble("marks")
                    );
                }
            }
        }

        return null;
    }

    public List<Student> getAllStudents()
            throws SQLException {

        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM students";

        try (
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("age"),
                    rs.getDouble("marks")
                );

                students.add(student);
            }
        }

        return students;
    }

    public boolean updateStudent(Student student)
            throws SQLException {

        String query =
            "UPDATE students SET name = ?, email = ?, " +
            "age = ?, marks = ? WHERE id = ?";

        try (
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setDouble(4, student.getMarks());
            ps.setInt(5, student.getId());

            return ps.executeUpdate() == 1;
        }
    }

    public boolean deleteStudent(int id)
            throws SQLException {

        String query =
            "DELETE FROM students WHERE id = ?";

        try (
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() == 1;
        }
    }
}
```

### Step 4: Create Main Class

```java
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        try {

            Student student = new Student(
                "Ayush",
                "ayush@example.com",
                22,
                85.5
            );

            boolean inserted = dao.addStudent(student);

            System.out.println(
                "Inserted: " + inserted
            );

            List<Student> students =
                dao.getAllStudents();

            System.out.println("Student Records:");

            for (Student s : students) {
                System.out.println(s);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
```

**Possible Output:**

```text
Inserted: true
Student Records:
1 | Ayush | ayush@example.com | 22 | 85.5
```

The output assumes the database table is empty before insertion and the connection is configured correctly.

---

## 22. JDBC Connection Pooling

Opening a new database connection for every request can introduce overhead.

Connection pooling solves this problem by maintaining a pool of reusable database connections.

### Without Connection Pooling

```text
Request 1 -> Create Connection -> Execute -> Close

Request 2 -> Create Connection -> Execute -> Close

Request 3 -> Create Connection -> Execute -> Close
```

### With Connection Pooling

```text
          Connection Pool
         +---------------+
         | Connection 1  |
         | Connection 2  |
         | Connection 3  |
         +---------------+
            ^    ^    ^
            |    |    |
         Requests reuse connections
```

### Advantages

1. Reduces repeated connection creation.
2. Improves performance under suitable workloads.
3. Limits the number of database connections.
4. Helps manage database resources.
5. Supports scalable applications.

Popular connection pool libraries include:

- HikariCP
- Apache Commons DBCP

### Example: HikariCP Configuration

Add this Maven dependency:

```xml
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>4.0.3</version>
</dependency>
```

Example Java configuration:

```java
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConfig {

    private static final HikariDataSource dataSource;

    static {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(
            "jdbc:mysql://localhost:3306/java_jdbc"
        );

        config.setUsername("root");
        config.setPassword("your_password");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection()
            throws SQLException {

        return dataSource.getConnection();
    }

    public static void closePool() {
        dataSource.close();
    }
}
```

Usage:

```java
try (Connection con = DataSourceConfig.getConnection()) {

    System.out.println("Connection obtained from pool.");

}
```

**Important:** In a pooled environment, calling `close()` on a borrowed Connection usually returns it to the pool rather than physically closing the database connection.

---

## 23. Common JDBC Mistakes

1. Forgetting to add the JDBC driver dependency.
2. Using an incorrect database URL.
3. Providing an incorrect username or password.
4. Forgetting to close Connection, Statement, or ResultSet.
5. Using Statement with concatenated user input.
6. Forgetting to call executeUpdate() for INSERT, UPDATE, and DELETE.
7. Calling executeQuery() for an INSERT statement.
8. Forgetting to call ResultSet.next() before reading the first row.
9. Forgetting to commit a transaction when auto-commit is disabled.
10. Not rolling back failed transactions.
11. Hardcoding database credentials in GitHub repositories.
12. Ignoring SQLException.
13. Creating unnecessary database connections.
14. Not checking the number of affected rows.
15. Using JDBC directly in every business logic class instead of separating responsibilities.

---

## 24. JDBC Best Practices

- Prefer PreparedStatement for parameterized SQL.
- Use try-with-resources for JDBC resources.
- Close ResultSet, Statement, and Connection properly.
- Keep database credentials outside source code.
- Use transactions for operations that must succeed together.
- Validate user input.
- Use connection pooling in applications that handle many database requests.
- Separate database logic using DAO or repository patterns.
- Handle SQLException appropriately.
- Use suitable SQL data types.
- Avoid selecting unnecessary columns.
- Use database indexes for frequently queried columns where appropriate.
- Never expose sensitive database errors to end users.
- Use the least-privilege database account necessary.
- Check affected-row counts when an operation must modify a specific record.
- Configure connection and query timeouts where appropriate.

---

## 25. JDBC Interview Questions

### Basic Questions

1. What is JDBC?
2. Why do we use JDBC?
3. What are the major components of JDBC?
4. What are the four types of JDBC drivers?
5. What is a JDBC URL?
6. What is DriverManager?
7. What is the Connection interface?
8. What is the Statement interface?
9. What is ResultSet?
10. What is SQLException?

### Intermediate Questions

11. What is the difference between Statement and PreparedStatement?
12. What is CallableStatement?
13. What is the difference between execute(), executeQuery(), and executeUpdate()?
14. What is the purpose of ResultSet.next()?
15. What is SQL Injection?
16. How does PreparedStatement prevent SQL injection?
17. What is batch processing in JDBC?
18. What is transaction management?
19. What are ACID properties?
20. What is the difference between commit() and rollback()?
21. What is auto-commit mode?
22. What is DatabaseMetaData?
23. What is ResultSetMetaData?
24. What are IN, OUT, and INOUT parameters?
25. What is a stored procedure?

### Advanced Questions

26. What is connection pooling?
27. Why is connection pooling important?
28. What is the DAO design pattern?
29. What is the difference between JDBC and ORM?
30. What is the difference between JDBC and Hibernate?
31. What is the difference between a forward-only and scrollable ResultSet?
32. What are JDBC transaction isolation levels?
33. What is the difference between Statement and PreparedStatement in terms of execution?
34. What is a generated key in JDBC?
35. How can you execute multiple SQL statements efficiently?
36. What happens when a database connection fails during a transaction?
37. How do you handle database exceptions?
38. Why should database credentials not be hardcoded?
39. How do you configure a JDBC connection pool?
40. How would you design a scalable Java database access layer?

---

## 26. Practice Exercises (Questions Only)

**Important:** Try to implement each exercise independently before reviewing the solution.

All solution programs are available in the [Practice-Programs folder](Practice-Programs/README.md).

### Beginner Level

1. Write a Java program to connect to a MySQL database using JDBC.
2. Write a program to create a database using JDBC.
3. Write a program to create a student table using JDBC.
4. Write a program to insert a student record using Statement.
5. Write a program to retrieve all student records using ResultSet.
6. Write a program to retrieve one student by ID.
7. Write a program to update a student's marks.
8. Write a program to delete a student record by ID.
9. Write a program to display records using a PreparedStatement.
10. Write a program to count the total number of student records.

### Intermediate Level

11. Write a program to insert multiple records using PreparedStatement.
12. Write a program to update multiple student records using batch processing.
13. Write a program to delete students whose marks are below a specified value.
14. Write a program to search students by name.
15. Write a program to retrieve students whose marks are greater than 80.
16. Write a program to demonstrate SQL injection using an unsafe query and then prevent it using PreparedStatement.
17. Write a program to demonstrate transaction commit.
18. Write a program to demonstrate transaction rollback.
19. Write a program to transfer money between two bank accounts using JDBC transactions.
20. Write a program to call a stored procedure using CallableStatement.
21. Write a program to retrieve an OUT parameter from a stored procedure.
22. Write a program to display database information using DatabaseMetaData.
23. Write a program to display column information using ResultSetMetaData.
24. Write a program to retrieve auto-generated keys after inserting a record.
25. Write a program to demonstrate try-with-resources in JDBC.

### Advanced Level

26. Build a Student Management System using JDBC.
27. Build an Employee Management System using CRUD operations.
28. Implement the DAO pattern for student records.
29. Build a bank account system with transaction management.
30. Create a login system using PreparedStatement.
31. Implement a batch insertion application for thousands of student records.
32. Build a library management system using JDBC and MySQL.
33. Implement connection pooling in a Java application.
34. Create a product inventory management system using JDBC.
35. Build a JDBC-based order management system.
36. Implement pagination using SQL LIMIT and OFFSET.
37. Create a program that handles duplicate email errors.
38. Build a transaction system that updates two related database tables.
39. Implement a database access layer using DAO and service classes.
40. Build a complete console-based Student Management System with add, view, search, update, and delete functionality.

---

## 27. Chapter Summary

In this chapter, you learned:

- Introduction to JDBC.
- JDBC architecture.
- Four types of JDBC drivers.
- JDBC API components.
- Installing and configuring MySQL Connector/J.
- Connecting Java to MySQL.
- Creating database tables.
- Statement and its important methods.
- PreparedStatement and its parameter-setting methods.
- Difference between execute(), executeQuery(), and executeUpdate().
- ResultSet and its navigation methods.
- CRUD operations.
- SQL Injection and its prevention.
- Batch processing.
- Transaction management.
- ACID properties.
- CallableStatement and stored procedures.
- JDBC exception handling.
- DatabaseMetaData and ResultSetMetaData.
- Retrieving auto-generated keys.
- DAO design pattern.
- Connection pooling.
- Common JDBC mistakes.
- JDBC best practices.

### Key Takeaways

| JDBC Component | Purpose |
|---|---|
| DriverManager | Establishes database connections |
| Connection | Represents a database connection |
| Statement | Executes static SQL |
| PreparedStatement | Executes parameterized SQL |
| CallableStatement | Executes stored procedures |
| ResultSet | Retrieves query results |
| SQLException | Handles database-related exceptions |
| DatabaseMetaData | Provides database information |
| ResultSetMetaData | Provides result-column information |
| Connection Pool | Reuses database connections |

### Final Note

JDBC is an essential foundation for understanding how Java applications interact with databases.

Even when using frameworks such as Spring Boot, Hibernate, or JPA, understanding JDBC helps you understand database connections, SQL execution, transactions, and performance.

Practice the CRUD examples first, then build the complete Student Management System.

---

**Keep coding, keep practicing, and build your Java knowledge step by step!**
