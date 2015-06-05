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
	<form action="/States/${player.playerName}/${player.playerChoice}/submitGuess.html" method="post">
		<p>Guess:<input type="text" name="guess"/></p>
		<P><input type="hidden" name="playerName" value="'${player.playerName}'"/></p>
	</form>
	<p name="result"> Your guess was ${guess.guess} </p>
</body>
</html>