<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>

<div class="page-header">
	<h1>Professor Log In</h1>
</div>

<form action="CARS_LogIn" method="post">
<table class="table table-bordered table-striped table-hover">
	<tr>
		<td>Username:</td>
		<td><input type="text" name="username" placeholder="whatever name is fine"></td>
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
		<td><input type="submit" value="Sign In"></td>
	</tr>
	

</table>
</form>





</body>
</html>