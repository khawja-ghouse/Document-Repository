## Spring Configuration with Java Annotation : IoC

In this section we will learn how to configure spring with java Annotation.

What are java Annotations?
1.     Special labels/markers added to java classes.
2.     They provide metadata about the class.
3.     They are processed either at compile time or at run time for special processing

![[Ch-5/Images/image-1.png]]

We can simply see the red colour box which is a hypothetical shoe box contains some metadata about the item inside it.

![[Ch-5/Images/image-2.png]]

So, after using the **@override** annotation if we are not overriding a method correctly then we are going to receive compile time errors.

![[Ch-5/Images/image-3.png]]

So basically, if we are configuring around 30 beans imagine the hard work we need to do. In stead we can make use of Annotations to reduce the work load.

Spring will be looking for classes with special spring annotations, if it finds one then it will register that class inside bean container.

![[Ch-5/Images/image-4.png]]

**Development Process :**
1. Enable component scanning in spring config file.
   ![[Ch-5/Images/image-5.png]]
   ```XML
   applicationContext.xml : 

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

<!-- add entry to enable component scanning -->
	<context:component-scan base-package="com.busybox.spring.anotations"></context:component-scan>
</beans>

```

2.  Add the **@component** annotation to our java classes.
   **TennisCoach.java**
```java
package com.busybox.spring.anotations;

import org.springframework.stereotype.Component;

@Component("tennisCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Learn to Swing your racket";
	}
}
```
![[Ch-5/Images/image-6.png]]

3. Retrieve the beans from the spring container.
   ![[Ch-5/Images/image-7.png]]
   
   **SpringAnnotationDriver.java**
   
```java
package com.busybox.spring.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationDriver {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(tennisCoach.getDailyWorkout()); //Learn to Swing your racket
		
		// close the context
		context.close();
	}

}
```

**@Component and Default Bean ID**

![[Ch-5/Images/image-8.png]]

So far we have learned how we will have to pass a ‘beanId’ in the @Component decorator so what we can retrieve the bean from the spring container later on.

How ever this work of specifying bean container we can out source to spring. So spring will generate the default ‘beanId’ for the class itself.
![[Ch-5/Images/image-9.png]]
And the default generated beanId is going to be the camel case format of the component class name.
![[Ch-5/Images/image-10.png]]

![[Ch-5/Images/image-11.png]]

TennisCoach.java
```java
package com.busybox.spring.anotations;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Learn to Swing your racket";				
	}
}

```

And everything else remains the same. But **@Component(“tennisCoach”)** becomes **@Component**

### Spring DI with Java Annotation & Auto wiring

In this section we will learn dependency injection with java annotation and auto wiring.

In the previous sections we have already used this example in constructor injection and setter injection way but we in this section we will implement this example in spring annotation and auto wiring way.

![[Ch-5/Images/image-12.png]]

![[Ch-5/Images/image-13.png]]

How the auto wiring is going to work?

So spring will scan for our components and during that it will get to know the component class requires a service as a dependency. Then it will look for any class which will implementing the service interface, if so then it will inject the class which implements the service interface.

![[Ch-5/Images/image-14.png]]

In the spring auto wiring dependency process, we have 3 types of injection types :
1.     Constructor Injection
2.     Setter Injection
3.     Field Injection

**Annotation Constructor Injection Development process :**

1.     Define the service interface and the class which implements it.
    ![[Ch-5/Images/image-16.png]]
   ```java
FortuneService.java
   
package com.busybox.spring.anotations;

public interface FortuneService {
	public String getDailyFotune();
}

```

**FortuneServiceImpl.java**

```java
package com.busybox.spring.anotations;

import org.springframework.stereotype.Component;

@Component
public class FotuneServiceImpl implements FortuneService {

	@Override
	public String getDailyFotune() {
		// TODO Auto-generated method stub
		return "well some good Fortune !!";
	}

}

```

**Coach.java:**

```java
package com.busybox.spring.anotations;

public interface Coach {

	public String getDailyWorkout();

	public String getDailyFortune();
}

```

