## Hibernate / JPA Overview

In this section we will get an overview of hibernate and JPA.

We will be covering the following,
![[Ch-7/Images/image-1.png]]

## What is Hibernate

At a high level hibernate will be used a framework to store and retrieve data from database.

![[Ch-7/Images/image-2.png]]

## Benefits of Hibernate

Hibernates helps us with the following,

![[Ch-7/Images/image-3.png]]

## Object - To - Relational Mapping (ORM)

In this concept a java class is mapped to a database sql table, so when ever we perform crud operation on a java object it is synced to the data base as table operations.

![[Ch-7/Images/image-4.png]]

## What is JPA ?

It is to be remembered that JPA is just a specification which defines set of standard interfaces.

We have actual vendors who will have their own implementations.

![[Ch-7/Images/image-5.png]]

Mainly we have two vendors (there might be many), among which Hibernate is the most popular one. Also Hibernate will be the default implementation to be used in spring boot.

![[Ch-7/Images/image-6.png]]

With a standard definition of JPA interfaces we are not locked to a specific vendor. If a vendor stops providing support then we can easily switch to another vendor without breaking our code.

![[Ch-7/Images/image-7.png]]

## Saving a Java Object with JPA

First of all we create our object which we need to be saved to the database. Then we take a help from a special JPA helper method _Entity Manager_ to perform the save operation.

Now behind the scenes hibernate will use the object to relational mapping (ORM) technique to insert the object data into corresponding tables in the database.

This is much easier than all of the manual JDBC code we had to write earlier.

![[Ch-7/Images/image-8.png]]

## Retrieving a Java Object with JPA

When it comes to retrieving objects from the database we have multiple strategies, but here we have shown the retrieval using the primary key.

Also here we take help of _Entity Manager_ to find an object from the database.

To maintain type safety we pass in the class information in the form of `Student.class` to the `find()` method.

![[Ch-7/Images/image-9.png]]

## Retrieving Multiple Objects with JPA

There could be a scenario where we want to fetch a list of students from the database.

![[Ch-7/Images/image-10.png]]

The clause used here `from Student` is a part of JPA Query Language (JPQL) and will be discussed later.

As displayed we will call `getResultList()` to get a list of Student objects from the database.

![[Ch-7/Images/image-11.png]]

## Development Checkpoint

Before moving forward make sure to install MySQL and MySQL workbench.

You can use the links shown to obtain the mentioned pieces of softwares.

![[Ch-7/Images/image-12.png]]

Run the utility SQL script in mysql workbench for creating the schema and the tables,

```MYSQL
student
CREATE DATABASE  IF NOT EXISTS `student_tracker`;
USE `student_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```

The above SQL script will

- create a schema `student_tracker` if not existing.
- drop table `student` if existing
- create table `student`


## Automatic Data Source Configuration

As we have seen before in spring boot Hibernate is the default implementation of JPA.

Moving forward we will Heavily use `EntityManager` for creating queries etc.

`EntityManager` is from Jakarta Persistence API (JPA).

Based on the configuration, spring boot will automatically create beans for `DataSource`, `EntityManager` ... etc.

We can then inject those into our DAO class as beans.

## Initializing Dependencies Spring Boot Project for JPA

We need to head over to [start.spring.io](https://start.spring.io/) and add following dependencies

1. MySQL Driver - mysql-connector-j
2. Spring Data JPA - spring-boot-starter-data-jpa

## Configuring Spring Boot Project for JPA

Based on the information available from the _pom.xml_ file spring will automatically configure the data source for us.

Based on our spring file we have,

- JDBC Driver : mysql-connector-j
- Spring Data (ORM) : spring-boot-starter-data-jpa

Spring will automatically read database connection properties from `application.properties` file.

![[Ch-7/Images/image-13.png]]

once we download and import our application, we are in a good place to start some development. Now we want to start this spring boot application as a command line application without involving the browser, so we can do the following modification.

```java
// CruddemoApplication.java
package com.khwaja.curddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// this hook will be called once bean definations are loaded.
	@Bean
	CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hello World");
		};
	}
}

```

We can create a bean with the type `CommandLineRunner` which is a lifecycle hook and will be called by the spring boot once all the bean definitions are loaded. For now this is just returning a lambda expression which prints hello world to the console.

Also we have to add the database configuration to the `application.properties` file

```application.properties
spring.application.name=cruddemo

spring.datasource.url =jdbc:mysql://localhost:3306/student_tracker
spring.datasource.username=root
spring.datasource.password=root

#Turn off the spring boot banner
spring.main.banner-mode=off

