Hibernate Overview
![[Ch-8/Images/image-1.png]]

Hibernate is a very popular framework works for storing/retrieving data from the database.

Hibernate user ORM (object-to-relational mapping) where we tell hibernate how to map our java objects to the database table. Under the hood, all the properties in the java object will be mapped to actual column names.

This ORM config can be done with the help of an XML file or with the help of annotations.

![[Ch-8/Images/image-5.png]]

![[Ch-8/Images/image-4.png]]

Hibernate is just another layer of abstraction on the top of JDBC.

```java
TestJdbc.java : 
package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimeZone=UTC";
		final String username = "hbstudent";
		final String password = "hbstudent";
		try {
			System.out.println("connecting to database : " + url);
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

```

Hibernate Configurations with Annotations

The hibernate configuration file is going to tell hibernate how to connect to the database. Also as we know previously, Hibernate uses JDBC for establishing connection.

Have a look at the sample hibernate config xml file :

```xml
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- JDBC Database connection settings -->
        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&amp;serverTimezone=UTC</property>
        <property name="connection.username">hbstudent</property>
        <property name="connection.password">hbstudent</property>

        <!-- JDBC connection pool settings ... using built-in test pool -->
        <property name="connection.pool_size">1</property>

        <!-- Select our SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
	
        <!-- Echo the SQL to stdout -->
        <property name="show_sql">true</property>

		<!-- Set the current session context -->
		<property name="current_session_context_class">thread</property>
 
    </session-factory>

</hibernate-configuration>

```

Hibernate has a class of Entity Class which is class mapped to database table. Well, when a POJO class is annotated it becomes an Entity class.

Now we have to
1.     map a class to the database table.
	![[Ch-8/Images/image-6.png]]
2.     map the class field names to database columns.
	![[Ch-8/Images/image-7.png]]
These above mapping can be done with the help of,

1.     XML config files (legacy approach)

2.     java annotation approach (modern approach)

First of all we will create a Student class and from inside the class we will annotate the fields so that they get connected to the db table.

Student.java:
```java
package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	public Student() {
		super();
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

Saving a Java Object with Hibernate

**SessionFactory** : This is the person who reads the hibernate config file, creates a connection to the database, creates session object for us. This is a heavy weight object, we only create it once in our application but we re use it over and over again.

**Session :** This is a wrapper around our JDBC connection. This session object will be used to save and retrieve object to/from the database. Session is a short lived method, for a given method we get a session, we use it and we throw it away(we will see how). Sessions are retrieved from the session factory.

![[Ch-8/Images/image-8.png]]

Previously we had created a student Entity class and had that mapped with the database with the help of hibernate annotations.

```java
Student.java : 
package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	public Student() {
		super();
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

CreateStudentDemo.java : 
package com.hibernate.demo.second;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
				// providing a file name is opt. hibernate will look for "hibernate.cfg.xml" as a default file name
				.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			// create student object
			System.out.println("creating student object");
			Student student = new Student("Anupam", "Acharya", "anupam@gmail.com");

			// begin a transaction
			System.out.println("beginning a transaction");
			currentSession.beginTransaction();
			
			// save the student object
			System.out.println("saving the student object");
			currentSession.save(student);
			
			// commit the transaction
			System.out.println("committing the transaction");
			currentSession.getTransaction().commit();
			
			System.out.println("done !!!");
		} finally {
			sessionFactory.close();
		}
	}
}

```

**QUESTION:  
Why we are using JPA Annotation instead of Hibernate ?

For example, why we are not using this org.hibernate.annotations.Entity?

**ANSWER:  
JPA is a standard specification. Hibernate is an implementation of the JPA specification.

Hibernate implements all of the JPA annotations.

The Hibernate team recommends the use of JPA annotations as a best practice

### Hibernate & Primary keys
Primary key uniquely identifies each row in a table. This must be a unique value and must not be null.

![[Ch-8/Images/image-9.png]]

Previously while generating the Entity class we made use of **@Id** annotation which way we told hibernate it is going to be a primary key.

Now while storing objects into the database we don’t give any value for the Id column and by default for every generated entry in the database the primary key is incremented by one.

How ever there are ways in which we will be able to generate custom unique primary keys while storing data into the database. This is done with the help of **@GeneratedValue** attribute. As a value to this attribute we can now pass in the id generation strategy types.

With **GenerationType.IDENTITY** we are telling mysql to take care of the primary key ID generation process.

![[Ch-8/Images/image-10.png]]

Various types of ID Generation Strategies across databases.

![[Ch-8/Images/image-11.png]]

Now there is also a way using which we can provide our custom primary-key generation. We need to implement the IdentifierGenerator and we have to override the method generate().

![[Ch-8/Images/image-12.png]]

There’s a similar way in which we can retrieve students from the database,

**Student.java (Entity Class)** :

```java
package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
		super();
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

