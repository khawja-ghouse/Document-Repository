Wrapper classes in Java provide a way to use primitive data types (such as int, char, boolean, etc.) as objects. Each primitive data type has a corresponding wrapper class in the java.lang package. The main reason for using wrapper classes is to take advantage of the functionalities provided by the Java API that require objects rather than primitive types. Here are the wrapper classes corresponding to each primitive type:

    byte → Byte
    short → Short
    int → Integer
    long → Long
    float → Float
    double → Double
    char → Character
    boolean → Boolean

Key Features of Wrapper Classes:

- **Immutability**: All wrapper classes are immutable, meaning once an object is created, its value cannot be changed.
- **Utility** Methods: Wrapper classes provide various utility methods for converting between strings and other data types, comparing values, and more. For example, Integer.parseInt(String) converts a string to an integer.
- **Constants**: Wrapper classes contain useful constants, such as Integer.MAX_VALUE and Double.NaN.
- **Nullability**: Unlike primitives, wrapper class instances can be null. This is useful in collections where you might need to represent the absence of a value.
- **Object-Oriented Features**: Being objects, instances of wrapper classes can be used in various object-oriented features like collections (List, Set, Map), generics, and synchronization.

Autoboxing and Unboxing:

Java provides a feature called autoboxing and unboxing to automatically convert between primitives and their corresponding wrapper classes.

 Autoboxing: Automatic conversion of a primitive type to its corresponding wrapper class object.

    java

int a = 5;
Integer aObj = a;  // Autoboxing

Unboxing: Automatic conversion of a wrapper class object to its corresponding primitive type.

    Integer bObj = 10;
    int b = bObj;  // Unboxing

Example:

Here's an example demonstrating the use of wrapper classes and autoboxing/unboxing:

```java



import java.util.ArrayList;
import java.util.List;

public class WrapperExample {
public static void main(String[] args) {
// Autoboxing: primitive to wrapper object
Integer intObject = 10;
Double doubleObject = 3.14;

        // Unboxing: wrapper object to primitive
        int intValue = intObject;
        double doubleValue = doubleObject;

        // Using wrapper classes in collections
        List<Integer> intList = new ArrayList<>();
        intList.add(intObject);  // Autoboxing
        intList.add(20);         // Autoboxing

        // Retrieving values from collection (Unboxing)
        int sum = 0;
        for (Integer num : intList) {
            sum += num;  // Unboxing
        }
        System.out.println("Sum: " + sum);
    }
}
```
### Benefits of Wrapper Classes:

- Collections Framework: Allows primitives to be stored in Java Collections which require objects.
- Utility Methods: Provides useful methods for data conversion and comparison.
- Null Values: Supports null values for representing the absence of a value.

### Drawbacks of Wrapper Classes:
- Memory Overhead: Wrapper objects consume more memory compared to primitives.
- Performance Overhead: Autoboxing and unboxing can introduce performance overhead due to the additional operations.

Wrapper classes are integral to Java programming, providing flexibility and additional functionality that is not possible with primitive types alone. 

