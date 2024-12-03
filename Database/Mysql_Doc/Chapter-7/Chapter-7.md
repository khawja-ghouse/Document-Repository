Joins are used to retrieve related data from multiple tables based on a common column.

---

#### **1. INNER JOIN**

- **Definition**: Retrieves rows where there is a match in both tables.
- **Query**:
```SQL
SELECT Users.name, Orders.product, Orders.amount
FROM Users 
INNER JOIN Orders ON Users.user_id = Orders.user_id;
+------------+------------+--------+
| name       | product    | amount |
+------------+------------+--------+
| John Doe   | Laptop     |   1200 |
| John Doe   | Headphones |    150 |
| Jane Smith | Smartphone |    800 |
| Alice Lee  | Tablet     |    600 |
+------------+------------+--------+

```

#### **2. LEFT JOIN**

- **Definition**: Retrieves all rows from the left table (Users) and matching rows from the right table (Orders). Non-matching rows in the right table are filled with `NULL`.
- **Query**:
  ```SQl
  SELECT Users.name, Orders.product, Orders.amount
FROM Users
LEFT JOIN Orders ON Users.user_id = Orders.user_id;

+------------+------------+--------+
| name       | product    | amount |
+------------+------------+--------+
| John Doe   | Laptop     |   1200 |
| John Doe   | Headphones |    150 |
| Jane Smith | Smartphone |    800 |
| Alice Lee  | Tablet     |    600 |
| Bob Brown  | NULL       |   NULL |
+------------+------------+--------+
5 rows in set (0.00 sec)

```

#### **3. RIGHT JOIN**

- **Definition**: Retrieves all rows from the right table (Orders) and matching rows from the left table (Users). Non-matching rows in the left table are filled with `NULL`.
- **Query**:
  
```SQL
  SELECT Users.name, Orders.product, Orders.amount
FROM Users
RIGHT JOIN Orders ON Users.user_id = Orders.user_id;

+------------+------------+--------+
| name       | product    | amount |
+------------+------------+--------+
| John Doe   | Laptop     |   1200 |
| Jane Smith | Smartphone |    800 |
| Alice Lee  | Tablet     |    600 |
| John Doe   | Headphones |    150 |
+------------+------------+--------+
```

#### **4. FULL JOIN**

- **Definition**: Combines results of both LEFT JOIN and RIGHT JOIN. Rows that do not match in either table are included as `NULL`.
- **Query**:
  ```SQL
SELECT Users.name, Orders.product, Orders.amount
FROM Users
LEFT JOIN Orders ON Users.user_id = Orders.user_id
UNION
SELECT Users.name, Orders.product, Orders.amount
FROM Users
RIGHT JOIN Orders ON Users.user_id = Orders.user_id;
+------------+------------+--------+
| name       | product    | amount |
+------------+------------+--------+
| John Doe   | Headphones |    150 |
| John Doe   | Laptop     |   1200 |
| Jane Smith | Smartphone |    800 |
| Alice Lee  | Tablet     |    600 |
| Bob Brown  | NULL       |   NULL |
+------------+------------+--------+
5 rows in set (0.00 sec)
```

**Note**: MySQL does not directly support FULL JOIN. The above query uses `UNION` to achieve the same effect.
#### **5. CROSS JOIN**

- **Definition**: Produces the Cartesian product of both tables, combining every row in the first table with every row in the second table.
- **Query**:
  ```SQL
  SELECT Users.name, Orders.product
    -> FROM Users
    -> CROSS JOIN Orders;
+------------+------------+
| name       | product    |
+------------+------------+
| Bob Brown  | Laptop     |
| Alice Lee  | Laptop     |
| Jane Smith | Laptop     |
| John Doe   | Laptop     |
| Bob Brown  | Smartphone |
| Alice Lee  | Smartphone |
| Jane Smith | Smartphone |
| John Doe   | Smartphone |
| Bob Brown  | Tablet     |
| Alice Lee  | Tablet     |
| Jane Smith | Tablet     |
| John Doe   | Tablet     |
| Bob Brown  | Headphones |
| Alice Lee  | Headphones |
| Jane Smith | Headphones |
| John Doe   | Headphones |
+------------+------------+
16 rows in set (0.00 sec)
```

#### **6. SELF JOIN**

- **Definition**: Joins a table with itself to find relationships within the same table.
- **Example Query**:
  ```SQL
  SELECT A.name AS User1, B.name AS User2, A.country FROM Users A INNER JOIN Users B ON A.country = B.country AND A.user_id != B.user_id;
  
+-----------+-----------+---------+
| User1     | User2     | country |
+-----------+-----------+---------+
| Bob Brown | John Doe  | USA     |
| John Doe  | Bob Brown | USA     |
+-----------+-----------+---------+
```

