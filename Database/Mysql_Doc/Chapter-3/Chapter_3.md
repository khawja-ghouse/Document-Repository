# CRUD Operations

c- create (insert command)

r- read (select command)

u- update

d- delete

These are four basic operation done to data present in a database.

Let's begin our crud operation by creating a table `cats`.

```sh
mysql> create table cats (
    -> cat_id int not null auto_increment,
    -> name varchar(100),
    -> breed varchar(100),
    -> age int,
    -> primary key(cat_id)
    -> );
Query OK, 0 rows affected (0.06 sec)
```

Let's add couple of records to our database,

```sh
mysql> insert into cats (name,breed,age)
    -> values ('Ringo', 'Tabby' , 4),
    -> ('cindy','maine coon',10),
    -> ('dumbledore','maine coon',11),
    -> ('egg','persian',4),
    -> ('misty','tabby',13),
    -> ('george michael','ragdoll',9),
    -> ('jackson','sphynx',7);
Query OK, 7 rows affected (0.02 sec)
Records: 7  Duplicates: 0  Warnings:
```

# Reading Data from the Database

So basically when we tried to retrieve the data we had used select * from cats where the `*` means give me data from all columns from ‘cats’ table.

```sh
mysql> select * from cats;
+--------+----------------+------------+------+
| cat_id | name           | breed      | age  |
+--------+----------------+------------+------+
|      1 | Ringo          | Tabby      |    4 |
|      2 | cindy          | maine coon |   10 |
|      3 | dumbledore     | maine coon |   11 |
|      4 | egg            | persian    |    4 |
|      5 | misty          | tabby      |   13 |
|      6 | george michael | ragdoll    |    9 |
|      7 | jackson        | sphynx     |    7 |
+--------+----------------+------------+------+
7 rows in set (0.00 sec)
```

As we can see as per our query we retrieve data from all column in the cats table.

But we can also be more specific about the data we receive from the table. There is also a way of specifying which columns we want in particular. For example if we only want to retrieve the names from the `cats` table we could do the following.

```sh
mysql> select name from cats;
+----------------+
| name           |
+----------------+
| Ringo          |
| cindy          |
| dumbledore     |
| egg            |
| misty          |
| george michael |
| jackson        |
+----------------+
7 rows in set (0.00 sec)
```

we can also choose to see the `age` from the cats table.

```sh
mysql> select age from cats;
+------+
| age  |
+------+
|    4 |
|   10 |
|   11 |
|    4 |
|   13 |
|    9 |
|    7 |
+------+
7 rows in set (0.00 sec)
```

We can also fetch data from multiple column data, the multiple columns has to be separated by a comma `,` 

```sh
mysql> select name,age,breed from cats;
+----------------+------+------------+
| name           | age  | breed      |
+----------------+------+------------+
| Ringo          |    4 | Tabby      |
| cindy          |   10 | maine coon |
| dumbledore     |   11 | maine coon |
| egg            |    4 | persian    |
| misty          |   13 | tabby      |
| george michael |    9 | ragdoll    |
| jackson        |    7 | sphynx     |
+----------------+------+------------+
7 rows in set (0.00 sec)
```

When the tables are displayed after querying then the columns will display in the order they were queried, consider the following:

```sh
mysql> select name,age,breed,cat_id from cats;
+----------------+------+------------+--------+
| name           | age  | breed      | cat_id |
+----------------+------+------------+--------+
| Ringo          |    4 | Tabby      |      1 |
| cindy          |   10 | maine coon |      2 |
| dumbledore     |   11 | maine coon |      3 |
| egg            |    4 | persian    |      4 |
| misty          |   13 | tabby      |      5 |
| george michael |    9 | ragdoll    |      6 |
| jackson        |    7 | sphynx     |      7 |
+----------------+------+------------+--------+
7 rows in set (0.00 sec)
```

# Where clause

So far we saw how to fetch data for single column or from multiple columns, but still we receive the complete set of data. We wish to retrieve the data upon certain condition being matched. This is implemented via the `where` keyword.

This `where` clause will also be used for updating and deleting things, because this deletion and updating will often require some condition. Suppose we might want to delete the cats based on `age` etc.

If we only want to fetch the cats whose age is `4`, we can do the following,

```sh
mysql> select * from cats where age=4;
+--------+-------+---------+------+
| cat_id | name  | breed   | age  |
+--------+-------+---------+------+
|      1 | Ringo | Tabby   |    4 |
|      4 | egg   | persian |    4 |
+--------+-------+---------+------+
2 rows in set (0.00 sec)
```

