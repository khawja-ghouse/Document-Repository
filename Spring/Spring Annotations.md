
## @Autowire
The `@Autowired` annotation in Spring is used for automatic dependency injection. It tells the Spring container to automatically inject a dependent object into your bean when it's created. This annotation can be used in various Spring components, like classes marked with `@Component`, `@Service`, or `@Repository`, or even in configuration classes marked with `@Configuration`.

## @Qualifer
The `@Qualifier` annotation in the Spring framework is used in conjunction with the `@Autowired` annotation to specify which bean should be injected when there are multiple beans of the same type. It provides a way to disambiguate between beans and helps Spring determine which specific bean should be injected into a particular dependency.

## @Configuration
The `@Configuration` annotation in the Spring framework is used to indicate that a Java class defines Spring Bean configuration. It's part of Spring's Java-based configuration approach, which provides an alternative to XML-based configuration. When a class is marked with `@Configuration`, it tells Spring that the class contains bean definitions and other configuration settings for the Spring application context.

Here are some key uses and characteristics of the `@Configuration` annotation:
1. **@Bean**  Method Definition 
   Inside a `@Configuration` class, you can use the `@Bean` annotation on methods to define Spring beans. These methods return instances of the beans that Spring will manage. You can also specify dependencies and other configurations within these methods.
```java
@Configuration
public class MyConfiguration {
    @Bean
    public MyService myService() {
        return new MyService();
    }
    @Bean
    public MyRepository myRepository() {
        return new MyRepositoryImpl();
    }
}

```
2. **@ComponentScan** 
   `@Configuration` classes are often used in conjunction with component scanning. You can use `@ComponentScan` to specify the base package(s) where Spring should look for components and `@Configuration` classes. This way, Spring can discover and register these beans in the application context.
   ```java
@Configuration
@ComponentScan(basePackages = "com.example")
public class MyConfiguration {
    // @Bean definitions and other configuration settings
}

```
3. **@PropertySource**
   You can use `@PropertySource` in combination with `@Configuration` classes to specify property sources for the application. This is useful for loading external configuration properties into the Spring environment.
```java
@Configuration
@PropertySource("classpath:myapp.properties")
public class MyConfiguration {
    // ...
}
```

4. **@Import**
   You can use the `@Import` annotation to import other `@Configuration` classes into a configuration class. This is useful for modularizing and organizing configuration settings.
   ```JAVA
@Configuration
@Import({DataSourceConfig.class, SecurityConfig.class})
public class MyApplicationConfig {
    // ...
}
```

## @EnableWebMvc
The `@EnableWebMvc` annotation is a configuration annotation in Spring that is used to enable the Spring Web MVC framework in your application. It is typically used in combination with Java-based configuration and can be added to a configuration class. This annotation tells Spring to set up the necessary infrastructure for building web applications, including configuring the DispatcherServlet and enabling the MVC features provided by Spring.

**Spring Boot**: If you are building a Spring Boot application, you generally don't need to use `@EnableWebMvc` explicitly because Spring Boot provides auto-configuration for Spring MVC. Spring Boot automatically configures the MVC components based on your project's dependencies and properties.
## @Component
The `@Component` annotation in the Spring framework is a fundamental annotation used to indicate that a Java class is a Spring component. It's a part of Spring's component scanning and auto-detection mechanism, allowing Spring to automatically discover and manage these components in the Spring application context.
Key points about the `@Component` annotation:

1. **Spring Component**: When you mark a class with `@Component`, you're essentially telling Spring that this class should be managed as a Spring bean. Spring will create and configure instances of these classes, and you can then use them throughout your application.
2. **Component Scanning**: Spring scans the specified base packages for classes marked with `@Component` during application startup. It identifies these classes, creates instances, and registers them in the Spring container.
3. **Auto-Detection**: Classes marked with `@Component` are auto-detected by Spring, which means you don't need to declare these beans explicitly in XML configuration or Java-based configuration classes. Spring automatically manages them.
4. **Default Name**: By default, the name of the bean is generated from the class name with a lowercase initial letter. For example, if you have a class `MyService`, the bean name will be "myService." You can customize the bean name using the `value` attribute of the `@Component` annotation.
```JAVA
@Component("customService")
public class MyService {
    // ...
}
```


In Spring, stereotype annotations are a set of special-purpose annotations that provide metadata about the roles and responsibilities of certain classes within the application. These annotations help in classifying and organizing Spring components, making it easier to understand the purpose of each class and facilitating the Spring container's configuration and auto-discovery of these components. The most commonly used stereotype annotations in Spring are:
**@Component @Controller @Services @Repository @Configuration @RestController**

## @RestController
In Spring, `@RestController` is a special type of annotation used to define a class as a RESTful controller. It's a combination of `@Controller` and `@ResponseBody`. When you annotate a class with `@RestController`, it implies that each method within the class is a controller action responsible for handling HTTP requests and returning the response as data (usually in a serialized format like JSON or XML)

	@ResponseBody
	The `@ResponseBody` annotation in Spring is used to indicate that the return value of a controller method should be treated as the response body in an HTTP response, rather than being resolved to a view name or template. It's typically used in combination with `@Controller` to create a RESTful web service or to return data directly in the response body of a traditional web application.
	
	@Controller
	The `@Controller` annotation is a fundamental component in the Spring Framework and is used to mark a class as a Spring MVC controller. It's primarily used in traditional web applications to handle HTTP requests and route them to appropriate methods for processing. A controller class typically contains methods (handler methods) that respond to specific HTTP requests.
	
	Each method within the class can be annotated with various HTTP request mapping annotations (e.g., `@GetMapping`, `@PostMapping`, `@RequestMapping`) to specify which types of requests it should handle and the URL paths associated with those requests
	

## @RequestMapping
The `@RequestMapping` annotation is a fundamental annotation in the Spring Framework used in Spring MVC to map web requests to specific handler methods in a controller. It allows you to define which URLs should trigger a particular controller method. The `@RequestMapping` annotation is applied at both the class and method levels, providing flexibility in mapping request paths.

- value or path = URL path or paths to which the method should respond.
- method = Specifies the HTTP request method (GET, POST, PUT, DELETE, etc.) that the method.
- params = `@RequestMapping(params = "paramName")`
- headers = `@RequestMapping(headers = "headerName")`
- consumes = `@RequestMapping(consumes = "mediaType")`
- produces = `@RequestMapping(produces = "mediaType")`


The `@RequestMapping` annotation in Spring is a versatile annotation that allows you to map controller methods to specific URL paths and HTTP request methods. It can be used to handle various types of requests, including GET, POST, PUT, DELETE, and more.

On the other hand, the `@GetMapping` and `@PostMapping` annotations are specialized versions of `@RequestMapping` that are designed for handling specific HTTP request methods. These annotations simplify the code and provide a more explicit and readable way to define mappings for GET and POST requests, respectively.

**NOTE:** 
- **@XmlRootElement** not a Spring framework annotation but used along with Spring if in case you want the response to have in XML.
- In Spring Framework if we need the response to support Mediatype JSON/XML we need to add additional 
  JSON and XML handler in pom like jakson for JSON and jaxB for XML.

## @Service
The `@Service` annotation is one of the stereotypes provided by the Spring Framework and is used to annotate classes as service components. Service components in Spring are typically used to encapsulate business logic and provide services to other parts of your application. They are commonly used in the service layer of a Spring application, which serves as an intermediary between the controller (presentation layer) and the data access layer (e.g., repositories or DAOs).


