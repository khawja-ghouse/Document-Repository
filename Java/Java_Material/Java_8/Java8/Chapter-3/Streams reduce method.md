
# Java Stream API - `reduce` Method

## What is the `reduce` Method in Streams?

The `reduce` method is a **terminal operation** in the Java Stream API used to combine the elements of a stream into a single result. It applies a binary operation iteratively to the elements, resulting in a reduced value.

### Key Features:

1. **Aggregation**: Combines stream elements into a single result, such as a sum, product, or concatenation.
2. **Custom Operations**: Allows you to define custom reduction logic using a **BinaryOperator** or a **BiFunction**.
3. **Parallel-Friendly**: Can be used efficiently in parallel streams.

---

## Where is it Used?

The `reduce` method is commonly used for:

1. Summing or multiplying numbers.
2. Concatenating strings.
3. Combining complex objects into a single result.

---

## Understanding the `reduce` Method

### Syntax:

There are three overloaded versions of `reduce`:

1. **Without Identity**:
    
    ```java
    Optional<T> reduce(BinaryOperator<T> accumulator)
    ```
    
    - Combines stream elements using the provided accumulator.
    - Returns an `Optional` because the stream could be empty.
2. **With Identity**:
    
    ```java
    T reduce(T identity, BinaryOperator<T> accumulator)
    ```
    
    - Uses an identity value as the starting point for the reduction.
3. **With Identity and Combiner** (for parallel streams):
    
    ```java
    <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
    ```
    
    - Allows more control over reduction logic in parallel streams.

---

### Example 1: Summing Numbers

```java
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

// Without identity
Optional<Integer> sum = integerList.stream()
                                   .reduce((a, b) -> a + b);
System.out.println(sum.orElse(0)); // Output: 15

// With identity
int sumWithIdentity = integerList.stream()
                                 .reduce(0, (a, b) -> a + b);
System.out.println(sumWithIdentity); // Output: 15
```

---

### Example 2: Concatenating Strings

```java
List<String> stringList = Arrays.asList("a", "b", "c", "d");

// Without identity
Optional<String> concatenated = stringList.stream()
                                          .reduce((s1, s2) -> s1 + s2);
System.out.println(concatenated.orElse("")); // Output: abcd

// With identity
String concatenatedWithIdentity = stringList.stream()
                                            .reduce("", (s1, s2) -> s1 + s2);
System.out.println(concatenatedWithIdentity); // Output: abcd
```

---

### Detailed Explanation of `BinaryOperator`:

The `BinaryOperator` functional interface is defined as:

```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    T apply(T t1, T t2);
}
```

#### Using Anonymous Inner Class:

```java
BinaryOperator<Integer> sumOperator = new BinaryOperator<Integer>() {
    @Override
    public Integer apply(Integer a, Integer b) {
        return a + b;
    }
};

int sum = integerList.stream()
                     .reduce(0, sumOperator);
System.out.println(sum); // Output: 15
```

#### Using Lambda Expression:

```java
BinaryOperator<Integer> sumOperator = (a, b) -> a + b;

int sum = integerList.stream()
                     .reduce(0, sumOperator);
System.out.println(sum); // Output: 15
```

#### Inline Lambda:

```java
int sum = integerList.stream()
                     .reduce(0, (a, b) -> a + b);
System.out.println(sum); // Output: 15
```

---

### Example 3: Combining with Identity and Combiner

In parallel streams, the third `reduce` variant is helpful. For example:

```java
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

int parallelSum = integerList.parallelStream()
                             .reduce(0, 
                                     (a, b) -> a + b,  // Accumulator
                                     (a, b) -> a + b); // Combiner
System.out.println(parallelSum); // Output: 15
```

---

### Real-World Example: Finding Maximum Value

```java
List<Integer> integerList = Arrays.asList(3, 5, 7, 2, 8);

Optional<Integer> max = integerList.stream()
                                   .reduce(Integer::max);
System.out.println(max.orElse(-1)); // Output: 8
```
