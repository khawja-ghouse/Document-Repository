# Inserting Data into Tables

Data can be inserted into the table using the following command,

```mysql
insert into <table_name>(column_1_name, column_2_name)
values(column_1_value, column_2_value);
```

For example we could do the following,

```mysql
insert into cats( name, age )
values (‘Jetson’, 7);
```

The order in which we provide our values should be in accordance with the order of column name specified. Consider the example below:

```mysql
insert into cats(age, name) 
values (23, ‘Drako’)
```

# Inserting multiple values

We can insert multiple values into a table instead of putting them individually. Consider the example below:

```mysql
insert into cats (name, age) 
values (‘david’,5),
       (‘dobby’,7);
```

# MySQL warnings

While inserting data into the tables, we can get crazy ass warnings due to data type mismatch or name truncation.

We can get a list of warnings using:

```mysql
show warnings;
```

# Null and Not-Null

Null means the value is not known. ‘Null’ does not means the value is ‘0’. When we perform a `desc <table-name>` then we get a table description.

```sh
mysql> desc confignode;
+------------------+--------------+------+-----+---------+----------------+
| Field            | Type         | Null | Key | Default | Extra          |
+------------------+--------------+------+-----+---------+----------------+
| nodeId           | int          | NO   | PRI | NULL    | auto_increment |
| nodeName         | varchar(255) | YES  |     | NULL    |                |
| isRoot           | tinyint(1)   | YES  |     | NULL    |                |
| hasChildren      | tinyint(1)   | YES  |     | NULL    |                |
| parentNodeId     | int          | YES  |     | NULL    |                |
| description      | varchar(255) | YES  |     | NULL    |                |
| type             | varchar(255) | YES  |     | NULL    |                |
| level            | int          | NO   |     | NULL    |                |
| version          | varchar(20)  | YES  |     | NULL    |                |
| primaryFeatureId | int          | YES  |     | NULL    |                |
+------------------+--------------+------+-----+---------+----------------+
10 rows in set (0.01 sec)
```

so, we get a column ‘Null’ and as a value we get ‘YES’ which means under that column the value is allowed to be not known, which basically means while filling data into the table we can skip the value for the column where the column is allowed to be null. This is the default behavior.

As a solution while creating a table we can set constraints where we can deliberately specify a specific column or all tables to not to be `null`. This is shown below:

```sh
mysql> create table cats2(
    -> name varchar(10) not null,
    -> age int not null
    -> );
Query OK, 0 rows affected (0.10 sec)
```

Now if we want to describe the table:

```sh
mysql> desc cats2;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| name  | varchar(10) | NO   |     | NULL    |       |
| age   | int         | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.01 sec)
```

Which basically means neither the `name` column and `age` could be set to `null`.

Now if we try to insert a null value we get the following error:
 
```sh
mysql> insert into cats2(name) values ('ipsum');
ERROR 1364 (HY000): Field 'age' doesn't have a default value
```

# Setting up default values for column constraints

For example, if we describe a table we get the following:

```sh
mysql> desc cats2;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| name  | varchar(10) | NO   |     | NULL    |       |
| age   | int         | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)
```

Here we have a column that says `Default` which means the default value to be used in-case a value for that column is not provided when making an entry to that table.

Here we don’t have a fallback default value for any column if a value is skipped. Hence we have null specified under `Default` column.

For specifying the default value we can use ‘default’ keyword, consider the following:

```sh
mysql> create table cats3(
    -> name varchar(10) not null default 'sexy-cat',
    -> age int not null default 10
    -> );
Query OK, 0 rows affected (0.05 sec)
```

now from the table description we can get to know if the fields can accept `null` values or is there are any default values existing for fields.

so inserting data:

```sh
mysql> insert into cats3 (name) values ('sakila');
Query OK, 1 row affected (0.04 sec)
```

On the above record, while inserting, we are ignoring the age and as a default `10` should be assigned as a default.

Similarly we can insert a record where we can ignore the name and in that case as a default value `sexy-cat` will be assigned.

consider the following example,

```sh
mysql> insert into cats3 (age) values (10);
Query OK, 1 row affected (0.01 sec)
```

As of now we inserted two records one without `age` and one without `name`, let's verify from a query below, whether the default values have been assigned or not.

```sh
mysql> show columns from cats3;
+-------+-------------+------+-----+----------+-------+
| Field | Type        | Null | Key | Default  | Extra |
+-------+-------------+------+-----+----------+-------+
| name  | varchar(10) | NO   |     | sexy-cat |       |
| age   | int         | NO   |     | 10       |       |
+-------+-------------+------+-----+----------+-------+
2 rows in set (0.00 sec)
```

At this point of time we might think if there is a default value provided for a column then why there is a ‘not-null’ constraint? This is because while inserting data if we are skipping a column value then the `default` value is assigned, but if the user deliberately enters `null` as a value then the record insertion won't happen.

Consider the following example,

```sh
mysql> insert into cats3 (name,age) values ('skyler',null);
ERROR 1048 (23000): Column 'age' cannot be null
```

This is how we are saved when we try to insert a null value.

# Primary Keys

**Primary Key** is a way for distinguishing identical records. **Primary key** for each entry must be unique. 

Duplicate primary-key entries are not allowed and will throw error.

We might have a scenario as described below:

![](chatper_2_1.png)

![](chapter_2_2.png)

`Primary key` in the end is just a table constraint. Consider the example:

```sh
mysql> create table unique_cats(
    -> id int not null,
    -> name varchar(10) not null,
    -> age int not null,
    -> primary key (id)
    -> );
Query OK, 0 rows affected (0.08 sec)
```

Now from the table description we also get the information about our primary key.

```sh
mysql> desc unique_cats;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int         | NO   | PRI | NULL    |       |
| name  | varchar(10) | NO   |     | NULL    |       |
| age   | int         | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
3 rows in set (0.01 sec)
```

Now let's insert some records into the table,

```sh
mysql> insert into unique_cats (id,name,age) values (2,'Lewis',12);
Query OK, 1 row affected (0.03 sec)
 
mysql> insert into unique_cats (id,name,age) values (2,'james',31);
ERROR 1062 (23000): Duplicate entry '2' for key 'unique_cats.PRIMARY'
```

Hence duplicates are not allowed.

We can add `auto_increment` constraint on the primary key if it is of type `int`, in this way we don’t have to keep track of the `id` manually and thus avoiding duplicate primary key clashes.

Consider the following example:

```sh
mysql> create table myCats (
    -> id int auto_increment,
    -> name varchar(10) not null,
    -> age int not null,
    -> primary key (id)
    -> );
Query OK, 0 rows affected (0.07 sec)
```

Now the table description can be verified as well.

```sh
mysql> desc myCats;
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| id    | int         | NO   | PRI | NULL    | auto_increment |
| name  | varchar(10) | NO   |     | NULL    |                |
| age   | int         | NO   |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+
3 rows in set (0.01 sec)
```

Now let's insert some data into the `myCats` table,

```sh
mysql> insert into myCats (name,age)
    -> values ('jakie',1), ('james',3), ('skippy',3);
Query OK, 3 rows affected (0.02 sec)
Records: 3  Duplicates: 0  Warnings: 0
```

and the data inserted can be verified as the following:

```sh
mysql> select * from myCats;
+----+--------+-----+
| id | name   | age |
+----+--------+-----+
|  1 | jakie  |   1 |
|  2 | james  |   3 |
|  3 | skippy |   3 |
+----+--------+-----+
3 rows in set (0.00 sec)
```

It can be observed from the table, though we are not inserting the data for the ‘id’ field it is getting auto incremented.