2. Create a constructor in our class for injections.
   ![[Ch-5/Images/image-17.png]]
   
   **TennisCoach.java :**
   ```java
package com.busybox.spring.anotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	FortuneService fortuneService;

	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Learn to Swing your racket";
	}

	@Override
	public String getDailyFortune() {

		return this.fortuneService.getDailyFotune();
	}
}

```


   3. Configure the dependency with **@Autowired** annotation 
![[image-20.png]]

_As of_ [_Spring Framework 4.3_](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation)_, an @Autowired annotation on such a constructor is no longer necessary if the target bean only defines one constructor to begin with. However, if several constructors are available, at least one must be annotated to teach the container which one to use._

**SpringAnnotationDriver.java :**
```java
package com.busybox.spring.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationDriver {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(tennisCoach.getDailyWorkout()); // Learn to Swing your racket
		System.out.println(tennisCoach.getDailyFortune()); // well some good Fortune !!

		// close the context
		context.close();
	}

}

```

Setter Injection using Spring Annotation and Autowiring

In this section we will be discussing setter injection with annotation and auto wiring.

In this type of injection we inject the dependencies by calling the setter methods in our class.

**Development Process for DI with spring annotation and autowiring :**

1. Create setter method in your class for injections.
   ![[Ch-5/Images/image-21.png]]
   
   2. Configure the DI with **@Autowired** annotation
    **TenniseCoach.java**
    
    ```java
package com.busybox.spring.anotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	FortuneService fortuneService;

	public TennisCoach(FortuneService fortuneService) {

	}

	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Learn to Swing your racket";
	}

	@Override
	public String getDailyFortune() {

		return this.fortuneService.getDailyFotune();
	}
}

```

![[image-22.png]]

_Now there is also some crazy cool feature made available from spring, For setter Injection it does not only have to be the setter method which initializes the dependency service. It can be any method but it must receive the **@Autowired** annotation._

TennisCoach.java : 
```java
package com.busybox.spring.anotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	FortuneService fortuneService;

	public TennisCoach(FortuneService fortuneService) {

	}

	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	// using normal method inside the class to initialize the dependency
	@Autowired
	public void initFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Learn to Swing your racket";
	}

	@Override
	public String getDailyFortune() {

		return this.fortuneService.getDailyFotune();
	}
}

```

**SpringAnnotationDriver.java :**

```java
package com.busybox.spring.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationDriver {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(tennisCoach.getDailyWorkout()); // Learn to Swing your racket
		System.out.println(tennisCoach.getDailyFortune()); // well some good Fortune !!

		// close the context
		context.close();
	}

}


```

Field Injection using Annotation & Autowiring

In this section we will be learning Field Injection with Annotation & Autowiring.

In this way we will directly inject the dependency to the class field (even to private variables). This is accomplished by **Java Reflection**.

**Development Process for Field Injection :**

1. **@Autowired** annotation is applied directly on the field holding the dependency. No Setter methods are required in this case.
   ![[Ch-5/Images/image-23.png]]
	
	TennisCoach.java
	```java
package com.busybox.spring.anotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	// field Injection
	@Autowired
	FortuneService fortuneService;

	public TennisCoach(FortuneService fortuneService) {

	}

	@Override
	public String getDailyWorkout() {
		return "Learn to Swing your racket";
	}

	@Override
	public String getDailyFortune() {

		return this.fortuneService.getDailyFotune();
	}
}

```

**Annotation Autowiring & Qualifiers**

So previously spring was automatically injecting the bean for the service implementation class with the help of **@Autowired** annotation regardless of the injection type used (Constructor, setter & field injection).

But the problem arises when there are more than one class implementing the service interface. Now spring will face ambiguity in choosing the correct Service Implementation class. We will cover below how to tackle with this exact situation.


![[image-24.png]]

![[image-25.png]]

So now in order to solve this problem we need to use the **@Qualifier(requested_Service_BeanId)** annotation where we explicitly tell spring which Service class to use while creating bean for TennisCoach Class.
**TennisCoach.java :**

```java
package com.busybox.spring.anotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fortuneServiceImpl")
	FortuneService fortuneService;

	public TennisCoach() {

	}
	@Override
	public String getDailyWorkout() {
		return "Learn to Swing your racket";
	}
	@Override
	public String getDailyFortune() {

		return this.fortuneService.getDailyFotune();
	}
}

```

Except from this everything remains the same.

