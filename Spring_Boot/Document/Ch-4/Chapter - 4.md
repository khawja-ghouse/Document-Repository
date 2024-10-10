# Bean Scopes

It generally tells :

1. Scopes refer to the life cycle of the bean.

2. How long does the bean live?

3. How many instances are created?

4. How is the bean shared in the spring environment?

## Default Scope (singleton)

In this case the spring container will create only one instance of the bean, by default. The same bean is cached in memory. All request to the bean will return the shared reference to the same bean.

![](Pasted%20image%2020240705154927.png)

![](Pasted%20image%2020240705154950.png)

![](Pasted%20image%2020240705154957.png)

In the diagram above both “alphaCoach” and “theCoach” will have a shared reference. This is a typical use case if we want to make use of stateless beans.

How ever, we can explicitly mention the scope type in the xml config file with ‘scope’ attribute as shown below :

![](Pasted%20image%2020240705155015.png)

Let’s look at the example below :

```xml
<!-- applicationContextSetterInjection.xml (xml config file) -->

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- Define your beans here -->
	<!-- dependency bean -->
	<bean id="myFortuneBean"
		class="com.busybox.setterInjection.HappyFortuneService"></bean>

	<!-- define bean injection as singleton, which is implicit -->
	<bean id="myCoach" class="com.busybox.setterInjection.TrackCoach"
		scope="singleton">
		<!-- setup setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>
	</bean>

	<bean id="baseBallCoach"
		class="com.busybox.setterInjection.BaseBallCoach">

		<!-- setup setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>
	</bean>


	<!-- load the property file -->
	<context:property-placeholder
		location="classpath:sport.properties" />
	<bean id="cricketCoach"
		class="com.busybox.setterInjection.CricketCoach">

		<!-- set up setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>

		<!-- injection for email id literal value -->
		<!-- <property name="emailAddress" value="busyboxhere@gmail.com"></property> -->

		<!-- injection for phone number literal value -->
		<!-- <property name="phoneNumber" value="8847848036"></property> -->

		<property name="phoneNumber" value="${phoneNumber}"></property>
		<property name="emailAddress" value="${emailAddress}"></property>

	</bean>

</beans>

```

```java
// SetterInjectionDriver.java  

package com.busybox.setterInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDriver {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextSetterInjection.xml");

		Coach trackCoach = context.getBean("myCoach", TrackCoach.class);

		// check for single tone scope by comparing trackCoach1 and trackCoach2
		Coach trackCoach1 = context.getBean("myCoach", TrackCoach.class);
		Coach trackCoach2 = context.getBean("myCoach", TrackCoach.class);

		Coach baseballCoach = context.getBean("baseBallCoach", BaseBallCoach.class);
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);

		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyFortune());

		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());

		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		System.out.println(cricketCoach.getEmailAddress());
		System.out.println(cricketCoach.getPhoneNumber());

		System.out.println("is trackCoach1==trackCoach2 ==> " + (trackCoach1 == trackCoach2));
		// is trackCoach1==trackCoach2 ==> true
		System.out.println("trackCoach1 memory address : "+trackCoach1);
		// trackCoach1 memory address : com.busybox.setterInjection.TrackCoach@2e6a8155
		System.out.println("trackCoach2 memory address : "+trackCoach2);
		// trackCoach2 memory address : com.busybox.setterInjection.TrackCoach@2e6a8155
		context.close();

	}

}

```

As we can see from the output the different beans point to same memory address.

## Prototype Scope 

In this type of scope, we will get a new instance of bean every time we request a bean.

![](Pasted%20image%2020240705155236.png)

So, every time we make a request for an object of ‘TrackCoach’ we will get different beans every time. This example is illustrated below : 

As we can see the diagram below, we have two different ‘TrackCoach’ objects in the memory.

![](Pasted%20image%2020240705155300.png)

This scope design is recommended if we want to maintain state full data.

Let’s see an example.

