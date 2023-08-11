#### 1. Interface with the private method
 
 Till java 8 interface only allowed default and static methods, from java 9 we also have support of private methods in interface.
```java
import java.util.*;

interface Util {
	static int foo(){
		return 5;
	}
	default int getNumberOfCore() {
		return healper();
	}
	private int helper() {
		return 4;
	}
}

public class Sample{
	public static void main(String[] args){
		System.out.println("OK");
	}
}

```

#### 2. REPL (Jshell)
   Oracle Corp has introduced a new tool called **jshell**. It stands for Java Shell and also known as REPL (Read Evaluate Print Loop). It is used to execute and test any Java Constructs like class, interface, enum, object, statements etc. very easily
   R - Read the input from the command prompt.
   E - The input is evaluated by the interpreter or compiler in the background.
   P -  The result of the evaluated code is printed back to the command prompt.
   L - The process repeats, creating an interactive cycle where users can continuously enter new code and immediately see the outcomes.

 REPLs are particularly useful for experimenting with code, learning programming concepts, and debugging. They provide a quick feedback loop, allowing developers to test small code snippets and see the results without needing to write a complete program and compile it separately.
 
`jshell> command without / is for the JDK`
 ![[Pasted image 20230811144416.png]]
 `jshell> command with / is for JSHELL`
![[Pasted image 20230811144442.png]]

 
#### 3. Factory Methods for Immutable List, Set, Map and Map.Entry

In Java 9, one of the notable features introduced was the addition of factory methods for creating immutable lists. These factory methods were added to the `java.util.List` interface and its implementations, allowing for a more concise and readable way to create immutable lists.

Prior to Java 9, creating an immutable list required using methods like `Collections.unmodifiableList()` or initializing a list using a loop. Java 9 addressed this with the introduction of the `List.of()` and `List.copyOf()` factory methods.

1. `List.of()`
   ```java
import java.util.List;

public class ImmutableListExample {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Orange");
        System.out.println(fruits);
    }
}
```

2. `List.copyOf()`
   ```java
import java.util.List;
import java.util.ArrayList;

public class ImmutableListCopyExample {
    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("Red");
        originalList.add("Green");
        originalList.add("Blue");

        List<String> immutableCopy = List.copyOf(originalList);
        System.out.println(immutableCopy);
    }
}
```

These factory methods provide a convenient and concise way to create immutable lists in Java 9 and later versions, reducing the need for boilerplate code and making code more readable.


#### 4. Java 9 Module System
Java 9 introduced a significant feature known as "modularization" through the Java Platform Module System (JPMS). This feature aims to address various challenges and improve the structure, maintainability, and performance of Java applications by enabling developers to create modular and well-encapsulated components.

1. **Module**: A module is a self-contained unit of code and resources. It groups related packages, classes, and resources together, providing better encapsulation. A module specifies what is export(public API) and what it requires( dependencies) from other modules.
2. **Module Declaration**: Each module is defined in module-info.java file, which declares the module's name, its dependencies, and what it exports. This file is placed in a root of the module's source directory.
3. **Exports and Requires:** Modules explicitly declares their dependencies on other modules using the **'requires'** keyword in their module-info.java file. They also specify which packages are accessible to other modules using the **'exports'** keyword.
4. Encapsulation: Modules provide strong encapsulation by allowing only specified packages to be accessible from outside the module.
	
|**Classpath**|**Modulepath**|
|---|---|
|Handles dependencies at a granular level using class files and JAR files|Enforces explicit dependency declarations at the module level|
|Doesn’t enforce explicit dependency declarations, leading to potential issues|Ensures a clear understanding of required resources, avoiding conflicts|
|All classes and resources are globally accessible by default|Promotes encapsulation and controlled visibility|
|Unrestricted accessibility can lead to naming conflicts or unintended dependencies|Prevents unwanted dependencies. Since the only exported packages are accessible by other modules|
|Less efficient since it requires searching through directories and JAR files|More efficient by building a dependency graph and loading only required modules, improving performance|
|The search process can be time-consuming, especially for large _classpaths_|Reduces search overhead, enhancing runtime performance|

**Benefits of Modularization:**
- Strong Encapsulation.
- Maintainability.
- Dependency Management.
- Performance.

#### 5. Process API Improvements.
Java 9 introduced several improvements to the Process API, which is used to manage and interact with native processes (external commands and applications) from within Java programs.
1. **ProcessHandle Interface**: The `java.lang.ProcessHandle` interface was introduced to provide a standardized way to interact with and manage native processes. This interface encapsulates information and operations related to a native process. It offers methods to retrieve process information, such as process ID, parent process, command, arguments, start time, and more.
   ```java
ProcessHandle processHandle = ProcessHandle.current();
System.out.println("Process ID: " + processHandle.pid());
System.out.println("Command: " + processHandle.info().command().orElse("N/A"));

```
2. **ProcessHandle.Info Class**: The `ProcessHandle.Info` class is nested within the `ProcessHandle` interface and provides additional information about a process. This information includes details such as the command, arguments, start time, user, CPU usage, and more.
   ```Java
   ProcessHandle.Info info = processHandle.info();
System.out.println("Command: " + info.command().orElse("N/A"));
System.out.println("Arguments: " + info.arguments().orElse("N/A"));

```
3. **onExit() Method**: The `ProcessHandle` interface introduced the `onExit()` method, which allows you to register a callback that is invoked when the process exits, either normally or abnormally.
   
   ```java
   ProcessHandle processHandle = ... // Obtain the process handle
processHandle.onExit().thenRun(() -> System.out.println("Process has exited."));
```
 and many other.


