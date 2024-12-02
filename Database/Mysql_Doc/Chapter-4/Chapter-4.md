### Logical Operator

Allow us to add logic to our sequel statements.

#### **not equal (!=)** : 
With this we can filter our results not matching a particular constraint. For example from the previous book table we can filter out the books those are not released in the year 2017. We can do the below:

```sh
select author_fname,author_lname,released_year from books where released_year != 2017;  
+--------------+----------------+---------------+  
| author_fname | author_lname   | released_year |  
+--------------+----------------+---------------+  
| Jhumpa       | Lahiri         |          2003 |  
| Neil         | Gaiman         |          2016 |  
| Neil         | Gaiman         |          2001 |  
| Jhumpa       | Lahiri         |          1996 |  
| Dave         | Eggers         |          2012 |  
| Dave         | Eggers         |          2013 |  
| Michael      | Chabon         |          2000 |  
| Patti        | Smith          |          2010 |  
| Dave         | Eggers         |          2001 |  
| Neil         | Gaiman         |          2003 |  
| Raymond      | Carver         |          1981 |  
| Raymond      | Carver         |          1989 |  
| Don          | DeLillo        |          1985 |  
| John         | Steinbeck      |          1945 |  
| David        | Foster Wallace |          2004 |  
| David        | Foster Wallace |          2005 |  
| Dan          | Harris         |          2014 |  
| Freida       | Harris         |          2001 |  
+--------------+----------------+---------------+  
18 rows in set (0.00 sec)
```

We can also get the data where the author last name is not ‘harris’,

```sh
SELECT title, author_lname FROM books WHERE author_lname != 'Harris';  
+-----------------------------------------------------+----------------+  
| title                                               | author_lname   |  
+-----------------------------------------------------+----------------+  
| The Namesake                                        | Lahiri         |  
| Norse Mythology                                     | Gaiman         |  
| American Gods                                       | Gaiman         |  
| Interpreter of Maladies                             | Lahiri         |  
| A Hologram for the King: A Novel                    | Eggers         |  
| The Circle                                          | Eggers         |  
| The Amazing Adventures of Kavalier & Clay           | Chabon         |  
| Just Kids                                           | Smith          |  
| A Heartbreaking Work of Staggering Genius           | Eggers         |  
| Coraline                                            | Gaiman         |  
| What We Talk About When We Talk About Love: Stories | Carver         |  
| Where I m Calling From: Selected Stories            | Carver         |  
| White Noise                                         | DeLillo        |  
| Cannery Row                                         | Steinbeck      |  
| Oblivion: Stories                                   | Foster Wallace |  
| Consider the Lobster                                | Foster Wallace |  
| Lincoln In The Bardo                                | Saunders       |  
+-----------------------------------------------------+----------------+  
17 rows in set (0.00 sec)
```


#### **like and not like**
**like** : This logical operator is used to perform a query where we filter out queries against not containing a specific pattern.

Let’s consider an example where we try to fetch all the book title that contains the letter ‘w’,

```sh
select title from books where title like '%w%';  
+-----------------------------------------------------+  
| title                                               |  
+-----------------------------------------------------+  
| A Heartbreaking Work of Staggering Genius           |  
| What We Talk About When We Talk About Love: Stories |  
| Where I m Calling From: Selected Stories            |  
| White Noise                                         |  
| Cannery Row                                         |  
+-----------------------------------------------------+  
5 rows in set (0.00 sec)
```

**not like**
Now we can do the opposite where we can fetch all the books where the title does not contain the letter ‘w’,
```sh
select title from books where title not like '%w%';  
+-------------------------------------------+  
| title                                     |  
+-------------------------------------------+  
| The Namesake                              |  
| Norse Mythology                           |  
| American Gods                             |  
| Interpreter of Maladies                   |  
| A Hologram for the King: A Novel          |  
| The Circle                                |  
| The Amazing Adventures of Kavalier & Clay |  
| Just Kids                                 |  
| Coraline                                  |  
| Oblivion: Stories                         |  
| Consider the Lobster                      |  
| 10% Happier                               |  
| fake_book                                 |  
| Lincoln In The Bardo                      |  
+-------------------------------------------+  
14 rows in set (0.00 sec)
```

