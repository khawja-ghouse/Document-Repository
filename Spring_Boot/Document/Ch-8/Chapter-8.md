# REST Web Services

In this section we will learn to,
![[Ch-8/Images/image-1.png]]Let's now look at the example problem here. We are trying to build a client app which provides the weather report for a city.

Now we don't have the data ready in our local database as we are not storing weather reports and weather is constantly changing.

So we need to get the weather data from an external web service.

![[Ch-8/Images/image-2.png]]
Now from our application we can talk to the external service using REST API calls over HTTP. REST stands for Representational State Transfer which is a light weight approach for communicating between applications.

REST implementation is language independent.

![[Ch-8/Images/image-3.png]]

The data received from the external web service could be in any format but XML and JSON are the two popular ones.

Out of which JSON is more popular and modern.

JSON stands for JavaScript Object Notation.

So we can call the end point in the following formats with required query params.

![[Ch-8/Images/image-4.png]]

Moving forward we will see how we can create the REST Services for ourselves.

![[Ch-8/Images/image-5.png]]

## REST API other names

![[Ch-8/Images/image-6.png]]## JSON Basics

JSON is a popular Data format with key value relation.

![[Ch-8/Images/image-8.png]]

Properties are always in double quotes.

![[Ch-8/Images/image-7.png]]

The right hand side is called a value and quoting is necessary based on the value type.
![[Ch-8/Images/image-9.png]]
We can have nested JSON as well.

![[Ch-8/Images/image-10.png]]

We can have JSON arrays as well. Remember to use square brackets for arrays.

![[Ch-8/Images/image-11.png]]
## REST HTTP Basics

The most common use of REST is over HTTP where we leverage HTTP methods for CRUD operations.

![[Ch-8/Images/image-12.png]]

## HTTP Messages

We will have a client server architecture we will have a client who will send HTTP Request Message and once that data is processed the server will be responding with HTTP Response Message.

![[Ch-8/Images/Image-13.png]]

### HTTP Request Message
![[Ch-8/Images/image-14.png]]

### HTTP Response Message

![[Ch-8/Images/image-15.png]]
### HTTP Status Codes

![[Ch-8/Images/image-16.png]]

### MIME Content Type

Describes the data format of the data returned by the server response.

![[Ch-8/Images/image-17.png]]

### Postman as a client tool

In the course we will use postman as a client tool.