#### 6. Try Resources Improvement.
In Java 9, the "try-with-resources" statement was enhanced to provide a more concise and flexible syntax for managing resources that need to be automatically closed when they are no longer needed.

Before Java 9:
```JAVA
try (Scanner scanner = new Scanner(new File("testRead.txt")); PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) { 
// omitted 
}

```

With Java 9:
```java
final Scanner scanner = new Scanner(new File("testRead.txt")); 
PrintWriter writer = new PrintWriter(new File("testWrite.txt"));

try (scanner;writer) 
{ 
// omitted 
}
```

#### 7. Reactive Streams.
 Reactive Streams is a programming model that provides a standardized way to deal with asynchronous stream processing in a non-blocking manner. It addresses the challenges of handling streams of data that are produced and consumed asynchronously, such as those encountered in reactive programming and backpressure scenarios.
 The core idea behind Reactive Streams is to define a set of interfaces, contracts, and rules for asynchronous stream processing to ensure efficient and non-blocking communication between producers and consumers of data streams. The key interfaces in the Reactive Streams API are:

1. **Publisher**: Represents the source of data or events that are being published asynchronously.
    
2. **Subscriber**: Represents the consumer of the data or events emitted by the Publisher.
    
3. **Subscription**: Represents the link between a Publisher and a Subscriber. It allows the Subscriber to request a certain amount of data and handle backpressure.
    
4. **Processor**: Represents a component that acts as both a Publisher and a Subscriber. It can transform or filter the data flowing between the upstream and downstream.

#### 8. Stream API Improvements.
Streams were introduced in Java to help developers perform aggregate operations from a sequence of objects. With Java 9, few more methods are added to make streams better.

## takeWhile(Predicate Interface)
### Syntax

`default Stream<T> takeWhile(Predicate<? super T> predicate)`

**takeWhile** method takes all the values until the predicate returns false. It returns, in case of ordered stream, a stream consisting of the longest prefix of elements taken from this stream matching the given predicate.

 ```java
import java.util.stream.Stream;
public class Tester {
   public static void main(String[] args) {
      Stream.of("a","b","c","","e","f").takeWhile(s->!s.isEmpty())
         .forEach(System.out::print);		 
   } 
}
output: 
abc
```

## dropWhile(Predicate Interface)

### Syntax

`default Stream<T> dropWhile(Predicate<? super T> predicate)`

dropWhile method throw away all the values at the start until the predicate returns true. It returns, in case of ordered stream, a stream consisting of the remaining elements of this stream after dropping the longest prefix of elements matching the given predicate.

```java
import java.util.stream.Stream;

public class Tester {
   public static void main(String[] args) {
      Stream.of("a","b","c","","e","f").dropWhile(s-> !s.isEmpty())
         .forEach(System.out::print);
      
      System.out.println();
      Stream.of("a","b","c","","e","","f").dropWhile(s-> !s.isEmpty())
         .forEach(System.out::print);
   } 
}
output
ef
ef
```

## iterate

### Syntax

`static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)`

iterate method now has hasNext predicate as parameter which stops the loop once hasNext predicate returns false.

```java
import java.util.stream.IntStream;
public class Tester {
   public static void main(String[] args) {
      IntStream.iterate(3, x -> x < 10, x -> x+ 3).forEach(System.out::println);
   } 
}

output
3
6
9
```

## ofNullable

### Syntax

`static <T> Stream<T> ofNullable(T t)`

**ofNullable** method is introduced to prevent NullPointerExceptions and to avoid null checks for streams. This method returns a sequential Stream containing single element, if non-null, otherwise returns an empty Stream.

```Java
import java.util.stream.Stream;

public class Tester {
   public static void main(String[] args) {
      long count = Stream.ofNullable(100).count();
      System.out.println(count);
  
      count = Stream.ofNullable(null).count();
      System.out.println(count);
   } 
}
output
1
0
```
#### 9. HTTP 2 Client
In Java SE 9, Oracle Corp is going to release New HTTP 2 Client API to support HTTP/2 protocol and WebSocket features. As existing or Legacy HTTP Client API has numerous issues (like supports HTTP/1.1 protocol and does not support HTTP/2 protocol and WebSocket, works only in Blocking mode and lot of performance issues.), they are replacing this HttpURLConnection API with new HTTP client. They are going to introduce a new HTTP 2 Client API under the “java.net.http” package. It supports both HTTP/1.1 and HTTP/2 protocols. It supports both Synchronous (Blocking Mode) and Asynchronous Modes.

#### 10. Enhanced Deprecated annotation

In Java SE 8 and earlier versions, Deprecated annotation is just a Marker interface without any methods. It is used to mark a Java API that is a class, field, method, interface, constructor, enum etc. In Java SE 9, Oracle Corp has enhanced @Deprecated annotation to provide more information about deprecated API and also provide a **Tool** to analyze an application’s static usage of deprecated APIs. They have add two methods to this Deprecated interface: **forRemoval** and **since** to serve this information.

#### 11. Improved Documents
 Java documentation in Java 9 make it easier for developers to find information, understand APIs, and use new features introduced in the language. The enhanced search functionality, updated API documentation, improvements to Javadoc, modular documentation, and improved navigation and readability all contribute to a more user-friendly and comprehensive documentation experience.

#### 12. Improved Optional class.