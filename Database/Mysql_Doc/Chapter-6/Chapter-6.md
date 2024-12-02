Aggregate Function

Here we will be learning different ways of performing operations on data like taking out the average, finding out the sum for couple of data.

Aggregate functions are built in functions in MySQL which will combine data to get meaning out of it. So, we can do something like finding average page number for all our books or find the page length for each author if an author has written multiple books etc.

These functions are called so because they operate on aggregated data.

#### Count()

This is a built-in aggregate function into MySQL which will count what we tell it to count.

For example, we want to count how many books are there in the database we can do the following.

```SQL
mysql> select count(*) as total_books from books;

+-------------+
| total_books |
+-------------+
|          19 |
+-------------+
1 row in set (0.00 sec)
```

For example, we would want to know about how many distinct author’s first name are there in the database, we can do the following

```SQL
mysql> select  count(distinct author_fname)   as distinct_author from books;

+-----------------+
| distinct_author |
+-----------------+
|              12 |
+-----------------+

1 row in set (0.00 sec)
```

Using ‘distinct’ outside of count() function will have no effect as already the ‘author_fname’ column will return all the records and the count() function will count all of them. Hence while fetching the column value for ‘author_fname’ we have to do the filtration and therefore ‘distinct’ is used inside ‘count()’.

Consider another example where we want to fetch distinct authors from the books table. This means we cannot simply rely on distinct first names as: Ryan Dhal and Ryan Stevens are two different persons. If we select these two with distinct then MySQL will treat both names as one, which is wrong.

Similarly, we cannot rely on distinct last names either as: Will Smith and Jaden Smith are two different persons but if we consider both as distinct last name, MySQL will treat both names as same, which again of course is wrong. So, we have to come up with an implementation where we do distinct with first name and last name at the same time, this can be done as below,

mysql> select count(distinct author_fname,author_lname) as distinct_authors from books;  
```SQL
+------------------+  
| distinct_authors |  
+------------------+  
|                9 |  
+------------------+  
1 row in set (0.00 sec)
```

Now if we want to find the number of books those contain ‘the’, we can do the following.

```SQL
mysql> select count(title) from books where title like '%the%';

+--------------+
| count(title) |
+--------------+
|            6 |
+--------------+

1 row in set (0.00 sec)
```


#### Group By

Group by summarizes or aggregates identical data into single rows. We can say take all our books and group them by author’s last name or by the released year. Suppose we run a query as shown below:

![](Chapter-6/Image_6.1.png)

(for keeping things clear actual output of the above query is reduced to 5 entries)

Now if we run a query containing **group by** we get the bizarre output which at the first sight makes no meaning to us.

