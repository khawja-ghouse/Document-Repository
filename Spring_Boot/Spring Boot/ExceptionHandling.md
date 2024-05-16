Development Process
1. Create a custom error response class
2. Create a custom exception 
3. Update REST service to throw exception if student not found
4. Add exception handler method using **@ExceptionHandler**

1. Creating error response class
```java
package com.skg.springdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserErrorResponse {

private int status;
private String message;
private long timeStamp;

}
```

2. Creating a Custom Exception Class
```java
package com.skg.springdemo.exception;

public class UserNotFoundException extends RuntimeException {
/**
*
*/
private static final long serialVersionUID = 1L;
public UserNotFoundException() {
super();
// TODO Auto-generated constructor stub
}

public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,boolean writableStackTrace) {
super(message, cause, enableSuppression, writableStackTrace);
// TODO Auto-generated constructor stub
}

public UserNotFoundException(String message, Throwable cause) {
super(message, cause);
// TODO Auto-generated constructor stub
}

public UserNotFoundException(String message) {
super(message);
// TODO Auto-generated constructor stub
}

public UserNotFoundException(Throwable cause) {
super(cause);
// TODO Auto-generated constructor stub
}

}
```

3. Update REST service to throw exception if USER not found
```java
@GetMapping("/getUserById/{userId}")
public User getUserByID(@PathVariable long userId) {

	if (userService.getUserById(userId) == null) {
		throw new UserNotFoundException("User Id not found - " + userId);
	}
	
	return userService.getUserById(userId);
}
```
4. Add exception handler method using **@ExceptionHandler**
```java
// Add exception handler using @ExceptionHandler
@ExceptionHandler
public ResponseEntity<UserErrorResponse> handelException(UserNotFoundException ex) {
// create a userErrorResponse
UserErrorResponse errorResponse = new UserErrorResponse();
errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
errorResponse.setMessage(ex.getMessage());
errorResponse.setTimeStamp(System.currentTimeMillis());

// return ResponseEntity
return new ResponseEntity<UserErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);

}
```