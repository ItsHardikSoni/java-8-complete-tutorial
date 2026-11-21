# Java JDBC - Practice Programs

This folder contains solutions for all 40 JDBC practice exercises.

Set `MYSQL_URL`, `MYSQL_USER`, and `MYSQL_PASSWORD` for your local MySQL server before running database programs.

```bash
export MYSQL_URL="jdbc:mysql://localhost:3306/studentdb"
export MYSQL_USER="root"
export MYSQL_PASSWORD="your-password"
```

```bash
javac 01-DatabaseConnection.java
java DatabaseConnection
```

## Beginner Level

1. [Database Connection](01-DatabaseConnection.java)
2. [Create Database](02-CreateDatabase.java)
3. [Create Student Table](03-CreateStudentTable.java)
4. [Insert Student Using Statement](04-InsertStudentWithStatement.java)
5. [Retrieve All Students](05-RetrieveAllStudents.java)
6. [Retrieve Student by ID](06-RetrieveStudentById.java)
7. [Update Student Marks](07-UpdateStudentMarks.java)
8. [Delete Student by ID](08-DeleteStudentById.java)
9. [Display with PreparedStatement](09-DisplayPreparedStatement.java)
10. [Count Student Records](10-CountStudentRecords.java)

## Intermediate Level

11. [PreparedStatement Batch Insert](11-PreparedStatementBatchInsert.java)
12. [Batch Update](12-BatchUpdate.java)
13. [Delete Low-Marks Students](13-DeleteLowMarks.java)
14. [Search Students by Name](14-SearchStudentByName.java)
15. [Students with Marks Above 80](15-StudentsAbove80.java)
16. [SQL Injection and PreparedStatement](16-SqlInjectionPreparedStatement.java)
17. [Transaction Commit](17-TransactionCommit.java)
18. [Transaction Rollback](18-TransactionRollback.java)
19. [Money Transfer Transaction](19-MoneyTransferTransaction.java)
20. [CallableStatement](20-CallableStatement.java)
21. [Stored Procedure OUT Parameter](21-StoredProcedureOutParameter.java)
22. [DatabaseMetaData](22-DatabaseMetaData.java)
23. [ResultSetMetaData](23-ResultSetMetaData.java)
24. [Retrieve Generated Keys](24-RetrieveGeneratedKeys.java)
25. [Try-With-Resources JDBC](25-TryWithResourcesJdbc.java)

## Advanced Level

26. [Student Management JDBC](26-StudentManagementSystemJdbc.java)
27. [Employee CRUD JDBC](27-EmployeeCrudJdbc.java)
28. [Student DAO Pattern](28-StudentDaoPattern.java)
29. [Bank Account Transaction](29-BankAccountTransaction.java)
30. [Login with PreparedStatement](30-LoginPreparedStatement.java)
31. [Batch Insert Thousands](31-BatchInsertThousands.java)
32. [Library Management JDBC](32-LibraryManagementJdbc.java)
33. [Simple JDBC Connection Pool](33-SimpleJdbcConnectionPool.java)
34. [Inventory Management JDBC](34-InventoryManagementJdbc.java)
35. [Order Management JDBC](35-OrderManagementJdbc.java)
36. [Pagination with LIMIT and OFFSET](36-PaginationLimitOffset.java)
37. [Duplicate Email Handling](37-DuplicateEmailHandling.java)
38. [Two-Table Transaction](38-TwoTableTransaction.java)
39. [DAO and Service Layer](39-DaoServiceLayer.java)
40. [Complete Console Student Management](40-CompleteStudentManagementSystem.java)
