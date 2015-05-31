<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<header>
<%@ page isELIgnored="false" %>
</header>
<body>
	<h1>
		${headerMessage}
	</h1>
	<h3>Hello ${player.playerName}, Welcome to the ${player.playerChoice} Challenge! Good Luck!</h3>
	
</body>
</html>