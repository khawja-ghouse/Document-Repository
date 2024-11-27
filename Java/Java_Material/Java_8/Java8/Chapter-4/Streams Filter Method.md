# Java Stream API - `filter` Method

## What is the `filter` Method in Streams?
The `filter` method in Java Stream API is an **intermediate operation** that is used to process each element of a stream and retain only those elements that match a given condition. It is based on the **Predicate** functional interface.

### Key Features:
1. **Selective Filtering**: Retains only elements that satisfy the specified condition.
2. **Non-Terminal**: Returns a new stream, so it can be chained with other stream operations.
3. **Lazy Evaluation**: The filtering is only performed when a terminal operation is invoked.

---

## Where is it Used?
The `filter` method is commonly used for:
1. Filtering elements from a collection based on specific conditions.
2. Processing large datasets efficiently using parallel streams.
3. Reducing data to a subset that meets certain criteria.

---

## Understanding the `filter` Method

### Syntax:
```java
Stream<T> filter(Predicate<? super T> predicate)
```
- **Input**: A `Predicate` that defines the condition to test elements.
- **Output**: A stream consisting of elements that match the predicate.

### Example 1: Filtering Even Numbers
```java
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> evenNumbers = integerList.stream()
                                       .filter(num -> num % 2 == 0)
                                       .collect(Collectors.toList());
System.out.println(evenNumbers); // Output: [2, 4]
```

---

## Detailed Explanation of `Predicate`:
The `Predicate` functional interface is used in the `filter` method to test elements.

### Definition:
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```
- **Input**: A single argument of type `T`.
- **Output**: A boolean value (`true` or `false`).
- **Purpose**: To define a condition that each element of the stream will be tested against.

### Using Anonymous Inner Class:
```java
Predicate<Integer> isEven = new Predicate<Integer>() {
    @Override
    public boolean test(Integer num) {
        return num % 2 == 0;
    }
};

List<Integer> evenNumbers = integerList.stream()
                                       .filter(isEven)
                                       .collect(Collectors.toList());
System.out.println(evenNumbers); // Output: [2, 4]
```

### Using Lambda Expression:
```java
Predicate<Integer> isEven = num -> num % 2 == 0;

List<Integer> evenNumbers = integerList.stream()
                                       .filter(isEven)
                                       .collect(Collectors.toList());
System.out.println(evenNumbers); // Output: [2, 4]
```

### Inline Lambda:
```java
List<Integer> evenNumbers = integerList.stream()
                                       .filter(num -> num % 2 == 0)
                                       .collect(Collectors.toList());
System.out.println(evenNumbers); // Output: [2, 4]
```

---

## Examples

### Example 2: Filtering Strings by Length
```java
List<String> stringList = Arrays.asList("apple", "bat", "cat", "elephant");

List<String> longStrings = stringList.stream()
                                     .filter(str -> str.length() > 3)
                                     .collect(Collectors.toList());
System.out.println(longStrings); // Output: [apple, elephant]
```

### Example 3: Filtering Null Values
```java
List<String> stringList = Arrays.asList("apple", null, "bat", null, "cat");

List<String> nonNullStrings = stringList.stream()
                                        .filter(Objects::nonNull)
                                        .collect(Collectors.toList());
System.out.println(nonNullStrings); // Output: [apple, bat, cat]
```

### Example 4: Filtering with Multiple Conditions
```java
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

List<Integer> evenAndGreaterThanThree = integerList.stream()
                                                  .filter(num -> num % 2 == 0 && num > 3)
                                                  .collect(Collectors.toList());
System.out.println(evenAndGreaterThanThree); // Output: [4, 6]
```

---

## Real-World Example: Filtering Employees by Salary
```java
class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }
}

List<Employee> employees = Arrays.asList(
    new Employee("John", 3000),
    new Employee("Jane", 5000),
    new Employee("Jack", 7000)
);

List<Employee> highEarners = employees.stream()
                                      .filter(emp -> emp.salary > 4000)
                                      .collect(Collectors.toList());
System.out.println(highEarners); // Output: [Jane: 5000.0, Jack: 7000.0]
```

---

