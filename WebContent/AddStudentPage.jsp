<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Link href = "css/AddStudentPage.css" rel="stylesheet" type="text/css"> 
</head>

<body>
<p class = "Label1">Add Student</p>

<form action='AddStudent' method ='POST'>

<table>
	<tr class = "Table1">
		<td>Name</td>
		<td>Card ID</td>
		<td>Student ID</td>		
	</tr>
	<tr>
		<td><input type='text' name='studentName'></td>
		<td><input type='text' name='cardID'></td>
		<td><input type='text' name='studnetID'></td>		
	</tr>

	<tr>
		<td class = "Label2">Belongs to class: 
			<select>
				<c:forEach items="${ClassList }" var="list" varStatus = "listStatus">
					<option name='section_ID' value ='${list.section_ID }'>
					${list.section_ID} + ${list.className } + ${list.class_ID }
					</option>				
				
				</c:forEach>
				<option>1</option>
				<option>2</option>
			
			</select>
		</td>	
	</tr>
	
	<tr>
		<td></td>
		<td></td>
		<td class = "Label3"><input type='submit' value='Add Student'>
	</td>

</table>

</form>

</body>
</html>