Use this [link](https://www.postman.com/downloads/) to download postman.

![[Ch-8/Images/image-18.png]]

## Spring REST Controller

In this section we will see how to create a Spring REST Controller.

![[Ch-8/Images/image-19.png]]This is how the rest controller will look once it has been created. As we can see when the client requests for `/test/hello` he will be getting "Hello World!" as a response.

![[Ch-8/Images/image-20.png]]

This output can be tested on the browser or on the postman.

For complex request construct postman is a recommended tool.

![[Ch-8/Images/image-21.png]]
## Spring REST Controller - Development Process

1. As a first step we are going to add a maven dependency for `Spring Boot Starter Web`
2. Next , we will create the REST Service using `@RestController`.

![[Ch-8/Images/image-22.png]]

```java
// DemoRestController.java
package com.khawja.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class DemoRestController {
	@GetMapping("/hello")
	public String getMethodName() {
		return "Hello World";
	}
}

```

```java
// DemoApplication.java
package com.khawja.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
```

and once we hit our services,

![[Ch-8/Images/image-23.png]]

## Java JSON Data Binding

The back and forth conversion between the JSON object and java POJO object is called data binding and has many other terms in the market.

![[Ch-8/Images/image-24.png]]

### JSON Data Binding with Jackson

Jackson is an open source project and will handle this underlying data binding process behind the scenes.

![[Ch-8/Images/image-25.png]]

This dependency is automatically added with spring boot starter web and we don't need to add this explicitly.

This **jackson** library will automatically call the relevant getter and setter methods for the data binding process.

When handling a request we need to convert the request payload json to java pojo, this is seamlessly handled by jackson by invoking corresponding setter methods

![[Ch-8/Images/image-26.png]]

Similarly while sending a response to the client the java pojo needs to be converted to json, in this case jackson will invoke the getter methods to create a json on the fly.

![[Ch-8/Images/image-27.png]]

There is absolutely no additional integration step required for jackson integration and will be taken care by Spring.

![[Ch-8/Images/image-28.png]]

#### Example - Students Rest API

Now to see this entire thing in action let's have an rest end point which returns a `List<Student>` converted into JSON array.

![[Ch-8/Images/image-29.png]]

As a first step we create the `Student` POJO with appropriate constructors and getters and setters.

```java


// Student.java

package com.khwaja.demo.entity;

public class Student {
	private String firstName;
	private String lastName;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	
}

```

Next we will create a controller and map the end point.

```java

// StudentRestController.java

package com.khawja.demo.rest;  
  
import com.khawja.demo.entity.Student;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
import java.util.ArrayList;  
import java.util.List;  
  
@RestController  
@RequestMapping("/api")  
public class StudentRestController {  
    @GetMapping("/students")  
    public List<Student> getStudents() {  
  
        List<Student> students = new ArrayList<Student>();  
        students.add(new Student("khwaja", "Ghouse"));  
        students.add(new Student("jancy", "Robert"));  
        students.add(new Student("Ruby", "Rosh"));  
        return students;  
    }  
}
```

Now when we are hitting the end point `/api/students` we will see a JSON array.

![[Ch-8/Images/image-30.png]]

So when we returned the `List<Student>` jackson converted it to a JSON array.

![[Ch-8/Images/image-31.png]]

## Spring Boot REST Path variables

In this section we are going to use spring REST with the path variables.

Path variables are referred to the dynamic path value appearing in a URL. Technically when client sends a request with a path variable, this path variable can contain different data for which different responses are produced.

![[Ch-8/Images/image-32.png]]

Now we will will create an end point which will accept a dynamic `studentID` and we will provide a response. For now we are skipping database integration we are just returning an `Student` object from the `List<Student>` using `studentID` as an index.

![[Ch-8/Images/image-33.png]]

As always the POJO <-> JSON conversion is done by jackson behind the scenes.

### Development Process

1. Add request mapping to Spring REST Service where bind path variable to method parameter using `@PathVariable`.
   ![[Ch-8/Images/image-34.png]]
```java
package com.khawja.demo.rest;

import com.khawja.demo.entity.Student;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void loadData() {
		students.add(new Student("Khawja", "Ghouse"));
		students.add(new Student("jancy", "Robert"));
		students.add(new Student("Ruby", "Rosh"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	
	@GetMapping("/students/{studentId}")
	public Student getMethodName(@PathVariable int studentId) {
		return students.get(studentId);
	}
	
}
```

It is very important to remember that the path variable name should match with the variable name used with `@PathVariable`.

![[Ch-8/Images/image-35.png]]

Now from the postman we can verify that with `0` as the `studentId` we are getting the first object from the `List<Student>`.

If we provide anything that exceeds the `List<Student>` capacity we will be responded with `500 Internal Server Error`.

Also this error is reported in the console as well.
![[Ch-8/Images/image-36.png]]

## Spring REST - Exception Handling

Now for the previous scenario we have seen that if we are providing an improper `studentId` then that results into an 500 - Internal Server Error.

![[Ch-8/Images/image-37.png]]

This is not much useful. Instead we could send a bit user friendly JSON which better explains the scenario.

![[Ch-8/Images/image-38.png]]

1. Throw an Custom Exception class which is thrown in case of illegal index value.
2. Create an Exception Handler class which handles this error and sends the above JSON as a response.

Remember the java object <---> JSON conversion happens with the jackson.

![[Ch-8/Images/image-39.png]]


### Spring REST - Exception Handling - Development Process

1. Create a custom error response class whose object will be sent as a json response if an exception occurs.
   ![[Ch-8/Images/image-40.png]]
   ![[Ch-8/Images/image-41.png]]
   ```java
   
// StudentErrorResponse.java 

package com.khawja.demo.rest;

public class StudentErrorResponse {

	private int status;
	private String message;
	private long timeStamp;

	public StudentErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public StudentErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
```

2. Create a Custom Exception class.
   ![[image-44.png]]
   ![[image-45.png]]
```java
// StudentNotFoundException.java

package com.khawja.demo.rest;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
```

3. Update REST service to throw custom exception if student is not found.
   ![[Ch-8/Images/image-46.png]]
   ```java
   package com.khawja.demo.rest;

import com.khawja.demo.entity.Student;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void loadData() {
		students.add(new Student("Khawja", "Ghouse"));
		students.add(new Student("jancy", "Robert"));
		students.add(new Student("Ruby", "Rosh"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getMethodName(@PathVariable int studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}
}

```

4. Add an exception handler method using `@ExceptionHandler`
   ![[image-47.png]]
   ![[image-48.png]]
   ```java
   package com.khawja.demo.rest;

import com.khawja.demo.entity.Student;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void loadData() {
		students.add(new Student("Anupam", "Acharya"));
		students.add(new Student("jancy", "Robert"));
		students.add(new Student("Ruby", "Rosh"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getMethodName(@PathVariable int studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

		// create a StudentErrorResponse object

		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(e.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		// return a response entity
		return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
}
```

![[Ch-8/Images/image-49.png]]

![[Ch-8/Images/image-50.png]]

As expected we are seeing our custom JSON response.

Still we have not handled an edge case which is what happens when the index is not an integer,

So we need to have a fallback exception handler which works for other scenarios,

```java
package com.busybox.demo.rest;

import com.busybox.demo.entity.Student;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void loadData() {
		students.add(new Student("Anupam", "Acharya"));
		students.add(new Student("jancy", "Robert"));
		students.add(new Student("Ruby", "Rosh"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getMethodName(@PathVariable int studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

		// create a StudentErrorResponse object

		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(e.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		// return a response entity
		return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception e) {

		// create a StudentErrorResponse object

		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage("Unable to find student");
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		// return a response entity
		return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
}
```

## Spring REST - Global Exception Handlin

In this section we will see how to implement global exception handling,

![[Ch-8/Images/image-51.png]]

In the previous examples we saw how to implement an exception handler using `@ExceptionHandler` but it is scoped to only once controller, hence it catches exceptions only in that particular controller.

In a real world scenario we are going to have multiple controllers and the previous implementation technique is not going to help us for tackling exception in various controllers.

Also if we start implementing exception handlers per individual controllers then we will have a lot of duplicate logic.

For above reasons we are going to have the exception handlers at a global level.

![[Ch-8/Images/image-52.png]]

So we can create an interceptor using `@ControllerAdvice` to pre process requests to controllers and post process responses to handle exceptions.

Also this is a use case of Aspect Oriented Programming (AOP).

![[Ch-8/Images/image-54.png]]

As illustrated, the controller advice / interceptor sits in the middle of client and server and act as a filter to catch various custom exceptions resulting from the various requests.

This is also one of the best practices in developing enterprise applications.

![[Ch-8/Images/image-55.png]]

### Spring REST - Global Exception Handling - Development Process

1. Create new `@ControllerAdvice`
   ![[Ch-8/Images/image-56.png]]
   ```java
   package com.khawja.demo.rest;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StudentRestExceptionHandler {

}

```

2. Refactor existing `StudentRestController` Service to remove the exception handling code.
   ![[image-57.png]]
	

```java
package com.khawja.demo.rest;

import com.khawja.demo.entity.Student;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void loadData() {
		students.add(new Student("Anupam", "Acharya"));
		students.add(new Student("jancy", "Robert"));
		students.add(new Student("Ruby", "Rosh"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getMethodName(@PathVariable int studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}

}
```
3. Add previously removed code to `@ControllerAdvice`
   ![[Ch-8/Images/image-58.png]]
```java
package com.khawja.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

		// create a StudentErrorResponse object

		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(e.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		// return a response entity
		return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception e) {

		// create a StudentErrorResponse object

		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage("Unable to find student");
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		// return a response entity
		return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
}
```

## REST API Design - Best Practices

While starting to design API we should consider the following,

1. Target Audience for our APIs
2. How will the Audience use our APIs
3. Design the APIs based on requirements.

Now let's dig into the API design process,

1. Review API requirements

This is first step in the process where we get a list of requirements and they should be understood properly.
![[Ch-8/Images/image-59.png]]
2. Identify the main resource / entity
   ![[Ch-8/Images/image-60.png]]
   3. Then all we are left with is mapping various actions of the entity with the HTTP methods
      ![[Ch-8/Images/image-61.png]]
      
	 Have a look at a real time implementation, API listing below, performing various operation on the entity `Employee`.
   
   ![[Ch-8/Images/image-62.png]]
   
### REST API Design - Anti Patterns 💣💀

While designing rest APIs we should never use nature of actions in the URL naming.

Instead we should be mapping entity actions to HTTP operations.
![[Ch-8/Images/image-63.png]]
### REST API Design - Examples from Open Source Projects
![[Ch-8/Images/image-64.png]]
![[Ch-8/Images/image-65.png]]
![[image-66.png]]


## Real Time Project

In this section we will create a spring boot project that connects to a database.
### API Requirements - REST Client should be able to

1. Get a list of employees
2. Get a single employee by id
3. Add a new employee
4. Update an employee
5. Delete an employee
   
### Rest API to be used

| HTTP Method | URL                           | CRUD Action                 |
| ----------- | ----------------------------- | --------------------------- |
| POST        | `/api/employees`              | Create a new employee       |
| GET         | `/api/employees`              | Read a list of employees    |
| GET         | `/api/employees/{employeeId}` | Read a single employee      |
| PUT         | `/api/employees`              | Update an existing employee |
| DELETE      | `/api/employees/{employeeId}` | Delete an existing employee |
### Development Process
![[image-67.png]]
### Application Architecture

We will have a Employee Rest Controller which will utilize the methods in the Employee Service and through the Employee DAO we will talk to the database.

![[image-68.png]]

### Set up DB table

```mysql
CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');
```

### Setup Project in Spring Initializer

Once this DB is set up we need to create a new project using spring initializer with the following dependencies

1. Spring Web (enables us to work with REST API)
2. Spring Boot DevTools (Auto Reload with development changes)
3. MySQL Driver (MySql connection driver)
4. Spring Data JPA (Spring JPA Support)

Once the project is configured we can import it to the editor.

### Configure DB Connection Properties

```java
spring.application.name=cruddemo

#
# JDBC properties
#
spring.datasource.url="jdbc://mysql://localhost:3306/employee_directory"
spring.datasource.username="root"
spring.datasource.password="root"
```

### Create Employee Entity

```java
package com.khawja.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    // define fields

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

    // define constructors
    public Employee() {

    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // define getter/setter

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

    // define toString
    @Override
    public String toString() {
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + '}';
    }
}

```

### Create Employee DAO and DAO IMPL

DAO Interface

```java
package com.khawja.springboot.cruddemo.dao;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
  
import java.util.List;  
  
public interface EmployeeDAO {  
    List<Employee> findAll();  
}
```

DAO Implementing Class

```java
package com.khawja.springboot.cruddemo.dao;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
import jakarta.persistence.EntityManager;  
import jakarta.persistence.TypedQuery;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  
  
import java.util.List;  
  
@Repository  
public class EmployeeDAOJPAImpl implements EmployeeDAO {  
  
    // define fields for entityManager  
    private EntityManager entityManager;  
  
    // setup constructor injection  
    @Autowired  
    public EmployeeDAOJPAImpl(EntityManager entityManager) {  
        this.entityManager = entityManager;  
    }  
  
    @Override  
    public List<Employee> findAll() {  
  
        // create a query  
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);  
  
        // execute query and get result list  
        List<Employee> employeeList = query.getResultList();  
  
        // return the results  
        return employeeList;  
    }  
}
```

### Create Rest Controller and provide mapping for GET '/api/employees'

```java
package com.khawja.springboot.cruddemo.rest;  
  
import com.khawja.springboot.cruddemo.dao.EmployeeDAO;  
import com.khawja.springboot.cruddemo.entity.Employee;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
import java.util.List;  
  

public class EmployeeRestController {  
  
    private final EmployeeDAO employeeDAO;  
  
    // quick and dirty : inject employee dao  
    // we will refactor this with a service layer    @Autowired  
    public EmployeeRestController(EmployeeDAO employeeDAO) {  
        this.employeeDAO = employeeDAO;  
    }  
  
    // expose end point "/employees" and return a list of employees  
    @GetMapping("/employees")  
    public List<Employee> findAll() {  
        return employeeDAO.findAll();  
    }  
}
```

### Adding a Service Layer

![[image-69.png]]
In a Spring Boot application, having a service layer between the DAO (Data Access Object) layer and the controller layer is a best practice that provides several benefits.

![[image-70.png]]
A service layer in a Spring Boot application provides a structured approach to organizing business logic, ensuring that your application remains modular, testable, and maintainable as it grows.

![[image-71.png]]

![[image-72.png]]
We will be creating services with `@Service`. Spring will automatically register the Service Implementation in the spring bean factory thanks to component scanning.

#### Development Steps for Employee Service

1. Define Service Interface
   ![[image-73.png]]
   ```java
package com.khawja.springboot.cruddemo.service;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
  
import java.util.List;  
  
public interface EmployeeService {  
    List<Employee> findAll();  
}
```
2. Define Service Implementation
   ![[image-74.png]]
   ```java
package com.khawja.springboot.cruddemo.service;  
  
import com.khawja.springboot.cruddemo.dao.EmployeeDAO;  
import com.khawja.springboot.cruddemo.entity.Employee;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  
import java.util.List;  
  
@Service  
public class EmployeeServiceImpl implements EmployeeService{  
  
    private EmployeeDAO employeeDAO;  
  
    public EmployeeServiceImpl() {  
  
    }  
  
    @Autowired  
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {  
        this.employeeDAO = employeeDAO;  
    }  
  
    @Override  
    public List<Employee> findAll() {  
        return employeeDAO.findAll();  
    }  
}
```
Now we can also refactor the Employee Controller to utilize the service instead of directly accessing the DAO.
```java
package com.busybox.springboot.cruddemo.rest;  
  
import com.busybox.springboot.cruddemo.entity.Employee;  
import com.busybox.springboot.cruddemo.service.EmployeeService;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
import java.util.List;  
  
@RestController  
@RequestMapping("/api")  
public class EmployeeRestController {  

	// using service now
    private final EmployeeService employeeService;  
  
    @Autowired  
    public EmployeeRestController(EmployeeService employeeService) {  
        this.employeeService = employeeService;  
    }  
  
    // expose end point "/employees" and return a list of employees  
    @GetMapping("/employees")  
    public List<Employee> findAll() {  
        return employeeService.findAll();  
    }  
}
```

As we can see we are simply delegating the calls to the DAO Layer which is a good practice as well.

ALWAYS USE A SERVICE LAYER !!!

As a good practice it is always recommended to maintain the traction boundary at the service layer rather then the DAO class methods.

![[image-75.png]]
With this let's proceed to implement the CRUD functionality of the Employee Entity.

#### Creating a new Employee

1. We will start by adding a new abstract method to the existing `EmployeeDAO` interface.
   ```java
package com.khawja.springboot.cruddemo.dao;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
  
import java.util.List;  
  
public interface EmployeeDAO {  
    List<Employee> findAll();  
  
    Employee save(Employee employee);  
}
```
2. Next let's provide the method IMPL in the `EmployeeDAOJPAImpl`
   ![[image-76.png]]
   ```java
   package com.khawja.springboot.cruddemo.dao;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
import jakarta.persistence.EntityManager;  
import jakarta.persistence.TypedQuery;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  
  
import java.util.List;  
  
@Repository  
public class EmployeeDAOJPAImpl implements EmployeeDAO {  
  
    // define fields for entityManager  
    private EntityManager entityManager;  
  
    // setup constructor injection  
    @Autowired  
    public EmployeeDAOJPAImpl(EntityManager entityManager) {  
        this.entityManager = entityManager;  
    }  
  
    @Override  
    public List<Employee> findAll() {  
  
        // create a query  
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);  
  
        // execute query and get result list  
        List<Employee> employeeList = query.getResultList();  
  
        // return the results  
        return employeeList;  
    }  
  
    @Override  
    public Employee save(Employee employee) {  
        // save employee  
        Employee updatedEmployee = entityManager.merge(employee);  
  
        // return the employee  
        return updatedEmployee;  
    }  
}
```

A word about the `merge` method here : This method will perform both the task of making a new entry in the DB as well as modifying the existing entry in the DB. This is based on the value of `id` property in the `employee` argument,

1. `id == 0` then save / insert new entry
2. otherwise, update existing

Also notice that there is no `@Transactional` annotation on the `save(...)` method as this will be handled on the service layer as discussed.

We need to return the updated `Employee` object to the client once the operation is completed.

3. Now we need to create a abstract method in the `EmployeeService` interface
   ```java
   package com.khawja.springboot.cruddemo.service;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
  
import java.util.List;  
  
public interface EmployeeService {  
    List<Employee> findAll();  
  
    Employee save(Employee employee);  
}
```
4. Now we need to provide IMPL for this method in `EmployeeServiceImpl`
   ```java
package com.khawja.springboot.cruddemo.service;  
  
import com.khawja.springboot.cruddemo.dao.EmployeeDAO;  
import com.khawja.springboot.cruddemo.entity.Employee;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  
  
import java.util.List;  
  
@Service  
public class EmployeeServiceImpl implements EmployeeService {  
  
    private EmployeeDAO employeeDAO;  
  
    public EmployeeServiceImpl() {  
  
    }  
  
    @Autowired  
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {  
        this.employeeDAO = employeeDAO;  
    }  
  
    @Override  
    public List<Employee> findAll() {  
        return employeeDAO.findAll();  
    }  
  
    @Transactional  
    @Override 
    public Employee save(Employee employee) {  
        return employeeDAO.save(employee);  
    }  
}
```
5.  As a final step we should map this service method to an endpoint
   Recap the table we had for various mappings,

| Status | HTTP Method | URL                         | CRUD Action                |
|--------|-------------|-----------------------------|----------------------------|
| 🖋️      | POST        | `/api/employees`            | Create a new employee       |
| ✅      | GET         | `/api/employees`            | Read a list of employees    |
| TODO    | GET         | `/api/employees/{employeeId}`| Read a single employee      |
| TODO    | PUT         | `/api/employees`            | Update an existing employee |
| TODO    | DELETE      | `/api/employees/{employeeId}`| Delete an existing employee |


Here we will create an endpoint `/api/employees` to work with POST method to create a new employee.

```java
package com.khawja.springboot.cruddemo.rest;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
import com.khawja.springboot.cruddemo.service.EmployeeService;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
import java.util.List;  
  
@RestController  
@RequestMapping("/api")  
public class EmployeeRestController {  
  
    private final EmployeeService employeeService;  
  
    @Autowired  
    public EmployeeRestController(EmployeeService employeeService) {  
        this.employeeService = employeeService;  
    }  
  
    // expose end point "/employees" and return a list of employees  
    @GetMapping("/employees")  
    public List<Employee> findAll() {  
        return employeeService.findAll();  
    }  
  
    @PostMapping("/employees")  
    public Employee addEmployee(@RequestBody Employee employee) {  
        // forcibly set the employee id to 0 just in case they pass  
        // an id in the request JSON to force save of a new employee                 // instead of updating an existing one.        
        employee.setId(0);  
  
        Employee savedEmployee = employeeService.save(employee);  
  
        return savedEmployee;  
    }  

```

Please note that we are explicitly making the employee `id` zero , just in case if there is a employee id passed in the request payload then it will be up desired update operation, as the the incoming data will be patched against the non zero `id` in the DB.

With this when we make a POST request in the postman, we will get back a JSON with the newly created `Employee` with the `id`.

![[image-77.png]]
![[image-78.png]]
Can also verify this from the DB (look for the last entry)

![[image-79.png]]

#### Reading an Employee (by id)

1. We will start by adding a new abstract method to the existing `EmployeeDAO` interface.
   ```java
   package com.khawja.springboot.cruddemo.dao;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
  
import java.util.List;  
  
public interface EmployeeDAO {  
    List<Employee> findAll();  
  
    Employee findById(int id);  
  
    Employee save(Employee employee);  
  
    void deleteById(int id);  
}
```
2. Next let's provide the method IMPL in the `EmployeeDAOJPAImpl`
   ![[image-80.png]]

```java
package com.khawja.springboot.cruddemo.dao;

import com.khawja.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    // define fields for entityManager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employeeList = query.getResultList();

        // return the results
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        // get the employee
        Employee employee = entityManager.find(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save employee
        Employee updatedEmployee = entityManager.merge(employee);

        // return the employee
        return updatedEmployee;
    }
}

```
3. Now we need to create a abstract method in the `EmployeeService` interface
   ```java
package com.khawja.springboot.cruddemo.service;

import com.khawja.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);
}
```
4. Now we need to provide IMPL for this method in `EmployeeServiceImpl`
   ```java
   package com.khawja.springboot.cruddemo.service;

import com.khawja.springboot.cruddemo.dao.EmployeeDAO;
import com.khawja.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }
}
```

We do not need a `@Transactional` annotation as this is a read operation and no data is written to the DB.

Also we can see the service layer is just delegating the control flow to the DAO layer, which is also one of the best practices.

5. As a final step we should map this service method to an endpoint

Recap the table we had for various mappings,

|Status|HTTP Method|URL|CRUD Action|
|---|---|---|---|
|✅|POST|`/api/employees`|Create a new employee|
|✅|GET|`/api/employees`|Read a list of employees|
|🖋️|GET|`/api/employees/{employeeId}`|Read a single employee|
|TODO|PUT|`/api/employees`|Update an existing employee|
|TODO|DELETE|`/api/employees/{employeeId}`|Delete an existing employee|
Here we will create an endpoint `/api/employees/{employeeId}` to work with POST method to fetch a employee by `employeeId`.

```java
package com.khawja.springboot.cruddemo.rest;

import com.khawja.springboot.cruddemo.entity.Employee;
import com.khawja.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose end point "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("employee not found with id " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // forcibly set the employee id to 0 just in case they pass
        // an id in the request JSON to force save of a new employee
        // instead of updating an existing one.
        employee.setId(0);

        Employee savedEmployee = employeeService.save(employee);

        return savedEmployee;
    }
```

Please note that if we can not find any `Employee` from the DB with the requested ID then we throw a `RuntimeException`

With this when we make a GET request in the postman, we will get back a JSON with the requested `Employee`.

![[image-81.png]]
### Update an Employee

1. We will start by adding a new abstract method to the existing `EmployeeDAO` interface. Actually we do not need to add any new method. The already existing `save()` method will do the job.
   
   ```java
package com.khawja.springboot.cruddemo.dao;  
  
import com.khawja.springboot.cruddemo.entity.Employee;  
  
import java.util.List;  
  
public interface EmployeeDAO {  
    List<Employee> findAll();  
  
    Employee findById(int id);  
  
    Employee save(Employee employee);
}
```

2. Next let's provide the method IMPL in the `EmployeeDAOJPAImpl`
   ```java
package com.khawja.springboot.cruddemo.dao;

import com.khawja.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    // define fields for entityManager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employeeList = query.getResultList();

        // return the results
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        // get the employee
        Employee employee = entityManager.find(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save employee
        Employee updatedEmployee = entityManager.merge(employee);

        // return the employee
        return updatedEmployee;
    }
}

```

![[image-82.png]]
In the above case as well the pre existing `save(...)` method will do the job. The only difference in the usage of `merge(...)` method is that the incoming employee object payload will have a none zero `id` property associated with it, so as discussed as `id != 0` the `merge` method will perform an update instead of an insert.

3. Now we need to create a abstract method in the `EmployeeService` interface. Actually we are using the pre existing `save(...)` abstract method declaration.
```java
package com.khawja.springboot.cruddemo.service;

import com.khawja.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);
}
```

4.  Now we need to provide IMPL for this method in `EmployeeServiceImpl`
   ```java
   package com.khawja.springboot.cruddemo.service;

import com.khawja.springboot.cruddemo.dao.EmployeeDAO;
import com.khawja.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }
}
```
5. As a final step we should map this service method to an endpoint

Recap the table we had for various mappings,

|Status|HTTP Method|URL|CRUD Action|
|---|---|---|---|
|✅|POST|`/api/employees`|Create a new employee|
|✅|GET|`/api/employees`|Read a list of employees|
|✅|GET|`/api/employees/{employeeId}`|Read a single employee|
|🖋️|PUT|`/api/employees`|Update an existing employee|
|TODO|DELETE|`/api/employees/{employeeId}`|Delete an existing employee|
Here we will create an endpoint `/api/employees` to work with PUT method to update an Employee.

```java
package com.khawja.springboot.cruddemo.rest;

import com.khawja.springboot.cruddemo.entity.Employee;
import com.khawja.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose end point "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("employee not found with id " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // forcibly set the employee id to 0 just in case they pass
        // an id in the request JSON to force save of a new employee
        // instead of updating an existing one.
        employee.setId(0);

        Employee savedEmployee = employeeService.save(employee);

        return savedEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee savedEmployee = employeeService.save(employee);

        return savedEmployee;
    }
}
```

Remember to return the updated `Employee` after the update to get it reflected everywhere in the client.

![[image-83.png]]

### Delete an Employee

1. We will start by adding a new abstract method to the existing `EmployeeDAO` interface.
   ```java
package com.khawja.springboot.cruddemo.dao;

import com.khawja.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
```
2. Next let's provide the method IMPL in the `EmployeeDAOJPAImpl`
```java
package com.khawja.springboot.cruddemo.dao;

import com.khawja.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    // define fields for entityManager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employeeList = query.getResultList();

        // return the results
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        // get the employee
        Employee employee = entityManager.find(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save employee
        Employee updatedEmployee = entityManager.merge(employee);

        // return the employee
        return updatedEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find the employee
        Employee employee = entityManager.find(Employee.class, id);

        // delete the employee
        entityManager.remove(employee);
    }
}
```
3.  Now we need to create a abstract method in the `EmployeeService` interface.
   ```java
   package com.khawja.springboot.cruddemo.service;

import com.khawja.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
```
4. Now we need to provide IMPL for this method in `EmployeeServiceImpl`
   ```java
   package com.khawja.springboot.cruddemo.service;

import com.khawja.springboot.cruddemo.dao.EmployeeDAO;
import com.khawja.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
```
As always the `@Transactional` boundary is applied at the service layer but not at the DAO layer.

5. As a final step we should map this service method to an endpoint

Recap the table we had for various mappings,

|Status|HTTP Method|URL|CRUD Action|
|---|---|---|---|
|✅|POST|`/api/employees`|Create a new employee|
|✅|GET|`/api/employees`|Read a list of employees|
|✅|GET|`/api/employees/{employeeId}`|Read a single employee|
|✅|PUT|`/api/employees`|Update an existing employee|
|🖋️|DELETE|`/api/employees/{employeeId}`|Delete an existing employee|
Here we will create an endpoint `/api/employees/{employeeId}` to work with DELETE method to update an `Employee`.

```java
package com.khawja.springboot.cruddemo.rest;

import com.khawja.springboot.cruddemo.entity.Employee;
import com.khawja.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose end point "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("employee not found with id " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // forcibly set the employee id to 0 just in case they pass
        // an id in the request JSON to force save of a new employee
        // instead of updating an existing one.
        employee.setId(0);

        Employee savedEmployee = employeeService.save(employee);

        return savedEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        Employee savedEmployee = employeeService.save(employee);

        return savedEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if (employee==null){
            throw new RuntimeException("the employee you are trying to delete does not exist with id"+employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted Employee with id "+employeeId;
    }
}
```

With this all of our CRUD operations are implemented.