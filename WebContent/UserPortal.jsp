<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>User Portal</p>
<p>welcome ${username }</p>

<form action="" method="post">

<table >
	
	<tr>
		<td>Select Class: 
			<select  name='section_ID'>
				<c:forEach items="${ClassList }" var="list" varStatus = "listStatus">
					<option value="${list.section_ID}">
					${list.section_ID} + ${list.className }
					</option>								
				</c:forEach>
				<option>1</option>
				<option>2</option>
			
			</select>
		</td>	
	</tr>
	
	<tr>
		<td>Class Started at: </td>
		<td>2017-
			<select name="month">
				<c:forEach begin="1" end="12" var="i">
					<option value="${i}"> ${i} </option>
				</c:forEach>
			</select>-		
			<select name="day">
				<c:forEach begin="1" end="31" var="i">
					<option value="${i}"> ${i} </option>
				</c:forEach>
			</select> 
			<select name="hour">	
				<c:forEach begin="0" end="23" var="i">
					<option value="${i}"> ${i} </option>
				</c:forEach>
			</select>
			:
			<select name="min">	
				<c:forEach begin="0" end="59" var="i">
					<option value="${i}"> ${i} </option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>Time format:</td>
		<td>2017  -MM  -DD   HH  :  MM</td>
	</tr>

	<tr>
		<td><input type="submit" value="Display Class"></td>
	</tr>
	

</table>
</form>
<br>
<a href=''>Add Student</a>
<br>
<a href=''>Add Class</a>
<br>
<a href='CARS'>CARS Home</a>
</body>
</html>