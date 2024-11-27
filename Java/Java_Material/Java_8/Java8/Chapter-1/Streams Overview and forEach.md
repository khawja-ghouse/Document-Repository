## Java Stream API - Overview

## What is the Java Stream API?

The Java Stream API is a powerful tool introduced in Java 8 to process collections of data in a functional style. It allows developers to perform operations like filtering, mapping, and reducing on collections with ease.

### Key Features:

1. **Declarative Style**: Allows you to express complex data processing queries in a readable and concise way.
2. **Lazy Evaluation**: Operations on streams are not executed until a terminal operation (e.g., `forEach`, `collect`) is invoked.
3. **Parallelism**: Simplifies parallel processing of data.

## Where is it Used?

The Stream API is commonly used for:

1. Data transformations and aggregations.
2. Filtering and mapping large data sets.
3. Parallel data processing to improve performance.


### **forEach()**
   The `forEach` method is a terminal operation in the Stream API used to perform an action for each element in the stream. It accepts a **Consumer** functional interface.
   
   Syntax:
```java
   void forEach(Consumer<? super T> action)
```

   Example
```Java
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
integerList.forEach((Integer i) -> System.out.println(i));
```
 
#### Detailed Explanation of `Consumer`:
The `Consumer` functional interface is defined as:

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

```

Using Anonymous Inner Class:
```Java
Consumer<Integer> consumer = new Consumer<Integer>() {
    @Override
    public void accept(Integer i) {
        System.out.println(i);
    }
};
integerList.forEach(consumer);

```

Using Lambda Expression:
```java
Consumer<Integer> consumer = (Integer i) -> System.out.println(i);
integerList.forEach(consumer);

```

Using Method Reference:
```java
integerList.forEach(System.out::println);

```


NOTE:

### **Intermediate Operations**:

- Transform and filter data: `filter`, `map`, `flatMap`
- Modify the stream: `distinct`, `sorted`, `limit`, `skip`
- Perform side-effects: `peek`

### **Terminal Operations**:

- Reduce data: `reduce`, `collect`
- Iterate: `forEach`, `forEachOrdered`
- Match and find: `anyMatch`, `allMatch`, `noneMatch`, `findFirst`, `findAny`
- Aggregate: `count`, `max`, `min`