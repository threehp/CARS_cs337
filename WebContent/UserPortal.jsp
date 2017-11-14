<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Professor's Main Page</title>
<Link href = "css/UserPortal.css" rel="stylesheet" type="text/css"> 
</head>
<body>


 <label class="Header">Welcome Back Richard!!!</label>
<label class="info">Please select a section and time to display class attendance.</label>
  <form action="Userportal" method="post">
  
 <img class="ProfImage" src="imgs/Richard.jpg">
<div class="popup">   
    
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
		<td class="class1">Class Started at: </td>
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
		<td class="class2">Time format:</td>
		<td>2017  -MM  -DD   HH  :  MM</td>
	</tr>

	<tr>
		<td><input type="submit" value="Display Class" class="Bttn"></td>
	</tr>
	

</table>
</div>
</form>
<br>
<a href='' class="addStudent">Add Student</a>
<br>
  <a href='' class="addClass">Add Class</a>
  <br>
<a href='CARS'>CARS Home</a>

</body>
</html>