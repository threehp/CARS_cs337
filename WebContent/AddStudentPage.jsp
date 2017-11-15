<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Link href = "css/AddStudentPage.css" rel="stylesheet" type="text/css"> 

</head>

<body>
<p>Add Student</p>

<form action='AddStudent' method ='POST'>

<table>
	<tr>
		<td>Name</td>
		<td>Card ID</td>
		<td>Student ID</td>		
	</tr>
	<tr>
		<td><input type='text' name='studentName'></td>
		<td><input type='text' name='card_ID'></td>
		<td><input type='text' name='student_ID' required></td>		
	</tr>

	<tr>
		<td colspan="2" class = "Label2">Belongs to class (check all applicable:) </td>	
		
		<td ><input type='submit' value='Add Student'>
	</tr>
	<c:forEach items="${ClassList }" var="list" varStatus = "listStatus">
		<tr>		
			<td colspan="2" class = "Label2">
			<input type ="checkbox" name="section_ID" value="${list.section_ID }">
			${list.section_ID} - ${list.className }		
			</td>
					
		</tr>			
	</c:forEach>


</table>

</form>

</body>
</html>