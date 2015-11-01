<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />
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
	
	
	
	<input type="submit" id="startPlayingBtn" value="Start Playing!"/>
	</form>
	<textarea name="message_display" default="stuff should display here">Hello world, I am alive, feed me</textarea>
	<script>
		$("#startPlayingBtn").on("click",function(){
			console.log("Clicked startPlaying BTN");
		});
	
	</script>
<jsp:include page="footer.jsp" />