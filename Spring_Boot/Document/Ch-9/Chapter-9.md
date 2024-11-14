   # JPA / Hibernate Advanced Mapping
So far in our path we have seen very basic database scenario with just one table.
![[Ch-9/Images/image-1.png]]
But the real world data is complex. We are going to have multiple tables and have relations between them.

We also need to somehow model this with Hibernate.

![[Ch-9/Images/image-2.png]]
We will see three kinds of mapping,

![[Ch-9/Images/image-3.png]]
## One to One Mapping

Consider an example where an instructor can have an 'instructor detail' entity which contains additional information about the instructor.

Basically this instructor information is broken down into two separate tables as shown,

![[Ch-9/Images/image-4.png]]

## One to Many Mapping

An instructor can have multiple courses, which is a classic example of One to Many Mapping.
![[Ch-9/Images/image-5.png]]
An exactly opposite scenario of this will be Multiple courses belonging to only one instructor which is a Many to One Mapping.

## Many to Many Mapping

An example of this would be a student having multiple courses and a courses having multiple students enrolled into it.

![[Ch-9/Images/image-6.png]]

## Primary Key & Foreign Key

Primary key is a column in a table which uniquely identifies a row in a table.

Foreign key is a column in a table which is a primary key in another table. Foreign key is used to link tables.

![[Ch-9/Images/image-7.png]]
## Cascade

In a database we can cascade operations which means if performing the db operation on the related tables.

In databases, _cascading_ refers to a feature in relational databases that allows for automatic propagation of changes (like updates or deletions) from one table to related tables. It's commonly used to maintain data integrity in relationships between tables, such as in foreign key constraints.

There are two primary types of cascading actions:

1. **ON DELETE CASCADE**: If a row in the parent table is deleted, this action automatically deletes all corresponding rows in the child table(s) that reference it. For instance, if you delete a record for a customer in a `Customer` table, all associated orders in an `Orders` table could be automatically deleted.
    
2. **ON UPDATE CASCADE**: If a row in the parent table is updated (e.g., the primary key value changes), this action automatically updates the foreign key values in related rows in the child table(s).
    

These cascading actions prevent orphaned records and ensure referential integrity between tables. They’re typically set up when defining foreign key constraints on tables.

![[Ch-9/Images/image-8.png]]

Similarly it is also possible that if we are deleting an `instructor` then we will get rid of the `instructor_detail` as well.

![[Ch-9/Images/image-9.png]]

Below we have a pictorial representation of how a `CASCADE DELETE` would work.

![[Ch-9/Images/image-10.png]]
This cascading feature is fully developer controlled and should be implemented with caution.

A place where CASCADE DELETE would not be applied is a scenario of a MANY to MANY relation. One we delete a student we must not delete the associated course.

![[Ch-9/Images/image-11.png]]
## Fetch Type : Eager vs Lazy Loading

Now if data is split into multiple tables when we fetch data for one table should we fetch the linked table data at one shot or at a later stage?

1. Eager will load everything in one shot.
2. Lazy loading will load the data on request.
![[Ch-9/Images/image-12.png]]

## Unidirectional Relationship

In this kind of relationship we need to load one entity first then we can load the other entity.

![[Ch-9/Images/image-13.png]]
For example in the above we need to load the instructor entity first then we can load the instructor detail instructor.

In the above scenario the connection exists in only one direction.

## Bi-Directional Relationship

In this kind of relationship we can load the entity in any direction.

![[Ch-9/Images/image-14.png]]

Which means we can load the Instructor entity from the Instructor Detail entity.

## One To One - Uni-Directional - (Development)
1. Step - 1 - DB setup
   ```mysql
DROP SCHEMA IF EXISTS `hb-01-one-to-one-uni`;

CREATE SCHEMA `hb-01-one-to-one-uni`;

use `hb-01-one-to-one-uni`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
```

Let's understand what is happening here,

