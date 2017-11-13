<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Add Class</p>


<form action='AddClass' method ='POST'>

<table>
	<tr>
		<td>Section #</td>
		<td>Class Name</td>
		<td>Teacher</td>		
	</tr>
	<tr>
		<td><input type='text' name='sectionID'></td>
		<td><input type='text' name='className'></td>
		<td><input type='text' name='teacherName'></td>
		<td><input type='submit' value='Add Class'>
	</tr>




</table>




</form>
</body>
</html>