#Reduce logging level. Set logging level to warn
logging.level.root=warn
```


We can have option for turning off the spring boot banner, and configuring the log level so we can clear the clutter from the console output.

Also across many software development teams the Hibernate is just referred as the JPA, as Hibernate is the default implementation for JPA in spring boot.

As a general JPA development process we need to annotate java classes and then develop java code to perform DB operations.

Moving forward we will heavily use the term _Entity Class_ which simply means a java class which is mapped to a database table.
![[Ch-7/Images/image-14.png]]

In the upcoming example we are going to use ORM (Object to Relational Mapping) to map a java class to the database.

If we look closely, in the java class the `firstName` is camel case and the same is written in snake case as the database column name. We need to provide correct mapping so that both properties are connected.

![[Ch-7/Images/image-15.png]]

Following are some key points which are required by the entity class.

![[Ch-7/Images/image-16.png]]

Refresher for constructor,

![[Ch-7/Images/image-17.png]]

### Java Annotations for JPA

We will begin with mapping the java entity class to the database table then we will map the entity class properties to the database columns.

#### Mapping a class to DB table

Here we are using the `@Entity` annotation to denote this class will be linked to a database table.

We are using the `@Table` annotation to link the class name with the database table name. This is an optional annotation. If this is skipped then it will be assumed that the java class and the database table will share a same name. It is not recommended as it might introduce breaking changes if there is a java class name refactoring.

![[image-18.png]]

As a next step we are mapping the entity class fields to the database columns using the `@Column()` annotation. The value inside the `name` attribute refers to the corresponding column name in the database table.

![[image-19.png]]

This `@Column()` annotation is optional.

![[image-20.png]]

The primary key is a core building block of the mysql tables. This is used to uniquely identify individual rows in a database table. This can not be a null value.

![[image-21.png]]

We have a notion of `AUTO_INCREMENT` in mysql which auto increments the primary key after each usage.

![[image-22.png]]

We can bring in this auto increment feature to the primary key binding with `@GeneratedValue()` annotation. With `strategy=GenerationType.IDENTITY` the primary key is generated and maintained by the database.

![[image-23.png]]
Here are the generation strategies that we could use.

![[image-24.png]]

We could we our own generation strategy if required.

![[image-25.png]]

With the initial theories taken care of let's now look into the actual Entity class creation,

```java

// Student.java

package com.khwaja.curddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	public Student() {

	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}

```

### Save a Java Object (Student)

In this section we will have a walkthrough about saving a java object into the database.

As a part of this process we are going to have a Student Data Access Object class which will act as a helper class for interacting with the database.

This type of class Data Access Object (DAO) class are a common design pattern which acts as an interfacing helper class.

![[image-26.png]]

This DAO class is going to have the following methods.

![[image-27.png]]

Moving further towards the database interaction our Student DAO will need a JPA Entity Manager.

`JPA Entity Manager` is the main component for saving / retrieving entities.

![[image-28.png]]

Now once the `Entity Manager` is established we can move one step ahead towards the DB operation. At this point we will need a `Data Source` information to interact with the database.

The Data Source simply defines the DB connection info, the username etc.

![[image-29.png]]Once the Entity Manager and the Data Source are auto created we can inject the Entity Manager into our DAO class to perform DB operations.

### Entity Manager vs JPA Repository

We might stumble upon the confusion about using Entity Manager vs JPA Repository. In both ways we can interact with the database.

- In simple terms if we need low level control and flexibility we can use EntityManager.
- If we need high level abstraction and minimal coding we can use JPA Repository.

![[image-30.png]]

![[image-31.png]]

#### Development steps to create Student DAO

![[image-32.png]]

##### Step - 1 : Define DAO Interface
![[image-33.png]]

```java
// StudentDAO.java
package com.khwaja.curddemo.dao;

import com.khwaja.curddemo.entity.Student;

public interface StudentDAO {
	void save(Student student);
}
```

##### Step - 2 : Define DAO implementation
![[image-34.png]]

In this step we are injecting `EntityManager` using spring constructor dependency injection using `@AutoWired` Annotation.

If we can see we have added a `@Repository` annotation at the class level which does the following job :

1. Specialized annotation for DAO classes for additional metadata.
2. Supports component scanning as this annotation extends from `@Component`.
3. Translates JDBC exceptions means the checked exceptions from the JDBC implementations are converted into un-checked exceptions to ease the coding process.

![[image-35.png]]

We also notice there is a `@Transactional` annotation applied to the `save(...)` method. This is a powerful annotation which initiates and ends a SQL transaction for us.

This should be imported from `org.springframework.transaction.annotation.Transactional` instead of `jakarta.transaction.Transactional`

![[image-36.png]]

##### Step - 3 : Update the main App

![[image-37.png]]

```java
// CruddemoApplication.java
package com.khwaja.curddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.khwaja.curddemo.dao.StudentDAO;
import com.khwaja.curddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("khwaja", "ghouse", "ghouseKhwaja@gmail.com");
		
		studentDAO.save(student);
		
		System.out.println("Saved Student with id "+student.getId());
	}
}

```

With this we have successfully saved this student into the database.

#### Retrieve an object using JPA

In this section we will learn to read objects from the database using JPA which in turn uses `EntityManager`.

![[image-38.png]]

Let's look at the development process

![[image-39.png]]

##### Step - 1 : Add new method to DAO Interface
![[image-40.png]]

```java
// StudentDAO.java