#### **Greater Than (>)** : 
This logical operator is used to filter out the results against a constraint greater than a specified value.

With the available data set so far we can query all the books those were released after 2007,

```sh
select title,released_year from books where released_year>2000;  
+-------------------------------------------+---------------+  
| title                                     | released_year |  
+-------------------------------------------+---------------+  
| The Namesake                              |          2003 |  
| Norse Mythology                           |          2016 |  
| American Gods                             |          2001 |  
| A Hologram for the King: A Novel          |          2012 |  
| The Circle                                |          2013 |  
| Just Kids                                 |          2010 |  
| A Heartbreaking Work of Staggering Genius |          2001 |  
| Coraline                                  |          2003 |  
| Oblivion: Stories                         |          2004 |  
| Consider the Lobster                      |          2005 |  
| 10% Happier                               |          2014 |  
| fake_book                                 |          2001 |  
| Lincoln In The Bardo                      |          2017 |  
+-------------------------------------------+---------------+  
13 rows in set (0.00 sec)
```

We could also get the books whose stock quantity is equal to or greater than 200,

```sh
select title,stock_quantity from books where stock_quantity>=200;  
+----------------------+----------------+  
| title                | stock_quantity |  
+----------------------+----------------+  
| fake_book            |            287 |  
| Lincoln In The Bardo |           1000 |  
+----------------------+----------------+  
2 rows in set (0.00 sec)
```

We can also perform number comparison :

```sh
SELECT 99 > 1;

--true (1)  
   
SELECT 99 > 567;  
   
100 > 5  
-- true (1)  
   
-15 > 15  
-- false (0)  
   
9 > -10  
-- true (1)  
   
1 > 1  
-- false (0)  
   
'a' > 'b'  
-- false (0)  
   
'A' > 'a'  
-- false (0)  
   
'A' >=  'a'  
-- true (1)
```

#### **Less Than (<) :** 
This logical operator is used to filter out the results against a constraint less than a specified value.

We can fetch the books whose pages are less than 250,

```sh
 select title,pages from  books where pages<=250;  
+-----------------------------------------------------+-------+  
| title                                               | pages |  
+-----------------------------------------------------+-------+  
| Interpreter of Maladies                             |   198 |  
| Coraline                                            |   208 |  
| What We Talk About When We Talk About Love: Stories |   176 |  
| Cannery Row                                         |   181 |  
+-----------------------------------------------------+-------+  
4 rows in set (0.00 sec)
```

**Logical And (&&)** : 
This logical operator is used to combine two or more conditions where all conditions must be true.

We can get the books where the author’s last name is ‘eggers’ and the released_year is more than 2010,

mysql> select title,author_lname,released_year from books where author_lname='eggers' && released_year > 2010;  
+----------------------------------+--------------+---------------+  
| title                            | author_lname | released_year |  
+----------------------------------+--------------+---------------+  
| A Hologram for the King: A Novel | Eggers       |          2012 |  
| The Circle                       | Eggers       |          2013 |  
+----------------------------------+--------------+---------------+  
2 rows in set, 1 warning (0.00 sec)

We can also fetch books where the last name is ‘eggers’ and the released_year is more than 2010 and the title must contain the word ‘novel’,

mysql> select title,author_lname, released_year from books where author_lname='eggers' && released_year > 2010 && title like '%novel%';  
+----------------------------------+--------------+---------------+  
| title                            | author_lname | released_year |  
+----------------------------------+--------------+---------------+  
| A Hologram for the King: A Novel | Eggers       |          2012 |  
+----------------------------------+--------------+---------------+  
1 row in set, 2 warnings (0.00 sec)

mysql> show warnings;  
+---------+------+------------------------------------------------------------------------------------+  
| Level   | Code | Message                                                                            |  
+---------+------+------------------------------------------------------------------------------------+  
| Warning | 1287 | '&&' is deprecated and will be removed in a future release. Please use AND instead |  
| Warning | 1287 | '&&' is deprecated and will be removed in a future release. Please use AND instead |  
+---------+------+------------------------------------------------------------------------------------+  
2 rows in set (0.00 sec)

