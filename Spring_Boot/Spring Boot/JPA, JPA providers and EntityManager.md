### Java Persistence API (JPA)

JPA is a specification for accessing, managing, and persisting data between Java objects and a relational database. It
provides a standard approach to ORM (Object-Relational Mapping), allowing developers to map Java classes to database
tables and manage the lifecycle of these objects in a database context.

- **Purpose:** Simplify database operations and reduce boilerplate code by providing a standardized way of dealing with
  relational data in Java applications.
- **Key Concepts:**
    - **Entities:** Java classes annotated with `@Entity` that represent tables in a database.
    - **Entity Relationships:** Annotations like `@OneToOne`, `@OneToMany`, `@ManyToOne`, and `@ManyToMany` to define
      relationships between entities.
    - **Persistence Context:** A set of entity instances that are managed by an Entity Manager, often referred to as
      the "first-level cache."

### Entity Manager

The Entity Manager is a central part of the JPA, responsible for interacting with the persistence context. It provides
APIs to perform CRUD (Create, Read, Update, Delete) operations on the entities, manage transactions, and query the
database.

- **Key Functions:**

    - **Persist:** Save a new entity to the database.
    - **Merge:** Update an existing entity in the database.
    - **Remove:** Delete an entity from the database.
    - **Find:** Retrieve an entity by its primary key.
    - **Query:** Create and execute queries to retrieve data from the database.

### Relationship Between JPA and Entity Manager

1. **Specification vs Implementation:**

    - **JPA:** It is a specification, meaning it defines the interfaces and the behavior expected but does not provide
      the actual implementation.
    - **Entity Manager:** It is part of the JPA specification, an interface that provides methods to interact with the
      persistence context and manage entities. The actual implementation of `EntityManager` is provided by a JPA
      provider (like Hibernate, EclipseLink, etc.).
2. **Role in Persistence:**

    - **JPA:** Provides the overarching framework and guidelines for ORM and data persistence in Java applications.
    - **Entity Manager:** Acts as the key component within this framework to manage the lifecycle and operations on
      entities, essentially bridging the application and the database.

### EntityManager and JPA

1. **JPA (Java Persistence API):**

    - **Specification:** JPA is a set of rules and guidelines for ORM (Object-Relational Mapping) in Java applications.
      It defines how Java objects should be mapped to database tables and how these objects should be managed within a
      persistence context.
    - **Core Concepts:**
        - Entities: Java classes representing database tables.
        - Entity Relationships: Annotations to define relationships between entities.
        - Persistence Context: Managed set of entity instances, usually tied to a particular transaction.
2. **EntityManager:**

    - **Interface:** EntityManager is an interface defined by the JPA specification. It provides methods for performing
      CRUD operations, querying the database, and managing the lifecycle of entities.
    - **Functionality:** EntityManager handles operations such as persisting new entities, merging existing entities,
      removing entities, finding entities by primary key, and creating queries.

### JPA Providers

- **Implementations:** JPA providers (such as Hibernate, EclipseLink, OpenJPA) are libraries that provide concrete
  implementations of the JPA specification. They implement the EntityManager interface and other parts of the JPA
  specification.
- **Role of JPA Providers:** These providers offer the actual code and functionality that adheres to the JPA
  specification, allowing developers to use the standardized API (like EntityManager) while the provider handles the
  underlying database interactions.