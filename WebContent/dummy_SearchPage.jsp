<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Link href = "css/SearchPageStyle.css" rel="stylesheet" type="text/css"> 
<title>dummy search response page</title>
</head>
<body class="Text">

<div class="popup">
			<c:forEach items= "${StudentList }" var="list" varStatus="listStatus" >
			
			<p style="color:Black;"> Hello, <strong>${list.name}</strong>
			<br>
			your student ID is <strong>${list.student_ID}</strong>. 
			<br>
			you punched at ${list.entryTime }
			</p>
			</c:forEach>
	
</div>
<form action="CARS" method="get">
<INPUT class="button"  TYPE='submit' value="Done" >

</form>
</body>
</html>