Please note, as of MySQL 8.0.17, the && operator is deprecated and support for it will be removed in a future MySQL version. Applications should be adjusted to use the standard SQL [AND](https://dev.mysql.com/doc/refman/8.0/en/logical-operators.html#operator_and) operator.

If you're using MySQL 5.7 or older, which most of you are if you're using GoormIDE, then you don't have to worry about this right now. But, in newer versions of MySQL (8.0.17 and newer) you will need to replace && with AND.

### **Logical And (&&)** :  This logical operator is used to combine two or more conditions where all conditions must be true.

We can get the books where the author’s last name is ‘eggers’ and the released_year is more than 2010,

 ```sh
select title,author_lname,released_year from books where author_lname='eggers' && released_year > 2010;  
+----------------------------------+--------------+---------------+  
| title                            | author_lname | released_year |  
+----------------------------------+--------------+---------------+  
| A Hologram for the King: A Novel | Eggers       |          2012 |  
| The Circle                       | Eggers       |          2013 |  
+----------------------------------+--------------+---------------+  
2 rows in set, 1 warning (0.00 sec)
```
We can also fetch books where the last name is ‘eggers’ and the released_year is more than 2010 and the title must contain the word ‘novel’,

 ```sh
select title,author_lname, released_year from books where author_lname='eggers' && released_year > 2010 && title like '%novel%';  
+----------------------------------+--------------+---------------+  
| title                            | author_lname | released_year |  
+----------------------------------+--------------+---------------+  
| A Hologram for the King: A Novel | Eggers       |          2012 |  
+----------------------------------+--------------+---------------+  
1 row in set, 2 warnings (0.00 sec)
```


```sh
show warnings;  
+---------+------+-------------------------------------+  
| Level   | Code |    Message                          |  
+---------+------+-------------------------------------+  
| Warning | 1287 | '&&' is deprecated. Please use AND  |  
| Warning | 1287 | '&&' is deprecated. Please use AND  |  
+---------+------+-------------------------------------+  
```
2 rows in set (0.00 sec)

Please note, as of MySQL 8.0.17, the && operator is deprecated and support for it will be removed in a future MySQL version. Applications should be adjusted to use the standard SQL [AND](https://dev.mysql.com/doc/refman/8.0/en/logical-operators.html#operator_and) operator.

If you're using MySQL 5.7 or older, which most of you are if you're using GoormIDE, then you don't have to worry about this right now. But, in newer versions of MySQL (8.0.17 and newer) you will need to replace && with AND.

#### **Logical OR (||) :** 
This logical operator is used to combine two or more conditions where any one condition must be true.

Please note, as of MySQL 8.0.17, the || operator is deprecated and support for it will be removed in a future MySQL version. Applications should be adjusted to use the standard SQL [OR](https://dev.mysql.com/doc/refman/8.0/en/logical-operators.html#operator_or) operator.

  
If you're using MySQL 5.7 or older, which most of you are if you're using GoormIDE, then you don't have to worry about this right now. But, in newer versions of MySQL (8.0.17 and newer) you will need to replace || with OR.

```sh
select title,author_lname,released_year,pages from books where author_lname="eggers" or released_year>2000 and pages > 400;
+--------------------------------------+--------------+---------------+-------+
| title                                | author_lname | released_year | pages |
+--------------------------------------+--------------+---------------+-------+
| American Gods                        | Gaiman       |          2001 |   465 |
| A Hologram for the King: A Novel     | Eggers       |          2012 |   352 |
| The Circle                           | Eggers       |          2013 |   504 |
| A Heartbreaking Work of Genius       | Eggers       |          2001 |   437 |
| fake_book                            | Harris       |          2001 |   428 |
+--------------------------------------+--------------+---------------+-------+
5 rows in set (0.00 sec)
```

As we can see from the above example we have got the output of books where the author_lname is “Eggers” or the released_year is after 2000 with every books with 400+ pages.

#### Between
It helps us filtering records based on two data :  the upper bound and the lower bound.

Alternatively, we can use the same thing with the combination of greater than (>) and less than (<) operators. Consider the example where we print all the books released between 2004 and 2015 :

```sh
select title,author_fname,author_lname,released_year from books where released_year > 2004 and released_year<2015;
+-------------------------+--------------+----------------+---------------+
| title                   | author_fname | author_lname   | released_year |
+-------------------------+--------------+----------------+---------------+
| A Hologram for the King | Dave         | Eggers         |          2012 |
| The Circle              | Dave         | Eggers         |          2013 |
| Just Kids               | Patti        | Smith          |          2010 |
| Consider the Lobster    | David        | Foster Wallace |          2005 |
| 10% Happier             | Dan          | Harris         |          2014 |
+-------------------------+--------------+----------------+---------------+
5 rows in set (0.00 sec)
```

How ever the same can also be achieved using the between operator, this is shown below :

```sh
select title,author_fname,author_lname,released_year from books where released_year between 2004 and 2015;

+-------------------------+--------------+----------------+---------------+
| title                   | author_fname | author_lname   | released_year |
+-------------------------+--------------+----------------+---------------+
| A Hologram for the King | Dave         | Eggers         |          2012 |
| The Circle              | Dave         | Eggers         |          2013 |
| Just Kids               | Patti        | Smith          |          2010 |
| Consider the Lobster    | David        | Foster Wallace |          2005 |
| 10% Happier             | Dan          | Harris         |          2014 |
+-------------------------+--------------+----------------+---------------+
5 rows in set (0.00 sec)
```

**Remember, while using the between operator the result set return is always inclusive of the upper and lower bounds.**

Now if there is a scenario where we want to get the books whose page numbers are not in between 100 and 400 then we can use **Not Between <…> and <…>** , this is shown below  :

```sh
select title,pages,released_year from books where pages not between 100 and 500;

+-------------------------------------------+-------+---------------+

| title                                     | pages | released_year |

+-------------------------------------------+-------+---------------+

| The Circle                                |   504 |          2013 |

| The Amazing Adventures of Kavalier & Clay |   634 |          2000 |

| Where Im Calling From: Selected Stories  |   526 |          1989 |

+-------------------------------------------+-------+---------------+

3 rows in set (0.00 sec)
```

#### In / Not In

There might be times when we would like to compare our data with a set of values, in those cases we can use the **In** operator.

For example we want to get the books where the author_lname is either “Gaiman”, “Eggers” or “Carver” , for this we can use the or operator as shown below :

```sh
select title, author_lname from books where author_lname in ("Gaiman", "Eggers", "Carver");
+-----------------------------------------------------+--------------+
| title                                               | author_lname |
+-----------------------------------------------------+--------------+
| Norse Mythology                                     | Gaiman       |
| American Gods                                       | Gaiman       |
| A Hologram for the King: A Novel                    | Eggers       |
| The Circle                                          | Eggers       |
| A Heartbreaking Work of Staggering Genius           | Eggers       |
| Coraline                                            | Gaiman       |
| What We Talk About When We Talk About Love: Stories | Carver       |
| Where I m Calling From: Selected Stories            | Carver       |
+-----------------------------------------------------+--------------+
8 rows in set (0.00 sec)

```

```sh
select title, released_year from books where released_year % 2 != 0 ;
+-----------------------------------------------------+---------------+
| title                                               | released_year |
+-----------------------------------------------------+---------------+
| The Namesake                                        |          2003 |
| American Gods                                       |          2001 |
| The Circle                                          |          2013 |
| A Heartbreaking Work of Staggering Genius           |          2001 |
| Coraline                                            |          2003 |
| What We Talk About When We Talk About Love: Stories |          1981 |
| Where I m Calling From: Selected Stories            |          1989 |
| White Noise                                         |          1985 |
| Cannery Row                                         |          1945 |
| Consider the Lobster                                |          2005 |
| fake_book                                           |          2001 |
| Lincoln In The Bardo                                |          2017 |
+-----------------------------------------------------+---------------+
12 rows in set (0.00 sec)
```