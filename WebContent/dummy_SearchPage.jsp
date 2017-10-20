<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dummy search response page</title>
</head>
<body>

<p>


<c:forEach items= "${StudentList }" var="list" varStatus="listStatus">

Hello, <strong>${list.name}</strong>
<br>
your student ID is <strong>${list.student_ID}</strong>. 
<br>
you punched at ${list.entryTime }

</c:forEach>


<br><br>
<a href="CARS">Done</a>



</p>
</body>
</html>