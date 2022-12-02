<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation Page</title>
</head>
<body>
	<!-- behind the scenes the student.getFirstName() is called -->
	<!-- behind the scenes the student.getLastName() is called -->
	Student is Confirmed : ${student.firstName} ${student.lastName}

	<br>
	<br> Country : ${student.country}

	<br>
	<br> > Favorite Language: ${student. favoriteLanguage}
	
	Operating Systems:

	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
		
			<li> ${temp} </li>
		
		</c:forEach>
	</ul>
</body>
</html>
