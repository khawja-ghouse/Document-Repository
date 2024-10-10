# Spring Container Config with Java : No XML

In this section we will learn to configure Spring container with java annotation without requiring a config XML file.

![](Pasted%20image%2020240708160336.png)

## Various ways of Configuring a Spring Container

![](Pasted%20image%2020240708160359.png)

## Development process for config with no XML : 

1.	Create a java class and annotate using `@Configuration`

![](Pasted%20image%2020240708160433.png)

2.	Add recursive component scanning using `@ComponentScan` (optional step)

![](Pasted%20image%2020240708160510.png)

3.	Read java configuration class, retrieve bean and call methods on the bean.

![](Pasted%20image%2020240708160525.png)

4. Retrieve bean from the spring container

![](Pasted%20image%2020240708160551.png)

```java
// SportConfig.java : (Configuration Class)
package com.busybox.spring.anotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.busybox.spring.anotations") // optional
public class SportConfig {

}
```

```java
// FortuneService.java 
package com.busybox.spring.anotations;

public interface FortuneService {
	public String getDailyFotune();
}
```

```java
// FortuneServiceImpl.java 
package com.busybox.spring.anotations;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getDailyFotune() {

		return "well some good Fortune ";
	}

}
```

```java
// Coach.java 
package com.busybox.spring.anotations;

public interface Coach {

	public String getDailyWorkout();

	public String getDailyFortune();
}
```

```java
// TennisCoach.java 

package com.busybox.spring.anotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fortuneServiceImpl")
	FortuneService fortuneService;

	@Value("${name}")
	private String name;

	@Value("${profession}")
	private String profession;

	public TennisCoach() {
		System.out.println("TennisCoach() no-arg constructor");
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

	// define bean init method
	@PostConstruct
	public void beanInitHook() {
		System.out.println("beanInitHook()");
	}

	// define bean destroy method
	@PreDestroy
	public void beanDestroyHook() {
		System.out.println("beanDestroyHook()");
	}

}
```

```java
// NoXMLJavaConfigDriver.java 
package com.busybox.spring.anotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXMLJavaConfigDriver {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);

		// call a method on the bean
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());

		// print values referenced from properties file
		System.out.println(tennisCoach.getName());
		System.out.println(tennisCoach.getProfession());
		
		// close the context
		context.close();

	}

}

// Output :
// TennisCoach() no-arg constructor
// beanInitHook()
// Learn to Swing your racket
// well some good Fortune
// beanDestroyHook()
```

## Define beans with Java Config : No XML

![](Pasted%20image%2020240708161014.png)

### Development Process : 

1.	Define a method to expose bean with `@Bean`

![](Pasted%20image%2020240708161103.png)

Well, here were are not doing a component scan to retrieve bean. In the java config file each and every bean is going to be defined individually. 

The method name to retrieve bean (in this case `swimCoach`) becomes the bean ID and gets registered in the spring container.

2.	Inject bean dependencies

![](Pasted%20image%2020240708161158.png)

3.	Read Spring Java  configuration class

![](Pasted%20image%2020240708161238.png)

4.	Retrieve bean from Spring container

![](Pasted%20image%2020240708161250.png)

```java
// FortuneService.java 
package com.busybox.spring.anotations;

public interface FortuneService {
	public String getDailyFotune();
}
```

```java
// FortuneServiceImpl.java 
package com.busybox.spring.anotations;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getDailyFotune() {

		return "well some good Fortune ";
	}

}
```

```java
// SadFortuneService.java 
package com.busybox.spring.anotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFotune() {

		return "Today is a sad Day :(";
	}

}
```

```java
// SwimCoach.java 
package com.busybox.spring.anotations;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "swim 1000 meters as a warm up !!";
	}

	@Override
	public String getDailyFortune() {

		return this.fortuneService.getDailyFotune();
	}
}

```

```java
// SportConfig.java : (java config file)

package com.busybox.spring.anotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.busybox.spring.anotations") // optional
public class SportConfig {

	// define bean for SadFortuneService
	@Bean
	FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for SwimCoach and Inject dependency
	@Bean
	SwimCoach swimCoach() {
		return new SwimCoach(this.sadFortuneService());
	}

}
```

```java
// NoXMLJavaConfigDriver 
package com.busybox.spring.anotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXMLJavaConfigDriver {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		Coach swimCoach = context.getBean("swimCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());

		// print values referenced from properties file
		System.out.println(tennisCoach.getName());
		System.out.println(tennisCoach.getProfession());

		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}

// output : 
// TennisCoach() no-arg constructor
// beanInitHook()
// Learn to Swing your racket
// well some good Fortune 
// swim 1000 meters as a warm up !!
// Today is a sad Day :(
// beanDestroyHook()

```

