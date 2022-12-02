<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
	<!-- modelAttribute is used to reference the Student model -->
	<form:form action="processForm" modelAttribute="student">
		<!-- This path attribute is very vital role here.
			
				 This attribute is used to reference property in the student model object
				 So when the form is rendered spring will call student.getFirstName() for path="firstName"
				 and it will also call student.getLastName() for path="lastName" 
				
				 So if we have some value inside the student object the form will load with
				 pre populated values.	 
			 -->

		<!-- behind the scenes the student.getFirstName() is called -->
				First Name : <form:input path="firstName" />
		<br>

		<!-- behind the scenes the student.getLastName() is called -->
				Last Name  : <form:input path="lastName" />
		<br>

		<!-- behind the scenes the student.getLastName() is called -->
				country : <form:select path="country">
			<%-- <form:option value="India" label="India" />
			<form:option value="France" label="France" />
			<form:option value="Australia" label="Australia" /> --%>

			<form:options items="${student.countryOptions}" />
		</form:select>

		<br>
		<br>

Favorite Language:

Java <form:radiobutton path="favoriteLanguage" value="Java" />
C# <form:radiobutton path="favoriteLanguage" value="C#" />
PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

		<br>
		<br>

		<!-- Now when we submit the form spring will call student.setFirstName(...) for path="firstName"
					 also it will call student.setLastName(...) for path="lastName" with this any value we
					 entered into the form fields will be bound to the model and will be accessible in the
					 controller method for further processing
				 -->

		<br>
		<br>
Operating Systems:
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
        MS Windows <form:checkbox path="operatingSystems" value="MS Window" />
		<input type="submit" value="submit">
	</form:form>
</body>
</html>