package com.khwaja.curddemo.dao;

import com.khwaja.curddemo.entity.Student;

public interface StudentDAO {
	void save(Student student);
	Student findById(Integer id);
}

```

##### Step - 2 : Define DAO implementation
![[image-41.png]]

```java
// StudentDAOImpl.java

package com.khwaja.curddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khwaja.curddemo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO {

	EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

}
```

##### Step - 3 : Update Main App
![[image-42.png]]

```java
// CruddemoApplication.java

package com.khwaja.curddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.khwaja.curddemo.dao.StudentDAO;
import com.khwaja.curddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("khwaja", "Ghouse", "ghousekhwaja@gmail.com");
		
		studentDAO.save(student);
		
		System.out.println("Saved Student with id "+student.getId());
	}
	
	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println("Found student with id 1 : "+student);
	}
}
```

#### Querying Objects with JPA

Previously we saw how to query / read a single object. Here in this section we will learn how to read / query multiple objects.

JPA has its own querying language JPQL for querying objects. It is similar to concepts to SQL but there is a subtle difference.

JPQL is based on `entityName` and `entityFields` where as SQL is based on table name and table columns.

![[image-43.png]]

![[image-44.png]]

![[image-45.png]]
![[image-46.png]]
![[image-47.png]]

![[image-48.png]]
![[image-49.png]]

![[image-50.png]]

Development Process for Querying objects with JPA

![[image-51.png]]

##### Step - 1 : Add new method to DAO interface

![[image-52.png]]

```java
// StudentDAO.java

package com.khwaja.curddemo.dao;

import java.util.List;

import com.khwaja.curddemo.entity.Student;

public interface StudentDAO {
	void save(Student student);

	Student findById(Integer id);

	List<Student> findAll();
}

```

##### Step - 2 : Define DAO implementation

![[image-53.png]]

```java
package com.khwaja.curddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khwaja.curddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

		return query.getResultList();
	}

}

```

##### Step - 3 : Update main App

![[image-54.png]]

```java
// CruddemoApplication.java
package com.khwaja.curddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.khwaja.curddemo.dao.StudentDAO;
import com.khwaja.curddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println("Found student with id 1 : "+student);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Anupam", "Acharya", "khwaja@gmail.com");
		
		studentDAO.save(student);
		
		System.out.println("Saved Student with id "+student.getId());
	}
}


```

#### Updating an Object with JPA

In this section we will try the existing information for an existing user.

We will start by retrieving the object from the database then we will modify and update the entry in the DB.

![[image-55.png]]

We have the power to update multiple records as well,

![[image-56.png]]

Let's look at the development process,

![[image-57.png]]

##### Step - 1 : Add new method to DAO interface

![[image-58.png]]

```java
// StudentDAO.java
package com.khwaja.curddemo.dao;

import java.util.List;

import com.khwaja.curddemo.entity.Student;

public interface StudentDAO {
	void save(Student student);

	Student findById(Integer id);

	List<Student> findAll();

	void update(Student student);
}
```

##### Step - 2 : Define DAO implementation

![[image-59.png]]

```java
// StudentDAOImpl.java
package com.khwaja.curddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khwaja.curddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

}

```

##### Step - 3 : Update Main App

![[image-60.png]]

```java
// CruddemoApplication.java
package com.khwaja.curddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.khwaja.curddemo.dao.StudentDAO;
import com.khwaja.curddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setLastName("Poppins");
		studentDAO.update(student);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println("Found student with id 1 : " + student);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("khwaja", "Ghouse", "khwaja@gmail.com");

		studentDAO.save(student);

		System.out.println("Saved Student with id " + student.getId());
	}
}

```

#### Deleting Object(s) with JPA

In this section we will learn deleting an object with JPA.

We can delete a student by fetching it from the DB first.

![[image-61.png]]

We can also delete single or multiple entries based on certain condition.

![[image-62.png]]

We can also delete all entities without any condition.

![[image-63.png]]

Let's look at the development process.

![[image-64.png]]

##### Step - 1 : Add new method to DAO interface

![[image-65.png]]

```java
package com.khwaja.curddemo.dao;

import java.util.List;

import com.khwaja.curddemo.entity.Student;
// StudentDAO.java
public interface StudentDAO {
	void save(Student student);

	Student findById(Integer id);

	List<Student> findAll();

	void update(Student student);

	void delete(Integer id);
}

```

##### Step - 2 : Add new method to DAO implementation

```java

// StudentDAOImpl.java
package com.khwaja.curddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khwaja.curddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}

}
```

##### Step - 3 : Update main app

```java
// CruddemoApplication.java
package com.khwaja.curddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.khwaja.curddemo.dao.StudentDAO;
import com.khwaja.curddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setLastName("Poppins");
		studentDAO.update(student);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println("Found student with id 1 : " + student);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Anupam", "Acharya", "khwaja@gmail.com");

		studentDAO.save(student);

		System.out.println("Saved Student with id " + student.getId());
	}
}

```

