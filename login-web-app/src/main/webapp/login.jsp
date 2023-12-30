<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login Form</title>
</head>
<body>

	<h1>Login Form</h1>

	<form action="./login" method="post">
		<label>Username</label> &nbsp; <input type="text" name="username" /> 
		<%= request.getAttribute("login.username") %> 
		<br><br>
		
		<label>Password</label> &nbsp; <input type="password" name="secretkey" /> 
		<%= request.getAttribute("login.secretkey") %>
		<br><br>
        
        <button type="submit">Submit</button>        
        
	</form>

<%= request.getAttribute("login.message") %>

</body>
</html>