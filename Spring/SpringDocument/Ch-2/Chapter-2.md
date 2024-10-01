## Inversion Of Control

This is the process of outsourcing the construction and management of objects. The outsourcing is going to get handled by an object factory.

Let's understand this with example

![[Image_1.png]]


![[Image_2.png]]

For the above example these are the code:

**MyApp.java**
```java
package com.khwaja.springdemo;

public class MyApp {
	public static void main(String[] args) {
		// create the object use the object
		Coach baseBallCoach = new BaseBallCoach();
		Coach trackCoach = new TrackCoach();
		// use the object
		System.out.println(baseBallCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyWorkout());
	}
}
```

**Coach.java**
```java
package com.khwaja.springdemo;

public interface Coach {
	public String getDailyWorkout();
}

```

**BaseBallCoach.java**
```JAVA
package com.khwaja.springdemo;

public class BaseBallCoach implements Coach {
	
	public String getDailyWorkout() {
		return "spend 30 minutes in batting practice";
	}
}

```

**TrackCoach.java**
```java
package com.khwaja.springdemo;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
}
```


So as we see from the code the Object creation process is hard coded the current application is not configurable. 
Spring was created to solve this exact problem, where we can create the type of objects we want only by changing the config file (XML config file), without us requiring to change the source code.  

![[Image_3.png]]

**The primary functions of spring container:**
1.     Create and manage objects (Inversion of Control)
2.     Inject objects dependencies (Dependency Injection)

**Ways of configuring the spring container:**
1.     XML configuration file (legacy but most application will use this)
2.     Java Annotation (modern way)
3.     Java Source Code (modern way)

**Spring development process:**

1.     Configure your spring beans:
		![[Image_4.png]]
	    Every bean will have a id which has to be unique and will be used to retrieve beans from the bean container.
	    
2.     Create a spring container
		 ![[Image_5.png]]
		 ![[Image_6.png]]
		 Spring container is known as **Application Context**.
		 
3.      Retrieve Beans from the container.
	   ![[Image_7.png]]
		In this step our application is going to talk to the spring container where it will ask for various objects and based on the XML config file the spring container will give us one.
	   The process of bean retrieval is shown below.
	   ![[Image_8.png]]


**What is a Spring Bean?**

A “Spring Bean” is simply a Java object.

When Java objects are created by the Spring Container, then Spring refers to them as “Spring Beans”.

Spring Beans are created from normal Java classes …. just like Java objects.

![](file:///C:/Users/khawj/AppData/Local/Temp/msohtmlclip1/01/clip_image002.gif)

Now as spring is introduced, we can wire up object implementation easily,

**MyApp.java**

```JAVA
package com.khawja.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {

		/*
		 * Before spring : everything hard coded.
		 * 
		 * // create the object use the object Coach baseBallCoach = new
		 * BaseBallCoach();
		 * 
		 * Coach trackCoach = new TrackCoach();
		 * 
		 * // use the object System.out.println(baseBallCoach.getDailyWorkout());
		 * System.out.println(trackCoach.getDailyWorkout());
		 */Run a hard 5k spend 30 minutes in batting practice

		// After spring was introduced
		
		// load the application config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve the bean from spring container
		Coach coach1 = context.getBean("myCoach", Coach.class);
		Coach coach2 = context.getBean("baseBallCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(coach1.getDailyWorkout());
		System.out.println(coach2.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
output: 
Run a hard 5k
spend 30 minutes in batting practice

```

**applicationContext.xml**
```xml

<?xml version=_"1.0"_ encoding=_"UTF-8"_?>
<beans xmlns=_"http://www.springframework.org/schema/beans"_

       xmlns:xsi=_"http://www.w3.org/2001/XMLSchema-instance"_

       xmlns:context=_"http://www.springframework.org/schema/context"_

       xsi:schemaLocation=_"http://www.springframework.org/schema/beans_

    _http://www.springframework.org/schema/beans/spring-beans.xsd_

    _http://www.springframework.org/schema/context_

    _http://www.springframework.org/schema/context/spring-context.xsd"_>

       <!-- Define your beans here -->

       <bean id=_"myCoach"_ class=_"com.khawja.springdemo.TrackCoach"_>

       </bean>

       <bean id=_"baseBallCoach"_ class=_"com.khawja.springdemo.BaseBallCoach"_>

       </bean>

</beans>
```


Why do we specify the Coach interface in getBean()?

For example:

Coach theCoach = context.getBean("myCoach", Coach.class); 

When we pass the interface to the method, behind the scenes Spring will cast the object for you.

context.getBean("myCoach", Coach.class)  

However, there are some slight differences than normal casting.

Behaves the same as **getBean(String)**, but provides a measure of type safety by throwing a **BeanNotOfRequiredTypeException** if the bean is not of the required type. This means that **ClassCastException** can't be thrown on casting the result correctly, as can happen with **getBean(String)**.