**HibernateCrud.java** :

```java
package com.hibernate.demo.second;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class HibernateCRUD {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			System.out.println("enter details");
			Student student = new Student(
new Scanner(System.in).nextLine(), 
new Scanner(System.in).nextLine(),
								new Scanner(System.in).nextLine()
    );
			currentSession.beginTransaction();
			currentSession.save(student);
			currentSession.getTransaction().commit();
			System.out.println("student saved!! assigned id : " + student.getId());

			currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();

			Student retrievedStudent = currentSession.get(Student.class, student.getId());
			System.out.println("retrieved student : " + retrievedStudent);
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			
		} finally {
sessionFactory.close();
		}

	}

}
output : 
enter details
roopa
kumari
rp@gmail.com
Hibernate: insert into student (email, first_name, last_name) values (?, ?, ?)
student saved!! assigned id : 7
Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_, student0_.first_name as first_na3_0_0_, student0_.last_name as last_nam4_0_0_ from student student0_ where student0_.id=?
retrieved student : Student [id=7, firstName=roopa, lastName=kumari, email=rp@gmail.com]

```

Querying Objects with Hibernate

![[Ch-8/Images/image-13.png]]
![[Ch-8/Images/image-14.png]]

Now consider the code below where we query all the student names from the database. Also in the recent version of hibernate “getResultList()” is changed to “list()”.

```java

package com.hibernate.demo.second;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {

		// load hibernate configuration file hibernate.cfg.xml and create an instance of
		// SessionFactory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			
			// get current session object
			Session currentSession = sessionFactory.getCurrentSession();
			// begin transaction
			currentSession.beginTransaction();
			
			List<Student> students = currentSession.createQuery("from Student").list();
			
			// display student list
			
			for (Student student : students) {
				System.out.println(student);
			}
			
			// commit transaction
			currentSession.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
		}
	}
}

output : 
Student [id=1, firstName=Anupam, lastName=Acharya, email=anupam@gmail.com]
Student [id=2, firstName=Anupam, lastName=Sahu, email=sahu@gmail.com]
Student [id=3, firstName=khawja, lastName=ghouse, email=kg@gmail.com]
Student [id=4, firstName=David, lastName=Alex, email=david_alex@gmail.com]
Student [id=5, firstName=Brian, lastName=Cooper, email=cooperbrian@gmail.com]
Student [id=6, firstName=demo-fname, lastName=demo-lname, email=demo-email@gmail.com]
Student [id=7, firstName=roopa, lastName=kumari, email=rp@gmail.com]

```

![[Ch-8/Images/image-15.png]]

![[Ch-8/Images/image-16.png]]

![[Ch-8/Images/image-17.png]]

Updating Objects with Hibernate

In the example below we will see how can we update a object from a database using hibernate

```java
package com.hibernate.demo.second;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session currentSession = sessionFactory.getCurrentSession();

		try {
			EntityTransaction transaction = currentSession.beginTransaction();

			Student student = currentSession.get(Student.class, 1);
			student.setEmail("anupamacharya25@gmail.com");
			System.out.println(student);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
		}
	}
}

```

Now in the db table the email id has been modified.

Now from the code we can see we are not calling session.save() or session.update(). This is because when we retrieve an object using session.get(Student.class,1) we get a persistent object.

Whenever we are setting the email using a setter method, the data in the persistent object is modified only in the memory, but when we are doing currentSession.getTransaction().commit() the data is written to the database.

Also along with modifying the single rows in the database we can perform a bulk edit as well, this is shown below :

```java

package com.hibernate.demo.second;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();

			currentSession.createQuery("update Student set email='foo_bar@gmail.com'").executeUpdate();

			currentSession.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
		}
	}
}

```

