#### Java unit testing
This trail is about unit testing in Java. Unit testing means testing the smaller units of your application, like classes and methods. The reason you test your code is to prove to yourself, and perhaps to the users / clients / customers, that your code works.
Unit tests are typically automated, meaning once they are implemented, you can run them again and again. That is, your computer can run them again and again, while you do something else.


#### A simple unit test

Let's consider a simple class I want to test:
```JAVA
public class MyUnit {

    public String concatenate(String one, String two){
        return one + two;
    }
}
```

#### **The Unit test**
***
To test this class I need a unit test that test each of its public methods. The class only has one public method, `concatenate()`, so all I need to test is this method.
Unit tests are implemented as classes with test methods. Each test method usually tests a single method of the target class. Sometimes, a test method can test more than one method in the target class, and sometimes, if the method to test is big, you split the test into multiple test methods.

Here is the JUnit unit test that test that the `concatenate()` method:

```JAVA
import org.junit.Test;
import static org.junit.Assert.*;

public class MyUnitTest {

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);

    }
}
```

>The unit test class is an ordinary class, with one method, `testConcatenate()`. Notice how this method is annotated with the JUnit annotation `@Test`. This is done to signal to the unit test runner, that this is method represents a unit test, that should be executed. Methods that are not annotated with `@Test` are not executed by the test runner.
>
>Inside the `testConcatenate()` method an instance of `MyUnit` is created. Then it's `concatenate()` method is called with two string values.
>
>Finally, the **`assertEquals()`** method is called. It is this method that does the actual testing. In this method we compare the output of the called method (`concatenate()`) with the expected output. In other words, we compare "onetwo" (expected output) with the value returned by the `concatenate()` method, which is kept in the variable `result`.
>
>If the two values are equal, nothing happens. The `assertEquals()` method returns normally. If the two values are not equal, an exception is thrown, and the test method stops executing here.
>
>The `assertEquals()` method is a statically imported method, which normally resides in the `org.junit.Assert` class. Notice the static import of this class at the top of `MyUnitTest`. Using the static import of the method is shorter than writing `Assert.assertEquals()`.

# Assert Methods

 Aftre having a look at simple test as shown above, most of the secret of implementing JUnit unit tests, is in the use of the assert methods in the class `org.junit.Assert`.
 - assertArrayEquals()
 - assertEquals()
 - assertTrue() + assertFalse()
 - assertNull() + assertNotNull()
 - assertSame() + assertNotSame()
 - assertThat()

#### Matches

Matchers is an external addition to the JUnit framework. Matchers were added by the framework called Hamcrest. JUnit 4.8.2 ships with Hamcrest internally, so you don't have to download it, and add it yourself.

Matchers are used with the `org.junit.Assert.assertThat()` method, which looks like this:

```JAVA
public void assertThat(Object o, Matcher matcher){
        ...
}
```

You can implement your own Matcher's, but JUnit (Hamcrest) comes with a few builtin matchers you can use. Here are a few examples:

```JAVA
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class MyMatcherTest {

    @Test
    public void testWithMatchers() {
        assertThat("this string", is("this string"));
        assertThat(123, is(123));
    }
}
```

We have different matchers
1. Chaining Matches
2. Core Matches
3. Custom Matches

#### Testing for Exception
Sometimes you may want to test that your code throws the right exceptions when given invalid input, or if executed in an invalid state. There are two ways to do this.

The first way to signal that it is expected that the test method results in an exception being thrown, is to add the `expected` attribute to the `@Test` annotation, like this:

```JAVA
@Test(expected = IllegalArgumentException.class)
public void testForExceptions1() {
    MyUnit myUnit = new MyUnit();

    myUnit.throwIllegalArgumentException();
}
```

Notice how the `expected` attribute is set to `IllegalArgumentException.class`. This signals to the test runner, that when it executes this test method it is expected that an `IllegalArgumentException` is thrown. If no `IllegalArgumentException` is thrown, the test fails.

The second way is to wrap the code you expect to throw an exception in a try-catch block, like this:

```JAVA
@Test
public void testForExceptions2() {
    MyUnit myUnit = new MyUnit();

    try{
        myUnit.throwIllegalArgumentException();

        fail("expected IllegalArgumentException");

    } catch(IllegalArgumentException e){
        //ignore, this exception is expected.
    }
```

Notice the `fail()` method call after the call to `myUnit.throwIllegalArgumentException()`. If the `throwIllegalArgumentException()` method returns normall, then this `fail()` call is executed, causing the test to fail.

Correspondingly, if the `throwIllegalArgumentException()` method throws the expected `IllegalArgumentException`, it is caught in the catch-clause, and ignored. The test continues.

#### Junit Suit

**JUnit test suites** help to grouping and executing tests in bulk. Executing tests separately for all test classes is not desired in most cases. Test suites help in achieving this grouping.

In JUnit, test suites can be created and executed with these annotations.

1.  **@RunWith**
2.  **@SuiteClasses**

Test classes **TestFeatureOne** and **TestFeatureTwo**

TestFeatureOne.java
```JAVA
import junit.framework.Assert;
 
import org.junit.Test;
 
public class TestFeatureOne {
  @Test
  public void testFirstFeature()
  {
    Assert.assertTrue(true);
  }
}
```