[![[Image-6.2.png]]![](Chapter-6/Image-6.2.png)

But behind the scenes if we look closer, we can know the entries in the output have been grouped into mega rows based on the author’s name. Which can be seen in the diagram below:

![](Chapter-6/Image-6.3.png)

As the data is grouped at this point according to the author_lname we can do many things with it. For example we can count the book written by individual authors as shown below:

![](Chapter-6/Image-6.4.png)

Now we can group the data by any available columns. For example, we want to know the total number of books written by any author. Now we can group the book titles by author’s first name. This would now combine all the rows under same author’s first name. Now as the data is aggregated or shrunk we can get whatever we want.

```SQL
mysql> select author_fname,count(*) as total_books from books group by author_fname;
+--------------+-------------+
| author_fname | total_books |
+--------------+-------------+
| Jhumpa       |           2 |
| Neil         |           3 |
| Dave         |           3 |
| Michael      |           1 |
| Patti        |           1 |
| Raymond      |           2 |
| Don          |           1 |
| John         |           1 |
| David        |           2 |
| Dan          |           1 |
| Freida       |           1 |
| George       |           1 |
+--------------+-------------+
12 rows in set (0.00 sec)
```

Now when we only select by author’s first name we might run into problem because if we have the following authors:

1.     Mike David
2.     Mike Williams

then both of the author only differs by their first name and hence when they are grouped by author’s first name they are treated as same entity and therefore grouped into one. LOL.

To avoid this, we can group by both author’s first name and last name. In that case before grouping the records we are comparing for uniqueness by first name and last name which is shown below,

```SQl
mysql> select author_fname,author_lname, count(*) from books group by author_fname,author_lname;  
+--------------+----------------+----------+  
| author_fname | author_lname   | count(*) |  
+--------------+----------------+----------+  
| Dan          | Harris         |        1 |  
| Dave         | Eggers         |        3 |  
| David        | Foster Wallace |        2 |  
| Don          | DeLillo        |        1 |  
| Freida       | Harris         |        1 |  
| George       | Saunders       |        1 |  
| Jhumpa       | Lahiri         |        2 |  
| John         | Steinbeck      |        1 |  
| Michael      | Chabon         |        1 |  
| Neil         | Gaiman         |        3 |  
| Patti        | Smith          |        1 |  
| Raymond      | Carver         |        2 |  
+--------------+----------------+----------+  
12 rows in set (0.00 sec)
```

So right now count(*) is actually counting the rows grouped under author_fname and author_lname.

Similarly if we wanted to know the total number of the books in a year we can do the following,

```SQL
mysql> select released_year,count(*) from books group by released_year;
+---------------+----------+
| released_year | count(*) |
+---------------+----------+
|          2003 |        2 |
|          2016 |        1 |
|          2001 |        3 |
|          1996 |        1 |
|          2012 |        1 |
|          2013 |        1 |
|          2000 |        1 |
|          2010 |        1 |
|          1981 |        1 |
|          1989 |        1 |
|          1985 |        1 |
|          1945 |        1 |
|          2004 |        1 |
|          2005 |        1 |
|          2014 |        1 |
|          2017 |        1 |
+---------------+----------+
16 rows in set (0.00 sec)
```

we can also get little fancy

```SQl
mysql> select concat('Total books released in ',released_year,' is ',count(*)) as book_release_data from books group by released_year;
+-----------------------------------+
| book_release_data                 |
+-----------------------------------+
| Total books released in 2003 is 2 |
| Total books released in 2016 is 1 |
| Total books released in 2001 is 3 |
| Total books released in 1996 is 1 |
| Total books released in 2012 is 1 |
| Total books released in 2013 is 1 |
| Total books released in 2000 is 1 |
| Total books released in 2010 is 1 |
| Total books released in 1981 is 1 |
| Total books released in 1989 is 1 |
| Total books released in 1985 is 1 |
| Total books released in 1945 is 1 |
| Total books released in 2004 is 1 |
| Total books released in 2005 is 1 |
| Total books released in 2014 is 1 |
| Total books released in 2017 is 1 |
+-----------------------------------+
16 rows in set (0.00 sec)

```


Min() and Max()

Min() is used to find out the min value in a table. Similarly Max() is used to find the maximum value in the table. These can work with or without ‘group by’. So we can do something like finding the minimum released_year. which is nothing but the first ever year when the book was released which is shown below:

For example, we want to know the first ever year when the book was released.

```SQL
mysql> select min(released_year) from books;
+--------------------+
| min(released_year) |
+--------------------+
|               1945 |
+--------------------+
1 row in set (0.00 sec)`
```

We can also get the minimum pages existing in our data

```SQL
mysql> select min(pages) from books;
+------------+
| min(pages) |
+------------+
|        176 |
+------------+
1 row in set (0.00 sec)

```

```SQL
mysql> **select** min(pages),title **from** books;  
+------------+--------------+  
| min(pages) | title        |  
+------------+--------------+|        176 | The Namesake |  
+------------+--------------+  
1 **row** **in** **set** (0.00 sec)
```

So at this point ‘The Nameshake’ is definitely not the book containing the least amount of pages.

Situation also goes super weird with ‘max()’ as well. Consider the code below:

```SQl
mysql> **select** max(pages),title **from** books;  
+------------+--------------+  
| max(pages) | title        |  
+------------+--------------+|        634 | The Namesake |  
+------------+--------------+  
1 **row** **in** **set** (0.00 sec)
```

So we can’t have same title both for min and max number of pages. This is the known issue with min() and max() aggregate functions.

However, with the learned concepts till this point we can do something as below:

If we want to find the book detail with the min num of pages

```SQl
mysql> select title, pages from books order by pages limit 1;
+-----------------------------------------------------+-------+
| title                                               | pages |
+----------------------------------------------------+-------+
| What We Talk About When We Talk About Love: Stories |   176 |
+-----------------------------------------------------+-------+
1 row in set (0.00 sec)

```

Another possible solution to this would be taking help of sub queries,
```SQL
mysql> select title, pages from books where pages = (select max(pages) from books);
+-------------------------------------------+-------+
| title                                     | pages |
+-------------------------------------------+-------+
| The Amazing Adventures of Kavalier & Clay |   634 |
+-------------------------------------------+-------+
1 row in set (0.04 sec)
```
We will see more subqueries later. But in the above example the nested query runs first and its output is used on the outer query. One potential downside of using subqueries is, it might slow down the performance if the nested query takes longer to complete.

The min() and max() functions can also be used with group by, for example we will find the year where an author published there first book. To solve this problem we have to group the output by the authors and if we take the min() published year, that will be our answer. This is done below:

```SQL
mysql> select author_fname,author_lname,released_year,min(released_year) from books group by author_fname,author_lname;  
+--------------+----------------+---------------+--------------------+  
| author_fname | author_lname   | released_year | min(released_year) |  
+--------------+----------------+---------------+--------------------+  
| Dan          | Harris         |          2014 |               2014 |  
| Dave         | Eggers         |          2012 |               2001 |  
| David        | Foster Wallace |          2004 |               2004 |  
| Don          | DeLillo        |          1985 |               1985 |  
| Freida       | Harris         |          2001 |               2001 |  
| George       | Saunders       |          2017 |               2017 |  
| Jhumpa       | Lahiri         |          2003 |               1996 |  
| John         | Steinbeck      |          1945 |               1945 |  
| Michael      | Chabon         |          2000 |               2000 |  
| Neil         | Gaiman         |          2016 |               2001 |  
| Patti        | Smith          |          2010 |               2010 |  
| Raymond      | Carver         |          1981 |               1981 |  
+--------------+----------------+---------------+--------------------+  
12 rows in set (0.00 sec)
```

We can also write a query to find out the particular book by an author which has got maximum number of pages, consider the query below:

```SQL
mysql> select author_fname,author_lname,max(pages) from books  group by author_lname,author_fname ;  
+--------------+----------------+------------+  
| author_fname | author_lname   | max(pages) |  
+--------------+----------------+------------+  
| Jhumpa       | Lahiri         |        291 |  
| Neil         | Gaiman         |        465 |  
| Dave         | Eggers         |        504 |  
| Michael      | Chabon         |        634 |  
| Patti        | Smith          |        304 |  
| Raymond      | Carver         |        526 |  
| Don          | DeLillo        |        320 |  
| John         | Steinbeck      |        181 |  
| David        | Foster Wallace |        343 |  
| Dan          | Harris         |        256 |  
| Freida       | Harris         |        428 |  
| George       | Saunders       |        367 |  
+--------------+----------------+------------+  
12 rows in set (0.00 sec)
```

Sum()

This function is as simple as it sounds. This function will be used to calculate sum.

Consider a use case where we wanted to count the total number of pages we have in our database. We could do something as shown below :

```SQL
mysql> select sum(pages) as total_pages from books;  
+-------------+  
| total_pages |  
+-------------+  
|        6623 |  
+-------------+  
1 row in set (0.00 sec)
```

We can also know total number of pages written by individual authors, we could do something like below :

```SQL
mysql> select sum(pages),concat_ws(" ",author_fname,author_lname) as author from books group by author_lname,author_fname;  
+------------+----------------------+  
| sum(pages) | author               |  
+------------+----------------------+  
|        489 | Jhumpa Lahiri        |  
|        977 | Neil Gaiman          |  
|       1293 | Dave Eggers          |  
|        634 | Michael Chabon       |  
|        304 | Patti Smith          |  
|        702 | Raymond Carver       |  
|        320 | Don DeLillo          |  
|        181 | John Steinbeck       |  
|        672 | David Foster Wallace |  
|        256 | Dan Harris           |  
|        428 | Freida Harris        |  
|        367 | George Saunders      |  
+------------+----------------------+  
12 rows in set (0.00 sec)
```

In the above example we also see how we have used **sum()** with **group by** clause.

Avg()

This function will be used to find out averages. If we wanted to know average pages written by authors we could do something like below :

```SQL
mysql> select avg(pages),concat_ws(" ",author_fname,author_lname) as author from books group by author_lname,author_fname;  
+------------+----------------------+  
| avg(pages) | author               |  
+------------+----------------------+  
|   244.5000 | Jhumpa Lahiri        |  
|   325.6667 | Neil Gaiman          |  
|   431.0000 | Dave Eggers          |  
|   634.0000 | Michael Chabon       |  
|   304.0000 | Patti Smith          |  
|   351.0000 | Raymond Carver       |  
|   320.0000 | Don DeLillo          |  
|   181.0000 | John Steinbeck       |  
|   336.0000 | David Foster Wallace |  
|   256.0000 | Dan Harris           |  
|   428.0000 | Freida Harris        |  
|   367.0000 | George Saunders      |  
+------------+----------------------+  
12 rows in set (0.28 sec)
```