### During All Java Configuration, how does the @Bean annotation work in the background?

For this code : 

```java
@Bean
SwimCoach swimCoach() {
	return new SwimCoach();
}
```

At a high-level, Spring creates a bean component manually. By default, the scope is singleton. So, any request for a "swimCoach" bean, will get the same instance of the bean since singleton is the default scope.

However, let's break it down line-by-line

#### @Bean
The `@Bean` annotation tells Spring that we are creating a bean component manually. We didn't specify a scope so the default scope is singleton.

```java
Coach swimCoach() {
}
```

This specifies that the bean will bean id of `swimCoach`. The method name determines the bean id. The return type is the `Coach` interface. This is useful for dependency injection. This can help Spring find any dependencies that implement the Coach `interface`.

The `@Bean` annotation will intercept any requests for `swimCoach` bean. Since we didn't specify a scope, the bean scope is singleton. As a result, it will give the same instance of the bean for any requests.

```java
return new SwimCoach();
```

This above code returns an instance of the `swimCoach`.

Now let's step back and look at the method in it's entirety.

```java
@Bean 
 public Coach swimCoach() {   
   SwimCoach mySwimCoach = new SwimCoach();   
   return mySwimCoach; 
 }
```

It is important to note that this method has the `@Bean` annotation. The annotation will intercept ALL calls to the method `swimCoach()`. Since no scope is specified the `@Bean` annotation uses singleton scope. Behind the scenes, during the `@Bean` interception, it will check in memory of the Spring container (`applicationContext`) and see if this given bean has already been created.

If this is the first time the bean has been created then it will execute the method as normal. It will also register the bean in the application context. So that is knows that the bean has already been created before. Effectively setting a flag.

The next time this method is called, the `@Bean` annotation will check in memory of the Spring container (`applicationContext`) and see if this given bean has already been created. Since the bean has already been created (previous paragraph) then it will immediately return the instance from memory. It will not execute the code inside of the method. Hence this is a singleton bean.

The code ,

```java
SwimCoach mySwimCoach = new SwimCoach(); 
return mySwimCoach;
```

is not executed for subsequent requests to the method `public Coach swimCoach()` . This code is only executed once during the initial bean creation since it is singleton scope.

Now let’s understand how the dependency is injected :

```java
return new SwimCoach(sadFortuneService())
```

This code creates an instance of `SwimCoach`. Note the call to the method `sadFortuneService()`. We are calling the annotated method above. The `@Bean` will intercept and return a singleton instance of `sadFortuneService`. The `sadFortuneService` is then injected into the swim coach instance.

## Injecting Values from Property Files

In this section we will how to inject values from properties files.

### Development Process : 

1.	Create a properties file

![](Pasted%20image%2020240708183831.png)

```properties
## Sport.properties 
name = Rick Sanchez
profession = Mad Scientist
```

2.	Load the properties file in the spring config.

![](Pasted%20image%2020240708183908.png)

```java
// SportConfig.java 

package com.busybox.spring.anotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.busybox.spring.anotations") // optional
@PropertySource("classpath:sport.properties") // loaded sport.properties file from class path
public class SportConfig {

	// define bean for SadFortuneService
	@Bean
	FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for SwimCoach and Inject dependency
	@Bean
	SwimCoach swimCoach() {
		return new SwimCoach(this.sadFortuneService());
	}

}
```

3.	Reference the values from properties file.

![](Pasted%20image%2020240708184007.png)

```java
SwimCoach.java : 
package com.busybox.spring.anotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${name}")
	private String name;

	@Value("${profession}")
	private String profession;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getName() {
		return name;
	}

	public String getProfession() {
		return profession;
	}

	@Override
	public String getDailyWorkout() {

		return "swim 1000 meters as a warm up !!";
	}

	@Override
	public String getDailyFortune() {

		return this.fortuneService.getDailyFotune();
	}
}
```

```java
// NoXMLJavaConfigDriver.java 
package com.busybox.spring.anotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXMLJavaConfigDriver {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());

		// print values referenced from properties file
		System.out.println(swimCoach.getName()); // Rick Sanchez
		System.out.println(swimCoach.getProfession()); // Mad Scientist

		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());

		// close the context
		context.close();

	}

}
```