## Spring MVC

What is Spring MVC ?
1.     It is a framework for building web applications in java
2.     It is based on Model-View-Controller design pattern.
3.     It leverages on core spring framework features like IoC and DI.

### Process flow in MVC

![[Ch-7/Images/image-1.png]]

So, we have an incoming request coming from the browser which will encounter the spring mvc front controller. This front controller will delegate the request to the controller code.

This controller section contains our business logic. We will also have our model adjusted in this business logic. This model is then passed to the front controller. Now this front controller will pass this model to the view template. View template is basically a HTML or JSP page which will take the model and will render the content to the browser.

We will cover this process of spring dealing with  web request in subsequent sections in more detail.

Benefits of using Spring MVC

1.     The spring way of building web app UI in java
2.     We can create and manage reusable UI components.
3.     Helps managing the state for web applications, session tracking and application tracking.
4.     We can process and validate the form data.
5.     We have flexible configuration for web layer.

Spring MVC behind the scenes

![[Ch-7/Images/image-2.png]]

![[Ch-7/Images/image-3.png]]

Everything starts with the incoming request and it will encounter something called as the **FrontController.** The FrontController is known as the **DispatcherServlet.** Now this DispatcherServlet is a part of spring framework which we don’t need to develop. This will be available for us to download as a jar.

This FrontController will delegate the request further.

As a developer we need to create the model, view and the controller. In a nutshell the model files will contain the data which will be processed by the controller and will be rendered by view template.

**Controller :**

![[Ch-7/Images/image-5.png]]

When the request reaches the FrontController it will delegate that request to Controller which will be created by the developer and will contain the business logic.

This controller will have code to handle the incoming request. We might right some logic to read some form data associated with the request and store the data in the models. Also, we can have additional code to perform crud operations with the database or interact with a web server.

Also, the controller will manage the data by putting them inside model files. Controller also takes the responsibility of sending proper model data to the proper view template so they get rendered properly.

**Model :**
![[Ch-7/Images/image-6.png]]

The model will contain our data. Models can also contain data resulting from data base operations and once we have the data then can be shipped to particular View Template for rendering. This model data can either be simple java object or collection.

**View Template :**

![[Ch-7/Images/image-7.png]]

Normally we will have a JSP page where we will display the data from the model into the view template.

## Example of Spring MVC Workflow:

1. **Client Request:** The client sends a request (e.g., a form submission) to the server.
    
2. **DispatcherServlet:** The `DispatcherServlet` intercepts the request and consults the `HandlerMapping` to find which controller should handle the request.
    
3. **Controller:** The appropriate controller (annotated with `@Controller`) is invoked. The controller handles the request and uses service classes to interact with the business logic. It updates the model with the required data.
    
4. **Model and View:** The controller returns a `ModelAndView` object that contains both the model and the view name.
    
5. **ViewResolver:** The `ViewResolver` uses the logical view name to map it to a specific view (e.g., a JSP page).
    
6. **View Rendering:** The view renders the data from the model and returns an HTML response to the client.

Setting up Spring MVC Config

1.     Add configurations to the file WEB-INF/web.xml (look point a & b )
		**a.**     **Configure Spring MVC Dispatcher Servlet**
		![[Ch-7/Images/image-8.png]]
		The above config file contains two sections
		     Location of the dispatcher servlet, this comes with spring jar so we just need to Provide the qualified **DispatcherServlet** class name as shown below ![[Ch-7/Images/image-9.png]]
		         In the next step as the initial parameter, we specify where the spring context configuration file is located.
			 ![[Ch-7/Images/image-10.png]]
	   **b.**     **Set up url mappings to Spring MVC Dispatcher Servlet**

		In this section we just tell our system for any incoming request, the request should be passed on to DispatcherServlet.

		By default in here the URL mapping is set to ‘/’ but this can be anything ‘/foo-bar’
		
	![[image-11.png]]
	Always remember the servlet-name in the servlet reference and the servlet-name in the servlet-mapping must always match.
	![[image-12.png]]
2.     Add configurations to the file WEB-INF/spring-mvc-demo-servlet.xml
		a.      Add support for component Scanning
		![[Ch-7/Images/image-13.png]]
		
		b.      Add support for conversion, formatting and validation
		![[Ch-7/Images/image-14.png]]
		c.      Configure Spring MVC View Resolver (how do we display the pages or where are the pages located)
		![[Ch-7/Images/image-15.png]]
		![[Ch-7/Images/image-16.png]]
		![[Ch-7/Images/image-17.png]]
		![[Ch-7/Images/image-18.png]]
	Creating a Spring Home Controller and View :
	![[Ch-7/Images/image-19.png]]
Development Process :

1.     Create Controller Class
	![[Ch-7/Images/image-20.png]]
2.     Define Controller Method
	![[Ch-7/Images/image-21.png]]