TestFeatureTwo.java

```JAVA
import junit.framework.Assert;
 
import org.junit.Test;
 
public class TestFeatureTwo {
  @Test
  public void testSecondFeature()
  {
    Assert.assertTrue(true);
  }
}
```

Create Junit test suit
```JAVA
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
 
import com.howtodoinjava.junit.TestFeatureOne;
import com.howtodoinjava.junit.TestFeatureTwo;
 
@RunWith(Suite.class)
@SuiteClasses({ TestFeatureOne.class, TestFeatureTwo.class })
public class TestFeatureSuite {
  //
}
```
---
#### Annotations for Junit

>**@Test** annotation specifies that method is the test method.
>
>**@Test(timeout=1000)** annotation specifies that method will be failed if it takes longer than 1000 milliseconds (1 second).
>
>**@BeforeClass** annotation specifies that method will be invoked only once, before starting all the tests.
>
  **@Before** annotation specifies that method will be invoked before each test.
>
  **@After** annotation specifies that method will be invoked after each test.
>
  **@AfterClass** annotation specifies that method will be invoked only once, after finishing all the tests.
>**@ParameterizedTest** Parameterized tests make it possible to run a test multiple times with different arguments. They are declared just like regular `@Test` methods but use the `@ParameterizedTest` annotation instead.
>
> In addition, you must declare at least one source that will provide the arguments for each invocation and then consume the arguments in the test method.
>
    For example, the following example demonstrates a parameterized test that uses the `@ValueSource` annotation to specify a String array as the source of arguments.
     
```java
class JUnit5Test {

    @ParameterizedTest
    @ValueSource(strings = { "cali", "bali", "dani" })
    void endsWithI(String str) {
        assertTrue(str.endsWith("i"));
    }
}
```

> **@RepeatedTest** JUnit 5 has the ability to repeat a test a specified number of times simply by annotating a method with `@RepeatedTest` and specifying the total number of repetitions desired.
>
    Each invocation of a repeated test behaves like the execution of a regular `@Test` method. 

```JAVA
class JUnit5Test {
    
@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
@DisplayName("RepeatingTest")
void customDisplayName(RepetitionInfo repInfo, TestInfo testInfo) {
	int i = 3;
	System.out.println(testInfo.getDisplayName() + 
		"-->" + repInfo.getCurrentRepetition()
	);
	
	assertEquals(repInfo.getCurrentRepetition(), i);
}
}
```


> **@DisplayName**
   Test classes and test methods can declare custom display names that will be displayed by test runners and test reports.
 ```java
 @DisplayName("DisplayName Demo")
class JUnit5Test {
    @Test
    @DisplayName("Custom test name")
    void testWithDisplayName() {
    }

    @Test
    @DisplayName("Print test name")
    void printDisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }
}
```

> **@BeforeEach**
	The `@BeforeEach` annotation denotes that the annotated method should be executed before each test method, analogous to JUnit 4’s `@Before`.
>
> **@AfterEach**
	This annotation denotes that the annotated method should be executed after each test method, analogous to JUnit 4’s `@After`. For example, if the tests need to reset a property after each test, we can annotate a method with `@AfterEach` for that task.
   **@BeforeAll**
	This annotation executes a method before all tests. This is analogous to JUnit 4’s `@BeforeClass`. The `@BeforeAll` annotation is typically used to initialize various things for the tests.
>
   **@AfterAll**
	The `@AfterAll` annotation is used to execute the annotated method, only after all tests have been executed. This is analogous to JUnit 4’s `@AfterClass`_._ We use this annotation to tear down or terminate all processes at the end of all tests.0
>
	**@Tag**
	We can use this annotation to declare tags for filtering tests, either at the class or method level.
	The `@Tag` annotation is useful when we want to create a test pack with selected tests.
>
    **@Disabled**
	The `@Disabled` annotation is used to disable or skip tests at class or method level. This is analogous to JUnit 4’s `@Ignore`.
	When declared at class level, all `@test` methods are skipped. When we use `@Disabled` at the method level, only the annotated method is disabled.

#### More on Junit 5 usage
***
1. **Nested tests**
   The **`@Nested`** annotation can be used to annotate inner classes which also contain tests. This allows to group tests and have additional **`@BeforeEach`** method, and one **`@AfterEach`** methods. When you add nested test classes to our test class, the following rules must be followed:
	-   All nested test classes must be non-static inner classes.
	-   The nested test classes are annotated with **`@Nested`** annotation so that the runtime can    recognize the nested test classes.
	-   a nested test class can contain **`Test`** methods, one **@BeforeEach** method, and one **@AfterEach** method.
2. **Test execution order**
   JUnit runs test methods is a deterministic but unpreditable order ***(MethodSorters.DEFAULT)*.** You can use the **@TestMethodOrder** on the class to control the execution order of the tests, via:
```JAVA

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class OrderAnnotationDemoTest {

    @Test
    @Order(1)
    void firstOne() {
        // test something here
    }

    @Test
    @Order(2)
    void secondOne() {
        // test something here
    }

}
```