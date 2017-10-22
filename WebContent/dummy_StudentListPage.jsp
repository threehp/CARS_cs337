<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Class Started at ${time} <br>

<p>
Student attended this class:
<table border = '1' >
	<tr>
		<th>Name</th>
		<th>Student ID</th>
		<th>Entry Time</th>
	</tr>
	<c:forEach items="${StudentList }" var="list" varStatus = "listStatus">
		<tr>
			<td>${list.name }</td>
			<td>${list.student_ID }</td>
			<td>${list.entryTime }</td>
		</tr>

	</c:forEach>

</table>
</p>

<p>
	<a href="CARS">Done</a>
</p>
</body>
</html>