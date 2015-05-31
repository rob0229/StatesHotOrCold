<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<header>
<%@ page isELIgnored="false" %>
</header>
<body>
	<h1>
		${headerMessage}
	</h1>
	<br>
	<%-- <form:errors path="student1.*"/> --%>
	
	<form action="/States/submitGameForm.html" method="post">
	<p>Student's Name : <input type="text" name="playerName"/></p>
	<p>Select Game: <select name="playerChoice" multiple>
								<option value="States">Guess The State</option>
					</select></p>
	
	
	
	<input type="submit" value="Start Playing!"/>
	</form>
</body>


</html>