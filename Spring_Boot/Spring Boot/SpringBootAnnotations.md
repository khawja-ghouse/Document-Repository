1.  **@SpringBootApplication**
	`@SpringBootApplication` annotation is a shortcut that combines the functionality of three other annotations:
	- `@Configuration`: This annotation indicates that a class provides Spring bean definitions. These are essentially objects managed by the Spring framework.
	- `@EnableAutoConfiguration`: This one tells Spring Boot to automatically configure a lot of things for your application based on the libraries you have on your classpath and other beans in your application. This saves you a bunch of configuration work.
	- `@ComponentScan`: This annotation tells Spring to scan a specific package (and its sub-packages) for classes annotated with `@Component`, `@Controller`, `@Service`, or other Spring stereotypes. This way, Spring can find these classes and create beans from them.
	  
2. **@RestController**
   The `@RestController` annotation is a convenient way to build controllers for RESTful web services. It's essentially shorthand for using both `@Controller` and `@ResponseBody` annotations together.
	- `@Controller`: This marks a class as a Spring MVC controller, which handles incoming HTTP requests.
	- `@ResponseBody`: This tells Spring to automatically serialize the object returned from a controller method into the response body. This is ideal for REST APIs that return data in formats like JSON or XML
		NOTE: By using `@RestController`, you don't need to annotate every method in your controller class with `@ResponseBody`. This makes your code cleaner and reduces redundancy.
		
3. **@RequestMapping**
 - This annotation is a general-purpose annotation used to map web requests to handler methods of Spring MVC and Spring WebFlux.
 - It can be **applied at the class level and/or method level**.
 - You can specify various attributes such as path, method, headers, consumes, produces, etc., to narrow down the mapping.
	- **`@GetMapping`**: This annotation is used to handle HTTP GET requests on a specific endpoint. It's a shortcut for `@RequestMapping(method = RequestMethod.GET)`.   
	- **`@PostMapping`**: This annotation is used to handle HTTP POST requests on a specific endpoint. It's a shortcut for `@RequestMapping(method = RequestMethod.POST)`. POST requests are typically used to create or submit data to the server.
	- `@PutMapping`: Used for handling HTTP PUT requests, which are typically used for updating resources.
	- `@DeleteMapping`: Used for handling HTTP DELETE requests, which are typically used for deleting resources.
	- `@PatchMapping`: Used for handling HTTP PATCH requests, which are used for partial updates of resources.
	 Benefits of using these annotations over @RequestMapping
	 - **Clarity and Readability**: They make your code more readable and self-documenting by explicitly specifying the expected HTTP method for each handler method.
	- **Improved Maintainability**: By separating concerns, it's easier to understand what type of request a method is supposed to handle.
	- **RESTful API Design**: These annotations promote the development of RESTful APIs by ensuring controllers handle requests according to the intended HTTP methods.
5. **@PathVariable**
   The `@PathVariable` annotation is a powerful tool for extracting data from the URL path itself. It allows you to capture dynamic values within the path and use them in your controller methods.
	```java
	@GetMapping("/getUserById/{userId}")
	public User getUserByID(@PathVariable long userId) {
		if (userService.getUserById(userId) == null) {
		throw new UserNotFoundException("User Id not found - " + userId);
		}
		return userService.getUserById(userId);
	}
   ```
	The name of the annotation attribute (`value` or `name`) specifies the name you want to use for the path variable. This name should match the placeholder name in the URL. Spring intercepts incoming requests and matches them to controller methods based on the URL pattern. When a match is found, Spring extracts the corresponding value from the URL path that aligns with the placeholder and assigns it to the method parameter annotated with `@PathVariable`.
	You can mark `@PathVariable` parameters as optional using the `required` attribute set to `false`. This allows handling scenarios where the path variable might be missing in the request.
6. **@ExceptionHandler**

	There are two ways to use `@ExceptionHandler`:
	1. **Local Exception Handling:** You can define an `@ExceptionHandler` method within a      controller class. This method will only handle **exceptions thrown from methods within that specific controller**.
	    
	2. **Global Exception Handling:** By creating a class annotated with `@ControllerAdvice`, you can define methods with `@ExceptionHandler` to handle **exceptions thrown from any controller in your application**. This is a more centralized approach to exception handling.

7. **@Repository**
   The `@Repository` annotation is a stereotype annotation in Spring Boot that marks a class as a repository bean. A repository bean is responsible for performing data access operations on a specific type of entity (domain object) using JPA (Java Persistence API). When you apply `@Repository` to a class, Spring Boot automatically detects it during component scanning.
   
   **Relationship with Spring Data JPA**
	- Spring Data JPA builds upon the `@Repository` annotation by providing interfaces that extend `Repository` (the base interface).
	- These extended interfaces, like `CrudRepository`, `JpaRepository`, and `PagingAndSortingRepository`, offer a broader range of data access methods.
	- By extending these interfaces, your repository class inherits their functionality, reducing boilerplate code and streamlining data access.
