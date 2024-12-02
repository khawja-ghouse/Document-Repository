Revisiting Data Types

char vs varchar :

The length of a CHAR column is fixed to the  length that you declare when you create the table.  The length can be any value from 0 to 255.  When CHAR values are stored, they are right-padded  with spaces to the specified length. When CHAR  values are retrieved, trailing spaces are removed  unless the PAD_CHAR_TO_FULL_LENGTH SQL mode is enabled.

|           |             |             |                |             |
| --------- | ----------- | ----------- | -------------- | ----------- |
| **Value** | **Char(4)** | **Storage** | **Varchar(4)** | **Storage** |
| ' '       | '    '      | 4 bytes     | ' '            | 1 byte      |
| 'ab'      | 'ab  '      | 4 bytes     | 'ab'           | 3 bytes     |
| 'abcd'    | 'abcd'      | 4 bytes     | 'abcd'         | 5 bytes     |
| 'abcdefg' | 'abcd'      | 4 bytes     | 'abcdefg'      | 5 bytes     |

Consider the table above where we show the difference between **char** and **varchar**

While using **char** , if we cross the specified size our content will be truncated

Decimal
![](Chapter-5/Image_5.1.png)

So, this **decimal(boundary, scale)** data types as seen will be having two arguments. The first argument denotes the total numbers of digit on both sides of decimal point. The second argument specifies the total number of digits allowed on the right-hand side of decimal.

Consider the example below where we create

```SQL
mysql> CREATE TABLE items(price DECIMAL(5,2));
Query OK, 0 rows affected (1.02 sec)

mysql> INSERT INTO items(price) VALUES(7);
Query OK, 1 row affected (0.06 sec)

mysql> INSERT INTO items(price) VALUES(7987654);
ERROR 1264 (22003): Out of range value for column 'price' at row 1

mysql> INSERT INTO items(price) VALUES(34.88);
Query OK, 1 row affected (0.01 sec)

mysql> **INSERT** **INTO** items(price) **VALUES**(298.9999);  
Query OK, 1 **row** affected, 1 warning (0.02 sec)  
  
mysql> **INSERT** **INTO** items(price) **VALUES**(1.9999);  
Query OK, 1 **row** affected, 1 warning (0.01 sec)  
  
mysql> **SELECT** * **FROM** items;  
+--------+  
| price  |  
+--------+|   7.00 |  
|  34.88 |  
| 299.00 |  
|   2.00 |  
+--------+  
4 **rows** **in** **set** (0.00 sec)
```


We also should remember when we try to insert a value larger than the specified constraint, then we get error and as a default max value for the current constraint is inserted.

for example, when we tried to insert 7987654 , we get out of range error and by default 999.99 is inserted.

We also should keep in mind for current constraint (decimal(5,2)) ; if there are more numbers after the decimal then the entire value is rounded up to next ceiling value.

### Float and Double

Both float and double can be used to store numbers with fraction with lesser memory but with approximation. Which means with these two data types we can store large numbers with lesser accuracy.


| **Data Type** | **Memory Needed** | **Precision Issues** |
| ------------- | ----------------- | -------------------- |
| FLOAT         | 4 Bytes           | ~7 digits            |
| DOUBLE        | 8 Bytes           | ~15 digits           |
We will loose precision if we go beyond 7 digits in case of float. The same way 15 digits for double. Consider the example below :

```SQL
mysql> CREATE TABLE thingies (price FLOAT);
Query OK, 0 rows affected (0.16 sec)

mysql> INSERT INTO thingies(price) VALUES (88.45);
Query OK, 1 row affected (0.04 sec)

mysql> SELECT * FROM thingies;
+-------+
| price |
+-------+
| 88.45 |
+-------+
1 row in set (0.00 sec)

mysql> INSERT INTO thingies(price) VALUES (8877.45);
Query OK, 1 row affected (0.04 sec)

mysql> SELECT * FROM thingies;
+---------+
| price   |
+---------+
|   88.45 |
| 8877.45 |
+---------+
2 rows in set (0.00 sec)

mysql> INSERT INTO thingies(price) VALUES (8877665544.45);
Query OK, 1 row affected (0.01 sec)

mysql> SELECT * FROM thingies;
+------------+
| price      |
+------------+
|      88.45 |
|    8877.45 |
| 8877670000 |
+------------+
3 rows in set (0.00 sec)


```

### Date and Time and DateTime

Date : This data type is used to store only date. It will be in the format “YYYY-MM-DD”. Always remember to put the date data within quotes.

Time : This data type is used to store only time. It will be in the format “HH:MM:SS”. Always remember to put the time data within quotes.

DateTime : This data type is used to store both the date and time together. This will be in the format “YYYY-MM-DD HH:MM:SS”. Always remember to put the date time data within quotes.

Consider the example below where we create the people table and playaround some data.

```SQL
mysql> CREATE TABLE people (name VARCHAR(100), birthDate DATE, birthTime TIME, birthDayTime DATETIME);  
   
mysql> INSERT INTO people (name, birthdate, birthtime, birthdt)  
VALUES('Padma', '1983-11-11', '10:07:35', '1983-11-11 10:07:35');  
   
mysql> INSERT INTO people (name, birthdate, birthtime, birthdt)  
VALUES('Larry', '1943-12-25', '04:10:42', '1943-12-25 04:10:42');

mysql>select * **from** people;  
+----------+------------+-----------+---------------------+  
| name     | birthDate  | birthTime | birthDayTime        |  
+----------+------------+-----------+---------------------+  
| zz   | 1995-09-24 | 09:07:35  | 1995-09-24 09:07:35 |  
| qa | 2000-01-24 | 02:11:47  | 2000-01-24 02:11:47 |  
| we  | 1993-11-20 | 23:03:35  | 1993-11-20 23:03:35 |  
| ss    | 1983-11-11 | 10:07:35  | 1983-11-11 10:07:35 |  
| ad    | 1943-12-25 | 04:10:42  | 1943-12-25 04:10:42 |  
+----------+------------+-----------+---------------------+
5 rows **in** **set** (0.00 sec)
```