Annotations - Default Bean Names - The Special Case

In general, when using Annotations, for the default bean name, Spring uses the following rule.

_If the annotation's value doesn't indicate a bean name, an appropriate name will be built based on the short name of the class (with the first letter lower-cased)._

For example:

**HappyFortuneService** becomes **happyFortuneService**

However, for the **special case of when BOTH the first and second characters of the class name are upper case**, then the **name is NOT converted**.

For example, if there is a Service class **RESTFortuneService**

**RESTFortuneService** will become **RESTFortuneService**

_***No conversion_ since the first two characters are upper case.

Behind the scenes, Spring uses the **Java Beans Introspector** to generate the default bean name. Here's a screenshot of the documentation for the key method.
![[Ch-5/Images/image-26.png]]

**Using @Qualifier with Constructors**

**@Qualifier** is a nice feature, but it is tricky when used with Constructors.

The syntax is much different from other examples and not exactly intuitive.  Consider this the "deep end of the pool" when it comes to Spring configuration LOL :-)

You have to place the @Qualifier annotation inside of the constructor arguments. 

Here's an example from our classroom example. I updated it to make use of constructor injection, with @Autowired and @Qualifier. Make note of the code in bold below:

```java
package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}

	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");

		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}

```

For detailed documentation on using @Qualifier with Constructors, see this link in the Spring Reference Manual

[https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation-qualifiers](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation-qualifiers)


**@Qualifier with Setter Injection**

You can use similar syntax with Setter Injection. You can use @Qualifier in method arguments line, such as

```java
@Autowired
public void setFortuneService(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
}

You can also use the @Qualifier above the method name. For example, here's the syntax

@Autowired
@Qualifier("randomFortuneService")
public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
}

```

Inject properties file using Java annotations

**1. Create a properties file to hold your properties. It will be a name value pair.**  

New text file:  src/sport.properties

name = Rick Sanchez

profession = Mad Scientit

Note the location of the properties file is very important. It must be stored in src/sport.properties

2. **Load the properties file in the XML config file.**

File: applicationContext.xml

Add the following lines:

**<context:property-placeholder location="classpath:sport.properties"/>**

This should appear just after the <context:component-scan .../> line

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- add entry to enable component scanning -->
	<context:component-scan
		base-package="com.busybox.spring.anotations"></context:component-scan>

	<!-- Inject property File -->
	<context:property-placeholder
		location="classpath:sport.properties" />
</beans>

```

3. **Inject the properties values**
   ```java
package com.busybox.spring.anotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fortuneServiceImpl")
	FortuneService fortuneService;

	@Value("${name}")
	private String name;

	@Value("${profession}")
	private String profession;

	public TennisCoach() {

	}

	public String getName() {
		return name;
	}

	public String getProfession() {
		return profession;
	}

	@Override
	public String getDailyWorkout() {
		return "Learn to Swing your racket";
	}

	@Override
	public String getDailyFortune() {

		return this.fortuneService.getDailyFotune();
	}

}

```

SpringAnnotationDriver.java

```java
package com.busybox.spring.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationDriver {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);

		// call a method on the bean
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());

		// print values referenced from properties file
		System.out.println(tennisCoach.getName()); // Rick Sanchez
		System.out.println(tennisCoach.getProfession()); // Mad Scientist
		
		// close the context
		context.close();
	}

}

```

Bean Scopes with Annotations

In this section we will be learning bean scopes with annotations.

From the previous lectures we have covered ,

![[Ch-5/Images/image-27.png]]

![[Ch-5/Images/image-28.png]]

![[Ch-5/Images/image-29.png]]

![[Ch-5/Images/image-30.png]]

![[Ch-5/Images/image-31.png]]

![[image-32.png]]

Bean Life Cycle Methods – with Annotations

![[image-33.png]]

![[image-34.png]]

![[image-35.png]]

**_Special Note about @PostConstruct and @PreDestroy Method Signatures_**

I want to provide additional details regarding the method signatures of @PostContruct and @PreDestroy methods.

**Access modifier**

The method can have any access modifier (public, protected, private)

**Return type  
The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.

**Method name  
The method can have any method name.

**Arguments  
The method can not accept any arguments. The method should be no-arg.