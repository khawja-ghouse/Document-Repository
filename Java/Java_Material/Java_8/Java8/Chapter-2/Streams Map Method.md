
# Java Stream API - `map` Method

## What is the `map` Method in Streams?

The `map` method is an **intermediate operation** in the Java Stream API that transforms each element of a stream into another form. It is widely used for data transformation, such as converting objects, extracting fields, or performing calculations on elements.

### Key Features:

1. **Element Transformation**: Converts each element of the stream into a new value using a mapping function.
2. **Functional Approach**: Accepts a **Function** functional interface to define the transformation logic.
3. **Creates a New Stream**: Returns a new stream containing the transformed elements.

---

## Where is it Used?

The `map` method is commonly used for:

1. Converting objects from one type to another (e.g., `Integer` to `String`).
2. Performing operations on each element, such as calculations.
3. Extracting fields from objects.

---

## Understanding the `map` Method

### Syntax:

```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper)
```

- `T`: The type of input elements.
- `R`: The type of result elements.
- `mapper`: A **Function** that applies the transformation logic.

---

### Example:

Suppose we have a list of integers, and we want to square each number.

```java
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

// Transforming each integer to its square
List<Integer> squaredList = integerList.stream()
                                       .map(i -> i * i)
                                       .collect(Collectors.toList());

System.out.println(squaredList); // Output: [1, 4, 9, 16, 25]
```

---

### Detailed Explanation of `Function`:

The `Function` functional interface is defined as:

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

#### Using Anonymous Inner Class:

```java
Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
    @Override
    public Integer apply(Integer i) {
        return i * i;
    }
};

List<Integer> squaredList = integerList.stream()
                                       .map(squareFunction)
                                       .collect(Collectors.toList());
```

#### Using Lambda Expression:

```java
Function<Integer, Integer> squareFunction = i -> i * i;

List<Integer> squaredList = integerList.stream()
                                       .map(squareFunction)
                                       .collect(Collectors.toList());
```

#### Inline Lambda:

```java
List<Integer> squaredList = integerList.stream()
                                       .map(i -> i * i)
                                       .collect(Collectors.toList());
```

#### Using Method Reference (if applicable):

For simple transformations like calling a method on each element, you can use a method reference:

```java
List<String> stringList = Arrays.asList("a", "b", "c");
List<String> upperCaseList = stringList.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());

System.out.println(upperCaseList); // Output: [A, B, C]
```

---

## Combining `map` with Other Stream Operations

### Filtering and Mapping:

```java
List<Integer> evenSquares = integerList.stream()
                                       .filter(i -> i % 2 == 0)
                                       .map(i -> i * i)
                                       .collect(Collectors.toList());

System.out.println(evenSquares); // Output: [4, 16]
```

### Mapping Nested Fields:

For a list of objects, `map` is useful for extracting or transforming fields:

```java
class Person {
    String name;
    int age;

    // Constructor and Getters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}

List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25));
List<String> names = people.stream()
                           .map(Person::getName)
                           .collect(Collectors.toList());

System.out.println(names); // Output: [Alice, Bob]
```