We also have utility function for providing current date, current time and current date time.

**CurDate()** : provides current date.

**CurTime()** : provides current time.

**Now()** : provides current date time.

have a look at the example below :

```SQL
mysql>select CurDate() as 'current date', CurTime() as 'current time', Now() as "current date & time";
+--------------+--------------+---------------------+
| current date | current time | current date & time |
+--------------+--------------+---------------------+
| 2022-01-22   | 00:59:35     | 2022-01-22 00:59:35 |
+--------------+--------------+---------------------+
1 row in set (0.00 sec)

```

Formatting Dates

We can format dates using an utility function **date_format(date,format)**.

The specifiers shown in the following table may be used in the **_format_** string. The % character is required before format specifier characters. 

| **Specifier** | **Description**                                                                                                                                                             |
| ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| %a            | Abbreviated weekday name (Sun..Sat)                                                                                                                                         |
| %b            | Abbreviated month name (Jan..Dec)                                                                                                                                           |
| %c            | Month, numeric (0..12)                                                                                                                                                      |
| %D            | Day of the month with English suffix (0th, 1st, 2nd, 3rd, …)                                                                                                                |
| %d            | Day of the month, numeric (00..31)                                                                                                                                          |
| %e            | Day of the month, numeric (0..31)                                                                                                                                           |
| %f            | Microseconds (000000..999999)                                                                                                                                               |
| %H            | Hour (00..23)                                                                                                                                                               |
| %h            | Hour (01..12)                                                                                                                                                               |
| %I            | Hour (01..12)                                                                                                                                                               |
| %i            | Minutes, numeric (00..59)                                                                                                                                                   |
| %j            | Day of year (001..366)                                                                                                                                                      |
| %k            | Hour (0..23)                                                                                                                                                                |
| %l            | Hour (1..12)                                                                                                                                                                |
| %M            | Month name (January..December)                                                                                                                                              |
| %m            | Month, numeric (00..12)                                                                                                                                                     |
| %p            | AM or PM                                                                                                                                                                    |
| %r            | Time, 12-hour (**_hh:mm:ss_** followed by AM or PM)                                                                                                                         |
| %S            | Seconds (00..59)                                                                                                                                                            |
| %s            | Seconds (00..59)                                                                                                                                                            |
| %T            | Time, 24-hour (**_hh:mm:ss_**)                                                                                                                                              |
| %U            | Week (00..53), where Sunday is the first day of the week; [WEEK()](https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_week) mode 0               |
| %u            | Week (00..53), where Monday is the first day of the week; [WEEK()](https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_week) mode 1               |
| %V            | Week (01..53), where Sunday is the first day of the week; [WEEK()](https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_week) mode 2; used with %X |
| %v            | Week (01..53), where Monday is the first day of the week; [WEEK()](https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_week) mode 3; used with %x |
| %W            | Weekday name (Sunday..Saturday)                                                                                                                                             |
| %w            | Day of the week (0=Sunday..6=Saturday)                                                                                                                                      |
| %X            | Year for the week where Sunday is the first day of the week, numeric, four digits; used with %V                                                                             |
| %x            | Year for the week, where Monday is the first day of the week, numeric, four digits; used with %v                                                                            |
| %Y            | Year, numeric, four digits                                                                                                                                                  |
| %y            | Year, numeric (two digits)                                                                                                                                                  |
| %%            | A literal % character                                                                                                                                                       |
| %**_x_**      | **_x_**, for any “**_x_**” not listed above                                                                                                                                 |

Consider the example where we use the format specifier to format date time :

```SQL
mysql>select concat_ws(" ",name,"was born on",date_format(birthDayTime,"%D of %M %Y at %h:%i:%s %p")) **as** 'Birth Day Time' **from** people;  
+----------------------------------------------------------+  
| Birth Day Time                                           |  
+----------------------------------------------------------+
| abc was born **on** 24th **of** September 1995 **at** 09:07:35 AM |  
| efg was born **on** 24th **of** January 2000 **at** 02:11:47 AM |  
| hij was born **on** 20th **of** November 1993 **at** 11:03:35 PM |  
| klm was born **on** 11th **of** November 1983 **at** 10:07:35 AM   |  
| Laasddrry was born **on** 25th **of** December 1943 **at** 04:10:42 AM   |  
+----------------------------------------------------------+  
5 rows **in** **set** (0.00 sec)
```


**datetime vs timestamp :** Both data types will be store date and time in the format “YYYY-MM-DD HH:MM:SS”.

But there is a basic difference. The supported range of **datetime** is from **1000-01-01 00:00:00** to **9999-12-31 23:59:59**. It consumes 8 bytes of memory. This is constant.

The **timestamp** data type has a range of **1970-01-01 00:00:01 UTC** to **2038-01-09 03:14:07 UTC.** It consumes 4 bytes of memory. This may vary according to time zone.