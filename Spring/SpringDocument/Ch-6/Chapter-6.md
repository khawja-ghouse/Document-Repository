Spring Container Config with Java : No XML

In this section we will learn to configure Spring container with java annotation without requiring a config XML file.

![[Ch-6/images/image-1.png]]

Various ways of Configuring a Spring Container

![[Ch-6/images/image-2.png]]


**Development process for config with no XML :**

1.     Create a java class and annotate using **@Configuration**
![[Ch-6/images/image-3.png]]
2.  Add recursive component scanning using **@ComponentScan** (optional step)
   ![[Ch-6/images/image-4.png]]
3. Read java configuration class, retrieve bean and call methods on the bean.
   ![[Ch-6/images/image-5.png]]
4. Retrieve bean from Spring container
   ![[Ch-6/images/image-6.png]]

Implementing above steps with code.

SportConfig.java (Configuration Class)
```java
package com.busybox.spring.anotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.khwaja.spring.anotations") // optional
public class SportConfig {

}
```

FortuneService.java :

```java
package com.busybox.spring.anotations;

public interface FortuneService {
	public String getDailyFotune();
}

```

**FortuneServiceImpl.java :**

```java
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

Coach.java:

```java
package com.busybox.spring.anotations;

public interface Coach {

	public String getDailyWorkout();

	public String getDailyFortune();
}

```

TenniseCoach.java:

```java
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

**NoXMLJavaConfigDriver.java :**

```java
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

Output :

TennisCoach() no-arg constructor

beanInitHook()

Learn to Swing your racket

well some good Fortune

beanDestroyHook()
```

Define beans with Java Config : No XML

![[Ch-6/images/image-7.png]]

**Development Process :**

**1.**   Define a method to expose bean with **@Bean**

![[Ch-6/images/image-8.png]]

Well, here were are not doing a component scan to retrieve bean. In the java config file each and every bean is going to be defined individually. The method name to retrieve bean (in this case **swimCoach**) becomes the bean ID and gets registered in the spring container.

**2.**  Inject bean dependencies
![[Ch-6/images/image-9.png]]

**3.**     Read Spring Java  configuration class

![[Ch-6/images/image-10.png]]

**4.**     Retrieve bean from Spring container
![[Ch-6/images/image-11.png]]

```java
FortuneService.java : 
package com.busybox.spring.anotations;

public interface FortuneService {
	public String getDailyFotune();
}

FortuneServiceImpl.java : 
package com.busybox.spring.anotations;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	@Override
	public String getDailyFotune() {

		return "well some good Fortune ";
	}

}

SadFortuneService.java : 
package com.busybox.spring.anotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFotune() {

		return "Today is a sad Day :(";
	}

}

SwimCoach.java : 
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

SportConfig.java : (java config file)

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

NoXMLJavaConfigDriver : 
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

Output : 
TennisCoach() no-arg constructor
beanInitHook()
Learn to Swing your racket
well some good Fortune 
swim 1000 meters as a warm up !!
Today is a sad Day :(
beanDestroyHook()

```

Injecting Values from Property Files

**Development Process :**

1.     Create a properties file
		![[Ch-6/images/image-12.png]]
2.     Load the properties file in the spring config.
		![[Ch-6/images/image-13.png]]
	SportsConfig.java
```java

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

3.     Reference the values from properties file.

![[Ch-6/images/image-14.png]]

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

NoXMLJavaConfigDriver.java : 
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