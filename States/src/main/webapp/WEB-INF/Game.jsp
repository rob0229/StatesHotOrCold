<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />

	<h1>
		${headerMessage}
	</h1>
	<h3>Hello ${player.playerName}, Welcome to the ${player.playerChoice} Challenge! Good Luck!</h3>
	<form action="/States/${player.playerName}/${player.playerChoice}/submitGuess.html" method="post">
		<p>Guess:<input type="text" name="guess"/></p>
		<P><input type="hidden" name="playerName" value="'${player.playerName}'"/></p>
	</form>
	<p name="result"> Your guess was ${guess.guess} </p>
	<input type="submit" id="startPlayingBtn" value="Start Playing!"/>
	
	<script>
	
		$("#startPlayingBtn").on('click',function(){
			console.log("Clicked startPlaying BTN");
		});
	
	</script>
<jsp:include page="footer.jsp" />