If we want to receive all the details of a cat whose `name` is `egg`, we can have the following:

```sh
mysql>   select * from cats where name='eGg';
+--------+------+---------+------+
| cat_id | name | breed   | age  |
+--------+------+---------+------+
|      4 | egg  | persian |    4 |
+--------+------+---------+------+
1 row in set (0.00 sec)
```

while querying, the string used for a ‘where’ clause is **`case insensitive`** in nature.

# Working with aliases

Sometimes we might have a requirement where we want to display the column names in a slightly changed manner. In those cases, we can use `aliases`.

There might be two tables with same column names. So when we fetch data from two tables from joins it will be difficult to identify which column belong to which table. Hence, we need `aliases`.

```sh
mysql> select name as 'cat name', breed as 'kitty-breed' from cats;
+----------------+-------------+
| cat name       | kitty-breed |
+----------------+-------------+
| Ringo          | Tabby       |
| cindy          | maine coon  |
| dumbledore     | maine coon  |
| egg            | persian     |
| misty          | tabby       |
| george michael | ragdoll     |
| jackson        | sphynx      |
+----------------+-------------+
7 rows in set (0.00 sec)
```

# Update command

For places when we fuck up we might want to undo changes that’s when ‘update’ command comes handy.

This comes with a syntax ,

```mySQL
update `table-name` set `column-name` = value where <condition>
```

consider the following example:

before updating:

```sh
mysql> select name as 'cat name', breed as 'kitty-breed' from cats;
+----------------+-------------+
| cat name       | kitty-breed |
+----------------+-------------+
| Ringo          | Tabby       |
| cindy          | maine coon  |
| dumbledore     | maine coon  |
| egg            | persian     |
| misty          | tabby       |
| george michael | ragdoll     |
| jackson        | sphynx      |
+----------------+-------------+
7 rows in set (0.00 sec)
```

for example, we want to update the breed `tabby` to `custom-breed` we can do the following:

```sh
mysql> update cats set breed='custom_breed' where breed='tabby';
Query OK, 2 rows affected (0.01 sec)
Rows matched: 2  Changed: 2  Warnings: 0
```

Now we can verify the data:

```sh
mysql> select * from cats;
+--------+----------------+--------------+------+
| cat_id | name           | breed        | age  |
+--------+----------------+--------------+------+
|      1 | Ringo          | custom_breed |    4 |
|      2 | cindy          | maine coon   |   10 |
|      3 | dumbledore     | maine coon   |   11 |
|      4 | egg            | persian      |    4 |
|      5 | misty          | custom_breed |   13 |
|      6 | george michael | ragdoll      |    9 |
|      7 | jackson        | sphynx       |    7 |
+--------+----------------+--------------+------+
7 rows in set (0.00 sec)
```

As we can see `cat_id` 1 and 6 has been updated to `custom_breed`.

For example we want to update the age where the name is `misty`, we can do the following:

```sh
mysql> update cats set age=14 where name='misty';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0
```

Let's verify the data,

```sh
mysql> select * from cats;
+--------+----------------+--------------+------+
| cat_id | name           | breed        | age  |
+--------+----------------+--------------+------+
|      1 | Ringo          | custom_breed |    4 |
|      2 | cindy          | maine coon   |   10 |
|      3 | dumbledore     | maine coon   |   11 |
|      4 | egg            | persian      |    4 |
|      5 | misty          | custom_breed |   14 |
|      6 | george michael | ragdoll      |    9 |
|      7 | jackson        | sphynx       |    7 |
+--------+----------------+--------------+------+
7 rows in set (0.00 sec)
```

If we compare the above two result sets then we could see the `age` of cat with `name` **misty** has been updated to 14.

We also can perform multiple selects, in that case we need to use the `update` keyword once. The fields to be updated are to be separated by commas.

```mysql
update <table_name> set <field_1> = <value_1>, <field_2> = <value_2> 
where <condition>;
```

# Delete keyword

As the name suggests `delete` keyword is used to delete data from the table.

This comes with a following syntax : 

```mysql
delete from <table-name> where <condition>
```

> This deleting operation is not reversible.

In our case we want to delete a record where the `name` is ‘egg’, we can do the following:

```sh
mysql> delete from cats where name='egg';
Query OK, 1 row affected (0.01 sec)
```

Now with this the entry is gone.

```sh
mysql> select * from cats where name = 'egg';
Empty set (0.00 sec)
```