We will start by creating the `instructor_detail` table,

![[image-15.png]]

then, We will then create the `instructor` table,
![[image-16.png]]
But at this point the tables `instructor_detail` and the `instructor` tables are not linked. We could do this by creating a foreign key constraint on the `instructor` table.
![[image-17.png]]Below, we have a pictorial representation of the foreign key relation,

![[image-18.png]]
![[image-19.png]]

![[image-20.png]]
2. Step - 2 - Create InstructorDetail entity class
   ![[image-21.png]]
   ```java
package com.example.khwaja.hb.unidirectional.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
```

3. Step - 3 - Create InstructorDetail class
   ![[Ch-9/Images/image-22.png]]
As of above figure the One to One mapping from Instructor entity to Instructor Detail entity has not been established.

As an additional step we would use `@OneToOne` and `@JoinColumn(name="...")` to create the one to one association.
![[Ch-9/Images/image-23.png]]

We can also configure the cascading behavior with the related entities.

BY DEFAULT NO OPERATIONS ARE CASCADED.

![[Ch-9/Images/image-24.png]]

We can also have multiple cascading types,

![[Ch-9/Images/image-25.png]]
```java
package com.example.khwaja.hb.unidirectional.demo.entity;

	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.OneToOne;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "instructor")
	public class Instructor {
	
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
	
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "instructor_detail_id")
	    private InstructorDetail instructorDetail;
	
	    public Instructor() {
	
	    }
	
	    public Instructor(String email, String firstName, String lastName) {
	        this.email = email;
	        this.firstName = firstName;
	        this.lastName = lastName;
	    }
	
	    public String getLastName() {
	        return lastName;
	    }
	
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
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
	
	    public String getEmail() {
	        return email;
	    }
	
	    public void setEmail(String email) {
	        this.email = email;
	    }
	
	    public InstructorDetail getInstructorDetail() {
	        return instructorDetail;
	    }
	
	    public void setInstructorDetail(InstructorDetail instructorDetail) {
	        this.instructorDetail = instructorDetail;
	    }
	
	    @Override
	    public String toString() {
	        return "Instructor{" +
	                "id=" + id +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", email='" + email + '\'' +
	                ", instructorDetail=" + instructorDetail +
	                '}';
	    }
	}

```

In the above we are cascading everything.

4. step - 4 - Creating DAO interface

To interact with the database we will need to have a class implementing a DAO interface.

![[Ch-9/Images/image-26.png]]

```java
package com.example.busybox.hb.unidirectional.demo.dao;

import com.example.busybox.hb.unidirectional.demo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
}
```
5. step - 5 - Creating DAO IMPL
   ![[Ch-9/Images/image-27.png]]
   ```java
   package com.example.busybox.hb.unidirectional.demo.dao;

import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOIMPL implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    AppDAOIMPL(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }
}
```

This is a simple application other wise the `@Transactional` would have been applied on the service layer.
6. step - 6 - Injecting DAO and starting the app
   
   ![[image-28.png]]
	
	```java
	package com.example.busybox.hb.unidirectional.demo;

import com.example.busybox.hb.unidirectional.demo.dao.AppDAO;
import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import com.example.busybox.hb.unidirectional.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){
		return (runner)->{
			createInstructor(appDAO);

		};
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("khawja@skg.com", "Khwaja", "ghouse");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/bbx", "cooking");

		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);
	}
}
```

In the above we are

1. Creating `Instructor` instance.
2. Creating `InstructorDetail` instance
3. Creating association by calling `setInstructorDetail(...)`
4. Saving `Instructor` instance.

Please note that in the above application we have provided `cascade = CascadeType.ALL` so saving a `Instructor` instance will also cascade this save operation to `InstructorDetail` instance. So the data inserted will be reflected in both the tables.