3.     Add request mapping to Controller Method
	![[Ch-7/Images/image-22.png]]
	This request mapping will handle all sorts of HTTP requests.
	4.     Return the View Name
	![[Ch-7/Images/image-23.png]]
	![[Ch-7/Images/image-24.png]]
	5.     Develop the view page.
	![[Ch-7/Images/image-25.png]]

**HomeController.java :**

```java
package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		return "main-menu"; //WEB-INF/view/main-menu.jsp
	}
}
```

Main-menu.jsp

```jsp
<html>
<head>

<title>Spring MVC HOME Page</title>
</head>
<body>

	<h1>Spring MVC HOME Page</h1>
</body>
</html>
```

Web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	id="WebApp_ID" version="3.1">

	<display-name>spring-mvc-demo</display-name>

	<absolute-ordering />

	<!-- Spring MVC Configs -->

	<!-- Step 1: Configure Spring MVC Dispatcher Servlet -->
	<servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<!-- Step 2: Set up URL mapping for Spring MVC Dispatcher Servlet -->
	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
	
</web-app>

```

**Spring-mvc-demo-servlet.xml :**

```xml
<?xml version=”1.0” encoding=”UTF-8”?>
<beans xmlns=”http://www.springframework.org/schema/beans”
	xmlns:xsi=”http://www.w3.org/2001/XMLSchema-instance”
	xmlns:context=”http://www.springframework.org/schema/context”
	xmlns:mvc=”http://www.springframework.org/schema/mvc”
	xsi:schemaLocation=”
		http://www.springframework.org/schema/beans
    	http://www.springframework.org/schema/beans/spring-beans.xsd
    	http://www.springframework.org/schema/context
    	http://www.springframework.org/schema/context/spring-context.xsd
    	http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd”>

	<!—Step 3: Add support for component scanning 
	<context:component-scan
		base-package=”com.luv2code.springdemo” />
	
	<!—Step 4: Add support for conversion, formatting and validation support 
	<mvc:annotation-driven />

	<!—Step 5: Define Spring MVC view resolver 
	<bean
		class=”org.springframework.web.servlet.view.InternalResourceViewResolver”>
		<property name=”prefix” value=”/WEB-INF/view/” />
		<property name=”suffix” value=”.jsp” />
	</bean>

</beans>

```

So we will create a form where the user will enter in its name, we will reflect the data in a jsp page.

 Development Process :
1.     Create Controller Class : HelloWorldController
2.     Show HTML form
	a.      Create a controller method to show a controller form
	b.     Create a view page for HTML form
3.     Process HTML form
	a.      Create a controller method to process HTML form.
	b.     Develop view  corresponding page

![[Ch-7/Images/image-26.png]]

HelloWorldController.java:

```java
package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// create a controller method to show initial html form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form"; // WEB-INF/view/hellowworld-form.jsp
	}

	// create a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

}

```

**Helloworld-form.jsp**
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World - Input Form</title>
</head>
<body>
	<form action="processForm" method="get">
		<input type="text" name="studentName" placeholder="what's your name">
		<input type="submit">
	</form>
</body>
</html>
```

HelloWorld.jsp

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	<h1>Hello World of Spring</h1>
	<p>Student name is ${param.studentName}</p>
</body>
</html>

```

Adding Data to Spring Model
![[Ch-7/Images/image-27.png]]
![[Ch-7/Images/image-28.png]]

Well in the following coding examples we are going to do the following :
![[Ch-7/Images/image-29.png]]

![[Ch-7/Images/image-30.png]]

The controller methods are very flexible in terms of receiving arguments. We get the request object and the model object. Initially the model will be empty and as we go through our application we keep on adding data to the model which can be accessed from the JSP page as shown below.

![[Ch-7/Images/image-31.png]]

```java
HelloWorldController.java : ( with added @RequestParam(“__”) )
package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// create a controller method to show initial html form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form"; // WEB-INF/view/hellowworld-form.jsp
	}

	// create a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// add a new controller method to read data from the form
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String shoutOut(HttpServletRequest request, Model model) {

		// read the request parameter from the HTML form
		String studentName = request.getParameter("studentName");

		// convert all data to upper case
		String upperCaseName = studentName.toUpperCase();

		// create our message
		String message = "yo !! " + upperCaseName;

		// add message to model data
		model.addAttribute("message", message);

		return "helloworld-version-two";
	}

	@RequestMapping("/processFormVersionThree")
	public String processFormMethodThree(@RequestParam("studentName") String studentName, Model model) {

		// convert all data to upper case
		String upperCaseName = studentName.toUpperCase();

		// create our message
		String message = "yo Buoy !! " + upperCaseName;

		// add message to model data
		model.addAttribute("message", message);

		return "helloworld-version-two";
	}

}

Output (only final page is shown): 

```