Relational mapping in SQL is crucial for understanding how different tables relate to each other in a database. Let's break it down with examples and queries.

### Types of Relational Mapping

1. **One-to-One Mapping**
    
    - One record in Table A is related to one and only one record in Table B.
    - Example: `Users` table and `Profiles` table.
2. **One-to-Many Mapping**
    
    - One record in Table A is related to multiple records in Table B.
    - Example: `Customers` table and `Orders` table.
3. **Many-to-Many Mapping**
    
    - Multiple records in Table A are related to multiple records in Table B.
    - Example: `Students` table and `Courses` table (using a `StudentCourses` junction table).

### One-to-One Mapping

```SQL
mysql> CREATE TABLE Users (
    ->     user_id INT PRIMARY KEY,
    ->     username VARCHAR(50)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE TABLE Profiles (
    ->     profile_id INT PRIMARY KEY,
    ->     user_id INT UNIQUE,
    ->     bio VARCHAR(255),
    ->     FOREIGN KEY (user_id) REFERENCES Users(user_id)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> INSERT INTO Users (user_id, username)VALUES (1, 'Alice'),(2, 'Bob'),(3, 'Charlie');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Profiles (profile_id, user_id, bio)VALUES (1, 1, 'Software Engineer'),(2, 2, 'Data Scientist'),(3, 3, 'Graphic Designer');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> Select u.username, p.bio From Users u JOIN Profiles p ON u.user_id = p.user_id;
+----------+-------------------+
| username | bio               |
+----------+-------------------+
| Alice    | Software Engineer |
| Bob      | Data Scientist    |
| Charlie  | Graphic Designer  |
+----------+-------------------+
3 rows in set (0.00 sec)
```

### One-to-Many Mapping

```sql

mysql> use oneToMany;
Database changed
mysql> CREATE TABLE Customers (
    ->     customer_id INT PRIMARY KEY,
    ->     customer_name VARCHAR(50)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE TABLE Orders (
    ->     order_id INT PRIMARY KEY,
    ->     customer_id INT,
    ->     order_date DATE,
    ->     FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> INSERT INTO Customers (customer_id, customer_name)
    -> VALUES
    -> (1, 'John Doe'),
    -> (2, 'Jane Smith'),
    -> (3, 'Emily Davis'),
    -> (4, 'Jhon Whick'),
    -> (5, 'Mark');
Query OK, 5 rows affected (0.01 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Orders (order_id, customer_id, order_date)
    -> VALUES
    -> (101, 1, '2024-12-01'),
    -> (102, 1, '2024-12-02'),
    -> (103, 2, '2024-12-01'),
    -> (104, 3, '2024-12-03'),
    -> (105, 4, '2024-12-02'),
    -> (106, 4, '2024-11-02'),
    -> (107, 4, '2024-11-08'),
    -> (108, 5, '2024-10-08');
Query OK, 8 rows affected (0.01 sec)
Records: 8  Duplicates: 0  Warnings: 0

mysql> SELECT c.customer_name, o.order_date
    -> FROM Customers c
    -> JOIN Orders o ON c.customer_id = o.customer_id;
+---------------+------------+
| customer_name | order_date |
+---------------+------------+
| John Doe      | 2024-12-01 |
| John Doe      | 2024-12-02 |
| Jane Smith    | 2024-12-01 |
| Emily Davis   | 2024-12-03 |
| Jhon Whick    | 2024-12-02 |
| Jhon Whick    | 2024-11-02 |
| Jhon Whick    | 2024-11-08 |
| Mark          | 2024-10-08 |
+---------------+------------+
8 rows in set (0.00 sec)
```

### Many-to-Many Mapping

```SQL
mysql> create database manyToMany;
Query OK, 1 row affected (0.01 sec)

mysql> use manyToMany;
Database changed
mysql> CREATE TABLE Students (
    ->     student_id INT PRIMARY KEY,
    ->     student_name VARCHAR(50)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE Courses (
    ->     course_id INT PRIMARY KEY,
    ->     course_name VARCHAR(50)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE TABLE StudentCourses (
    ->     student_id INT,
    ->     course_id INT,
    ->     PRIMARY KEY (student_id, course_id),
    ->     FOREIGN KEY (student_id) REFERENCES Students(student_id),
    ->     FOREIGN KEY (course_id) REFERENCES Courses(course_id)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> INSERT INTO Students (student_id, student_name)
    -> VALUES
    -> (1, 'Alice'),
    -> (2, 'Bob'),
    -> (3, 'Charlie');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Courses (course_id, course_name)
    -> VALUES
    -> (101, 'Mathematics'),
    -> (102, 'Physics'),
    -> (103, 'Computer Science');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO StudentCourses (student_id, course_id)
    -> VALUES
    -> (1, 101), -- Alice is enrolled in Mathematics
    -> (1, 103), -- Alice is enrolled in Computer Science
    -> (2, 101), -- Bob is enrolled in Mathematics
    -> (2, 102), -- Bob is enrolled in Physics
    -> (3, 103); -- Charlie is enrolled in Computer Science
Query OK, 5 rows affected (0.01 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> SELECT s.student_name, c.course_name
    -> FROM Students s
    -> JOIN StudentCourses sc ON s.student_id = sc.student_id
    -> JOIN Courses c ON sc.course_id = c.course_id;
+--------------+------------------+
| student_name | course_name      |
+--------------+------------------+
| Alice        | Mathematics      |
| Alice        | Computer Science |
| Bob          | Mathematics      |
| Bob          | Physics          |
| Charlie      | Computer Science |
+--------------+------------------+
5 rows in set (0.00 sec)
```