```mysql
// other code
// ...
// ...
// ...

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "instructor_detail_id")
private InstructorDetail instructorDetail;

// other code
// ...
// ...
// ...
```
Data from the `instructor` table -
![[Ch-9/Images/image-29.png]]
Data from the `instructor_detail` table -
![[Ch-9/Images/image-30.png]]
If we could inspect the logs we could see that data was inserted first into the `instructor_detail` table, then to `instructor` this is because we need the primary key from `instructor_detail` table which will be used as a foreign key for `instructor`.

Now to implement the above everything remains the same except,

1. We need to add new method to DAO Interface
   ```java
   package com.example.busybox.hb.unidirectional.demo.dao;

import com.example.busybox.hb.unidirectional.demo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
}

```
2. We need to add Implementation for DAO interface
   ```java
   package com.example.busybox.hb.unidirectional.demo.dao;

import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOIMPL implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    AppDAOIMPL(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }
}
```

3. call DAO method from main app.
   ```java
   package com.example.busybox.hb.unidirectional.demo;

import com.example.busybox.hb.unidirectional.demo.dao.AppDAO;
import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import com.example.busybox.hb.unidirectional.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){
		return (runner)->{
//			createInstructor(appDAO);
			findInstructorById(appDAO);
		};
	}

	private void findInstructorById(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1);
		System.out.println("Found \n"+instructor+ "\n with id "+1);
	}

}
```

```
Found 
Instructor{id=1, firstName='Khawja', lastName='Ghouse', email='khwajag@.com', instructorDetail=InstructorDetail{id=1, youtubeChannel='http://www.youtube.com/khawja', hobby='cooking'}}
 with id 1
```

Also we can see that it is fetching the instructor detail information along with it.

### Deleting an object in One to One Relationship

It is crucial to understand that as we have applied `cascade = CascadeType.ALL` deleting a row from `instructor` table will also delete the associated row in the `instructor_detail` table as well.

Now to implement the above everything remains the same except,

1. We need to add new method to DAO Interface
   ```java
   package com.example.busybox.hb.unidirectional.demo.dao;

import com.example.busybox.hb.unidirectional.demo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
```
2. We need to add Implementation for DAO interface
   ```java
   package com.example.busybox.hb.unidirectional.demo.dao;

import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOIMPL implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    AppDAOIMPL(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        entityManager.remove(instructor);
    }
}
```

3. call DAO method from main app.
   ```java
   package com.example.khawja.hb.unidirectional.demo;

import com.example.khawja.hb.unidirectional.demo.dao.AppDAO;
import com.example.khawja.hb.unidirectional.demo.entity.Instructor;
import com.example.khawja.hb.unidirectional.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){
		return (runner)->{
//			createInstructor(appDAO);
//			findInstructorById(appDAO);
			deleteInstructorById(appDAO);
		};
	}

	private void deleteInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructorById(1);
		System.out.println("Deleted Instructor by id "+1);
	}

	private void createInstructor(AppDao appDAO) {  
	    Instructor instructor = new Instructor("khwajag@.com", "Khawja", "Ghouse");  
	    InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/khawja", "cooking");  
	    instructor.setInstructorDetail(instructorDetail);  
	    appDAO.save(instructor);  
	}  
	  
	private void findInstructorById(AppDao appDAO) {  
	    Instructor instructor = appDAO.findByID(1);  
	    System.out.println("Found \n"+instructor+ "\n with id "+1);  
	}
}
```

## One To One - Bi-Directional - (Development)

Currently we have a uni-directional mapping,
![[Ch-9/Images/image-31.png]]
which is making our only way through the `instructor` entity to the `instructor_detail` entity.

But as a bi-directional one to one mapping we should be able to load `instructor` entity by loading the `instructor_detail` entity.

![[Ch-9/Images/image-32.png]]
To Establish this relation we have to modify the existing `InstructorDetail` entity class.

1. Create a field of type `Instructor`
2. Create appropriate getter and setters.
3. Add and Configure `@OneToOne(...)`
4. Add cascade info

