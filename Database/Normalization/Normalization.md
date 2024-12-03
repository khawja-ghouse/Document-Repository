### What is Normalization in Databases?

**Normalization** is a process in database design that organizes data to minimize redundancy and dependency. It involves structuring tables in a way that ensures data is stored efficiently, reducing the risk of anomalies during data manipulation such as insertion, update, or deletion.

---

### Why is Normalization Important?

1. **Reduces Data Redundancy:** Ensures data is stored only once, eliminating duplicate information across tables.
2. **Improves Data Integrity:** Ensures that relationships between tables are properly maintained.
3. **Enhances Query Performance:** Smaller, well-structured tables with minimal redundancy are faster to query.
4. **Prevents Anomalies:** Avoids issues like inconsistent or incomplete data caused by redundant storage.

---

### Steps in Normalization (Normalization Forms)

Normalization is carried out in steps, called **normal forms (NF)**. Each step builds upon the previous one.

#### 1. **First Normal Form (1NF):**

- **Goal:** Eliminate repeating groups and ensure each column contains atomic (indivisible) values.
- **Rules:**
    - Each column should contain unique data (no arrays or lists).
    - Each row should be uniquely identifiable.
- **Example Before 1NF:**
    
    ```plaintext
    OrderID   Customer   Product
    1         John       Phone, Laptop
    2         Alice      Tablet
    ```
    
- **After 1NF:**
    
    ```plaintext
    OrderID   Customer   Product
    1         John       Phone
    1         John       Laptop
    2         Alice      Tablet
    ```
    

#### 2. **Second Normal Form (2NF):**

- **Goal:** Ensure no partial dependency exists, meaning all non-key attributes should depend on the whole primary key.
- **Rules:**
    - The table must first be in 1NF.
    - Non-key attributes must depend on the entire primary key, not just part of it.
- **Example Before 2NF:**
    
    ```plaintext
    OrderID   ProductID   ProductName   Customer
    1         101         Phone         John
    1         102         Laptop        John
    ```
    
- **After 2NF:**
    - Split into two tables:
        
        ```plaintext
        Orders:
        OrderID   Customer
        1         John
        
        Products:
        ProductID   ProductName   OrderID
        101         Phone         1
        102         Laptop        1
        ```
        

#### 3. **Third Normal Form (3NF):**

- **Goal:** Eliminate transitive dependencies, where non-key attributes depend on other non-key attributes.
- **Rules:**
    - The table must be in 2NF.
    - Non-key attributes should depend only on the primary key.
- **Example Before 3NF:**
    
    ```plaintext
    OrderID   Customer   CustomerAddress
    1         John       123 Street
    2         Alice      456 Avenue
    ```
    
- **After 3NF:**
    - Split into two tables:
        
        ```plaintext
        Orders:
        OrderID   Customer
        1         John
        2         Alice
        
        Customers:
        Customer   CustomerAddress
        John       123 Street
        Alice      456 Avenue
        ```
        

#### 4. **Boyce-Codd Normal Form (BCNF):**

- **Goal:** Address anomalies that 3NF might not resolve, ensuring every determinant is a candidate key.
- **Rules:**
    - The table must be in 3NF.
    - All functional dependencies should be on candidate keys.

#### 5. **Higher Normal Forms (4NF, 5NF, and 6NF):**

- **Goal:** Handle more complex scenarios like multi-valued dependencies (4NF), join dependencies (5NF), or further refinement (6NF).
- **Usage:** Often applicable in specialized cases.

---

### Real-World Example of Normalization

#### Scenario: E-Commerce Database

- **Unnormalized Table:**
    
    ```plaintext
    OrderID   Customer   Product       Quantity   DeliveryAddress
    1         John       Phone, Laptop 1, 2       123 Street
    ```
    
- **After Normalization:**
    - **Orders Table:**
        
        ```plaintext
        OrderID   Customer
        1         John
        ```
        
    - **Products Table:**
        
        ```plaintext
        ProductID   ProductName
        101         Phone
        102         Laptop
        ```
        
    - **OrderDetails Table:**
        
        ```plaintext
        OrderID   ProductID   Quantity
        1         101         1
        1         102         2
        ```
        
    - **Customers Table:**
        
        ```plaintext
        Customer   DeliveryAddress
        John       123 Street
        ```
        

---

### When to Normalize and When Not to?

1. **Normalize When:**
    
    - Data consistency is a priority.
    - Redundancy and anomalies need to be eliminated.
    - The system is write-heavy with frequent data updates.
2. **Denormalize When:**
    
    - Query performance (read-heavy systems) is more critical.
    - The system can tolerate minor data redundancy for faster access.
