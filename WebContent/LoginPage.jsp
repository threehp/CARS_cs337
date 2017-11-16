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

<form action="Login" method="post">

<table class="table table-bordered table-striped table-hover">
	<tr>
		<td>Username:</td>
		<td><input type="text" name="username" placeholder="Jose"></td>
		
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="password" placeholder="jose"></td>
	</tr>
	<tr>
		<td><input type="submit" value="Sign In"></td>
	</tr>
	
	<c:if test="${errorMsg != null }">
		<tr>
			<td colspan ="3">${errorMsg }</td>
		</tr>
	</c:if>

</table>
</form>





</body>
</html>