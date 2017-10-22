<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CARS Front Page</title>
</head>
<body>

<p><strong>CARS</strong></p>
<p>Card Attendance Recording System</p>



<p>

<form action='CARS_Search' method='post' >

<input type='text' name='search_input'  >
<br>
<input type='radio' name='search_type' value='card_ID' checked>Card  
<input type='radio' name='search_type' value='student_ID'>Student ID

<br><br>

<input type='submit' value='Search'>

</form>

${error_message }

<br><br>
<a href='CARS_LogIn'>Professor Logs In</a>


</p>


</body>
</html>