```java
package com.example.khawja.hb.unidirectional.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
```

![[Ch-9/Images/image-33.png]]

With the above configuration in place we have established One to One bi-directional mapping.

With this implementation we should be able to retrieve `Instructor` entity with `Instructor_Detail` entity.

Let's start with modifying the DAO interface,
```java
package com.example.busybox.hb.unidirectional.demo.dao;

import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import com.example.busybox.hb.unidirectional.demo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
}
```

Now let's implement the method,

```java
package com.example.busybox.hb.unidirectional.demo.dao;

import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import com.example.busybox.hb.unidirectional.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOIMPL implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    AppDAOIMPL(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }
}
```

Now updating the main app,

```java
package com.example.busybox.hb.unidirectional.demo;

import com.example.busybox.hb.unidirectional.demo.dao.AppDAO;
import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import com.example.busybox.hb.unidirectional.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){
		return (runner)->{
//			createInstructor(appDAO);
//			findInstructorById(appDAO);
//			deleteInstructorById(appDAO);
			findInstructorDetailById(appDAO);
		};
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(1);

		System.out.println("found instructor detail with id 1 : "+ instructorDetail+instructorDetail.getInstructor());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructorById(1);
		System.out.println("Deleted Instructor by id "+1);
	}

	private void findInstructorById(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1);
		System.out.println("Found \n"+instructor+ "\n with id "+1);
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("anupam@bbx.com", "Anupam", "Acharya");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/bbx", "cooking");

		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);
	}
}


```

As we have `cascade = CascadeType.ALL` set on the `instructor_detail` entity; deleting a row on the `instructor_details` table will also delete the related row in the `instructor` table.

## Entity Lifecycle

|Operations|Description|
|---|---|
|Detach|If entity is detached, it is not associated with a Hibernate session|
|Merge|If instance is detached from session, then merge will reattach to  <br>session|
|Persist|Transitions new instances to managed state. Next flush / commit  <br>will save in db.|
|Remove|Transitions managed entity to be removed. Next flush / commit  <br>will delete from db.|
|Refresh|Reload / synch object with data from db. Prevents stale data|
![[Ch-9/Images/image-34.png]]

## One to Many


In this section we will look at implementing One to Many relations.

For our consideration we will consider One Instructor can have multiple courses.

This association is directional. We could travel from Courses entity to the Instructor entity and the other way around.

![[Ch-9/Images/image-35.png]]We also could have the above association in reverse, which is Many To One. Where many Courses will have only one instructor.

This kind of association is often called as Inverse / opposite of One to Many.
![[Ch-9/Images/image-36.png]]

In a real world project we would not apply Cascade delete in this relation. In the above example, deleting a Course should not delete the associated instructor and deleting an instructor should not should not delete the course.

![[Ch-9/Images/image-37.png]]

Development of One To Many

#### Step - 1 : Set up DB

```mysql
DROP SCHEMA IF EXISTS `hb-03-one-to-many`;

CREATE SCHEMA `hb-03-one-to-many`;

use `hb-03-one-to-many`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE `instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) 
  REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `instructor_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `TITLE_UNIQUE` (`title`),
  
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
  
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`instructor_id`) 
  REFERENCES `instructor` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
```

![[Ch-9/Images/image-38.png]]

With the DB setup we have One to One relation between `instructor` and `instructor_detail`. Where as we have Many to One relation between `course` and `instructor`.

#### Step - 2 - Create Course Entity Class

```java
package com.example.khawja.hb.unidirectional.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	public Course() {
	}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course{" + "id=" + id + ", title='" + title + '\'' + '}';
	}
}
```

In here as we can see we are linking to the `Instructor` table from the `Courses` table using the `instructor_id` column with the `@JoinColumn()` attribute.

Also part of the implementation we have to remember that we must not apply `cascade = CascadeType.Delete`.

#### Step - 3 Update Instructor class

