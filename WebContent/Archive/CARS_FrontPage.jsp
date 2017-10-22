<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!--  <body background="CarsBack.png">-->
<head>
	<meta charset="UTF-8">
	<title>Card Attendance Recording System</title>
	<Link href = "1css/FrontPageStyle.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<form action="CARS_LogIn" method="get">
			<INPUT class= "LogInBttn" TYPE="submit" value="Professor Login" >
	</form>
	
	<form action='CARS_Search' method='post' >
			
			<img class="EagleImage" src="imgs/eagle2.png">
					
			<INPUT class="InputBox" type="text" name='search_input' placeholder="Click here and then swipe your card">
			<INPUT type='radio' class="searchType" name='search_type' value='card_ID' id="Card" checked> 
			 	<label class="Label1" for="Card">Card </label>
			<INPUT type='radio' class="searchType2" name='search_type' id="Student" value='student_ID'>
				<label class="Label2" for="Student">Student ID </label>
			<INPUT class="SubmitBttn"  TYPE='submit' value="Search">
			<!-- <INPUT class= "LostCardBttn" TYPE="Button" value="Lost or Stolen Card">-->
			
			<footer class="FooterTxt">MISAEL - WILSON - NARCISO - JIAJUN</footer>
		
			
	</form>

<div class="content">
	${error_message }
</div>
	



</body>
</html>