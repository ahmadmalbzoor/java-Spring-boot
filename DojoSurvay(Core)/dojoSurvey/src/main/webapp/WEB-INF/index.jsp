<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div id="dwidth">
		<div id="border">
			<form action="/result" method="POST">
				Your Name :<input type="text" name="name"
					placeholder="Enter Your name"></input><br> Dojo
				Location: <select name="location" id="location" required="required">
					<option value="San Jose">San Jose</option>
					<option value="San msh Jose">San msh Jose</option>
				</select><br> Favorite Language : <select name="language" id="language"
					>
					<option value="Java">Java</option>
					<option value="python">Python</option>
					<option value="mern">MERN</option>
				</select><br> Comment(Optional)
				<textarea rows="10" cols="15" name="comment"></textarea><br>
				<input type="submit" value="Button">
			</form>
		</div>
	</div>
</body>
</html>