```xml
applicationContextSetterInjection.xml (xml config file) 

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- Define your beans here -->
	<!-- dependency bean -->

	<bean id="myFortuneBean"
		class="com.busybox.setterInjection.HappyFortuneService"></bean>

	<!-- define bean injection as prototype -->
	<bean id="myCoach" class="com.busybox.setterInjection.TrackCoach"
		scope="prototype">
		<!-- setup setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>
	</bean>

	<bean id="baseBallCoach"
		class="com.busybox.setterInjection.BaseBallCoach">

		<!-- setup setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>
	</bean>


	<!-- load the property file -->
	<context:property-placeholder
		location="classpath:sport.properties" />
	<bean id="cricketCoach"
		class="com.busybox.setterInjection.CricketCoach">

		<!-- set up setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>

		<!-- injection for email id literal value -->
		<!-- <property name="emailAddress" value="busyboxhere@gmail.com"></property> -->

		<!-- injection for phone number literal value -->
		<!-- <property name="phoneNumber" value="8847848036"></property> -->




		<property name="phoneNumber" value="${phoneNumber}"></property>
		<property name="emailAddress" value="${emailAddress}"></property>

	</bean>

</beans>
```

```java
// SetterInjectionDriver.java 
package com.busybox.setterInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDriver {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextSetterInjection.xml");

		Coach trackCoach = context.getBean("myCoach", TrackCoach.class);

		// check for single tone scope by comparing trackCoach1 and trackCoach2
		Coach trackCoach1 = context.getBean("myCoach", TrackCoach.class);
		Coach trackCoach2 = context.getBean("myCoach", TrackCoach.class);

		Coach baseballCoach = context.getBean("baseBallCoach", BaseBallCoach.class);
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);

		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyFortune());

		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());

		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		System.out.println(cricketCoach.getEmailAddress());
		System.out.println(cricketCoach.getPhoneNumber());

		System.out.println("is trackCoach1==trackCoach2 ==> " + (trackCoach1 == trackCoach2));
		System.out.println("trackCoach1 memory address : " + trackCoach1);
		System.out.println("trackCoach2 memory address : " + trackCoach2);

		context.close();

	}

}

// output : 

// is trackCoach1==trackCoach2 ==> false
// trackCoach1 memory address : com.busybox.setterInjection.TrackCoach@52719fb6
// trackCoach2 memory address : com.busybox.setterInjection.TrackCoach@3012646b


```

As we can see from the output the references are different and the bean references are completely.

Below are some other possible scopes for beans which we will see in the spring mvc section.

![](Pasted%20image%2020240705155424.png)

## Bean Life Cycle Methods

When the bean container starts, there are couple of things that happen. The beans are instantiated, then the actual dependencies are injected, next we have some **Internal Spring Processing.** After this we have option for adding our custom initialization code. In this initialization we can call business logic codes and manage resources like (db connection, sockets and files etc)

At this point the bean is ready to use and we can call methods on it.