Here we need to update the existing Instructor class to add association to the `Course` entity.

We have to remember that it is going to be a One to Many relation from the `Instructor` entity to the `Course` entity.

Also deleting the `Instructor` entity should not delete an existing course hence we should apply the cascading type as `cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}`.

```java
package com.example.busybox.hb.unidirectional.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courses;


    public Instructor() {

    }

    public Instructor(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", instructorDetail=" + instructorDetail + '}';
    }

    public void add(Course course) {
        if (courses == null) {
            courses = new ArrayList<Course>();
        }

        courses.add(course);
        course.setInstructor(this);
    }
}
```

As we can see the `Instructor` entity is linked to the `Course` entity with `@MappedBy(...)` annotation,
![[Ch-9/Images/image-39.png]]

Also we can see in the `Instructor` entity we have added utility method for adding a course,

![[Ch-9/Images/image-40.png]]

Update the main APP

```java
package com.example.busybox.hb.unidirectional.demo;

import com.example.busybox.hb.unidirectional.demo.dao.AppDAO;
import com.example.busybox.hb.unidirectional.demo.entity.Course;
import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import com.example.busybox.hb.unidirectional.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return (runner) -> {
//			createInstructor(appDAO);
//			findInstructorById(appDAO);
//			deleteInstructorById(appDAO);
//			findInstructorDetailById(appDAO);
//          deleteInstructorDetailById(appDAO);
            createInstructorWithCourses(appDAO);
        };
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("susan@bbx.com", "Susan", "Wong");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/su", "gaming");

        instructor.setInstructorDetail(instructorDetail);

        Course course1 = new Course("Air Guitar - The Ultimate Guide");
        Course course2 = new Course("Pin Ball - MasterClass");

        instructor.add(course1);
        instructor.add(course2);

        appDAO.save(instructor);
    }

    private void deleteInstructorDetailById(AppDAO appDAO) {
        appDAO.deleteInstructorDetailById(1);
    }

    private void findInstructorDetailById(AppDAO appDAO) {
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2);

        System.out.println("found instructor detail with id 2 : " + instructorDetail + instructorDetail.getInstructor());
    }

    private void deleteInstructorById(AppDAO appDAO) {
        appDAO.deleteInstructorById(1);
        System.out.println("Deleted Instructor by id " + 1);
    }

    private void findInstructorById(AppDAO appDAO) {
        Instructor instructor = appDAO.findInstructorById(1);
        System.out.println("Found \n" + instructor + "\n with id " + 1);
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("khawja@bbx.com", "khawja", "ghouse");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/bbx", "cooking");

        instructor.setInstructorDetail(instructorDetail);

        appDAO.save(instructor);
    }
}

```

With this we are creating courses with an instructor.
![[Ch-9/Images/image-41.png]]

## Fetch Types : Eager vs Lazy

When we are working with associations it is important to decide whether to fetch data for related entities in one shot or on demand.

If we are fetching data for all related entities then we are Eager loading everything. If we are fetching data on demand then it is a case of Lazy Loading.
![[Ch-9/Images/image-42.png]]

In the above it makes sense to load all the Courses once we load an instructor, But in the scenario shown below if we load the students when we load a course might lead to a performance bottleneck.

![[Ch-9/Images/image-43.png]]

As a best practice we should always prefer lazy loading instead of Eager loading.
![[Ch-9/Images/image-44.png]]

![[Ch-9/Images/image-45.png]]

Let's look at a real world use case,
![[Ch-9/Images/image-46.png]]
Let's consider we have a page like above where we can search for `Instructor`. Hence when we are searching for an instructor we don't need to load all the courses associated with them.

The kind of arrangement we have on the diagram is sometimes referred to as a Master View.

Hence as a general practice it is commonly advised to lazy load data in the Master View.

![[Ch-9/Images/image-47.png]]
Now when the user clicks on view details we are loading a detailed view as shown below, where we are loading data of the related entities.

