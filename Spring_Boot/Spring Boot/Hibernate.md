What is Hibernate?
A framework for persisting / saving Java objects in database.
www.hibernate.org/orm


![[whatIsHibernate.png]]

Benefits of Hibernate
1. Hibernate handles all of the low-level SQL
2. Minimize the amount of JDBC code you have to develop
3. Hibernate provides the Object-to-Relational Mapping (ORM)

Object-To-Relational Mapping (ORM)
1. The developer defines mapping between Java class and database table.

![[ormMapping.png]]

By default the hibernate converts **firstName** to **first_name** in database.

What is JPA?
1. Jakarta Persistence API (JPA) which previously known as Java Persistence API.
		Standard API for Object-to-Relational-Mapping (ORM)

	Only a specification
		Defines a set of interfaces. It requires an implementation to be usable.
	
	JPA - Vendor Implementations
		There are many implementations of JPA but Hibernate and EclipseLink are popular implementations
		![[jpaImplementation.png]]
	 
	Spring boot default JPA implementation is Hibernate.
What are the benefits of JPA
1. By having a standard API, you are not locked to vendor's implementation
2. Maintain portable, flexible code by coding to JPA spec (interfaces)
3. Can theoretically switch vendor implementations
	1. Fox example, if Vendor ABC stops supporting their product.
	2. You can switch to Vendor XYZ without vendor lock in
	![[savingJavaObjectWithJPA.png]]

How does Hibernate / JPA relate to JDBC?

Hibernate / JPA uses JDBC for all database communications 
![[Jpa_JDBC.png]]

Automatic Data Source Configuration
 1. Based on configs, Spring Boot will automatically create the beans: DataSource, EntityManager,.. and many others.
 2. You can then inject these into your app for example your DAO.

Application properties configurations for mysql datasource

```properties
# DataSource Configuration
# we don't need to give database URL spring will automatically detects the drivers based
# on URL provided.

spring.datasource.url=jdbc:mysql://localhost:3306/chit_fund?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

# Minimise some of the logging
# Turn off the spring Boot banner

Spring.main.banner-mode=off

# Reduce logging lebel. Set logging level to warn
# This will show only warnings and errors.
logging.level.root=warn 


```

JPA Dev Process - To Do List
1. Annotate Java Class
2. Develop Java Code to perform database operations

Terminology
`Entity Class - Java class that is mapped to a database table.`

Java Annotations
Step 1:  Map class to database table
Step 2: Map fields to database columns

![[MapClassToDatabaseTable.png]]
![[MapfiledsToColumn.png]]

**@Column** is optional, If its not specified the column name is the same as Java field.
Same goes with **@Table**, database table name is same as class name.

JPA Identity - Primary Key

Example: 

![[JPAIdentityPrimaryKey.png]]![[idGenerationStrategies.png]]

You can also define your own CUSTOM generation stratergy :-)
Create implementation of `org.hibernate.id.IdentifierGenerator`

Override the method: `public Serializeable generate()`