When we close the context by calling ‘context.close()’ the spring container shuts down. At this point we have an option to call our own custom destroy method, in this destruction we can call business logic codes and manage cleaning up resources like (db connection, sockets and files etc .After this the entire bean cycle is over and the application shuts down.

![](Pasted%20image%2020240705155515.png)

![](Pasted%20image%2020240705155520.png)

### Init : method Configuration

![](Pasted%20image%2020240705155545.png)

### destroy : method configuration 

![](Pasted%20image%2020240705155613.png)

![](Pasted%20image%2020240705155619.png)

Now let’s consider the example below :

First we will create init and destroy methods inside the TrackCoach.java file.

```java
TrackCoach.java : 

package com.busybox.setterInjection;

public class TrackCoach implements Coach {

	// define a private field for dependency
	private FortuneService fortuneService;

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	// define a setter method for dependency injection
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.fortuneService.getFortune();
	}

	// add a bean life cycle init method

	void beanInitHook() {
		System.out.println("beanInitHook()");
	}

	// add a bean life cycle destroy method
	void beanDestroyHook() {
		System.out.println("beanDestroyHook()");
	}
}
```

Now as shown in the previous configurations we have to wire these methods inside the xml config file. This is shown below :

```xml
<!-- applicationContextSetterInjection.xml -->

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- Define your beans here -->


	<!-- dependency bean -->

	<bean id="myFortuneBean"
		class="com.busybox.setterInjection.HappyFortuneService"></bean>

	<!-- define bean injection as prototype -->
	<bean id="myCoach" class="com.busybox.setterInjection.TrackCoach"
		init-method="beanInitHook" destroy-method="beanDestroyHook">
		<!-- setup setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>
	</bean>

	<bean id="baseBallCoach"
		class="com.busybox.setterInjection.BaseBallCoach">

		<!-- setup setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>
	</bean>


	<!-- load the property file -->
	<context:property-placeholder
		location="classpath:sport.properties" />
	<bean id="cricketCoach"
		class="com.busybox.setterInjection.CricketCoach">

		<!-- set up setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>

		<!-- injection for email id literal value -->
		<!-- <property name="emailAddress" value="busyboxhere@gmail.com"></property> -->

		<!-- injection for phone number literal value -->
		<!-- <property name="phoneNumber" value="8847848036"></property> -->

		<property name="phoneNumber" value="${phoneNumber}"></property>
		<property name="emailAddress" value="${emailAddress}"></property>

	</bean>

</beans>

```

Now we have to create a driver class which will contain the `main()` method. This is where we retrieve the bean and the life cycle hook methods should execute.

```java
BeanScopeLifeCycleDriver.java : 

package com.busybox.setterInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeLifeCycleDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextSetterInjection.xml");
		
		Coach trackCoach = context.getBean("myCoach",TrackCoach.class);
		
		context.close();
		
	}

}

// output : 
// beanInitHook()
// beanDestroyHook()
```

**Special Note about init and destroy Method Signatures :**

1. **Access modifier :** The method can have any access modifier (public, protected, private)

2. **Return type :** The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.

3. **Method name :** The method can have any method name.

4. **Arguments :** The method cannot accept any arguments. The method should be _no-arg_.

**Special Note about Destroy Life cycle and Prototype Scope**

There is a subtle point we need to be aware of with "prototype" scoped beans. **_For "prototype" scoped beans, Spring does not call the destroy method._**

**In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean :** the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance.

Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, **in the case of prototypes, configured destruction lifecycle callbacks are not called**. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding.

This also applies to both XML configuration and Annotation-based configuration.

The class whose bean injection scope is configured as “prototype” must implement an interface **DisposableBean** which contains a “destroy()” method

We can destroy prototype beans but custom coding is required. Consider the development stops below :

1. Create a custom bean processor. This bean processor will keep track of prototype scoped beans. During shutdown it will call the destroy() method on the prototype scoped beans. The custom processor should be configured in the spring config file.

```xml
<!-- Bean custom processor to handle calling destroy methods on prototype 
	scoped beans -->
<bean id="customProcessor"
	class="com.luv2code.springdemo.MyCustomBeanProcessor">
</bean>

```

2. The prototype scoped beans MUST implement the `DisposableBean` interface. This interface defines a "destroy()" method.
3. The Spring configuration does not require use the destroy-method attribute. You can safely remove it.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- Define your beans here -->


	<!-- dependency bean -->

	<bean id="myFortuneBean"
		class="com.busybox.setterInjection.HappyFortuneService"></bean>

	<!-- define bean injection as prototype -->
	<!-- the scope is prototype for TrackCoach Bean the destroy-method hook will not be called -->
	<bean id="myCoach" class="com.busybox.setterInjection.TrackCoach"
		init-method="beanInitHook" destroy-method="beanDestroyHook" scope="prototype">
		<!-- setup setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>
	</bean>

	<bean id="baseBallCoach"
		class="com.busybox.setterInjection.BaseBallCoach">

		<!-- setup setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>
	</bean>


	<!-- load the property file -->
	<context:property-placeholder
		location="classpath:sport.properties" />
	<bean id="cricketCoach"
		class="com.busybox.setterInjection.CricketCoach">

		<!-- set up setter injection -->
		<property name="fortuneService" ref="myFortuneBean"></property>

		<!-- injection for email id literal value -->
		<!-- <property name="emailAddress" value="busyboxhere@gmail.com"></property> -->

		<!-- injection for phone number literal value -->
		<!-- <property name="phoneNumber" value="8847848036"></property> -->
		<property name="phoneNumber" value="${phoneNumber}"></property>
		<property name="emailAddress" value="${emailAddress}"></property>

	</bean>

</beans>

```