As a general practice load the data for dependent widgets.

![[Ch-9/Images/image-48.png]]

In the table below we have default Fetch Types corresponding to association types. These defaults are used if none is specified while defining associations.

![[Ch-9/Images/image-49.png]]

We must remember that in order to lazy load data we need to have an open Hibernate session. Speaking in a more general way we would need an open database connection to retrieve data.

If the Hibernate session is closed and we still try to load data then Hibernate will throw an exception.

At this point `Instructor` and `Course` has One to Many relation so the fetchType for `Course` entity is `FetchType.LAZY` by default. This means loading an `Instructor` will not load the related `Course`.

Let's now add a method `findInStructorWithCourses(...)` to the main app whose purpose is to load an instructor and its related courses.

```java
package com.example.busybox.hb.unidirectional.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.busybox.hb.unidirectional.demo.dao.AppDAO;
import com.example.busybox.hb.unidirectional.demo.entity.Course;
import com.example.busybox.hb.unidirectional.demo.entity.Instructor;
import com.example.busybox.hb.unidirectional.demo.entity.InstructorDetail;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return (runner) -> {
//			createInstructor(appDAO);
//			findInstructorById(appDAO);
//			deleteInstructorById(appDAO);
//			findInstructorDetailById(appDAO);
//          deleteInstructorDetailById(appDAO);
//          createInstructorWithCourses(appDAO);
			findInStructorWithCourses(appDAO);
		};
	}

	private void findInStructorWithCourses(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("found instructor " + instructor);
		List<Course> courses = instructor.getCourses();
		System.out.println("found courses " + courses);
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("susan@bbx.com", "Susan", "Wong");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/su", "gaming");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("Pin Ball - MasterClass");

		instructor.add(course1);
		instructor.add(course2);

		appDAO.save(instructor);
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(1);
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2);

		System.out
				.println("found instructor detail with id 2 : " + instructorDetail + instructorDetail.getInstructor());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructorById(1);
		System.out.println("Deleted Instructor by id " + 1);
	}

	private void findInstructorById(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1);
		System.out.println("Found \n" + instructor + "\n with id " + 1);
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("khawja@bbx.com", "Khawja", "Ghouse");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/bbx", "cooking");

		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);
	}
}

```

now when we run the application we get the instructor object,

`
`found instructor Instructor{id=1, firstName='Susan', lastName='Wong', email='susan@bbx.com', instructorDetail=InstructorDetail{id=1, youtubeChannel='http://www.youtube.com/su', hobby='gaming'}}`


but we can not obtain the courses from the `Instructor` entity. The moment we even try to attempt this we get an exception,

`
`org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.example.busybox.hb.unidirectional.demo.entity.Instructor.courses: could not initialize proxy - no Session`

Which clearly is saying that out hibernate session has been closed.

Now one quick and dirty solution to this would be to load the `Course` entity eagerly, this is done by changing the fetch type to `fetch = fetchType.EAGER` in the `Instructor` class.

```java
package com.example.khawja.hb.unidirectional.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetail;

	// added  fetch = FetchType.EAGER
	@OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Course> courses;

	public Instructor() {

	}

	public Instructor(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", email='" + email + '\'' + ", instructorDetail=" + instructorDetail + '}';
	}

	public void add(Course course) {
		if (courses == null) {
			courses = new ArrayList<Course>();
		}

		courses.add(course);
		course.setInstructor(this);
	}
}

```

With the above quick and dirty fix we retrieve both the `Instructor` and `Course` objects.

`found instructor Instructor{id=1, firstName='Susan', lastName='Wong', email='susan@bbx.com', instructorDetail=InstructorDetail{id=1, youtubeChannel='http://www.youtube.com/su', hobby='gaming'}}`

`found courses [Course{id=10, title='Air Guitar - The Ultimate Guide'}, Course{id=11, title='Pin Ball - MasterClass'}]`


